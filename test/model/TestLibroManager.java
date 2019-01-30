package model;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import bean.Libro;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestLibroManager extends TestCase{

	private LibroManager manager;
	
	public TestLibroManager(String name){
		super(name);
	}

	@Override
	public void setUp() throws Exception{
		manager=new LibroManager();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testRicerca() throws SQLException{
		Collection<Libro> libriCercati=manager.ricerca("*","");
		assertTrue(libriCercati.size()==0);
		
		libriCercati=manager.ricerca("Il piccolo principe","");
		assertTrue(libriCercati.size()==0);
		
		libriCercati=manager.ricerca("Il barone rampante","*");
		assertTrue(libriCercati.size()==0);
		
		libriCercati=manager.ricerca("Il barone rampante","Cavallo");
		assertTrue(libriCercati.size()==0);
		
		libriCercati=manager.ricerca("Il barone rampante","Romanzo");
		assertTrue(libriCercati.size()>0);
		
		Iterator<Libro> it=libriCercati.iterator();
		while(it.hasNext()){
			Libro libro=it.next();
			assertNotNull(libro.getIsbn());
			assertNotNull(libro.getTitolo());
			assertNotNull(libro.getTrama());
			assertNotNull(libro.getFoto());
			assertNotNull(libro.getCasaEditrice());
			assertNotNull(libro.getPrezzo());
			assertNotNull(libro.getQuantit‡());
			assertNotNull(libro.getCategoria());
			assertNotNull(libro.getCopieVendute());
			assertNotNull(libro.getDataUscita());
			assertNotNull(libro.getQuantit‡Selezionata());
		}
	}
	
	public void TestGetLibriPi˘Venduti() throws SQLException{
		Collection<Libro> libriPi˘Venduti=manager.getLibriPi˘Venduti();
		assertTrue(libriPi˘Venduti.size()>0);
		
		Iterator<Libro> it=libriPi˘Venduti.iterator();
		while(it.hasNext()){
			Libro libro=it.next();
			assertNotNull(libro.getIsbn());
			assertNotNull(libro.getTitolo());
			assertNotNull(libro.getTrama());
			assertNotNull(libro.getFoto());
			assertNotNull(libro.getCasaEditrice());
			assertNotNull(libro.getPrezzo());
			assertNotNull(libro.getQuantit‡());
			assertNotNull(libro.getCategoria());
			assertNotNull(libro.getCopieVendute());
			assertNotNull(libro.getDataUscita());
			assertNotNull(libro.getQuantit‡Selezionata());
		}
	}
	
	public void TestGetLibriInEvidenza() throws SQLException{
		Collection<Libro> libriInEvidenza=manager.getLibriPi˘Venduti();
		assertTrue(libriInEvidenza.size()>0);
		
		Iterator<Libro> it=libriInEvidenza.iterator();
		while(it.hasNext()){
			Libro libro=it.next();
			assertNotNull(libro.getIsbn());
			assertNotNull(libro.getTitolo());
			assertNotNull(libro.getTrama());
			assertNotNull(libro.getFoto());
			assertNotNull(libro.getCasaEditrice());
			assertNotNull(libro.getPrezzo());
			assertNotNull(libro.getQuantit‡());
			assertNotNull(libro.getCategoria());
			assertNotNull(libro.getCopieVendute());
			assertNotNull(libro.getDataUscita());
			assertNotNull(libro.getQuantit‡Selezionata());
		}
	}
	
	public void TestVisualizzaLibro() throws SQLException{
		Libro libro=manager.visualizzaLibro("12");
		assertNull(libro);
		
		libro=manager.visualizzaLibro("1234567891234");
		assertNull(libro);
		
		libro=manager.visualizzaLibro("9788804679622");
		assertNotNull(libro);
		
		assertNotNull(libro.getIsbn());
		assertNotNull(libro.getTitolo());
		assertNotNull(libro.getTrama());
		assertNotNull(libro.getFoto());
		assertNotNull(libro.getCasaEditrice());
		assertNotNull(libro.getPrezzo());
		assertNotNull(libro.getQuantit‡());
		assertNotNull(libro.getCategoria());
		assertNotNull(libro.getCopieVendute());
		assertNotNull(libro.getDataUscita());
		assertNotNull(libro.getQuantit‡Selezionata());
	}
	
	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTest(new TestLibroManager("testRicerca"));
		
		
		return suite;
	}
}
