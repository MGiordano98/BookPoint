package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectionPool.DriverMaagerConnectionPool;

public class InterazioneLibroManager {

	/**
	 * 
	 * @param isbn
	 * @param email
	 * @throws SQLException 
	 */
	public void aggiungiLibroPreferiti(String isbn, String email) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		String insertQ= "INSERT INTO preferisce (utenteEmail, libroIsbn) values (?, ?)";
		
		try {
			pStatement= connection.prepareStatement(insertQ);
			pStatement.setString(1, email);
			pStatement.setString(2, isbn);
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
	 * @param isbn
	 * @param email
	 * @throws SQLException 
	 */
	public void rimuoviLibroPreferiti(String isbn, String email) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		String deleteQ= "DELETE FROM preferiti WHERE utenteEmail = ? AND libroIsbn = ?";
		
		try {
			pStatement= connection.prepareStatement(deleteQ);
			pStatement.setString(1, email);
			pStatement.setString(2, isbn);
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
	 * @param testo
	 * @param isbn
	 * @throws SQLException 
	 */
	public void aggiungiRecensione(String testo, String isbn, String email) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		String insertQ= "INSERT INTO Recensione (testo, libroIsbn, utenteEmail) VALUES (?, ?, ?)";
		
		try {
			pStatement= connection.prepareStatement(insertQ);
			pStatement.setString(1, testo);
			pStatement.setString(2, isbn);
			pStatement.setString(3, email);
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
	 * @param idRecensione
	 * @throws SQLException 
	 */
	public void rimuoviRecensione(int idRecensione) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		String deleteQ= "DELETE FROM recensione WHERE id= ?";
		
		try {
			pStatement= connection.prepareStatement(deleteQ);
			pStatement.setInt(1, idRecensione);
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