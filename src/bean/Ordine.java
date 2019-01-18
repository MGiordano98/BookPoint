package bean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

public class Ordine implements Serializable{
	private static final long serialVersionUID = 1L;

	private int idOrdine;
	private Date dataEffettuata;
	private Date dataConsegna;
	private Time ora;
	private String numCarta;
	private String via;
	private String città;
	private String cap;
	private double prezzoTot;
	private String stato;
	private Collection<Libro> libri;
	
	

	public Ordine() {
		super();
	}

	public Ordine(int idOrdine, Date dataEffettuata, Date dataConsegna, Time ora, String numCarta, String via, String città, String cap,
			double prezzoTot, String stato, Collection<Libro> libri) {
		super();
		this.idOrdine = idOrdine;
		this.dataEffettuata = dataEffettuata;
		this.dataConsegna = dataConsegna;
		this.ora = ora;
		this.numCarta = numCarta;
		this.via = via;
		this.città = città;
		this.cap = cap;
		this.prezzoTot = prezzoTot;
		this.stato = stato;
		this.libri = libri;
	}

	public int getIdOrdine() {
		return this.idOrdine;
	}

	/**
	 * 
	 * @param idOrdine
	 */
	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public Date getDataEffettuata() {
		return this.dataEffettuata;
	}

	/**
	 * 
	 * @param data
	 */
	public void setDataEffettuata(Date data) {
		this.dataEffettuata = data;
	}

	
	
	public Date getDataConsegna() {
		return dataConsegna;
	}

	public void setDataConsegna(Date dataConsegna) {
		this.dataConsegna = dataConsegna;
	}

	public Time getOra() {
		return this.ora;
	}

	/**
	 * 
	 * @param ora
	 */
	public void setOra(Time ora) {
		this.ora = ora;
	}

	public String getNumCarta() {
		return this.numCarta;
	}

	/**
	 * 
	 * @param numCarta
	 */
	public void setNumCarta(String numCarta) {
		this.numCarta = numCarta;
	}

	public String getVia() {
		return this.via;
	}

	/**
	 * 
	 * @param via
	 */
	public void setVia(String via) {
		this.via = via;
	}

	public String getCittà() {
		return this.città;
	}

	/**
	 * 
	 * @param città
	 */
	public void setCittà(String città) {
		this.città = città;
	}

	public String getCap() {
		return this.cap;
	}

	/**
	 * 
	 * @param cap
	 */
	public void setCap(String cap) {
		this.cap = cap;
	}

	public double getPrezzoTot() {
		return this.prezzoTot;
	}

	/**
	 * 
	 * @param prezzoTot
	 */
	public void setPrezzoTot(double prezzoTot) {
		this.prezzoTot = prezzoTot;
	}


	public Collection<Libro> getLibri() {
		return this.libri;
	}

	/**
	 * 
	 * @param libri
	 */
	public void setLibri(Collection<Libro> libri) {
		this.libri = libri;
	}

	public String getStato() {
		return stato;
	}

	/**
	 * 
	 * @param stato
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}

	
}