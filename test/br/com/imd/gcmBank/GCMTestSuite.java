package br.com.imd.gcmBank;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ContaTest.class,
				ContaBonusTest.class,
				ContaPoupancaTest.class,
				BancoServiceTest.class,
				ContaBonusServiceTest.class,
				ContaPoupancaServiceTest.class})
public class GCMTestSuite {
}
