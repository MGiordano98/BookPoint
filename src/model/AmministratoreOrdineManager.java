package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Ordine;
import connectionPool.DriverMaagerConnectionPool;

public class AmministratoreOrdineManager {

	/**
	 * 
	 * @param numOrdine
	 * @throws SQLException 
	 */
	public Ordine ricercaOrdine(int numOrdine) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		String selectQ= "SELECT * FROM ordine WHERE numero = ?";
		Ordine ordine= new Ordine();
		
		try {
			pStatement= connection.prepareStatement(selectQ);
			pStatement.setInt(1, numOrdine);
			ResultSet rs= pStatement.executeQuery();
			
			while(rs.next()) {
				ordine.setCittà(rs.getString("città"));
				ordine.setDataConsegna(rs.getDate("dataConsegna"));
				ordine.setOra(rs.getString("oraConsegna"));
				ordine.setIdOrdine(rs.getInt("numero"));
				ordine.setStato(rs.getString("stato"));
			}
		}finally {
			try {
				if(pStatement!=null) pStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return ordine;
		
	}

	/**
	 * 
	 * @param numOrdine
	 * @param stato
	 * @throws SQLException 
	 */
	public void cambiaStato(int numOrdine, String stato) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		String updateQ= "UPDATE ordine SET stato = " + stato + " WHERE numero = " + numOrdine;
		
		try {
			pStatement= connection.prepareStatement(updateQ);
			pStatement.executeUpdate();
			connection.commit();
		}finally {
			try {
				if(pStatement!=null) pStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	/**
	 * 
	 * @param numOrdine
	 * @param data
	 * @param ora
	 */
	public void cambiaDataEOra(int numOrdine, String data, String ora) {
		// TODO - implement AmministratoreOrdineManager.cambiaDataEOra
		throw new UnsupportedOperationException();
	}

}