package bean;

import java.io.Serializable;

public class Indirizzo implements Serializable{
	private static final long serialVersionUID = 1L;

	private String via;
	private int numCivico;
	private int cap;
	private String città;
	private int id;
	
	
	
	public Indirizzo() {
		super();
	}

	public Indirizzo(String via, int numCivico, int cap, String città, int id) {
		super();
		this.via = via;
		this.numCivico = numCivico;
		this.cap = cap;
		this.città = città;
		this.id = id;
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

	public int getNumCivico() {
		return this.numCivico;
	}

	/**
	 * 
	 * @param numCivico
	 */
	public void setNumCivico(int numCivico) {
		this.numCivico = numCivico;
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

	public int getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

}