package model;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Collection;
import java.util.Iterator;

import bean.CartaDiCredito;
import bean.Indirizzo;
import bean.Ordine;
import bean.Utente;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestAmministratoreOrdineManager extends TestCase{
	private AmministratoreOrdineManager manager;
	
	public TestAmministratoreOrdineManager(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		manager= new AmministratoreOrdineManager();
	}
	
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
	
	public void testRicercaOrdine() throws SQLException {
	 
		assertNull(manager.ricercaOrdine(-1));
		assertNull(manager.ricercaOrdine(100));
		assertNull(manager.ricercaOrdine(1));
	}
	
	public void testCambiaStato() throws SQLException {
		
		assertTrue(manager.cambiaStato(-1,""));
		assertTrue(manager.cambiaStato(100, ""));
		assertTrue(manager.cambiaStato(1, "nel carrello"));
		assertTrue(manager.cambiaStato(1,"Consegnato"));
	}
	
	public void testCambiaDataEOra() throws SQLException {
		
		assertFalse(manager.cambiaDataEOra(-1, null, null));
		assertFalse(manager.cambiaDataEOra(100, null, null));
		
		Time ora=Time.valueOf("30:10:10");
		assertFalse(manager.cambiaDataEOra(1, null, ora));
		
		ora=Time.valueOf("10:10:10");
		Date data=Date.valueOf("01-01-2001");
		assertFalse(manager.cambiaDataEOra(1, data, ora));
		
		data=Date.valueOf("01-01-2001");
		ora=Time.valueOf("10:10:10");
		assertTrue(manager.cambiaDataEOra(1, data, ora));
		
	}
	
	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTest(new TestAmministratoreOrdineManager("testRicercaOrdine"));
		suite.addTest(new TestAmministratoreOrdineManager("testCambiaStato"));
		suite.addTest(new TestAmministratoreOrdineManager("testCambiaDataEOra"));
		
		return suite;
	}
}
