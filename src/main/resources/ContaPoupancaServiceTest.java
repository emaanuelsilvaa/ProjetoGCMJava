package main.resources;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import br.com.imd.gcmBank.servico.BancoService;
import br.com.imd.gcmBank.servico.ContaPoupancaService;

public class ContaPoupancaServiceTest {

	@Test
	public void InserirContaSuccessTest() {
		ContaPoupancaService cp = new ContaPoupancaService();
		assertTrue(cp.inserirConta(1, 10));
	}
	
	@Test
	public void InserirContaFailTest() {
		ContaPoupancaService cp = new ContaPoupancaService();
		cp.inserirConta(2, 10);
		assertFalse(cp.inserirConta(2, 10));
	}

	
	@Test
	@Disabled
	public void VerificarSaldoSuccessTest() {
		ContaPoupancaService cp = new ContaPoupancaService();
		cp.inserirConta(3, 1.0);
		assertEquals(1.0, cp.verificarSaldo(3), 0.1);
	}
		
	@Test
	public void VerificarSaldoFailTest() {
		ContaPoupancaService cp = new ContaPoupancaService();
		assertEquals(Double.MAX_VALUE, cp.verificarSaldo(4), 0.1);
	}
	
	@Test
	public void CreditarSuccessTest() {
		ContaPoupancaService cp = new ContaPoupancaService();
		cp.inserirConta(5, 0);
		cp.creditar(5, 10);
		assertEquals(10.0, cp.verificarSaldo(5), 0.1);
	}
	
	@Test
	public void CreditarFailTest() {
		ContaPoupancaService cp = new ContaPoupancaService();
		assertFalse(cp.creditar(6, 10));
	}
	
	@Test
	public void DebitarSuccessTest() {
		ContaPoupancaService cp = new ContaPoupancaService();
		cp.inserirConta(7, 0);
		cp.debitar(7, 10);
		assertEquals(-10, cp.verificarSaldo(7), 0.1);
	}
	
	@Test
	public void TransferirOrigemTest() {
		ContaPoupancaService cp = new ContaPoupancaService();
		cp.inserirConta(8, 0);
		cp.inserirConta(9, 0);
		cp.transferir(8, 9, 50);
		assertEquals(-50, cp.verificarSaldo(8), 0.1);
	}
	
	@Test
	public void TransferirDestinoTest() {
		ContaPoupancaService cp = new ContaPoupancaService();
		cp.inserirConta(10, 0);
		cp.inserirConta(11, 0);
		cp.transferir(10, 11, 50);
		assertEquals(50, cp.verificarSaldo(11), 0.1);
	}
	
	@Test
	public void IsContaPoupancaSuccessTest() {
		ContaPoupancaService cp = new ContaPoupancaService();
		cp.inserirConta(12, 0);
		assertTrue(cp.isContaPoupanca(12));
	}
	
	@Test
	public void IsContaPoupancaFailTest() {
		ContaPoupancaService cp = new ContaPoupancaService();
		assertFalse(cp.isContaPoupanca(13));
	}
	
	@Test
	public void ObterRendimentolTest() {
		ContaPoupancaService cp = new ContaPoupancaService();
		cp.inserirConta(14, 10);
		cp.creditar(14, 100);
		assertEquals(110, cp.obterRendimentoDeJuros(14, 10), 0.1);
	}
}
