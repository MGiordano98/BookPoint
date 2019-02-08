package model;



import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import bean.Autore;
import bean.Libro;
import bean.Ordine;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;



public class TestGestioneOrdineManager extends TestCase{

	private GestioneOrdineManager manager;
	

	public TestGestioneOrdineManager(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		manager= new GestioneOrdineManager();
	}
	
	@Override
	protected void tearDown() throws Exception {
	}
	
	public void testVisualizzaStorico() throws SQLException{
		Collection<Ordine> ordini=manager.visualizzaStorico("*");
		assertTrue(ordini.isEmpty());
		
		ordini=manager.visualizzaStorico("antonio@gmail.it");
		assertTrue(ordini.isEmpty());
		
		ordini=manager.visualizzaStorico("g.teodoro@studenti.unisa.it");
		assertNotNull(ordini);
		assertTrue(!ordini.isEmpty());
		
		Iterator<Ordine> it=ordini.iterator();
		while(it.hasNext()){
			Ordine ordine=it.next();
			
			assertNotNull(ordine);
			
			assertNotNull(ordine.getCap());
			assertNotNull(ordine.getCittà());
			assertNotNull(ordine.getNumCarta());
			assertNotNull(ordine.getStato());
			assertNotNull(ordine.getVia());
			assertNotNull(ordine.getDataConsegna());
			assertNotNull(ordine.getDataEffettuata());
			assertNotNull(ordine.getIdOrdine());
			assertNotNull(ordine.getNumCivico());
			assertNotNull(ordine.getOra());
			assertNotNull(ordine.getPrezzoTot());
			
			assertNotNull(ordine.getLibri());
			assertTrue(!ordine.getLibri().isEmpty());
			
			Iterator<Libro> it2=ordine.getLibri().iterator();
			
			while(it2.hasNext()){
				
				Libro libro=it2.next();
				
				assertNotNull(libro);
				assertNotNull(libro.getTitolo());
				assertNotNull(libro.getPrezzo());
				assertNotNull(libro.getQuantità());				
			}
		}
	}
	
	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTest(new TestGestioneOrdineManager("testVisualizzaStorico"));
		
		return suite;
	}
	
}
