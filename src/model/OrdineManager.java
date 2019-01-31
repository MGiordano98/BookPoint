package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
		PreparedStatement getIdStatement= null;
		PreparedStatement pStatement= null;
		
		String getIdQ="Select max(numero) as id from ordine";
		int idOrdine=0;
		try{
			getIdStatement=connection.prepareStatement(getIdQ);
			ResultSet rs1=getIdStatement.executeQuery();
			if(rs1.next()){
				idOrdine=rs1.getInt("id")+1;
			}
			else{
				return false;
			}
		}
		finally{
			try {
				if(getIdStatement!=null) {
					getIdStatement.close();
				}
			}finally{
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		
		String insertQ= "INSERT INTO ordine (numero,dataOrdine, oraConsegna, dataConsegna, totale, via, numeroCivico, cap, citt‡, stato, numeroCarta, utente)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		boolean result = false;
		
		try {
			pStatement= connection.prepareStatement(insertQ);
			pStatement.setInt(1, idOrdine);
			pStatement.setDate(2, ordine.getDataEffettuata());
			pStatement.setTime(3, ordine.getOra());
			pStatement.setDate(4, ordine.getDataConsegna());
			pStatement.setDouble(5, ordine.getPrezzoTot());
			pStatement.setString(6, ordine.getVia());
			pStatement.setInt(7, ordine.getNumCivico());
			pStatement.setString(8, ordine.getCap());
			pStatement.setString(9, ordine.getCitt‡());
			pStatement.setString(10, ordine.getStato());
			pStatement.setString(11, ordine.getNumCarta());
			pStatement.setString(12, ordine.getEmail());
			int result1 =pStatement.executeUpdate();
			connection.commit();
			
			ordine.setIdOrdine(idOrdine);
			int result2 =doSaveLibriAcquistati(connection, ordine);
			int result3 =doUpdateQuantit‡(connection, ordine);
			
			if(result1!=0 && result2!=0) result=true;
		}finally {
			try {
				if(pStatement!=null) {
					pStatement.close();
					getIdStatement.close();
				}
			}finally{
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return result;
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

	private int doUpdateQuantit‡(Connection connection, Ordine ordine) throws SQLException {
		PreparedStatement pStatement= null;
		String selectQ= "SELECT quantit‡Disponibile, copieVendute FROM libro WHERE isbn=?";
		Collection<Libro> libriAcquistati= ordine.getLibri();
		boolean fallimento= false;
		int result=0;
		try {
			for(Libro l: libriAcquistati) {
				pStatement= connection.prepareStatement(selectQ);
				pStatement.setString(1, l.getIsbn());
				ResultSet rs= pStatement.executeQuery();
				if(rs.next()) {
					int quantit‡Disponibile= rs.getInt("quantit‡Disponibile");
					int copieVendute= rs.getInt("copieVendute");
					if(doUpdateQuantit‡Disponibile(connection, copieVendute, quantit‡Disponibile, l.getQuantit‡Selezionata(), l.getIsbn())==1) {
						fallimento= true;
					}
				}
			}
		}finally {
			try {
				if(pStatement!=null)
					pStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		if(!fallimento) result=1; 
		return result;
		
	}
	
	private int doUpdateQuantit‡Disponibile(Connection connection, int copieVendute, int quantit‡Disponibile,
			int quantit‡Selezionata, String isbn) throws SQLException {
		PreparedStatement pStatement= null;
		String updateQ= "UPDATE libro SET quantit‡Disponibile= ?, copieVendute= ? WHERE isbn= ?";
		int result=0;
		try {
			pStatement= connection.prepareStatement(updateQ);
			pStatement.setInt(1, quantit‡Disponibile - quantit‡Selezionata);
			pStatement.setInt(2, copieVendute+ quantit‡Selezionata);
			pStatement.setString(3, isbn);
			if(pStatement.executeUpdate()==1) {
				result=1;
			}
			connection.commit();
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