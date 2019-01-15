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
			preparedStatement.setString(1, libro.getIsbn());
			preparedStatement.setString(2, libro.getTitolo());
			preparedStatement.setString(3, libro.getTrama());
			preparedStatement.setString(4, libro.getFoto());
			preparedStatement.setString(5, libro.getCasaEditrice());
			preparedStatement.setDouble(6, libro.getPrezzo());
			preparedStatement.setInt(7, libro.getQuantit‡());
			preparedStatement.setString(8, libro.getCategoria());

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
		
		String insertQ= "insert into scrive (libro, autore) values (?, ?)";
		
		for(String autore: autori) {
			preparedStatement = connection.prepareStatement(insertQ);
			preparedStatement.setString(1, isbn);
			preparedStatement.setString(2, autore);
			preparedStatement.executeUpdate();
			connection.commit();
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
			String updateQ = "UPDATE libro WHERE isbn = ? SET ? = ?";
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.setString(1, isbn);
			preparedStatement.setString(2, tipo);
			preparedStatement.setString(3, nuovoAttributo);
			preparedStatement.executeUpdate();
			connection.commit();
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
			String deleteQ = "DELETE FROM libro WHERE isbn = ?";
			preparedStatement= connection.prepareStatement(deleteQ);
			preparedStatement.setString(1, isbn);
			preparedStatement.executeUpdate();
			connection.commit();
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
			String deleteQ = "DELETE FROM recensione WHERE id = ?";
			preparedStatement= connection.prepareStatement(deleteQ);
			preparedStatement.setInt(1, idRecensione);
			preparedStatement.executeUpdate();
			connection.commit();
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
		
		String selectQ= "SELECT * FROM utente WHERE email = ?";
		Utente utente= new Utente();
		try {
			preparedStatement= connection.prepareStatement(selectQ);
			preparedStatement.setString(1, email);
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
			String updateQ = "UPDATE utente WHERE email = ? SET tipo = ?";
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, tipo);
			preparedStatement.executeUpdate();
			connection.commit();
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
			String deleteQ = "DELETE FROM utente WHERE email = ?";
			preparedStatement= connection.prepareStatement(deleteQ);
			preparedStatement.setString(1, email);
			preparedStatement.executeUpdate();
			connection.commit();
		}finally {
			try {
				preparedStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	}

}