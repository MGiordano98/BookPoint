package model;

import java.util.List;
import bean.*;

public class DataManager {

	/**
	 * 
	 * @param email
	 * @param password
	 */
	public boolean login(String email, String password) {
		// TODO - implement DataManager.login
		throw new UnsupportedOperationException();
	}

	public boolean logout() {
		// TODO - implement DataManager.logout
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 * @param password
	 */
	public boolean registrazione(String email, String password) {
		// TODO - implement DataManager.registrazione
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 */
	public List<CartaDiCredito> ricercaCarte(String email) {
		// TODO - implement DataManager.ricercaCarte
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 */
	public List<Indirizzo> ricercaIndirizzi(String email) {
		// TODO - implement DataManager.ricercaIndirizzi
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 * @param numCarta
	 * @param intestatario
	 * @param dataScadenza
	 * @param cvv
	 */
	public void aggiungiCarta(String email, int numCarta, String intestatario, String dataScadenza, int cvv) {
		// TODO - implement DataManager.aggiungiCarta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 * @param numCarta
	 */
	public void rimuoviCarta(String email, int numCarta) {
		// TODO - implement DataManager.rimuoviCarta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 * @param via
	 * @param numCivico
	 * @param cap
	 * @param citt‡
	 */
	public void aggiungiIndirizzo(String email, String via, int numCivico, int cap, String citt‡) {
		// TODO - implement DataManager.aggiungiIndirizzo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 * @param idIndirizzo
	 */
	public void rimuoviIndirizzo(String email, int idIndirizzo) {
		// TODO - implement DataManager.rimuoviIndirizzo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 * @param idIndirizzo
	 * @param via
	 * @param numCivico
	 * @param CAP
	 * @param citt‡
	 */
	public void modificaIndirizzo(String email, int idIndirizzo, String via, int numCivico, int CAP, String citt‡) {
		// TODO - implement DataManager.modificaIndirizzo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param isbn
	 * @param titolo
	 * @param trama
	 * @param foto
	 * @param casaEditrice
	 * @param prezzo
	 * @param quantit‡Disponibile
	 * @param Categoria
	 */
	public void aggiungiLibro(String isbn, String titolo, String trama, String foto, String casaEditrice, double prezzo, int quantit‡Disponibile, String Categoria) {
		// TODO - implement DataManager.aggiungiLibro
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tipo
	 * @param nuovoAttributo
	 */
	public void modificaAttributo(String tipo, String nuovoAttributo) {
		// TODO - implement DataManager.modificaAttributo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param isbn
	 */
	public void eliminaLibro(String isbn) {
		// TODO - implement DataManager.eliminaLibro
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idRecensione
	 */
	public void eliminaRecensione(int idRecensione) {
		// TODO - implement DataManager.eliminaRecensione
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 */
	public Utente ricercaAccount(String email) {
		// TODO - implement DataManager.ricercaAccount
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 * @param tipo
	 */
	public void cambiaTipo(String email, String tipo) {
		// TODO - implement DataManager.cambiaTipo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 */
	public void eliminaUtente(String email) {
		// TODO - implement DataManager.eliminaUtente
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param isbn
	 * @param quantit‡
	 */
	public void aggiungiAlCarrello(String isbn, int quantit‡) {
		// TODO - implement DataManager.aggiungiAlCarrello
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param isbn
	 */
	public void eliminaDalCarrello(String isbn) {
		// TODO - implement DataManager.eliminaDalCarrello
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numCarta
	 * @param idIndirizzo
	 */
	public boolean completaAcquisto(int numCarta, int idIndirizzo) {
		// TODO - implement DataManager.completaAcquisto
		throw new UnsupportedOperationException();
	}

	public void selezionaCartaEIndirizzo() {
		// TODO - implement DataManager.selezionaCartaEIndirizzo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param isbn
	 */
	public void aumentaQuantit‡(String isbn) {
		// TODO - implement DataManager.aumentaQuantit‡
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param isbn
	 */
	public void diminuisciQuantit‡(String isbn) {
		// TODO - implement DataManager.diminuisciQuantit‡
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param testo
	 * @param categoria
	 */
	public List<Libro> ricerca(String testo, String categoria) {
		// TODO - implement DataManager.ricerca
		throw new UnsupportedOperationException();
	}

	public List<Libro> visualizzaCatalogo() {
		// TODO - implement DataManager.visualizzaCatalogo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 */
	public List<Ordine> visualizzaStorico(String email) {
		// TODO - implement DataManager.visualizzaStorico
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param isbn
	 * @param email
	 */
	public void aggiungiLibroPreferiti(String isbn, String email) {
		// TODO - implement DataManager.aggiungiLibroPreferiti
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param isbn
	 * @param email
	 */
	public void rimuoviLibroPreferiti(String isbn, String email) {
		// TODO - implement DataManager.rimuoviLibroPreferiti
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param testo
	 * @param isbn
	 */
	public void aggiungiRecensione(String testo, String isbn) {
		// TODO - implement DataManager.aggiungiRecensione
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idRecensione
	 */
	public void rimuoviRecensione(int idRecensione) {
		// TODO - implement DataManager.rimuoviRecensione
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numOrdine
	 */
	public Ordine ricercaOrdine(int numOrdine) {
		// TODO - implement DataManager.ricercaOrdine
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numOrdine
	 * @param stato
	 */
	public void cambiaStato(int numOrdine, String stato) {
		// TODO - implement DataManager.cambiaStato
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numOrdine
	 * @param data
	 * @param ora
	 */
	public void cambiaDataEOra(int numOrdine, String data, String ora) {
		// TODO - implement DataManager.cambiaDataEOra
		throw new UnsupportedOperationException();
	}

}