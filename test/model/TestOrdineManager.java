package model;

import java.util.ArrayList;

import bean.Carrello;
import bean.Libro;
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
