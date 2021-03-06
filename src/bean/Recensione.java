package bean;

import java.io.Serializable;

public class Recensione implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String testo;
	private String isbn;
	private String email;

	
	
	public Recensione() {
		super();
	}

	public Recensione(int id, String testo, String isbn, String email) {
		super();
		this.testo = testo;
		this.isbn = isbn;
		this.email = email;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
