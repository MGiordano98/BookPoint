package model;


import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import bean.Autore;
import bean.Libro;
import bean.Utente;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestAmministratoreManager extends TestCase{
	private AmministratoreManager manager;
	
	
	public TestAmministratoreManager(String name) {
		super(name);
	}
	
	@Override
	public void setUp() throws Exception{
		manager= new AmministratoreManager();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	public void testAggiungiLibro() throws SQLException {
		Libro libro=null;
		assertFalse(manager.aggiungiLibro(libro));
		
		libro=new Libro();
		libro.setIsbn("1234");
		assertFalse(manager.aggiungiLibro(libro));
		
		libro=new Libro();
		libro.setIsbn("1234567891234");
		libro.setTitolo("@");
		assertFalse(manager.aggiungiLibro(libro));
		
		libro=new Libro();
		libro.setIsbn("1234567891234");
		libro.setTitolo("Il piccolo principe");
		libro.setTrama("TestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTestoTesto");
		assertFalse(manager.aggiungiLibro(libro));
		
		libro=new Libro();
		libro.setIsbn("1234567891234");
		libro.setTitolo("Il piccolo principe");
		libro.setTrama("Testo");
		libro.setTrama("*");
		assertFalse(manager.aggiungiLibro(libro));
		
		libro=new Libro();
		libro.setIsbn("1234567891234");
		libro.setTitolo("Il piccolo principe");
		libro.setTrama("Testo");
		libro.setTrama("Romanzo");
		libro.setPrezzo(-1.00);
		assertFalse(manager.aggiungiLibro(libro));
		
		libro=new Libro();
		libro.setIsbn("1234567891234");
		libro.setTitolo("Il piccolo principe");
		libro.setTrama("Testo");
		libro.setTrama("Romanzo");
		libro.setPrezzo(1.00);
		libro.setQuantità(-1);
		assertFalse(manager.aggiungiLibro(libro));
		
		libro=new Libro();
		libro.setIsbn("1234567891234");
		libro.setTitolo("Il piccolo principe");
		libro.setTrama("Testo");
		libro.setTrama("Romanzo");
		libro.setPrezzo(1.00);
		libro.setQuantità(1);
		libro.setAutori(null);
		assertFalse(manager.aggiungiLibro(libro));
		
		libro=new Libro();
		libro.setIsbn("1234567891234");
		libro.setTitolo("Il piccolo principe");
		libro.setTrama("Testo");
		libro.setTrama("Romanzo");
		libro.setPrezzo(1.00);
		libro.setQuantità(1);
		ArrayList<Autore> autori=new ArrayList<Autore>();
		libro.setAutori(autori);
		assertFalse(manager.aggiungiLibro(libro));
		
		libro=new Libro();
		libro.setIsbn("1234567891234");
		libro.setTitolo("Il piccolo principe");
		libro.setTrama("Testo");
		libro.setTrama("Romanzo");
		libro.setPrezzo(1.00);
		libro.setQuantità(1);
		autori=new ArrayList<Autore>();
		Autore autore= new Autore("Giovanni");
		autori.add(autore);
		libro.setAutori(autori);
		libro.setDataUscita(Date.valueOf("2000-10-20"));
		assertFalse(manager.aggiungiLibro(libro));
		
		libro=new Libro();
		libro.setIsbn("1234567891234");
		libro.setTitolo("Il piccolo principe");
		libro.setTrama("Testo");
		libro.setTrama("Romanzo");
		libro.setPrezzo(1.00);
		libro.setQuantità(1);
		autori=new ArrayList<Autore>();
		autore= new Autore("Giovanni");
		autori.add(autore);
		libro.setAutori(autori);
		GregorianCalendar data= new GregorianCalendar();
		data.add(Calendar.DAY_OF_MONTH, 1);
		Date dataUscita= new Date(data.getTime().getTime());
		libro.setDataUscita(dataUscita);
		assertFalse(manager.aggiungiLibro(libro));
		
		libro=new Libro();
		libro.setIsbn("1234567891234");
		libro.setTitolo("Il piccolo principe");
		libro.setTrama("Testo");
		libro.setTrama("Romanzo");
		libro.setPrezzo(1.00);
		libro.setQuantità(1);
		autori=new ArrayList<Autore>();
		autore= new Autore("Giovanni");
		autori.add(autore);
		libro.setAutori(autori);
		data= new GregorianCalendar();
		dataUscita= new Date(data.getTime().getTime());
		libro.setDataUscita(dataUscita);
		assertTrue(manager.aggiungiLibro(libro));
		
		
	}
	
	public void testEliminaRecensione() throws SQLException {
		assertFalse(manager.eliminaRecensione(-1));
		assertFalse(manager.eliminaRecensione(100));
		assertTrue(manager.eliminaRecensione(1));	
	}
	
	public void testEliminaLibro() throws SQLException {
		
		assertFalse(manager.eliminaLibro("1"));
		assertFalse(manager.eliminaLibro("1234567891234"));
		assertTrue(manager.eliminaLibro("9788868363574"));
	}
	
	public void testRicercaAccount() throws SQLException {
		
		Utente utente=manager.ricercaAccount("ciao.it");
		assertNull(utente);
	
		
		utente=manager.ricercaAccount("m.garofalo@studenti.unisa.it");
		assertNull(utente);

		
		utente=manager.ricercaAccount("g.teodoro@studenti.unisa.it");
		assertNotNull(utente);
		assertNotNull(utente.getCognome());
		assertNotNull(utente.getEmail());
		assertNotNull(utente.getNome());
		assertNotNull(utente.getPassword());
		assertNotNull(utente.getTipo());
		assertNotNull(utente.getDataDiNascita());
		
	}
	
	public void testCambiaTipo() throws SQLException {
		
		assertFalse(manager.cambiaTipo("ciao",""));
		assertFalse(manager.cambiaTipo("m.garofalo@studenti.unisa.it",""));
		assertFalse(manager.cambiaTipo("m.giordano@studenti.unisa.it","Amministratore condominio"));
		assertTrue(manager.cambiaTipo("m.giordano@studenti.unisa.it","Cliente"));
	}
	
	public void testEliminaUtente() throws SQLException {
		
		assertFalse(manager.eliminaUtente("giacomo"));
		assertFalse(manager.eliminaUtente("m.garofalo@studenti.unisa.it"));
		assertFalse(manager.eliminaUtente("m.giordano@studenti.unisa.it"));
		
	}
	

	
	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTest(new TestAmministratoreManager("testAggiungiLibro"));
		suite.addTest(new TestAmministratoreManager("testEliminaRecensione"));
		suite.addTest(new TestAmministratoreManager("testEliminaLibro"));
		suite.addTest(new TestAmministratoreManager("testRicercaAccount"));
		suite.addTest(new TestAmministratoreManager("testCambiaTipo"));
		suite.addTest(new TestAmministratoreManager("testEliminaUtente"));
		return suite;
	}
	
	
}
