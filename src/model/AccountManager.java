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
	 * @param email l'email inserita dall'utente durante il login
	 * @param password la password inserita dall'utente durante il login
	 * @return null se non ha trovato l'account o un Utente se ha trovato l'account
	 * @throws SQLException
	 */
	public Utente login(String email, String password) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		String selectQ= "SELECT * FROM utente WHERE email = ? AND psw = ?";
		Utente utente= null;
		
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
/*
	/**
	 * 
	 * @param email
	 * @param password
	 * @throws SQLException 
	 
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
			
		}catch(Exception e){
			return false;
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
	}*/
	
	/**
	 * 
	 * @param email l'email dell'utente loggato
	 * @param vecchiaPassword la vecchia password inserita dall'utente
	 * @param nuovaPassword la nuova password da inserire
	 * @return true se la password è stata cambiata con successo, altrimenti false
	 * @throws SQLException
	 */
	public boolean changePassword(String email, String vecchiaPassword, String nuovaPassword) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		boolean passCambiata= false;
		try {			
			if(checkVecchiaPassword(email, vecchiaPassword, connection)) {
			
				String updateQ= "UPDATE utente SET psw = ? WHERE email = ?";
				
				pStatement= connection.prepareStatement(updateQ);
				pStatement.setString(1, nuovaPassword);
				pStatement.setString(2, email);
				if(pStatement.executeUpdate()==1) {
					passCambiata= true;
				}
				connection.commit();
			}
		}catch(Exception e){
			return false;
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

	/**
	 * 
	 * @return true se la vecchia password inserita dall'utente è uguale alla password attuale, false altrimenti
	 * @throws SQLException
	 */
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
	 * @param email l'email dell'utente loggato
	 * @return una lista vuota se non ci sono carte associate all'account, altrimenti una lista con le carte associate
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
	 * @param email l'email dell'utente loggato
	 * @return una lista vuota se non ci sono indirizzi associati all'account, altrimenti una lista con 
	 * gli indirizzi associati
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
	 * @param email l'email dell'utente loggato
	 * @param carta la carta da aggiungere
	 * @return true se la carta è stata aggiunta con successo, altrimenti false
	 * @throws SQLException
	 */
	public boolean aggiungiCarta(String email, CartaDiCredito carta) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		boolean result= false;
		String insertQ= "INSERT INTO cartadicredito (numeroDiCarta, intestatario, dataScadenza, cvv, utente)"
				+ " VALUES (?, ?, ?, ?, ?)";
		
		try {
			pStatement= connection.prepareStatement(insertQ);
			pStatement.setString(1, carta.getNumCarta());
			pStatement.setString(2, carta.getIntestatario());
			pStatement.setDate(3, carta.getData());
			pStatement.setString(4, carta.getCvv());
			pStatement.setString(5, email);
			
			if(pStatement.executeUpdate()==1) {
				result= true;
			}
			connection.commit();
			
			
		}catch(Exception e){
			return false;
		}finally {
			try {
				if(pStatement!= null) {
					pStatement.close();
				}
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return result;
	}

	/**
	 * 
	 * @param numCarta il numero della carta da rimuovere
	 * @return true se la carta è stata rimossa con successo, altrimenti false
	 * @throws SQLException
	 */
	public boolean rimuoviCarta(String numCarta) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		boolean result= false;
		String deleteQ= "DELETE FROM cartadicredito WHERE numeroDiCarta = ?";
		
		try {
			pStatement= connection.prepareStatement(deleteQ);
			pStatement.setString(1, numCarta);
			
			if(pStatement.executeUpdate()==1) {
				result= true;
			}
			connection.commit();			
		}catch(Exception e){
			return false;
		}finally {
			try {
				if(pStatement!= null) {
					pStatement.close();
				}
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return result;
	}

	/**
	 * 
	 * @param email l'email dell'utente loggato
	 * @param indirizzo l'indirizzo da aggiungere
	 * @return true se l'indirizzo è stato aggiunto con successo, altrimenti false
	 * @throws SQLException
	 */
	public boolean aggiungiIndirizzo(String email, Indirizzo indirizzo) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		boolean result= false;
		String insertQ= "INSERT INTO indirizzo (via, cap, città, numeroCivico, utente)"
				+ " VALUES (?, ?, ?, ?, ?)";
		
		try {
			pStatement= connection.prepareStatement(insertQ);
			pStatement.setString(1, indirizzo.getVia());
			pStatement.setString(2, indirizzo.getCap());
			pStatement.setString(3, indirizzo.getCittà());
			pStatement.setInt(4, indirizzo.getNumCivico());
			pStatement.setString(5, email);
			
			if(pStatement.executeUpdate()==1) {
				result= true;
			}
			connection.commit();
		}catch(Exception e){
			return false;
		}finally {
			try {
				if(pStatement!= null) {
					pStatement.close();
				}
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param idIndirizzo l'id dell'indirizzo da rimuovere
	 * @return true se l'indirizzo è stato rimosso con successo, altrimenti false
	 * @throws SQLException
	 */
	public boolean rimuoviIndirizzo(int idIndirizzo) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		boolean result= false;
		String deleteQ= "DELETE FROM indirizzo WHERE id = ?";
		
		try {
			pStatement= connection.prepareStatement(deleteQ);
			pStatement.setInt(1, idIndirizzo);
			
			if(pStatement.executeUpdate()==1) {
				result= true;
			}
			connection.commit();			
		}catch(Exception e){
			return false;
		}finally {
			try {
				if(pStatement!= null) {
					pStatement.close();
				}
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param indirizzo l'indirizzo contenente i paramentri da modificare
	 * @param email l'email dell'account associato
	 * @return true se la modifica è avveuta con successo, altrimenti false
	 * @throws SQLException
	 */
	public boolean modificaIndirizzo(Indirizzo indirizzo, String email) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		boolean result=false;
		String updateQ= "UPDATE indirizzo SET via = ?, numeroCivico = ?, cap = ?, città = ?, utente = ? WHERE id = ?";
		
		try {
			pStatement= connection.prepareStatement(updateQ);
			pStatement.setString(1, indirizzo.getVia());
			pStatement.setInt(2, indirizzo.getNumCivico());
			pStatement.setString(3, indirizzo.getCap());
			pStatement.setString(4, indirizzo.getCittà());
			pStatement.setString(5, email);
			pStatement.setInt(6, indirizzo.getId());
			
			if(pStatement.executeUpdate()==1) {
				result=true;
			}
			connection.commit();
		}catch(Exception e){
			return false;
		}finally {
			try {
				if(pStatement!= null) {
					pStatement.close();
				}
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return result;
	}


}