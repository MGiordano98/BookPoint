 package model;

import java.sql.Connection;
import java.sql.Date;
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
	 * @param libro il libro da aggiungere
	 * @return true se il libro Ë stato aggiunto con successo, altrimenti false
	 * @throws SQLException
	 */
	public boolean aggiungiLibro(Libro libro) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		boolean result= false;
		try {
			connection = DriverMaagerConnectionPool.getConnection();

			//  Viene inserito il libro
			String insertSQL = "INSERT INTO libro"
					+ " (isbn, titolo, trama, foto, casaEditrice, prezzo, quantit‡Disponibile, categoria, dataUscita)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, libro.getIsbn());
			preparedStatement.setString(2, libro.getTitolo());
			preparedStatement.setString(3, libro.getTrama());
			preparedStatement.setString(4, libro.getFoto());
			preparedStatement.setString(5, libro.getCasaEditrice());
			preparedStatement.setDouble(6, libro.getPrezzo());
			preparedStatement.setInt(7, libro.getQuantit‡());
			preparedStatement.setString(8, libro.getCategoria());
			preparedStatement.setDate(9, libro.getDataUscita());

			if(preparedStatement.executeUpdate()==1) {
				result=true;
			}

			connection.commit();

			//per ogni autore verifichiamo se Ë presente nel database, se non Ë presente lo inseriamo nella tabella autore e poi inseriamo
			//una tupla nella tabbella scrive.
			//Se non Ë presente inseriamo solamente una tupla nella tabella scrive.
			ArrayList<Autore> libri= libro.getAutori();
			for(Autore temp : libri){

				if(!presenteAutore(temp,connection)){
					insertAutore(temp.getNome());
				}
				if(!insertScrive(temp.getNome(),libro.getIsbn(),connection)) {
					result= false;
				}

			}

			connection.commit();
		}catch(Exception e) {
			return false;
		}	finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
				result= true;
			}
		}
		return result;
	}

	/**
	 * 
	 * @param nome il nome dell'autore
	 * @param isbn l'isbn del libro scritto dall'autore
	 * @param connection la connessione con il database
	 * @return true se l'inserimento Ë avvenuto con successo, altrimenti false
	 * @throws SQLException
	 */
	private boolean insertScrive(String nome, String isbn, Connection connection) throws SQLException {

		PreparedStatement preparedStatement=null;
		boolean result= false;

		try{
			String InsertSQL="insert into scrive(autore, libro) "
					+ "values(?, ?)";

			preparedStatement=connection.prepareStatement(InsertSQL);
			preparedStatement.setString(1,nome);
			preparedStatement.setString(2,isbn);

			if(preparedStatement.executeUpdate()==1) {
				result= true;
			}

			connection.commit();

		}catch(Exception e){
			return false;
		} finally{
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param nome il nome dell'autore
	 * @return true se l'inserimento dell'autore Ë avvenuto con successo, altrimenti false
	 * @throws SQLException
	 */
	private boolean insertAutore(String nome) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		
		PreparedStatement preparedStatement=null;
		boolean result= false;
		try{
			String InsertSQL="insert into autore(nome) "
					+ "values(?)";

			preparedStatement=connection.prepareStatement(InsertSQL);
			preparedStatement.setString(1,nome);

			if(preparedStatement.executeUpdate()==1) {
				result= true;
			}

			connection.commit();
		}catch(Exception e){
			return false;
		} finally{
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param autore l'autore di cui si deve controllare la presenza
	 * @param connection la connessione al db
	 * @return true se l'autore Ë gi‡ presente nel db, altrimenti false
	 * @throws SQLException
	 */
	private boolean presenteAutore(Autore autore, Connection connection) throws SQLException {

		PreparedStatement preparedStatement= null;

		String checkSQL="SELECT * "
				+ "FROM autore "
				+ "WHERE nome = ?";

		boolean trovato=false;

		try{
			preparedStatement=connection.prepareStatement(checkSQL);
			preparedStatement.setString(1, autore.getNome());

			ResultSet rs=preparedStatement.executeQuery();

			if(rs.next()){
				trovato= true;
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
	 * @param isbn del libro di cui si deve modificare la data d'uscita
	 * @param nuovoAttributo la nuova data d'uscita
	 * @return true se la data d'uscita Ë stata modificata con successo, altrimenti false
	 * @throws SQLException
	 */
	public boolean modificaDataUscita(String isbn, Date nuovoAttributo) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;

		boolean result= false;
		connection= DriverMaagerConnectionPool.getConnection();
		try {
			String updateQ = "UPDATE libro SET dataUscita = ? WHERE isbn = ?";
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.setDate(1, nuovoAttributo);
			preparedStatement.setString(2, isbn);
			if(preparedStatement.executeUpdate()==1) {
				result= true;
			}
			connection.commit();
		}catch(Exception e){
			return false;
		}finally {
			try {
				preparedStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param isbn l'isbn del libro di cui si deve modificare la categoria
	 * @param nuovoAttributo la nuova categoria
	 * @return true se la categoria Ë stata modificata con successo, altrimenti false
	 * @throws SQLException
	 */
	public boolean modificaCategoria(String isbn, String nuovoAttributo) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;

		boolean result= false;
		connection= DriverMaagerConnectionPool.getConnection();
		try {
			String updateQ = "UPDATE libro SET categoria = ? WHERE isbn = ?";
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.setString(1, nuovoAttributo);
			preparedStatement.setString(2, isbn);

			if(preparedStatement.executeUpdate()==1) {
				result= true;
			}
			connection.commit();
		}catch(Exception e){
			return false;
		}finally {
			try {
				preparedStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param isbn l'isbn del libro di cui si deve modificare la quantit‡ disponibile
	 * @param nuovoAttributo la nuova quantit‡ disponibile
	 * @return true se la quantit‡ disponibile Ë stata modificata con successo, altrimenti false
	 * @throws SQLException
	 */
	public boolean modificaQuantit‡Disponibile(String isbn, int nuovoAttributo) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;

		boolean result=false;
		connection= DriverMaagerConnectionPool.getConnection();
		try {
			String updateQ = "UPDATE libro SET quantit‡Disponibile = ? WHERE isbn = ?";
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.setInt(1, nuovoAttributo);
			preparedStatement.setString(2, isbn);
			if(preparedStatement.executeUpdate()==1) {
				result= true;
			}
			connection.commit();
		}catch(Exception e){
			return false;
		}finally {
			try {
				preparedStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param isbn l'isbn del libro di cui si deve modificare il prezzo
	 * @param nuovoAttributo il nuovo prezzo
	 * @return true se il prezzo Ë stato modificato con successo, altrimenti false
	 * @throws SQLException
	 */
	public boolean modificaPrezzo(String isbn, double nuovoAttributo) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;

		boolean result= false;
		connection= DriverMaagerConnectionPool.getConnection();
		try {
			String updateQ = "UPDATE libro SET prezzo = ? WHERE isbn = ?";
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.setDouble(1, nuovoAttributo);
			preparedStatement.setString(2, isbn);
			if(preparedStatement.executeUpdate()==1) {
				result= true;
			}
			connection.commit();
		}catch(Exception e){
			return false;
		}finally {
			try {
				preparedStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param isbn l'isbn del libro di cui si deve modificare la casa editrice
	 * @param nuovoAttributo la nuova casa editrice
	 * @return true se la casa editrice Ë stata modificata con successo, altrimenti false
	 * @throws SQLException
	 */
	public boolean modificaCasaEditrice(String isbn, String nuovoAttributo) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;

		boolean result= false;
		connection= DriverMaagerConnectionPool.getConnection();
		try {
			String updateQ = "UPDATE libro SET casaEditrice = ? WHERE isbn = ?";
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.setString(1, nuovoAttributo);
			preparedStatement.setString(2, isbn);
			if(preparedStatement.executeUpdate()==1) {
				result= true;
			}
			connection.commit();
		}catch(Exception e){
			return false;
		}finally {
			try {
				preparedStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param isbn l'isbn del libro di cui si deve modificare la foto
	 * @param nuovoAttributo la nuova foto
	 * @return true se la foto Ë stata modificata con successo, altrimenti false
	 * @throws SQLException
	 */
	public boolean modificaFoto(String isbn, String nuovoAttributo) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;

		boolean result= false;
		connection= DriverMaagerConnectionPool.getConnection();
		try {
			String updateQ = "UPDATE libro SET foto = ? WHERE isbn = ?";
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.setString(1, nuovoAttributo);
			preparedStatement.setString(2, isbn);
			if(preparedStatement.executeUpdate()==1) {
				result= true;
			}
			connection.commit();
		}catch(Exception e){
			return false;
		}finally {
			try {
				preparedStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param isbn l'isbn del libro di cui si deve modificare la trama
	 * @param nuovoAttributo la nuova trama
	 * @return true se la trama Ë stata modifica con successo, altrimenti false
	 * @throws SQLException
	 */
	public boolean modificaTrama(String isbn, String nuovoAttributo) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;

		boolean result= false;
		connection= DriverMaagerConnectionPool.getConnection();
		try {
			String updateQ = "UPDATE libro SET trama = ? WHERE isbn = ?";
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.setString(1, nuovoAttributo);
			preparedStatement.setString(2, isbn);
			if(preparedStatement.executeUpdate()==1) {
				result= true;
			}
			connection.commit();
		}catch(Exception e){
			return false;
		}finally {
			try {
				preparedStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param isbn l'isbn del libro di cui si deve modificare il titolo
	 * @param nuovoAttributo il nuovo titolo 
	 * @return true se il titolo Ë stato modificato con successo, altrimenti false
	 * @throws SQLException
	 */
	public boolean modificaTitolo(String isbn, String nuovoAttributo) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;
		boolean result= false;
		connection= DriverMaagerConnectionPool.getConnection();
		try {
			String updateQ = "UPDATE libro SET titolo = ? WHERE isbn = ?";
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.setString(1, nuovoAttributo);
			preparedStatement.setString(2, isbn);
			if(preparedStatement.executeUpdate()==1) {
				result= true;
			}
			connection.commit();
		}catch(Exception e){
			return false;
		}finally {
			try {
				preparedStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param isbn l'isbn del libro da eliminare
	 * @return
	 * @throws SQLException
	 */
	public boolean eliminaLibro(String isbn) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;

		boolean result= false;
		connection= DriverMaagerConnectionPool.getConnection();

		try {
			String deleteQ = "DELETE FROM libro WHERE isbn = ?";
			preparedStatement= connection.prepareStatement(deleteQ);
			preparedStatement.setString(1, isbn);
			if(preparedStatement.executeUpdate()==1) {
				result= true;
			}
			connection.commit();
		}catch(Exception e){
			return false;
		}finally {
			try {
				preparedStatement.close();
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
	public boolean eliminaRecensione(int idRecensione) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;

		boolean result= false;
		connection= DriverMaagerConnectionPool.getConnection();

		try {
			String deleteQ = "DELETE FROM recensione WHERE id = ?";
			preparedStatement= connection.prepareStatement(deleteQ);
			preparedStatement.setInt(1, idRecensione);
			if(preparedStatement.executeUpdate()==1) {
				result= true;
			}
			connection.commit();
		}catch(Exception e){
			return false;
		}finally {
			try {
				preparedStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return result;
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
	public boolean cambiaTipo(String email, String tipo) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;

		boolean result= false;
		connection= DriverMaagerConnectionPool.getConnection();

		try {
			String updateQ = "UPDATE utente SET tipo = ? WHERE email = ?";
			preparedStatement= connection.prepareStatement(updateQ);
			preparedStatement.setString(1, tipo);
			preparedStatement.setString(2, email);
			if(preparedStatement.executeUpdate()==1) {
				result= true;
			}
			connection.commit();
		}catch(Exception e){
			return false;
		}
			finally {
			try {
				preparedStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param email
	 * @throws SQLException 
	 */
	public boolean eliminaUtente(String email) throws SQLException {
		Connection connection= null;
		PreparedStatement preparedStatement= null;

		boolean result= false;
		connection= DriverMaagerConnectionPool.getConnection();

		try {
			String deleteQ = "DELETE FROM utente WHERE email = ?";
			preparedStatement= connection.prepareStatement(deleteQ);
			preparedStatement.setString(1, email);
			if(preparedStatement.executeUpdate()==1) {
				result= true;
			}
			connection.commit();
		}catch(Exception e){
			return false;
		}finally {
			try {
				preparedStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return result;
	}

}