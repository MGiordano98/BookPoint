package model;

import java.sql.Date;
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
	 * @throws SQLException 
	 */
	public Utente login(String email, String password) throws SQLException {
		return accountM.login(email, password);
	}

	/**
	 * 
	 * @param email
	 * @param password
	 * @throws SQLException 
	 */
	public boolean registrazione(String email, String password, String nome, String cognome, Date dataDiNascita) throws SQLException {
		return accountM.registrazione(email, password, nome, cognome, dataDiNascita);
	}

	public boolean changePassword(String email, String vecchiaPassword, String nuovaPassword) throws SQLException {
		return accountM.changePassword(email, vecchiaPassword, nuovaPassword);
	}
	
	/**
	 * 
	 * @param email
	 * @throws SQLException 
	 */
	public Collection<CartaDiCredito> ricercaCarte(String email) throws SQLException {
		return accountM.ricercaCarte(email);
	}

	/**
	 * 
	 * @param email
	 * @throws SQLException 
	 */
	public Collection<Indirizzo> ricercaIndirizzi(String email) throws SQLException {
		return accountM.ricercaIndirizzi(email);
	}

	/**
	 * 
	 * @param email
	 * @param numCarta
	 * @param intestatario
	 * @param dataScadenza
	 * @param cvv
	 * @throws SQLException 
	 */
	public void aggiungiCarta(String email, int numCarta, String intestatario, Date dataScadenza, int cvv) throws SQLException {
		accountM.aggiungiCarta(email, numCarta, intestatario, dataScadenza, cvv);
	}

	/**
	 * 
	 * @param email
	 * @param numCarta
	 * @throws SQLException 
	 */
	public void rimuoviCarta(int numCarta) throws SQLException {
		accountM.rimuoviCarta(numCarta);
	}

	/**
	 * 
	 * @param email
	 * @param via
	 * @param numCivico
	 * @param cap
	 * @param città
	 * @throws SQLException 
	 */
	public void aggiungiIndirizzo(String email, String via, int numCivico, int cap, String città) throws SQLException {
		accountM.aggiungiIndirizzo(email, via, numCivico, cap, città);
	}

	/**
	 * 
	 * @param email
	 * @param idIndirizzo
	 * @throws SQLException 
	 */
	public void rimuoviIndirizzo(int idIndirizzo) throws SQLException {
		accountM.rimuoviIndirizzo(idIndirizzo);
	}

	/**
	 * 
	 * @param email
	 * @param idIndirizzo
	 * @param via
	 * @param numCivico
	 * @param CAP
	 * @param città
	 * @throws SQLException 
	 */
	public void modificaIndirizzo(String email, int idIndirizzo, String via, int numCivico, int cap, String città) throws SQLException {
		accountM.modificaIndirizzo(email, idIndirizzo, via, numCivico, cap, città);
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
	 * @throws SQLException 
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
	 * @throws SQLException 
	 */
	public boolean completaAcquisto(Ordine ordine) throws SQLException {
		return ordineM.completaAcquisto(ordine);
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
	 * @throws SQLException 
	 */
	public Collection<Ordine> visualizzaStorico(String email) throws SQLException {
		return gestioneOrdineM.visualizzaStorico(email);
	}

	/**
	 * 
	 * @param isbn
	 * @param email
	 * @throws SQLException 
	 */
	public void aggiungiLibroPreferiti(String isbn, String email) throws SQLException {
		interazioneLibroM.aggiungiLibroPreferiti(isbn, email);
	}

	/**
	 * 
	 * @param isbn
	 * @param email
	 * @throws SQLException 
	 */
	public void rimuoviLibroPreferiti(String isbn, String email) throws SQLException {
		interazioneLibroM.rimuoviLibroPreferiti(isbn, email);
	}

	/**
	 * 
	 * @param testo
	 * @param isbn
	 * @throws SQLException 
	 */
	public void aggiungiRecensione(String testo, String isbn, String email) throws SQLException {
		interazioneLibroM.aggiungiRecensione(testo, isbn, email);
	}

	/**
	 * 
	 * @param idRecensione
	 * @throws SQLException 
	 */
	public void rimuoviRecensione(int idRecensione) throws SQLException {
		interazioneLibroM.rimuoviRecensione(idRecensione);
	}

	/**
	 * 
	 * @param numOrdine
	 * @throws SQLException 
	 */
	public Ordine ricercaOrdine(int numOrdine) throws SQLException {
		return amministratoreOrdiniM.ricercaOrdine(numOrdine);
	}

	/**
	 * 
	 * @param numOrdine
	 * @param stato
	 * @throws SQLException 
	 */
	public void cambiaStato(int numOrdine, String stato) throws SQLException {
		amministratoreOrdiniM.cambiaStato(numOrdine, stato);
	}

	/**
	 * 
	 * @param numOrdine
	 * @param data
	 * @param ora
	 * @throws SQLException 
	 */
	public void cambiaDataEOra(int numOrdine, String data, String ora) throws SQLException {
		amministratoreOrdiniM.cambiaDataEOra(numOrdine, data, ora);
	}

}