package model;

import java.util.ArrayList;

import bean.Carrello;
import bean.Libro;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class TestOrdineManager extends TestCase {

	public TestOrdineManager(String name) {
		super(name);
	}

	public void testAggiungiAlCarrello() {

		Libro libro= new Libro();
		
		ArrayList<Libro> libri= new ArrayList<Libro>();
		libri.add(libro);
		
		assertEquals(1, libri.size());
	}
	
	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTest(new TestOrdineManager("testAggiungiAlCarrello"));
		return suite;
	}
	
	public static void main() {
		
		TestRunner.run(suite());

	}
}
