package test.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import br.com.imd.gcmBank.servico.ContaBonusService;



public class ContaBonusServiceTest {

	@Test
	public void InserirContaSuccessTest() {
		ContaBonusService cb = new ContaBonusService();
		assertTrue(cb.inserirConta(1));
	}
	
	@Test
	public void InserirContaFailTest() {
		ContaBonusService cb = new ContaBonusService();
		cb.inserirConta(2);
		assertFalse(cb.inserirConta(2));
	}
	
	@Test
	@Disabled
	public void IsContaBonusSuccessTest() {
		ContaBonusService cb = new ContaBonusService();
		cb.inserirConta(3);
		assertTrue(cb.isContaBonus(3));
		
	}
	
	@Test
	public void IsContaBonusFailTest() {
		ContaBonusService cb = new ContaBonusService();
		assertFalse(cb.isContaBonus(4));
	}
	
	@Test
	//@Disabled
	public void VerificarSaldoTest() {
		ContaBonusService cb = new ContaBonusService();
		cb.inserirConta(5);
		cb.creditar(5, 10);
		assertEquals(0, cb.verificarSaldo(5), 0.1);
	}
	
	@Test
	@Disabled
	public void CreditarSuccessTest() {
		ContaBonusService cb = new ContaBonusService();
		cb.inserirConta(6);
		assertTrue(cb.creditar(6, 50));
	}
	
	@Test
	@Disabled
	public void CreditarFailTest() {
		ContaBonusService cb = new ContaBonusService();
		assertFalse(cb.creditar(7, 50));
	}
	
	@Test
	@Disabled
	public void CreditarSuccessSaldoTest() {
		ContaBonusService cb = new ContaBonusService();
		cb.inserirConta(8);
		cb.creditar(8, 50);
		assertEquals(50.0, cb.verificarSaldo(8), 0.1);
	}
	
	@Test
	@Disabled
	public void DebitarSuccessTest() {
		ContaBonusService cb = new ContaBonusService();
		cb.inserirConta(9);
		cb.debitar(9, 50);
		assertEquals(-50.0, cb.verificarSaldo(8), 0.1);
	}
	
	@Test
	@Disabled
	public void TransferirSuccessOrigemTest() {
		ContaBonusService cb = new ContaBonusService();
		cb.inserirConta(10);
		cb.inserirConta(11);
		cb.transferir(10, 11, 50);
		assertEquals(-50.0, cb.verificarSaldo(10), 0.1);
	}
	
	@Test
	@Disabled
	public void TransferirSuccessDestinoTest() {
		ContaBonusService cb = new ContaBonusService();
		cb.inserirConta(12);
		cb.inserirConta(13);
		cb.transferir(10, 11, 50);
		assertEquals(-50.0, cb.verificarSaldo(13), 0.1);
	}
}
