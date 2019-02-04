package model;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import bean.Libro;
import bean.Ordine;
import carrello.Carrello;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestOrdineManager extends TestCase {
	private OrdineManager manager;
	private Carrello carrello;
	
	public TestOrdineManager(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		manager= new OrdineManager();
		carrello= new Carrello();
	}
	
	@Override
	protected void tearDown() throws Exception {
	}
	
	public void testAggiungiAlCarrello() {
		Libro libro= new Libro();
		libro.setIsbn("9789753102001");
		libro.setPrezzo(3);
		int quantit‡= 5;
		
		carrello= manager.aggiungiAlCarrello(carrello, libro, quantit‡);
		
		assertEquals(1, carrello.getLibri().size());
		assertEquals(5, carrello.getLibro("9789753102001").getQuantit‡Selezionata());
		assertEquals(15.00, carrello.getLibro("9789753102001").getPrezzo() * carrello.getLibro("9789753102001").getQuantit‡Selezionata());
	}
	
	public void testCompletaAcquisto() throws SQLException{
		Ordine ordine=null;
		assertFalse(manager.completaAcquisto(ordine));
		
		ordine=new Ordine();
		assertFalse(manager.completaAcquisto(ordine));
		
		ordine=new Ordine();
		ordine.setDataEffettuata(new Date(1000000000));
		assertFalse(manager.completaAcquisto(ordine));
		
		ordine=new Ordine();
		ordine.setDataEffettuata(new Date(1000000000));
		ordine.setOra(new Time(1000));
		assertFalse(manager.completaAcquisto(ordine));
		
		ordine=new Ordine();
		ordine.setDataEffettuata(new Date(1000000000));
		ordine.setOra(new Time(1000));
		ordine.setDataConsegna(new Date(1000000001));;
		assertFalse(manager.completaAcquisto(ordine));
		
		ordine=new Ordine();
		ordine.setDataEffettuata(new Date(1000000000));
		ordine.setOra(new Time(1000));
		ordine.setDataConsegna(new Date(1000000001));
		ordine.setPrezzoTot(11);
		assertFalse(manager.completaAcquisto(ordine));
		
		ordine=new Ordine();
		ordine.setDataEffettuata(new Date(1000000000));
		ordine.setOra(new Time(1000));
		ordine.setDataConsegna(new Date(1000000001));
		ordine.setPrezzoTot(11);
		ordine.setVia("Enrico");
		assertFalse(manager.completaAcquisto(ordine));
		
		ordine=new Ordine();
		ordine.setDataEffettuata(new Date(1000000000));
		ordine.setOra(new Time(1000));
		ordine.setDataConsegna(new Date(1000000001));
		ordine.setPrezzoTot(11);
		ordine.setVia("Enrico");
		ordine.setNumCivico(9);
		assertFalse(manager.completaAcquisto(ordine));
		
		ordine=new Ordine();
		ordine.setDataEffettuata(new Date(1000000000));
		ordine.setOra(new Time(1000));
		ordine.setDataConsegna(new Date(1000000001));
		ordine.setPrezzoTot(11);
		ordine.setVia("Enrico");
		ordine.setNumCivico(9);
		ordine.setCap("80040");
		assertFalse(manager.completaAcquisto(ordine));
		
		ordine=new Ordine();
		ordine.setDataEffettuata(new Date(1000000000));
		ordine.setOra(new Time(1000));
		ordine.setDataConsegna(new Date(1000000001));
		ordine.setPrezzoTot(11);
		ordine.setVia("Enrico");
		ordine.setNumCivico(9);
		ordine.setCap("80040");
		ordine.setCitt‡("Napoli");
		assertFalse(manager.completaAcquisto(ordine));
		
		ordine=new Ordine();
		ordine.setDataEffettuata(new Date(1000000000));
		ordine.setOra(new Time(1000));
		ordine.setDataConsegna(new Date(1000000001));
		ordine.setPrezzoTot(11);
		ordine.setVia("Enrico");
		ordine.setNumCivico(9);
		ordine.setCap("80040");
		ordine.setCitt‡("Napoli");
		ordine.setStato("inPreparazione");
		assertFalse(manager.completaAcquisto(ordine));
		
		ordine=new Ordine();
		ordine.setDataEffettuata(new Date(1000000000));
		ordine.setOra(new Time(1000));
		ordine.setDataConsegna(new Date(1000000001));
		ordine.setPrezzoTot(11);
		ordine.setVia("Enrico");
		ordine.setNumCivico(9);
		ordine.setCap("80040");
		ordine.setCitt‡("Napoli");
		ordine.setStato("inPreparazione");
		ordine.setNumCarta("0000000000000004");
		assertFalse(manager.completaAcquisto(ordine));
		
		ordine=new Ordine();
		ordine.setDataEffettuata(new Date(1000000000));
		ordine.setOra(new Time(1000));
		ordine.setDataConsegna(new Date(1000000001));
		ordine.setPrezzoTot(11);
		ordine.setVia("Enrico");
		ordine.setNumCivico(9);
		ordine.setCap("80040");
		ordine.setCitt‡("Napoli");
		ordine.setStato("inPreparazione");
		ordine.setNumCarta("0000000000000004");
		ordine.setEmail("g.teodoro@studenti.unisa.it");
		assertFalse(manager.completaAcquisto(ordine));
		
		ordine=new Ordine();
		ordine.setDataEffettuata(new Date(1000000000));
		ordine.setOra(new Time(1000));
		ordine.setDataConsegna(new Date(1000000001));
		ordine.setPrezzoTot(11);
		ordine.setVia("Enrico");
		ordine.setNumCivico(9);
		ordine.setCap("80040");
		ordine.setCitt‡("Napoli");
		ordine.setStato("inPreparazione");
		ordine.setNumCarta("0000000000000004");
		ordine.setEmail("g.teodoro@studenti.unisa.it");
		ArrayList<Libro> libri=new ArrayList<Libro>();
		Libro libro=new Libro();
		libri.add(libro);
		ordine.setLibri(libri);
		assertFalse(manager.completaAcquisto(ordine));
		
		ordine=new Ordine();
		ordine.setDataEffettuata(new Date(1000000000));
		ordine.setOra(new Time(1000));
		ordine.setDataConsegna(new Date(1000000001));
		ordine.setPrezzoTot(11);
		ordine.setVia("Enrico");
		ordine.setNumCivico(9);
		ordine.setCap("80040");
		ordine.setCitt‡("Napoli");
		ordine.setStato("inPreparazione");
		ordine.setNumCarta("0000000000000004");
		ordine.setEmail("g.teodoro@studenti.unisa.it");
		libri=new ArrayList<Libro>();
		libro=new Libro();
		libro.setIsbn("9788804598893");
		libri.add(libro);
		ordine.setLibri(libri);
		assertFalse(manager.completaAcquisto(ordine));
		
		ordine=new Ordine();
		ordine.setDataEffettuata(new Date(1000000000));
		ordine.setOra(new Time(1000));
		ordine.setDataConsegna(new Date(1000000001));
		ordine.setPrezzoTot(11);
		ordine.setVia("Enrico");
		ordine.setNumCivico(9);
		ordine.setCap("80040");
		ordine.setCitt‡("Napoli");
		ordine.setStato("inPreparazione");
		ordine.setNumCarta("0000000000000004");
		ordine.setEmail("g.teodoro@studenti.unisa.it");
		libri=new ArrayList<Libro>();
		libro=new Libro();
		libro.setIsbn("9788804598893");
		libro.setTitolo("Il barone rampante");
		libri.add(libro);
		ordine.setLibri(libri);
		assertFalse(manager.completaAcquisto(ordine));
		
		ordine=new Ordine();
		ordine.setDataEffettuata(new Date(1000000000));
		ordine.setOra(new Time(1000));
		ordine.setDataConsegna(new Date(1000000001));
		ordine.setPrezzoTot(11);
		ordine.setVia("Enrico");
		ordine.setNumCivico(9);
		ordine.setCap("80040");
		ordine.setCitt‡("Napoli");
		ordine.setStato("inPreparazione");
		ordine.setNumCarta("0000000000000004");
		ordine.setEmail("g.teodoro@studenti.unisa.it");
		libri=new ArrayList<Libro>();
		libro=new Libro();
		libro.setIsbn("9788804598893");
		libro.setTitolo("Il barone rampante");
		libro.setQuantit‡(1);
		libri.add(libro);
		ordine.setLibri(libri);
		assertFalse(manager.completaAcquisto(ordine));
		
		ordine=new Ordine();
		ordine.setDataEffettuata(new Date(1000000000));
		ordine.setOra(new Time(1000));
		ordine.setDataConsegna(new Date(1000000001));
		ordine.setPrezzoTot(11);
		ordine.setVia("Enrico");
		ordine.setNumCivico(9);
		ordine.setCap("80040");
		ordine.setCitt‡("Napoli");
		ordine.setStato("inPreparazione");
		ordine.setNumCarta("0000000000000004");
		ordine.setEmail("g.teodoro@studenti.unisa.it");
		libri=new ArrayList<Libro>();
		libro=new Libro();
		libro.setIsbn("9788804598893");
		libro.setTitolo("Il barone rampante");
		libro.setQuantit‡(1);
		libro.setPrezzo(11);
		libri.add(libro);
		ordine.setLibri(libri);
		assertFalse(manager.completaAcquisto(ordine));
	}
	
	public void testRimuoviDalCarrello() {
		ArrayList<Libro> libri= carrello.getLibri();
		Libro libro= new Libro();
		libro.setIsbn("9789753102001");
		libro.setQuantit‡Selezionata(5);
		libri.add(libro);
		carrello.setLibri(libri);
		
		String isbn= "9789753102001";
		carrello= manager.rimuoviDalCarrello(carrello, isbn);
		
		assertEquals(0, carrello.getLibri().size());
	}
	
	public void testAumentaQuantit‡() {
		ArrayList<Libro> libri= carrello.getLibri();
		Libro libro= new Libro();
		libro.setIsbn("9789753102001");
		libro.setQuantit‡(50);
		libro.setQuantit‡Selezionata(5);
		libri.add(libro);
		carrello.setLibri(libri);
		
		String isbn= "9789753102001";
		carrello= manager.aumentaQuantit‡(carrello, isbn);
		
		assertEquals(6, carrello.getLibro("9789753102001").getQuantit‡Selezionata());
	}
	
	public void testDiminuisciQuantit‡() {
		ArrayList<Libro> libri= carrello.getLibri();
		Libro libro= new Libro();
		libro.setIsbn("9789753102001");
		libro.setQuantit‡Selezionata(5);
		libri.add(libro);
		carrello.setLibri(libri);
		
		String isbn= "9789753102001";
		carrello= manager.diminuisciQuantit‡(carrello, isbn);
		
		assertEquals(4, carrello.getLibro("9789753102001").getQuantit‡Selezionata());
	}
	
	
	
	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTestSuite(TestOrdineManager.class);

		return suite;
	}
	
}
