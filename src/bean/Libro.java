package bean;

import java.io.Serializable;

public class Libro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String isbn;
	private String titolo;
	private String trama;
	private String foto;
	private String casaEditrice;
	private double prezzo;
	private int quantitąDisponibile;
	private String categoria;
	
	
	
	public Libro() {
		super();
	}

	public Libro(String isbn, String titolo, String trama, String foto, String casaEditrice, double prezzo, int quantitąDisponibile,
			String categoria) {
		super();
		this.isbn = isbn;
		this.titolo = titolo;
		this.trama = trama;
		this.foto = foto;
		this.casaEditrice = casaEditrice;
		this.prezzo = prezzo;
		this.quantitąDisponibile = quantitąDisponibile;
		this.categoria = categoria;
	}
	
	

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitolo() {
		return this.titolo;
	}

	/**
	 * 
	 * @param titolo
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getTrama() {
		return this.trama;
	}

	/**
	 * 
	 * @param trama
	 */
	public void setTrama(String trama) {
		this.trama = trama;
	}

	public String getFoto() {
		return this.foto;
	}

	/**
	 * 
	 * @param foto
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getCasaEditrice() {
		return this.casaEditrice;
	}

	/**
	 * 
	 * @param casaEditrice
	 */
	public void setCasaEditrice(String casaEditrice) {
		this.casaEditrice = casaEditrice;
	}

	public double getPrezzo() {
		return this.prezzo;
	}

	/**
	 * 
	 * @param prezzo
	 */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantitąDisponibile() {
		return this.quantitąDisponibile;
	}

	/**
	 * 
	 * @param quantitąDisponibile
	 */
	public void setQuantitąDisponibile(int quantitąDisponibile) {
		this.quantitąDisponibile = quantitąDisponibile;
	}

	public String getCategoria() {
		return this.categoria;
	}

	/**
	 * 
	 * @param categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


}