package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

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
		
		String insertQ= "INSERT INTO ordine (numero, data, oraConsegna, dataConsegna, totale, via, cap, citt‡, stato, numeroCarta)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		boolean result = false;
		
		try {
			pStatement= connection.prepareStatement(insertQ);
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

		String selectSQL = "SELECT numero FROM " + "ordine" + " WHERE data = ? AND oraConsegna = ? AND cartaDiCredito = ?";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setDate(1, ordine.getDataEffettuata());
			preparedStatement.setTime(2, ordine.getOra());
			preparedStatement.setInt(3, ordine.getNumCarta());


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
		String insertQ= "INSERT INTO libriAcquistati (ordine, libro, trama, quantit‡, prezzoAcquisto)"
				+ " values(?, ?, ?, ?, ?)";
		Collection<Libro> libriAcquistati= ordine.getLibri();
		int result=0;
		
		try {
			for(Libro l: libriAcquistati) {
					pStatement= connection.prepareStatement(insertQ);
					pStatement.setInt(1, ordine.getIdOrdine());
					pStatement.setString(2, l.getIsbn());
					pStatement.setString(3, l.getTrama());
					pStatement.setInt(4, l.getQuantit‡());
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

	
	public void aggiungiAlCarrello(Libro lib, int quantit‡) {
		lib.setQuantit‡Selezionata(quantit‡);
		libri.add(lib);
		totale+= lib.getPrezzo()* quantit‡;
	}
	
	public void aumentaQuantit‡(String isbn) {
		
	}
	
	public void diminuisciQuantit‡(String isbn) {
		
	}
	
	public void rimuoviDalCarrello(String isbn) {
		
	}
}