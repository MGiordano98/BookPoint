package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import bean.CartaDiCredito;
import bean.Indirizzo;
import bean.Utente;
import connectionPool.DriverMaagerConnectionPool;

public class AccountManager {

	/**
	 * 
	 * @param email
	 * @param password
	 * @throws SQLException 
	 */
	public Utente login(String email, String password) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		String selectQ= "SELECT * FROM utente WHERE email = ? AND password = ?";
		Utente utente= null;
		
		try {
			pStatement= connection.prepareStatement(selectQ);
			pStatement.setString(1, email);
			pStatement.setString(2, password);
			ResultSet rs= pStatement.executeQuery();
			while(rs.next()) {
				utente= new Utente();
				utente.setNome(rs.getString("nome"));
				utente.setCognome(rs.getString("congome"));
				utente.setDataDiNascita(rs.getDate("dataDiNascita"));
				utente.setTipo(rs.getString("tipo"));
			}
		}finally {
			try {
				if(pStatement!= null) {
					pStatement.close();
				}
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return utente;
	}

	/**
	 * 
	 * @param email
	 * @param password
	 * @throws SQLException 
	 */
	public boolean registrazione(String email, String password, String nome, String cognome, Date dataDiNascita) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		boolean registrato= false;
		
		String insertQ= "INSERT INTO utente (email, password, nome, cognome, dataDiNascita) "
				+ "VALUES (?, ?, ?, ?, ?)";
		
		try {
			pStatement= connection.prepareStatement(insertQ);
			pStatement.setString(1, email);
			pStatement.setString(2, password);
			pStatement.setString(3, nome);
			pStatement.setString(4, cognome);
			pStatement.setDate(5, dataDiNascita);
			int reg= pStatement.executeUpdate();
			if(reg==1) {
				registrato=true;
			}
			connection.commit();
			
		}finally {
			try {
				if(pStatement!= null) {
					pStatement.close();
				}
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return registrato;
	}
	
	/**
	 * 
	 * @param email
	 * @param vecchiaPassword
	 * @param nuovaPassword
	 * @throws SQLException 
	 */
	public boolean changePassword(String email, String vecchiaPassword, String nuovaPassword) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		boolean passCambiata= false;
		try {			
			if(checkVecchiaPassword(email, vecchiaPassword, connection)) {
			
				String updateQ= "UPDATE utente WHERE email = ? SET password = ?";
				
				pStatement= connection.prepareStatement(updateQ);
				pStatement.setString(1, email);
				pStatement.setString(2, nuovaPassword);
				int result= pStatement.executeUpdate();
				if(result==1) {
					passCambiata= true;
				}
				
				connection.commit();
			}
		}finally {
			try {
				if(pStatement!= null) {
					pStatement.close();
				}
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return passCambiata;
	}

	private boolean checkVecchiaPassword(String email, String vecchiaPassword, Connection connection) throws SQLException {
		PreparedStatement pStatement= null;
		
		boolean passChecked= false;
		
		String selectQ= "SELECT * FROM utente WHERE email = ? AND password = ?";
		
		pStatement= connection.prepareStatement(selectQ);
		pStatement.setString(1, email);
		pStatement.setString(2, vecchiaPassword);
		ResultSet rs= pStatement.executeQuery();
		while(rs.next()) {
			passChecked=true;
		}
		return passChecked;
	}

	/**
	 * 
	 * @param email
	 * @throws SQLException 
	 */
	public Collection<CartaDiCredito> ricercaCarte(String email) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		Collection<CartaDiCredito> carte= new LinkedList<CartaDiCredito>();
		
		String selectQ= "SELECT * FROM cartaDiCredito WHERE utenteEmail = ?";
		
		try {
			pStatement= connection.prepareStatement(selectQ);
			pStatement.setString(1, email);
			ResultSet rs= pStatement.executeQuery();
			while(rs.next()) {
				CartaDiCredito carta= new CartaDiCredito();
				carta.setIntestatario(rs.getString("intestatario"));
				carta.setCvv(rs.getInt("cvv"));
				carta.setData(rs.getDate("dataDiScadenza"));
				carta.setNumCarta(rs.getInt("numeroDiCarta"));
				
				carte.add(carta);
			}
		}finally {
			try {
				if(pStatement!= null) {
					pStatement.close();
				}
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return carte;
	}

	/**
	 * 
	 * @param email
	 * @throws SQLException 
	 */
	public Collection<Indirizzo> ricercaIndirizzi(String email) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		Collection<Indirizzo> indirizzi= new LinkedList<Indirizzo>();
		
		String selectQ= "SELECT * FROM indirizzo WHERE utenteEmail = ?";
		
		try {
			pStatement= connection.prepareStatement(selectQ);
			pStatement.setString(1, email);
			ResultSet rs= pStatement.executeQuery();
			while(rs.next()) {
				Indirizzo indirizzo= new Indirizzo();
				indirizzo.setVia(rs.getString("via"));
				indirizzo.setNumCivico(rs.getInt("numeroCivico"));
				indirizzo.setCap(rs.getInt("cap"));
				indirizzo.setCittà(rs.getString("città"));
				indirizzo.setId(rs.getInt(rs.getInt("id")));
				
				indirizzi.add(indirizzo);
			}
		}finally {
			try {
				if(pStatement!= null) {
					pStatement.close();
				}
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return indirizzi;
	}

	/**
	 * 
	 * @param email
	 * @param numCarta
	 * @param intestatario
	 * @param dataScadenza
	 * @param cvv
	 * @throws SQLException 
	 */
	public void aggiungiCarta(String email, int numCarta, String intestatario, Date dataScadenza, int cvv) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		String insertQ= "INSERT INTO cartaDiCredito (numeroDiCarta, intestatario, dataScadenza, cvv, utenteEmail)"
				+ " VALUES (?, ?, ?, ?, ?)";
		
		try {
			pStatement= connection.prepareStatement(insertQ);
			pStatement.setInt(1, numCarta);
			pStatement.setString(2, intestatario);
			pStatement.setDate(3, dataScadenza);
			pStatement.setInt(4, cvv);
			pStatement.setString(5, email);
			
			pStatement.executeUpdate();
			connection.commit();
		}finally {
			try {
				if(pStatement!= null) {
					pStatement.close();
				}
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	/**
	 * 
	 * @param email
	 * @param numCarta
	 * @throws SQLException 
	 */
	public void rimuoviCarta(int numCarta) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		String deleteQ= "DELETE FROM cartaDiCredito WHERE numeroDiCarta = ?";
		
		try {
			pStatement= connection.prepareStatement(deleteQ);
			pStatement.setInt(1, numCarta);
			
			pStatement.executeUpdate();
			connection.commit();			
		}finally {
			try {
				if(pStatement!= null) {
					pStatement.close();
				}
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	/**
	 * 
	 * @param email
	 * @param via
	 * @param numCivico
	 * @param cap
	 * @param città
	 * @throws SQLException 
	 */
	public void aggiungiIndirizzo(String email, String via, int numCivico, int cap, String città) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		String insertQ= "INSERT INTO indirizzo (via, cap, città, numeroCivico, utenteEmail)"
				+ " VALUES (?, ?, ?, ?, ?)";
		
		try {
			pStatement= connection.prepareStatement(insertQ);
			pStatement.setString(1, via);
			pStatement.setInt(2, cap);
			pStatement.setString(3, città);
			pStatement.setInt(4, numCivico);
			pStatement.setString(5, email);
			
			pStatement.executeUpdate();
			connection.commit();
		}finally {
			try {
				if(pStatement!= null) {
					pStatement.close();
				}
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	/**
	 * 
	 * @param email
	 * @param idIndirizzo
	 * @throws SQLException 
	 */
	public void rimuoviIndirizzo(int idIndirizzo) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		String deleteQ= "DELETE FROM indirizzo WHERE id = ?";
		
		try {
			pStatement= connection.prepareStatement(deleteQ);
			pStatement.setInt(1, idIndirizzo);
			
			pStatement.executeUpdate();
			connection.commit();			
		}finally {
			try {
				if(pStatement!= null) {
					pStatement.close();
				}
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	/**
	 * 
	 * @param email
	 * @param idIndirizzo
	 * @param via
	 * @param numCivico
	 * @param CAP
	 * @param città
	 * @throws SQLException 
	 */
	public void modificaIndirizzo(String email, int idIndirizzo, String via, int numCivico, int cap, String città) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		String updateQ= "UPDATE indirizzo SET via = ?, nummeroCivico = ?, cap = ?, città = ?, email = ? WHERE id = ?";
		
		try {
			pStatement= connection.prepareStatement(updateQ);
			pStatement.setInt(1, idIndirizzo);
			pStatement.setString(2, via);
			pStatement.setInt(3, numCivico);
			pStatement.setInt(4, cap);
			pStatement.setString(5, città);
			pStatement.setString(6, email);
			
			pStatement.executeUpdate();
			connection.commit();
		}finally {
			try {
				if(pStatement!= null) {
					pStatement.close();
				}
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	}


}