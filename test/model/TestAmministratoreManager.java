package model;


import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import bean.Autore;
import bean.Libro;
import bean.Recensione;
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
		libro.setQuantit‡(-1);
		assertFalse(manager.aggiungiLibro(libro));
		
		libro=new Libro();
		libro.setIsbn("1234567891234");
		libro.setTitolo("Il piccolo principe");
		libro.setTrama("Testo");
		libro.setTrama("Romanzo");
		libro.setPrezzo(1.00);
		libro.setQuantit‡(1);
		libro.setAutori(null);
		assertFalse(manager.aggiungiLibro(libro));
		
		libro=new Libro();
		libro.setIsbn("1234567891234");
		libro.setTitolo("Il piccolo principe");
		libro.setTrama("Testo");
		libro.setTrama("Romanzo");
		libro.setPrezzo(1.00);
		libro.setQuantit‡(1);
		ArrayList<Autore> autori=new ArrayList<Autore>();
		libro.setAutori(autori);
		assertFalse(manager.aggiungiLibro(libro));
		
		libro=new Libro();
		libro.setIsbn("1234567891234");
		libro.setTitolo("Il piccolo principe");
		libro.setTrama("Testo");
		libro.setTrama("Romanzo");
		libro.setPrezzo(1.00);
		libro.setQuantit‡(1);
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
		libro.setQuantit‡(1);
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
		libro.setQuantit‡(1);
		autori=new ArrayList<Autore>();
		autore= new Autore("Giovanni");
		autori.add(autore);
		libro.setAutori(autori);
		data= new GregorianCalendar();
		dataUscita= new Date(data.getTime().getTime());
		libro.setDataUscita(dataUscita);
		assertTrue(manager.aggiungiLibro(libro));
		
		
	}
	
	public void testModificaDataUscita() throws SQLException {
		
	}
	
	public void testModificaCategoria() throws SQLException {
		
	}
	
	public void testModificaQuantit‡Disponibile() throws SQLException {
		
	}
	
	public void testModificaPrezzo() throws SQLException {
		
	}
	
	public void testModificaCasaEditrice() throws SQLException {
		
	}
	
	public void testModificaFoto() throws SQLException {
		
	}
	
	public void testModificaTrama() throws SQLException {
		
	}
	
	public void testModificaTitolo() throws SQLException {
		
	}
	
	public void testEliminaRecensione() throws SQLException {
		
	}
	
	public void testEliminaLibro() throws SQLException {
		
	}
	
	public void testRicercaAccount() throws SQLException {
		
	}
	
	public void testCambiaTipo() throws SQLException {
		
	}
	
	public void testEliminaUtente() throws SQLException {
		
	}
	

	
	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTest(new TestAmministratoreManager("testAggiungiLibro"));
		suite.addTest(new TestAmministratoreManager("testModificaCategoria"));
		suite.addTest(new TestAmministratoreManager("testModificaQuantit‡Disponibile"));
		suite.addTest(new TestAmministratoreManager("testModificaPrezzo"));
		suite.addTest(new TestAmministratoreManager("testModificaDataUscita"));
		suite.addTest(new TestAmministratoreManager("testModificaCasaEditrice"));
		suite.addTest(new TestAmministratoreManager("testModificaFoto"));
		suite.addTest(new TestAmministratoreManager("testModificaTrama"));
		suite.addTest(new TestAmministratoreManager("testModificaTitolo"));
		suite.addTest(new TestAmministratoreManager("testEliminaRecensione"));
		suite.addTest(new TestAmministratoreManager("testEliminaLibro"));
		suite.addTest(new TestAmministratoreManager("testAggiungiLibroError"));
		suite.addTest(new TestAmministratoreManager("testRicercaAccount"));
		suite.addTest(new TestAmministratoreManager("testCambiaTipo"));
		suite.addTest(new TestAmministratoreManager("testEliminaUtente"));
		suite.addTest(new TestAmministratoreManager("testRimuoviAutore"));
		
		return suite;
	}
	
	
}
