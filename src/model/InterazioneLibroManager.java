package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import bean.Autore;
import bean.Libro;
import bean.Recensione;
import connectionPool.DriverMaagerConnectionPool;

public class InterazioneLibroManager {

	/**
	 * 
	 * @param isbn l'isbn del libro da aggiungere ai preferiti
	 * @param email l'email dell'utente
	 * @return true se il libro è stato aggiunto tra i preferito, altrimenti false
	 * @throws SQLException
	 */
	public boolean aggiungiLibroPreferiti(String isbn, String email) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		boolean result= false;
		String insertQ= "INSERT INTO preferisce (utente, libro) values (?, ?)";
		
		try {
			pStatement= connection.prepareStatement(insertQ);
			pStatement.setString(1, email);
			pStatement.setString(2, isbn);
			if(pStatement.executeUpdate()==1) {
				result= true;
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
		return result;
	}

	/**
	 * 
	 * @param isbn l'isbn del libro da rimuovere dai preferiti
	 * @param email l'email dell'utente
	 * @return true se il libro è stato rimosso dai preferiti, altrimenti false
	 * @throws SQLException
	 */
	public boolean rimuoviLibroPreferiti(String isbn, String email) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		boolean result= false;
		String deleteQ= "DELETE FROM preferisce WHERE utente = ? AND libro = ?";
		
		try {
			pStatement= connection.prepareStatement(deleteQ);
			pStatement.setString(1, email);
			pStatement.setString(2, isbn);
			if(pStatement.executeUpdate()==1) {
				result= true;
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
		return result;
	}

	/**
	 * 
	 * @param recensione la recensione da aggiungere
	 * @return true se la recensione è stata aggiunta con successo, altrimenti false
	 * @throws SQLException
	 */
	public boolean aggiungiRecensione(Recensione recensione) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		boolean result= false;
		String insertQ= "INSERT INTO recensione (testo, libro, utente) VALUES (?, ?, ?)";
		
		try {
			pStatement= connection.prepareStatement(insertQ);
			pStatement.setString(1, recensione.getTesto());
			pStatement.setString(2, recensione.getIsbn());
			pStatement.setString(3, recensione.getEmail());
			if(pStatement.executeUpdate()==1) {
				result= true;
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
		return result;
	}

	/**
	 * 
	 * @param idRecensione l'id della recensione da rimuovere
	 * @return true se la recensione è stata rimossa con successo, altrimenti false
	 * @throws SQLException
	 */
	public boolean rimuoviRecensione(int idRecensione) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		boolean result= false;
		String deleteQ= "DELETE FROM recensione WHERE id= ?";
		
		try {
			pStatement= connection.prepareStatement(deleteQ);
			pStatement.setInt(1, idRecensione);
			if(pStatement.executeUpdate()==1) {
				result= true;
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
		return result;
	}
	
	/**
	 * 
	 * @param isbn l'isbn del libro di cui si devono prendere le recensioni
	 * @return una collection vuota se non ci sono recensioni associate al libro, altrimenti una collection con le recensioni associate
	 * @throws SQLException
	 */
	public Collection<Recensione> getRecensioni(String isbn) throws SQLException{
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement=null;
		Collection<Recensione> recensioni= new LinkedList<Recensione>();
		
		String selectQ= "SELECT * FROM recensione WHERE libro = ?";
		
		try {
			pStatement= connection.prepareStatement(selectQ);
			pStatement.setString(1, isbn);
			ResultSet rs= pStatement.executeQuery();
			
			while(rs.next()) {
				Recensione recensione= new Recensione();
				recensione.setEmail(rs.getString("utenteEmail"));
				recensione.setIsbn(isbn);
				recensione.setTesto(rs.getString("testo"));
				
				recensioni.add(recensione);
			}
		}finally {
			try {
				if(pStatement!=null) {
					pStatement.close();
				}
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return recensioni;
	}

	/**
	 * 
	 * @param email l'email dell'utente di cui si devono prendere i libri preferiti
	 * @return una collection vuota se non ci sono libri ai preferiti, altrimenti una collection con i libri aggiunti ai preferiti
	 * @throws SQLException
	 */
	public Collection<Libro> getPreferiti(String email) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		Collection<Libro> libri= new LinkedList<Libro>();
		
		String selectQ= "SELECT * "
				+ "FROM (preferisce "
				+ "INNER JOIN libro ON (preferisce.libro = libro.isbn)) "
				+ "WHERE preferisce.utente = ?";
		
		try {
			pStatement= connection.prepareStatement(selectQ);
			pStatement.setString(1, email);
			ResultSet rs= pStatement.executeQuery();
			while(rs.next()) {
				Libro lib= new Libro();
				lib.setIsbn(rs.getString("isbn"));
				lib.setTitolo(rs.getString("titolo"));
				lib.setPrezzo(rs.getDouble("prezzo"));
				lib.setTrama(rs.getString("trama"));
				lib.setFoto(rs.getString("libro.foto"));
				
				lib.setAutori(getAutori(connection, lib.getIsbn()));
				libri.add(lib);
			}
		}finally {
			try {
				if(pStatement!=null) pStatement.close();
			}finally {
				connection.close();
			}
		}
		
		return libri;
	}
	
	/**
	 * 
	 * @param connection la connessione al db
	 * @param isbn l'isbn del libro di cui si devono prendere gli autori
	 * @return un array vuoto se non ci sono autori associati all'account, altrimenti un array con gli autori
	 * @throws SQLException
	 */
	private ArrayList<Autore> getAutori(Connection connection, String isbn) throws SQLException {
		PreparedStatement pStatement=null;
		ArrayList<Autore> autori= new ArrayList<Autore>();
		
		String selectQ= "SELECT autore FROM (libro "
				+ "INNER JOIN scrive ON (libro.isbn = scrive.libro)) "
				+ "WHERE libro.isbn = ?";
		
		pStatement= connection.prepareStatement(selectQ);
		pStatement.setString(1, isbn);
		ResultSet rs = pStatement.executeQuery();
		while(rs.next()) {
		autori.add(new Autore(rs.getString("autore")));
		}
		
		return autori;
	}

}