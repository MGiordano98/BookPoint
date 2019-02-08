package model;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import bean.Autore;
import bean.Libro;
import bean.Ordine;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestOrdineManager extends TestCase {
	private OrdineManager manager;
	
	
	public TestOrdineManager(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		manager= new OrdineManager();
		
	}
	
	@Override
	protected void tearDown() throws Exception {
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
		ordine.setStato("in preparazione");
		ordine.setNumCarta("00000000000000000000");
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
		ordine.setStato("in preparazione");
		ordine.setNumCarta("0000000000000004");
		ordine.setEmail("g.teodorostudenti.unisa.it");
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
		ordine.setStato("in preparazione");
		ordine.setNumCarta("0000000000000005");
		ordine.setEmail("g.teodoro@studenti.unisa.it");
		
		ArrayList<Libro> libri=new ArrayList<Libro>();
		Libro libro=new Libro();
		
		libro.setIsbn("9788804679622");
		libro.setPrezzo(8.4);
		libro.setTitolo("Dieci piccoli indiani");
		libro.setQuantit‡Selezionata(1);;
		
		libri.add(libro);
		ordine.setLibri(libri);
		
		assertTrue(manager.completaAcquisto(ordine));
		
	}
	
	
	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTestSuite(TestOrdineManager.class);

		return suite;
	}
	
}
