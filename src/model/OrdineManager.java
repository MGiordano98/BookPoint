package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import bean.Carrello;
import bean.Libro;
import bean.Ordine;
import connectionPool.*;

@SuppressWarnings("unused")
public class OrdineManager {
	
	static final private String NOME_TABELLA= "ordine";


	/**
	 * 
	 * @param numCarta
	 * @param idIndirizzo
	 * @throws SQLException 
	 */
	public boolean completaAcquisto(Ordine ordine) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		String insertQ= "INSERT INTO ordine (dataOrdine, oraConsegna, dataConsegna, totale, via, numeroCivico, cap, citt‡, stato, numeroCarta, utente)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		boolean result = false;
		
		try {
			pStatement= connection.prepareStatement(insertQ);
			pStatement.setDate(1, ordine.getDataEffettuata());
			pStatement.setTime(2, ordine.getOra());
			pStatement.setDate(3, ordine.getDataConsegna());
			pStatement.setDouble(4, ordine.getPrezzoTot());
			pStatement.setString(5, ordine.getVia());
			pStatement.setInt(6, ordine.getNumCivico());
			pStatement.setString(7, ordine.getCap());
			pStatement.setString(8, ordine.getCitt‡());
			pStatement.setString(9, ordine.getStato());
			pStatement.setString(10, ordine.getNumCarta());
			pStatement.setString(11, ordine.getEmail());
			int result1 =pStatement.executeUpdate();
			connection.commit();
			
			int idOrdine= doGetCodiceOrdine(ordine);
			ordine.setIdOrdine(idOrdine);
			
			int result2 =doSaveLibriAcquistati(connection, ordine);
			
			if(result1!=0 && result2!=0) result=true;
		}finally {
			try {
				if(pStatement!=null) {
					pStatement.close();
				}
			}finally{
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return result;
	}


	private int doGetCodiceOrdine(Ordine ordine) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int idOrdine=0;

		String selectSQL = "SELECT numero FROM " + "ordine" + " WHERE dataOrdine = ? AND oraConsegna = ? AND numeroCarta = ?";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setDate(1, ordine.getDataEffettuata());
			preparedStatement.setTime(2, ordine.getOra());
			preparedStatement.setString(3, ordine.getNumCarta());


			ResultSet rs = preparedStatement.executeQuery();

			if(rs.next()) {
				idOrdine= rs.getInt("numero");
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return idOrdine;
	}


	private int doSaveLibriAcquistati(Connection connection, Ordine ordine) throws SQLException {
		PreparedStatement pStatement= null;
		String insertQ= "INSERT INTO libriAcquistati (ordine, libro, titolo, quantit‡, prezzoAcquisto)"
				+ " values(?, ?, ?, ?, ?)";
		Collection<Libro> libriAcquistati= ordine.getLibri();
		int result=0;
		
		try {
			for(Libro l: libriAcquistati) {
					pStatement= connection.prepareStatement(insertQ);
					pStatement.setInt(1, ordine.getIdOrdine());
					pStatement.setString(2, l.getIsbn());
					pStatement.setString(3, l.getTitolo());
					pStatement.setInt(4, l.getQuantit‡Selezionata());
					pStatement.setDouble(5, l.getPrezzo());
					
					result= pStatement.executeUpdate();
					connection.commit();
			}
		}finally {
			try {
				if(pStatement!=null)
					pStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return result;
	}

	
	public Carrello aggiungiAlCarrello(Carrello carrello, Libro libro, int quantit‡) {
		
		carrello.aggiungiAlCarrello(libro, quantit‡);
		
		return carrello;
		
	}
	
	public Carrello aumentaQuantit‡(Carrello carrello,String isbn) {
		
		carrello.aumentaQuantit‡(isbn);
		
		return carrello;
	}
	
	public Carrello diminuisciQuantit‡(Carrello carrello,String isbn) {
		
		carrello.diminuisciQuantit‡(isbn);
		
		return carrello;
	}
	
	public Carrello rimuoviDalCarrello(Carrello carrello, String isbn) {
		
		carrello.rimuoviLibro(isbn);
		
		return carrello;
	}
}