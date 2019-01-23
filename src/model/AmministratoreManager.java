package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	//DA FINIRE
	public void aggiungiLibro(Libro libro) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverMaagerConnectionPool.getConnection();

			//  Viene inserito il libro
			String insertSQL = "INSERT INTO libro"
					+ " (isbn, titolo, trama, foto, casaEditrice, prezzo, quantit‡Disponibile, categoria,copieVendute) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";



			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, libro.getIsbn());
			preparedStatement.setString(2, libro.getTitolo());
			preparedStatement.setString(3, libro.getTrama());
			preparedStatement.setString(4, libro.getFoto());
			preparedStatement.setString(5, libro.getCasaEditrice());
			preparedStatement.setDouble(6, libro.getPrezzo());
			preparedStatement.setInt(7, libro.getQuantit‡());
			preparedStatement.setString(8, libro.getCategoria());
			preparedStatement.setInt(9, libro.getCopieVendute());

			preparedStatement.executeUpdate();

			//per ogni autore verifichiamo se Ë presente nel database, se non Ë presente lo inseriamo nella tabella autore e poi inseriamo
			//una tupla nella tabbella scrive.
			//Se non Ë presente inseriamo solamente una tupla nella tabella scrive.
			for(Autore temp : libro.getAutori()){

				if(!presenteAutore(temp,connection)){
					insertAutore(temp.getNome(), connection);
				}
					insertScrive(temp.getNome(),libro.getIsbn(),connection);
				
			}

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	private void insertScrive(String nome, String isbn, Connection connection) throws SQLException {
		
		PreparedStatement preparedStatement=null;
		
		try{
			String InsertSQL="insert into Scrivi(autore,libro)"
					+ "values(?,?)";
			
			preparedStatement=connection.prepareStatement(InsertSQL);
			preparedStatement.setString(1,nome);
			preparedStatement.setString(2,isbn);
			
			preparedStatement.executeUpdate();
			
		} finally{
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	private void insertAutore(String nome, Connection connection) throws SQLException {
		
		PreparedStatement preparedStatement=null;
		
		try{
			String InsertSQL="insert into autore(nome)"
					+ "values(?)";
			
			preparedStatement=connection.prepareStatement(InsertSQL);
			preparedStatement.setString(1,nome);
			
			preparedStatement.executeUpdate();
			
		} finally{
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		
		
	}

	
	//DA FINIRE
	private boolean presenteAutore(Autore autore, Connection connection) throws SQLException {

		PreparedStatement preparedStatement= null;

		String checkSQL="SELECT * "
				+ "FROM AUTORE"
				+ "WHERE nome=?";

		boolean trovato=false;
		
		try{
			preparedStatement=connection.prepareStatement(checkSQL);
			preparedStatement.setString(1, autore.getNome());

			ResultSet rs=preparedStatement.executeQuery();

			if(rs.next()){
				trovato= true;;
			}


		}finally{
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}

		return trovato;

	}

	/**
	 * 
	 * @param tipo
	 * @param nuovoAttributo
	 * @throws SQLException 
	 */

	public void modificaDataUscita(String isbn, Date nuovoAttributo) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;

		connection= DriverMaagerConnectionPool.getConnection();
		try {
			String updateQ = "UPDATE libro WHERE isbn = ? SET dataUscita = ?";
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.setString(1, isbn);
			preparedStatement.setDate(2, nuovoAttributo);
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

	public void modificaCopieVendute(String isbn, int nuovoAttributo) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;

		connection= DriverMaagerConnectionPool.getConnection();
		try {
			String updateQ = "UPDATE libro WHERE isbn = ? SET copieVendute = ?";
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.setString(1, isbn);
			preparedStatement.setInt(2, nuovoAttributo);
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

	public void modificaCategoria(String isbn, String nuovoAttributo) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;

		connection= DriverMaagerConnectionPool.getConnection();
		try {
			String updateQ = "UPDATE libro WHERE isbn = ? SET ? = ?";
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.setString(1, isbn);
			preparedStatement.setString(2, nuovoAttributo);
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

	public void modificaQuantit‡Disponibile(String isbn, int nuovoAttributo) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;

		connection= DriverMaagerConnectionPool.getConnection();
		try {
			String updateQ = "UPDATE libro WHERE isbn = ? SET quantit‡Disponibile = ?";
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.setString(1, isbn);
			preparedStatement.setInt(2, nuovoAttributo);
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

	public void modificaPrezzo(String isbn, double nuovoAttributo) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;

		connection= DriverMaagerConnectionPool.getConnection();
		try {
			String updateQ = "UPDATE libro WHERE isbn = ? SET prezzo = ?";
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.setString(1, isbn);
			preparedStatement.setDouble(2, nuovoAttributo);
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

	public void modificaCasaEditrice(String isbn, String nuovoAttributo) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;

		connection= DriverMaagerConnectionPool.getConnection();
		try {
			String updateQ = "UPDATE libro WHERE isbn = ? SET casaEditrice = ?";
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.setString(1, isbn);
			preparedStatement.setString(2, nuovoAttributo);
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

	public void modificaFoto(String isbn, String nuovoAttributo) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;

		connection= DriverMaagerConnectionPool.getConnection();
		try {
			String updateQ = "UPDATE libro WHERE isbn = ? SET foto = ?";
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.setString(1, isbn);
			preparedStatement.setString(2, nuovoAttributo);
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

	public void modificaTrama(String isbn, String nuovoAttributo) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;

		connection= DriverMaagerConnectionPool.getConnection();
		try {
			String updateQ = "UPDATE libro WHERE isbn = ? SET trama = ?";
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.setString(1, isbn);
			preparedStatement.setString(2, nuovoAttributo);
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

	public void modificaTitolo(String isbn, String nuovoAttributo) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;

		connection= DriverMaagerConnectionPool.getConnection();
		try {
			String updateQ = "UPDATE libro WHERE isbn = ? SET titolo = ?";
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.setString(1, isbn);
			preparedStatement.setString(2, nuovoAttributo);
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
				utente.setEmail(email);
				utente.setNome(rs.getString("nome"));
				utente.setDataDiNascita(rs.getDate("dataDiNascita"));
				utente.setCognome(rs.getString("cognome"));
				utente.setPassword(rs.getString("psw"));
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