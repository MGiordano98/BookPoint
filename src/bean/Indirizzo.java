package bean;

import java.io.Serializable;

public class Indirizzo implements Serializable{
	private static final long serialVersionUID = 1L;

	private String via;
	private int numCivico;
	private String cap;
	private String citt�;
	private int id;
	
	
	
	public Indirizzo() {
		super();
	}

	public Indirizzo(String via, int numCivico, String cap, String citt�, int id) {
		super();
		this.via = via;
		this.numCivico = numCivico;
		this.cap = cap;
		this.citt� = citt�;
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

	public String getCitt�() {
		return this.citt�;
	}

	/**
	 * 
	 * @param citt�
	 */
	public void setCitt�(String citt�) {
		this.citt� = citt�;
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