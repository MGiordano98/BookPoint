package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
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
		
		String selectQ= "SELECT * FROM utente WHERE email = ? AND psw = ?";
		Utente utente= null;
		
		System.out.println("ciao");
		
		try {
			pStatement= connection.prepareStatement(selectQ);
			pStatement.setString(1, email);
			pStatement.setString(2, password);
			ResultSet rs= pStatement.executeQuery();
			while(rs.next()) {
				utente= new Utente();
				utente.setEmail(rs.getString("email"));
				utente.setNome(rs.getString("nome"));
				utente.setCognome(rs.getString("cognome"));
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
	public boolean registrazione(Utente utente) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		boolean registrato= false;
		
		String insertQ= "INSERT INTO utente (email, psw, nome, cognome, dataDiNascita,tipo) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			pStatement= connection.prepareStatement(insertQ);
			pStatement.setString(1, utente.getEmail());
			pStatement.setString(2, utente.getPassword());
			pStatement.setString(3, utente.getNome());
			pStatement.setString(4, utente.getCognome());
			pStatement.setDate(5, utente.getDataDiNascita());
			pStatement.setString(6, "cliente");
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
			
				String updateQ= "UPDATE utente WHERE email = ? SET psw = ?";
				
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
		
		String selectQ= "SELECT * FROM utente WHERE email = ? AND psw = ?";
		
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
		
		String selectQ= "SELECT * FROM cartadicredito WHERE utente = ?";
		
		try {
			pStatement= connection.prepareStatement(selectQ);
			pStatement.setString(1, email);
			ResultSet rs= pStatement.executeQuery();
			while(rs.next()) {
				CartaDiCredito carta= new CartaDiCredito();
				carta.setIntestatario(rs.getString("intestatario"));
				carta.setCvv(rs.getString("cvv"));
				carta.setData(rs.getDate("dataScadenza"));
				carta.setNumCarta(rs.getString("numeroDiCarta"));
				
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
		
		String selectQ= "SELECT * FROM indirizzo WHERE utente = ?";
		
		try {
			pStatement= connection.prepareStatement(selectQ);
			pStatement.setString(1, email);
			ResultSet rs= pStatement.executeQuery();
			while(rs.next()) {
				Indirizzo indirizzo= new Indirizzo();
				indirizzo.setVia(rs.getString("via"));
				indirizzo.setNumCivico(rs.getInt("numeroCivico"));
				indirizzo.setCap(rs.getString("cap"));
				indirizzo.setCittà(rs.getString("città"));
				indirizzo.setId(rs.getInt("id"));
				
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
	public void aggiungiCarta(String email, CartaDiCredito carta) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		String insertQ= "INSERT INTO cartadicredito (numeroDiCarta, intestatario, dataScadenza, cvv, utente)"
				+ " VALUES (?, ?, ?, ?, ?)";
		
		try {
			pStatement= connection.prepareStatement(insertQ);
			pStatement.setString(1, carta.getNumCarta());
			pStatement.setString(2, carta.getIntestatario());
			pStatement.setDate(3, carta.getData());
			pStatement.setString(4, carta.getCvv());
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
		
		String deleteQ= "DELETE FROM cartadicredito WHERE numeroDiCarta = ?";
		
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
	public void aggiungiIndirizzo(String email, Indirizzo indirizzo) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		String insertQ= "INSERT INTO indirizzo (via, cap, città, numeroCivico, utente)"
				+ " VALUES (?, ?, ?, ?, ?)";
		
		try {
			pStatement= connection.prepareStatement(insertQ);
			pStatement.setString(1, indirizzo.getVia());
			pStatement.setString(2, indirizzo.getCap());
			pStatement.setString(3, indirizzo.getCittà());
			pStatement.setInt(4, indirizzo.getNumCivico());
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
	public void modificaIndirizzo(String email, Indirizzo indirizzo) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		String updateQ= "UPDATE indirizzo SET via = ?, nummeroCivico = ?, cap = ?, città = ?, email = ? WHERE id = ?";
		
		try {
			pStatement= connection.prepareStatement(updateQ);
			pStatement.setInt(1, indirizzo.getId());
			pStatement.setString(2, indirizzo.getVia());
			pStatement.setInt(3, indirizzo.getNumCivico());
			pStatement.setString(4, indirizzo.getCap());
			pStatement.setString(5, indirizzo.getCittà());
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