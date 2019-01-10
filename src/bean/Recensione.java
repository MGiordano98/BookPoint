package bean;

import java.io.Serializable;

public class Recensione implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String testo;
	private String nomeUtente;
	private String email;

	
	
	public Recensione() {
		super();
	}

	public Recensione(String testo, String nomeUtente, String email) {
		super();
		this.testo = testo;
		this.nomeUtente = nomeUtente;
		this.email = email;
	}

	public String getTesto() {
		return this.testo;
	}

	/**
	 * 
	 * @param testo
	 */
	public void setTesto(String testo) {
		this.testo = testo;
	}

	public String getNomeUtente() {
		return this.nomeUtente;
	}

	/**
	 * 
	 * @param nomeUtente
	 */
	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public void getAttribute() {
		// TODO - implement Recensione.getAttribute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attribute
	 */
	public void setAttribute(int attribute) {
		// TODO - implement Recensione.setAttribute
		throw new UnsupportedOperationException();
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
