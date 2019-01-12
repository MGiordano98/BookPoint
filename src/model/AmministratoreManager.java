package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Autore;
import bean.Libro;
import bean.Utente;
import connectionPool.DriverMaagerConnectionPool;

public class AmministratoreManager {

	/**
	 * 
	 * @param isbn
	 * @param titolo
	 * @param trama
	 * @param foto
	 * @param casaEditrice
	 * @param prezzo
	 * @param quantit‡Disponibile
	 * @param Categoria
	 * @throws SQLException 
	 */
	public void aggiungiLibro(Libro libro, ArrayList<String> autori) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverMaagerConnectionPool.getConnection();
		//	checkAutori(autori, connection);

			String insertSQL = "INSERT INTO libro"
					+ " (isbn, titolo, trama, foto, casaEditrice, prezzo, quantit‡Disponibile, categoria) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";



			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(0, libro.getIsbn());
			preparedStatement.setString(1, libro.getTitolo());
			preparedStatement.setString(2, libro.getTrama());
			preparedStatement.setString(3, libro.getFoto());
			preparedStatement.setString(4, libro.getCasaEditrice());
			preparedStatement.setDouble(5, libro.getPrezzo());
			preparedStatement.setInt(6, libro.getQuantit‡());
			preparedStatement.setString(7, libro.getCategoria());

			preparedStatement.executeUpdate();

			connection.commit();
			
			insertAutori(autori, libro.getIsbn(), connection);
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	private void insertAutori(ArrayList<String> autori, String isbn, Connection connection) throws SQLException {
		PreparedStatement preparedStatement= null;
		
		String insertQ= "insert into scrittoDa (libroISBN, autoreID) values (?, ?)";
		
		for(String autore: autori) {
			preparedStatement = connection.prepareStatement(insertQ);
			preparedStatement.setString(0, isbn);
			preparedStatement.setString(1, autore);
			preparedStatement.executeUpdate();
		}
		
		try {
			if (preparedStatement != null)
				preparedStatement.close();
		} finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
	}

	private void checkAutori(ArrayList<Autore> autori, Connection connection) {
/*		PreparedStatement preparedStatement= null;
		
		for(String nomeCognome : autori) {
			String selectQ= "select * from autori where nome = ? and cognome = ?"
			
			if(!rs.hasNext()) insert..
		}*/
	}

	/**
	 * 
	 * @param tipo
	 * @param nuovoAttributo
	 * @throws SQLException 
	 */
	public void modificaAttributo(String isbn, String tipo, String nuovoAttributo) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;
		
		connection= DriverMaagerConnectionPool.getConnection();
		
		try {
			String updateQ = "UPDATE libro WHERE isbn = " + isbn + " set " + tipo + " = " + nuovoAttributo;
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.executeUpdate();
		}finally {
			try {
				preparedStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	/**
	 * 
	 * @param isbn
	 * @throws SQLException 
	 */
	public void eliminaLibro(String isbn) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;
		
		connection= DriverMaagerConnectionPool.getConnection();
		
		try {
			String deleteQ = "DELETE FROM libro WHERE isbn = " + isbn;
			preparedStatement= connection.prepareStatement(deleteQ);
			preparedStatement.executeUpdate();
		}finally {
			try {
				preparedStatement.close();
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
	public void eliminaRecensione(int idRecensione) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;
		
		connection= DriverMaagerConnectionPool.getConnection();
		
		try {
			String deleteQ = "DELETE FROM recensione WHERE id = " + idRecensione;
			preparedStatement= connection.prepareStatement(deleteQ);
			preparedStatement.executeUpdate();
		}finally {
			try {
				preparedStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	/**
	 * 
	 * @param email
	 * @throws SQLException 
	 */
	public Utente ricercaAccount(String email) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement preparedStatement= null;
		
		String selectQ= "SELECT * FROM utente WHERE email = " + email;
		Utente utente= new Utente();
		try {
			preparedStatement= connection.prepareStatement(selectQ);
			ResultSet rs= preparedStatement.executeQuery();
			
			while(rs.next()) {
				utente.setEmail("email");
				utente.setNome(rs.getString("nome"));
				utente.setDataDiNascita(rs.getDate("dataDiNascita"));
				utente.setCognome(rs.getString("cognome"));
				utente.setPassword(rs.getString("password"));
				utente.setTipo(rs.getString("tipo"));
			}
		}finally {
			try {
			if(preparedStatement!=null)
				preparedStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return utente;
	}

	/**
	 * 
	 * @param email
	 * @param tipo
	 * @throws SQLException 
	 */
	public void cambiaTipo(String email, String tipo) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;
		
		connection= DriverMaagerConnectionPool.getConnection();
		
		try {
			String updateQ = "UPDATE utente WHERE email = " + email + " set tipo = " + tipo;
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.executeUpdate();
		}finally {
			try {
				preparedStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	/**
	 * 
	 * @param email
	 * @throws SQLException 
	 */
	public void eliminaUtente(String email) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;
		
		connection= DriverMaagerConnectionPool.getConnection();
		
		try {
			String deleteQ = "DELETE FROM utente WHERE email = " + email;
			preparedStatement= connection.prepareStatement(deleteQ);
			preparedStatement.executeUpdate();
		}finally {
			try {
				preparedStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	}

}