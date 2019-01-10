package bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Ordine implements Serializable{
	private static final long serialVersionUID = 1L;

	private int idOrdine;
	private Date data;
	private String ora;
	private String numCarta;
	private String via;
	private String città;
	private int cap;
	private int prezzoTot;
	private List<Libro> libri;
	
	

	public Ordine() {
		super();
	}

	public Ordine(int idOrdine, Date data, String ora, String numCarta, String via, String città, int cap,
			int prezzoTot, List<Libro> libri) {
		super();
		this.idOrdine = idOrdine;
		this.data = data;
		this.ora = ora;
		this.numCarta = numCarta;
		this.via = via;
		this.città = città;
		this.cap = cap;
		this.prezzoTot = prezzoTot;
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

	public Date getData() {
		return this.data;
	}

	/**
	 * 
	 * @param data
	 */
	public void setData(Date data) {
		this.data = data;
	}

	public String getOra() {
		return this.ora;
	}

	/**
	 * 
	 * @param ora
	 */
	public void setOra(String ora) {
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

	public int getCap() {
		return this.cap;
	}

	/**
	 * 
	 * @param cap
	 */
	public void setCap(int cap) {
		this.cap = cap;
	}

	public int getPrezzoTot() {
		return this.prezzoTot;
	}

	/**
	 * 
	 * @param prezzoTot
	 */
	public void setPrezzoTot(int prezzoTot) {
		this.prezzoTot = prezzoTot;
	}

	public void getAttribute() {
		// TODO - implement Ordine.getAttribute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attribute
	 */
	public void setAttribute(int attribute) {
		// TODO - implement Ordine.setAttribute
		throw new UnsupportedOperationException();
	}

	public List<Libro> getLibri() {
		return this.libri;
	}

	/**
	 * 
	 * @param libri
	 */
	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}

}