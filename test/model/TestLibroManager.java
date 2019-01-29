package model;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import bean.Libro;
import junit.framework.TestCase;

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
	
	public void TestRicercaTesto() throws SQLException{
		Collection<Libro> libriCercati=manager.ricerca("d","");
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
	
	public void TestRicercaCategoria() throws SQLException{
		Collection<Libro> libriCercati=manager.ricerca("","Romanzo");
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
	
	public void TestRicercaTestoCategoria() throws SQLException{
		Collection<Libro> libriCercati=manager.ricerca("d","Romanzo");
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
	
}
