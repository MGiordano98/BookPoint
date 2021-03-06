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

public class LibroManager {
	
	private static final String TABLE_NAME= "libro";
	private final int NUMERO_LIBRI=8;//Numero di libri che si vuole mostrare

	/**
	 * 
	 * @param testo il testo della ricerca (nome libro o nome autore)
	 * @param categoria la categoria inserita
	 * @return una collection vuota se non � stato trovato alcun libro, altrimenti una collection con i libri trovati
	 * @throws SQLException
	 */
	public Collection<Libro> ricerca(String testo, String categoria) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Libro> libri = new LinkedList<Libro>();

		String selectSQL = "Select * from libro inner join scrive on isbn=libro where categoria like ?"
				+ " And (titolo like ? Or autore like ?) GROUP BY isbn";


		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			preparedStatement.setString(1,"%"+categoria+"%");
			preparedStatement.setString(2,"%"+ testo+"%");
			preparedStatement.setString(3,"%"+testo+ "%");
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Libro bean = new Libro();

				bean.setIsbn(rs.getString("isbn"));
				bean.setTitolo(rs.getString("titolo"));
				bean.setTrama(rs.getString("trama"));
				bean.setFoto(rs.getString("foto"));
				bean.setCasaEditrice(rs.getString("casaEditrice"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setQuantit�(rs.getInt("quantit�Disponibile"));
				bean.setCategoria(rs.getString("categoria"));
				bean.setCopieVendute(rs.getInt("copieVendute"));
				bean.setDataUscita(rs.getDate("dataUscita"));
				
				bean.setRecensioni(getRecensioni(connection, bean.getIsbn()));
				bean.setAutori(getAutori(connection, bean.getIsbn()));
				
				libri.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return libri;
	}

	/**
	 * 
	 * @return una collection vuota se non sono presenti libri nel db, altrimenti ritorna una collection con i libri
	 * pi� venduti in ordine decrescente
 	 * @throws SQLException
	 */
	public Collection<Libro> getLibriPi�Venduti() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Libro> libri = new LinkedList<Libro>();

		String selectSQL = "SELECT * FROM " + TABLE_NAME + " ORDER BY copieVendute desc";

		
		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			int i=0;
			while (rs.next() && i<NUMERO_LIBRI) {
				Libro bean = new Libro();

				bean.setIsbn(rs.getString("isbn"));
				bean.setTitolo(rs.getString("titolo"));
				bean.setTrama(rs.getString("trama"));
				bean.setFoto(rs.getString("foto"));
				bean.setCasaEditrice(rs.getString("casaEditrice"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setQuantit�(rs.getInt("quantit�Disponibile"));
				bean.setCategoria(rs.getString("categoria"));
				bean.setCopieVendute(rs.getInt("copieVendute"));
				bean.setDataUscita(rs.getDate("dataUscita"));
				
				bean.setRecensioni(getRecensioni(connection, bean.getIsbn()));
				bean.setAutori(getAutori(connection, bean.getIsbn()));
				
				libri.add(bean);
				i++;
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return libri;
	}
	
	/**
	 * 
	 * @return una collection vuota se non sono presenti libri nel db, altrimenti ritorna una collection con i libri
	 * in evidenza in ordine decrescente
 	 * @throws SQLException
	 */
	public Collection<Libro> getLibriInEvidenza() throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Libro> libri = new LinkedList<Libro>();

		String selectSQL = "SELECT * FROM " + TABLE_NAME + " ORDER BY dataUscita desc";

		
		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			int i=0;
			while (rs.next() && i<NUMERO_LIBRI) {
				Libro bean = new Libro();

				bean.setIsbn(rs.getString("isbn"));
				bean.setTitolo(rs.getString("titolo"));
				bean.setTrama(rs.getString("trama"));
				bean.setFoto(rs.getString("foto"));
				bean.setCasaEditrice(rs.getString("casaEditrice"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setQuantit�(rs.getInt("quantit�Disponibile"));
				bean.setCategoria(rs.getString("categoria"));
				bean.setCopieVendute(rs.getInt("copieVendute"));
				bean.setDataUscita(rs.getDate("dataUscita"));
				
				bean.setRecensioni(getRecensioni(connection, bean.getIsbn()));
				bean.setAutori(getAutori(connection, bean.getIsbn()));
				
				libri.add(bean);
				i++;
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return libri;
	}

	/**
	 * 
	 * @param isbn l'isbn del libro da visualizzare
	 * @return null se non � stato trovato il libro, altrimenti un Libro contenente i dati del libro cercato
	 * @throws SQLException
	 */
	public Libro visualizzaLibro(String isbn) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		Libro libro=null;
		
		String selectQ= "SELECT * FROM libro WHERE isbn= ?";
		
		try {
			pStatement= connection.prepareStatement(selectQ);
			pStatement.setString(1, isbn);
			ResultSet rs= pStatement.executeQuery();
			if(rs.next()){
				libro=new Libro();
				libro.setIsbn(rs.getString("isbn"));
				libro.setPrezzo(rs.getDouble("prezzo"));
				libro.setTitolo(rs.getString("titolo"));
				libro.setTrama(rs.getString("trama"));
				libro.setFoto(rs.getString("foto"));
				libro.setCasaEditrice(rs.getString("casaEditrice"));
				libro.setQuantit�(rs.getInt("quantit�Disponibile"));
				libro.setCategoria(rs.getString("categoria"));
				libro.setCopieVendute(rs.getInt("copieVendute"));
				libro.setDataUscita(rs.getDate("dataUscita"));
				
				libro.setRecensioni(getRecensioni(connection, isbn));
				libro.setAutori(getAutori(connection, isbn));
			}
		} finally {
			try {
				if (pStatement != null)
					pStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return libro;
	}
	
	/**
	 * 
	 * @param connection la connessione al db
	 * @param isbn l'isbn del libro di cui si devono ottenere le recensioni
	 * @return un array vuoto se non sono state trovate recensioni associate al libro, altrimenti un array con le recensioni
	 * @throws SQLException
	 */
	private ArrayList<Recensione> getRecensioni(Connection connection, String isbn) throws SQLException {
		PreparedStatement pStatement=null;
		ArrayList<Recensione> recensioni= new ArrayList<Recensione>();
		
		String selectQ= "SELECT * FROM (libro "
				+ "INNER JOIN recensione ON (libro.isbn = recensione.libro)) "
				+ "WHERE libro.isbn = ?";
		
		pStatement= connection.prepareStatement(selectQ);
		pStatement.setString(1, isbn);
		ResultSet rs = pStatement.executeQuery();
		while(rs.next()) {
			recensioni.add(new Recensione(rs.getInt("id"), rs.getString("testo"), isbn, rs.getString("utente")));
		}
		return recensioni;
	}

	/**
	 * 
	 * @param connection la connessione al db
	 * @param isbn l'isbn del libro di cui si devono ottenere gli autori
	 * @return un array vuoto se non sono stati autori associati al libro, altrimenti un array di autori
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