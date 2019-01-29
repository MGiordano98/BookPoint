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
		int numOrdine= 3;
		Ordine ordine= manager.ricercaOrdine(numOrdine);
		assertNotNull(ordine);
	}
	
	public void testCambiaStato() throws SQLException {
		int numOrdine= 3;
		String stato= "In Preparazione";
		assertTrue(manager.cambiaStato(numOrdine, stato));
	}
	
	public void testCambiaDataEOra() throws SQLException {
		int numOrdine= 3;
		Date data= Date.valueOf("2020-01-01");
		Time ora= Time.valueOf("10:10:10");
		assertTrue(manager.cambiaDataEOra(numOrdine, data, ora));
	}
	
	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTest(new TestAmministratoreOrdineManager("testRicercaOrdine"));
		suite.addTest(new TestAmministratoreOrdineManager("testCambiaStato"));
		suite.addTest(new TestAmministratoreOrdineManager("testCambiaDataEOra"));
		
		return suite;
	}
}
