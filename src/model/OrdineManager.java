package model;

import connectionPool.*;

public class OrdineManager {
	
	static final private String NOME_TABELLA= "ordine";

	/**
	 * 
	 * @param isbn
	 * @param quantità
	 */
	public void aggiungiAlCarrello(String isbn, int quantità) {
		
		
	}

	/**
	 * 
	 * @param isbn
	 */
	public void eliminaDalCarrello(String isbn) {
		// TODO - implement OrdineManager.eliminaDalCarrello
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numCarta
	 * @param idIndirizzo
	 */
	public boolean completaAcquisto(int numCarta, int idIndirizzo) {
		// TODO - implement OrdineManager.completaAcquisto
		throw new UnsupportedOperationException();
	}

	public void selezionaCartaEIndirizzo() {
		// TODO - implement OrdineManager.selezionaCartaEIndirizzo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param isbn
	 */
	public void aumentaQuantità(String isbn) {
		// TODO - implement OrdineManager.aumentaQuantità
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param isbn
	 */
	public void diminuisciQuantità(String isbn) {
		// TODO - implement OrdineManager.diminuisciQuantità
		throw new UnsupportedOperationException();
	}

}