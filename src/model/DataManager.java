package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import bean.*;

public class DataManager {
	private AccountManager accountM = new AccountManager();
	private AmministratoreManager amministratoreM = new AmministratoreManager();
	private AmministratoreOrdineManager amministratoreOrdiniM = new AmministratoreOrdineManager();
	private GestioneOrdineManager gestioneOrdineM = new GestioneOrdineManager();
	private InterazioneLibroManager interazioneLibroM = new InterazioneLibroManager();
	private LibroManager libroM = new LibroManager();
	private OrdineManager ordineM = new OrdineManager();
	
	

	/**
	 * 
	 * @param email
	 * @param password
	 */
	public boolean login(String email, String password) {
		return accountM.login(email, password);
	}

	public boolean logout() {
		return accountM.logout();
	}

	/**
	 * 
	 * @param email
	 * @param password
	 */
	public boolean registrazione(String email, String password) {
		return accountM.registrazione(email, password);
	}

	/**
	 * 
	 * @param email
	 */
	public Collection<CartaDiCredito> ricercaCarte(String email) {
		return accountM.ricercaCarte(email);
	}

	/**
	 * 
	 * @param email
	 */
	public Collection<Indirizzo> ricercaIndirizzi(String email) {
		return accountM.ricercaIndirizzi(email);
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
		accountM.aggiungiCarta(email, numCarta, intestatario, dataScadenza, cvv);
	}

	/**
	 * 
	 * @param email
	 * @param numCarta
	 */
	public void rimuoviCarta(String email, int numCarta) {
		accountM.rimuoviCarta(email, numCarta);
	}

	/**
	 * 
	 * @param email
	 * @param via
	 * @param numCivico
	 * @param cap
	 * @param città
	 */
	public void aggiungiIndirizzo(String email, String via, int numCivico, int cap, String città) {
		accountM.aggiungiIndirizzo(email, via, numCivico, cap, città);
	}

	/**
	 * 
	 * @param email
	 * @param idIndirizzo
	 */
	public void rimuoviIndirizzo(String email, int idIndirizzo) {
		accountM.rimuoviIndirizzo(email, idIndirizzo);
	}

	/**
	 * 
	 * @param email
	 * @param idIndirizzo
	 * @param via
	 * @param numCivico
	 * @param CAP
	 * @param città
	 */
	public void modificaIndirizzo(String email, int idIndirizzo, String via, int numCivico, int CAP, String città) {
		accountM.modificaIndirizzo(email, idIndirizzo, via, numCivico, CAP, città);
	}

	/**
	 * 
	 * @param isbn
	 * @param titolo
	 * @param trama
	 * @param foto
	 * @param casaEditrice
	 * @param prezzo
	 * @param quantitàDisponibile
	 * @param Categoria
	 * @throws SQLException 
	 */
	public void aggiungiLibro(Libro libro, ArrayList<String> autori) throws SQLException {
		amministratoreM.aggiungiLibro(libro, autori);
	}

	/**
	 * 
	 * @param tipo
	 * @param nuovoAttributo
	 * @throws SQLException 
	 */
	public void modificaAttributo(String email, String tipo, String nuovoAttributo) throws SQLException {
		amministratoreM.modificaAttributo(email, tipo, nuovoAttributo);
	}

	/**
	 * 
	 * @param isbn
	 * @throws SQLException 
	 */
	public void eliminaLibro(String isbn) throws SQLException {
		amministratoreM.eliminaLibro(isbn);
	}

	/**
	 * 
	 * @param idRecensione
	 * @throws SQLException 
	 */
	public void eliminaRecensione(int idRecensione) throws SQLException {
		amministratoreM.eliminaRecensione(idRecensione);
	}

	/**
	 * 
	 * @param email
	 */
	public Utente ricercaAccount(String email) throws SQLException {
		return amministratoreM.ricercaAccount(email);
	}

	/**
	 * 
	 * @param email
	 * @param tipo
	 * @throws SQLException 
	 */
	public void cambiaTipo(String email, String tipo) throws SQLException {
		amministratoreM.cambiaTipo(email, tipo);
	}

	/**
	 * 
	 * @param email
	 * @throws SQLException 
	 */
	public void eliminaUtente(String email) throws SQLException {
		amministratoreM.eliminaUtente(email);
	}

	/**
	 * 
	 * @param numCarta
	 * @param idIndirizzo
	 */
	public boolean completaAcquisto(int numCarta, int idIndirizzo) {
		return ordineM.completaAcquisto(numCarta, idIndirizzo);
	}

	public void selezionaCartaEIndirizzo() {
		ordineM.selezionaCartaEIndirizzo();
	}

	/**
	 * 
	 * @param testo
	 * @param categoria
	 * @throws SQLException 
	 */
	public Collection<Libro> ricerca(String testo, String categoria) throws SQLException {
		return libroM.ricerca(testo, categoria);
	}

	public ArrayList<Collection<Libro>> visualizzaCatalogo() {
		ArrayList<Collection<Libro>> catalogo = new ArrayList<Collection<Libro>>();
		
		catalogo.add(libroM.getLibriPiùVenduti());
		catalogo.add(libroM.getLibriInEvidenza());
		
		return catalogo;
	}

	/**
	 * 
	 * @param email
	 */
	public Collection<Ordine> visualizzaStorico(String email) {
		return gestioneOrdineM.visualizzaStorico(email);
	}

	/**
	 * 
	 * @param isbn
	 * @param email
	 */
	public void aggiungiLibroPreferiti(String isbn, String email) {
		interazioneLibroM.aggiungiLibroPreferiti(isbn, email);
	}

	/**
	 * 
	 * @param isbn
	 * @param email
	 */
	public void rimuoviLibroPreferiti(String isbn, String email) {
		interazioneLibroM.rimuoviLibroPreferiti(isbn, email);
	}

	/**
	 * 
	 * @param testo
	 * @param isbn
	 */
	public void aggiungiRecensione(String testo, String isbn) {
		interazioneLibroM.aggiungiRecensione(testo, isbn);
	}

	/**
	 * 
	 * @param idRecensione
	 */
	public void rimuoviRecensione(int idRecensione) {
		interazioneLibroM.rimuoviRecensione(idRecensione);
	}

	/**
	 * 
	 * @param numOrdine
	 */
	public Ordine ricercaOrdine(int numOrdine) {
		return amministratoreOrdiniM.ricercaOrdine(numOrdine);
	}

	/**
	 * 
	 * @param numOrdine
	 * @param stato
	 */
	public void cambiaStato(int numOrdine, String stato) {
		amministratoreOrdiniM.cambiaStato(numOrdine, stato);
	}

	/**
	 * 
	 * @param numOrdine
	 * @param data
	 * @param ora
	 */
	public void cambiaDataEOra(int numOrdine, String data, String ora) {
		amministratoreOrdiniM.cambiaDataEOra(numOrdine, data, ora);
	}

}