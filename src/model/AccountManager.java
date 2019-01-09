package model;

import java.util.List;
import bean.CartaDiCredito;
import bean.Indirizzo;

public class AccountManager {

	/**
	 * 
	 * @param email
	 * @param password
	 */
	public boolean login(String email, String password) {
		// TODO - implement AccountManager.login
		throw new UnsupportedOperationException();
	}

	public boolean logout() {
		// TODO - implement AccountManager.logout
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 * @param password
	 */
	public boolean registrazione(String email, String password) {
		// TODO - implement AccountManager.registrazione
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 */
	public List<CartaDiCredito> ricercaCarte(String email) {
		// TODO - implement AccountManager.ricercaCarte
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 */
	public List<Indirizzo> ricercaIndirizzi(String email) {
		// TODO - implement AccountManager.ricercaIndirizzi
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
		// TODO - implement AccountManager.aggiungiCarta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 * @param numCarta
	 */
	public void rimuoviCarta(String email, int numCarta) {
		// TODO - implement AccountManager.rimuoviCarta
		throw new UnsupportedOperationException();
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
		// TODO - implement AccountManager.aggiungiIndirizzo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 * @param idIndirizzo
	 */
	public void rimuoviIndirizzo(String email, int idIndirizzo) {
		// TODO - implement AccountManager.rimuoviIndirizzo
		throw new UnsupportedOperationException();
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
		// TODO - implement AccountManager.modificaIndirizzo
		throw new UnsupportedOperationException();
	}

}