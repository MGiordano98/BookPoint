package model;


import java.sql.SQLException;
import bean.Utente;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestAccountManager extends TestCase{
	private AccountManager manager;


	public TestAccountManager(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		manager= new AccountManager();
	}
	
	@Override
	protected void tearDown() throws Exception {
	}
		
	public void testLogin() throws SQLException{
		Utente utente= manager.login("giovanni","");
		assertNull(utente);
		
		utente= manager.login("m.garofalo@studenti.unisa.it","");
		assertNull(utente);

		utente= manager.login("m.giordano@studenti.unisa.it","psw");
		assertNull(utente);
		
		utente= manager.login("m.giordano@studenti.unisa.it","#Massimo0");
		assertNull(utente);
		
		utente= manager.login("m.giordano162@studenti.unisa.it","ANbttjnp1");
		assertNotNull(utente);
		assertNotNull(utente.getCognome());
		assertNotNull(utente.getEmail());
		assertNotNull(utente.getNome());
		assertNotNull(utente.getTipo());
		assertNotNull(utente.getDataDiNascita());
	}
	
	
	
	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTest(new TestAccountManager("testLogin"));
		return suite;
	}
}
