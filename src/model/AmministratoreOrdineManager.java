package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;


import bean.Ordine;
import connectionPool.DriverMaagerConnectionPool;

public class AmministratoreOrdineManager {

	/**
	 * 
	 * @param numOrdine il numero dell'ordine da ricercare
	 * @return null se non ha trovato l'ordine, altrimenti ritorna un Ordine con i dati dell'ordine cercato
	 * @throws SQLException
	 */
	public Ordine ricercaOrdine(int numOrdine) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;

		String selectQ= "SELECT * FROM ordine WHERE numero = ?";
		Ordine ordine=null;
		try{
			if(numOrdine<=0) throw new IllegalArgumentException("Numero ordine errato");
			try {
				pStatement= connection.prepareStatement(selectQ);
				pStatement.setInt(1, numOrdine);
				ResultSet rs= pStatement.executeQuery();

				if(rs.next()) {
					ordine=new Ordine();
					ordine.setCittà(rs.getString("città"));
					ordine.setDataEffettuata(rs.getDate("dataOrdine"));
					ordine.setDataConsegna(rs.getDate("dataConsegna"));
					ordine.setOra(rs.getTime("oraConsegna"));
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
		}catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		return ordine;

	}

	/**
	 * 
	 * @param numOrdine il numero dell'ordine di cui si deve cambiare lo stato
	 * @param stato il nuovo stato
	 * @return true se lo stato è stato cambiato con successo, altrimenti false
	 * @throws SQLException
	 */
	public boolean cambiaStato(int numOrdine, String stato) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;

		boolean result= false;
		String updateQ= "UPDATE ordine SET stato = ? WHERE numero = ?";

		try{
			if(numOrdine<=0) throw new IllegalArgumentException("Numero ordine errato");
			if(!stato.equalsIgnoreCase("In preparazione") &&  !stato.equalsIgnoreCase("In transito") && !stato.equalsIgnoreCase("In consegna") && !stato.equalsIgnoreCase("Consegnato")) throw new IllegalArgumentException("Stato errato");
			try {
				pStatement= connection.prepareStatement(updateQ);
				pStatement.setString(1, stato);
				pStatement.setInt(2, numOrdine);
				if(pStatement.executeUpdate()==1) {
					result= true;
				}
				connection.commit();
			}finally {
				try {
					if(pStatement!=null) pStatement.close();
				}finally {
					DriverMaagerConnectionPool.releaseConnection(connection);
				}
			}
		}catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 
	 * @param numOrdine il numero dell'ordine di cui si deve cambiare la data e l'ora
	 * @param data la nuova data d'arrivo
	 * @param ora la nuova ora d'arrivo
	 * @return true se la data e l'ora d'arrivo sono state cambiate con successo, altrimenti false
	 * @throws SQLException
	 */
	public boolean cambiaDataEOra(int numOrdine, Date data, Time ora) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;

		boolean result= false;
		String updateQ= "UPDATE ordine SET dataConsegna = ?, oraConsegna = ? WHERE numero = ?";
		try{

			if(numOrdine<=0) throw new IllegalArgumentException("Numero ordine errato");
			if(data==null) throw new IllegalArgumentException("Data errata");
			if(ora==null) throw new IllegalArgumentException("Ora errata");
			try {
				pStatement= connection.prepareStatement(updateQ);
				pStatement.setDate(1, data);
				pStatement.setTime(2, ora);
				pStatement.setInt(3, numOrdine);
				if(pStatement.executeUpdate()==1) {
					result= true;
				}
				connection.commit();
			}finally {
				try {
					if(pStatement!=null) pStatement.close();
				}finally {
					DriverMaagerConnectionPool.releaseConnection(connection);
				}
			}
		}catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		return result;
	}

}