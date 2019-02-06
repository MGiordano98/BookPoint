package model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestLibroManager.class,TestAccountManager.class,TestAmministratoreManager.class,TestAmministratoreOrdineManager.class,TestGestioneOrdineManager.class,TestOrdineManager.class})
public class AllTests {

}
