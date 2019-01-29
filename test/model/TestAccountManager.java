package model;


import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import bean.CartaDiCredito;
import bean.Indirizzo;
import bean.Utente;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestAccountManager extends TestCase{
	private AccountManager manager;
	private Utente utente;

	public TestAccountManager(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		manager= new AccountManager();
		utente= new Utente();
		utente.setEmail("v.sammartino@studenti.unisa.it");
		utente.setPassword("Vittorio");
		utente.setNome("Vittorio");
		utente.setCognome("Sammartino");
		utente.setDataDiNascita(Date.valueOf("1997-06-24"));
		utente.setTipo("cliente");
		
	}
	
	@Override
	protected void tearDown() throws Exception {
	}
	
	public void testRegistrazione() throws SQLException {
		boolean result= manager.registrazione(utente);
		assertTrue(result);
	}
	
	public void testLogin() throws SQLException{
		String email= utente.getEmail();
		String password= utente.getPassword();
		Utente utente= manager.login(email, password);
		assertNotNull(utente.getEmail());
		assertNotNull(utente.getNome());
		assertNotNull(utente.getCognome());
		assertNotNull(utente.getTipo());
	}
	
	public void testChangePassword() throws SQLException {
		String email= "v.sammartino@studenti.unisa.it";
		String vecchiaPassword= "Vittorio";
		String nuovaPassword= "Pino";
		boolean result= manager.changePassword(email, vecchiaPassword, nuovaPassword);
		assertTrue(result);
	}
	
	public void testChangePasswordAgain() throws SQLException {
		String email= "v.sammartino@studenti.unisa.it";
		String vecchiaPassword= "Pino";
		String nuovaPassword= "Vittorio";
		boolean result= manager.changePassword(email, vecchiaPassword, nuovaPassword);
		assertTrue(result);
	}
	
	public void testRicercaCarte() throws SQLException {
		String email= "g.teodoro@studenti.unisa.it";
		Collection<CartaDiCredito> carte= manager.ricercaCarte(email);
		assertTrue(carte.size()>0);
		
		Iterator<CartaDiCredito> it= carte.iterator();
		while(it.hasNext()) {
			CartaDiCredito carta= it.next();
			assertNotNull(carta.getNumCarta());
			assertNotNull(carta.getIntestatario());
			assertNotNull(carta.getData());
			assertNotNull(carta.getCvv());
		}
	}
	
	public void testRicercaIndirizzi() throws SQLException {
		String email= "g.teodoro@studenti.unisa.it";
		assertNotNull(manager.ricercaIndirizzi(email));
	}
	
	public void testAggiungiCarta() throws SQLException {
		CartaDiCredito carta= new CartaDiCredito();
		carta.setNumCarta("0000000000000001");
		carta.setIntestatario("Vittorio Sammartino");
		carta.setData(Date.valueOf("2020-01-01"));
		carta.setCvv("188");
		assertTrue(manager.aggiungiCarta(utente.getEmail(), carta));
	}
	
	public void testRimuoviCarta() throws SQLException {
		String numCarta= "0000000000000001";
		assertTrue(manager.rimuoviCarta(numCarta));
	}
	
	public void testAggiungiIndirizzo() throws SQLException {
		Indirizzo indirizzo= new Indirizzo();
		indirizzo.setVia("portaromana");
		indirizzo.setCap("84015");
		indirizzo.setCittà("nocerca superiore");
		indirizzo.setNumCivico(29);
		assertTrue(manager.aggiungiIndirizzo(utente.getEmail(), indirizzo));
	}
	
	public void testRimuoviIndirizzo() throws SQLException {
		Collection<Indirizzo> indirizzi= manager.ricercaIndirizzi(utente.getEmail());
		Iterator<Indirizzo> it= indirizzi.iterator();
		Indirizzo indirizzo= (Indirizzo) it.next();
		
		assertTrue(manager.rimuoviIndirizzo(indirizzo.getId()));
	}
	
	public void testModificaIndirizzo() throws SQLException {
		String email= utente.getEmail();
		Collection<Indirizzo> indirizzi= manager.ricercaIndirizzi(utente.getEmail());
		Iterator<Indirizzo> it= indirizzi.iterator();
		Indirizzo indirizzo= (Indirizzo) it.next();
		
		indirizzo.setCittà("nocerca inferiore");
		assertTrue(manager.modificaIndirizzo(indirizzo,email));
	}
	
	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTest(new TestAccountManager("testRegistrazione"));
		suite.addTest(new TestAccountManager("testLogin"));
		suite.addTest(new TestAccountManager("testChangePassword"));
		suite.addTest(new TestAccountManager("testChangePasswordAgain"));
		suite.addTest(new TestAccountManager("testRicercaCarte"));
		suite.addTest(new TestAccountManager("testRicercaIndirizzi"));
		suite.addTest(new TestAccountManager("testAggiungiCarta"));
		suite.addTest(new TestAccountManager("testRimuoviCarta"));
		suite.addTest(new TestAccountManager("testAggiungiIndirizzo"));
		suite.addTest(new TestAccountManager("testModificaIndirizzo"));
		suite.addTest(new TestAccountManager("testRimuoviIndirizzo"));
		
		
		return suite;
	}
}
