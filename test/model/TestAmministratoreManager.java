package model;


import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Autore;
import bean.Libro;
import bean.Recensione;
import bean.Utente;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class TestAmministratoreManager extends TestCase{
	private AmministratoreManager manager;
	private ArrayList<Autore> autori;
	private ArrayList<Recensione> recensioni;
	private Libro libro;
	private Libro libroEmpty;
	
	public TestAmministratoreManager(String name) {
		super(name);
	}
	
	@Override
	public void setUp() throws Exception{
		manager= new AmministratoreManager();
		autori= new ArrayList<Autore>();
		autori.add(new Autore("Antoine de Saint-Exupéry"));
		recensioni= new ArrayList<Recensione>();
		recensioni.add(new Recensione(0,"cavallo","9788854172388","g.teodoro@studenti.unisa.it"));
		libroEmpty= new Libro();
		libro= new Libro();
		libro.setIsbn("9788854172388");
		libro.setTitolo("Il piccolo principe");
		libro.setTrama("Ecco il mio segreto. È molto semplice: si vede bene solo con il cuore. L'essenziale è invisibile agli occhi.\r\n" + 
				"Il Piccolo Principe è la storia dell’incontro in mezzo al deserto tra un aviatore e un buffo ometto vestito da principe che è arrivato sulla Terra dallo spazio. Ma c’è molto di più di una semplice amicizia in questo libro surreale, filosofico e magico.");
		libro.setFoto("9788854172388.jpg");
		libro.setCategoria("fantasy");
		libro.setCasaEditrice("Newton Compton");
		libro.setAutori(autori);
		libro.setPrezzo(12);
		libro.setCopieVendute(50);
		libro.setDataUscita(Date.valueOf("2010-10-10"));
		libro.setRecensioni(recensioni);
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testAggiungiLibroError() throws SQLException {
		boolean result= manager.aggiungiLibro(libroEmpty);
		assertFalse(result);
	}
	
	public void testAggiungiLibro() throws SQLException {
		boolean result= manager.aggiungiLibro(libro);
		assertEquals(true, result);
	}
	
	public void testModificaDataUscita() throws SQLException {
		String isbn= libro.getIsbn();
		Date data= Date.valueOf("2020-9-9");
		boolean result= manager.modificaDataUscita(isbn, data);
		assertEquals(true, result);
	}
	
	public void testModificaCategoria() throws SQLException {
		String isbn= libro.getIsbn();
		String categoria= "avventura";
		boolean result= manager.modificaCategoria(isbn, categoria);
		assertEquals(true, result);
	}
	
	public void testModificaQuantitàDisponibile() throws SQLException {
		String isbn= libro.getIsbn();
		int quantità= 20;
		boolean result= manager.modificaQuantitàDisponibile(isbn, quantità);
		assertEquals(true, result);
	}
	
	public void testModificaPrezzo() throws SQLException {
		String isbn= libro.getIsbn();
		double prezzo= 20.5;
		boolean result= manager.modificaPrezzo(isbn, prezzo);
		assertEquals(true, result);
	}
	
	public void testModificaCasaEditrice() throws SQLException {
		String isbn= libro.getIsbn();
		String casaEditrice= "New York";
		boolean result= manager.modificaCasaEditrice(isbn, casaEditrice);
		assertEquals(true, result);
	}
	
	public void testModificaFoto() throws SQLException {
		String isbn= libro.getIsbn();
		String foto= "pippo.jsp";
		boolean result= manager.modificaFoto(isbn, foto);
		assertEquals(true, result);
	}
	
	public void testModificaTrama() throws SQLException {
		String isbn= libro.getIsbn();
		String trama= "baaaaab";
		boolean result= manager.modificaTrama(isbn, trama);
		assertEquals(true, result);
	}
	
	public void testModificaTitolo() throws SQLException {
		String isbn= libro.getIsbn();
		String titolo= "poor";
		boolean result= manager.modificaTitolo(isbn, titolo);
		assertEquals(true, result);
	}
	
	
	public void testEliminaRecensione() throws SQLException {
		String isbn= libro.getIsbn();
		int idRecensione= 8;
		boolean result= manager.eliminaRecensione(idRecensione);
		assertEquals(true, result);
	}
	
	public void testEliminaLibro() throws SQLException {
		String isbn= libro.getIsbn();
		boolean result= manager.eliminaLibro(isbn);
		assertEquals(true, result);
	}
	
	public void testRicercaAccount() throws SQLException {
		String email= "g.buonocore15@studenti.unisa.it";
		Utente utente= manager.ricercaAccount(email);
		assertNotNull(utente.getEmail());
		assertNotNull(utente.getNome());
		assertNotNull(utente.getCognome());
		assertNotNull(utente.getTipo());
	}
	
	public void testCambiaTipo() throws SQLException {
		String email="g.buonocore15@studenti.unisa.it";
		String tipo="cliente";
		assertEquals(true, manager.cambiaTipo(email, tipo));
	}
	
	public void testEliminaUtente() throws SQLException {
		String email="v.sammartino@studenti.unisa.it";
		assertEquals(true, manager.eliminaUtente(email));
	}
	
	public void testRimuoviAutore() throws SQLException {
		Autore autore= new Autore("Antoine de Saint-Exupéry");
		assertEquals(true, manager.rimuoviAutore(autore));
	}
	
	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTest(new TestAmministratoreManager("testAggiungiLibro"));
		suite.addTest(new TestAmministratoreManager("testModificaCategoria"));
		suite.addTest(new TestAmministratoreManager("testModificaQuantitàDisponibile"));
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
