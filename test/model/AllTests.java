package model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAccountManager.class, TestAmministratoreManager.class, TestOrdineManager.class})
public class AllTests {

}
