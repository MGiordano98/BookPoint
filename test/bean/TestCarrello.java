package bean;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import carrello.Carrello;

import java.sql.Date;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import model.LibroManager;
import model.TestLibroManager;

public class TestCarrello extends TestCase  {

	Carrello carrello;
	ArrayList<Autore> autori;
	ArrayList<Recensione> recensioni;
	Date dataUscita;
	
	public TestCarrello(String name){
		super(name);
	}
	
	@Override
	public void setUp() throws Exception{ 
		carrello=new Carrello();
		
		autori=new ArrayList<Autore>();
		recensioni=new ArrayList<Recensione>();
		dataUscita=new Date(1000000000);
		
		Libro libro1= new Libro("9788804598893","Il barone rampante", "", "", "" , 11, 50,"",autori ,recensioni, dataUscita);
		libro1.setQuantit‡Selezionata(1);
		
		Libro libro2= new Libro("9788804679622","Dieci piccoli indiani", "", "", "" , 8.4, 50,"",autori ,recensioni, dataUscita);
		libro2.setQuantit‡Selezionata(2);
		
		ArrayList<Libro> libri=new ArrayList<Libro>();
		libri.add(libro1);
		libri.add(libro2);
		
		carrello.setLibri(libri);
		carrello.setTotale((libro1.getPrezzo()*libro1.getQuantit‡Selezionata())+(libro2.getPrezzo()*libro2.getQuantit‡Selezionata()));
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testAggiungiAlCarrello(){
		Libro libro= new Libro("97888","Il barone rampante", "", "", "" , 11, 50,"",autori ,recensioni, dataUscita);
		assertFalse(carrello.aggiungiAlCarrello(libro, 0));
		
		libro= new Libro("9788804598893","Il barone rampante", "", "", "" , 11, -1,"",autori ,recensioni, dataUscita);
		assertFalse(carrello.aggiungiAlCarrello(libro, 0));
		
		libro= new Libro("9788804598893","Il barone rampante", "", "", "" , 11, 50,"",autori ,recensioni, dataUscita);
		assertFalse(carrello.aggiungiAlCarrello(libro, -1));
		
		libro= new Libro("9788804598893","Il barone rampante", "", "", "" , 11, 50,"",autori ,recensioni, dataUscita);
		assertFalse(carrello.aggiungiAlCarrello(libro, 51));
		
		libro= new Libro("9788804598893","Il barone rampante", "", "", "" , 11, 50,"",autori ,recensioni, dataUscita);
		assertTrue(carrello.aggiungiAlCarrello(libro, 1));
	}

	public void testRimuoviLibro(){
		
		assertFalse(carrello.rimuoviLibro("12"));
		
		assertFalse(carrello.rimuoviLibro("9788868363574"));
		
		assertTrue(carrello.rimuoviLibro("9788804598893"));
	}
	
	public void testAumentaQuantit‡(){
		
		assertFalse(carrello.rimuoviLibro("12"));
		
		assertFalse(carrello.rimuoviLibro("9788868363574"));
		
		assertTrue(carrello.rimuoviLibro("9788804598893"));	
	}
	
	public void testDiminuisciQuantit‡(){
		
		assertFalse(carrello.rimuoviLibro("12"));
		
		assertFalse(carrello.rimuoviLibro("9788868363574"));
		
		assertTrue(carrello.rimuoviLibro("9788804598893"));	
	}
	
	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTest(new TestCarrello("testAggiungiAlCarrello"));
		suite.addTest(new TestCarrello("testRimuoviLibro"));
		suite.addTest(new TestCarrello("testAumentaQuantit‡"));
		suite.addTest(new TestCarrello("testDiminuisciQuantit‡"));
		
		return suite;
	}
}
