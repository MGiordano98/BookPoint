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
	 * @param isbn
	 * @param email
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
	 * @param isbn
	 * @param email
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
	 * @param testo
	 * @param isbn
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
	 * @param idRecensione
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