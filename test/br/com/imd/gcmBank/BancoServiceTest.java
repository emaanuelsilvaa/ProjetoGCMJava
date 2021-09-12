package br.com.imd.gcmBank;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.imd.gcmBank.servico.BancoService;

public class BancoServiceTest {
	@Test
	public void InserirContaSuccessTest() {
		BancoService b = new BancoService();
		assertTrue(b.inserirConta(1));
	}
	
	@Test
	public void InserirContaFailTest() {
		BancoService b = new BancoService();
		b.inserirConta(2);
		assertFalse(b.inserirConta(2));
	}
	
	@Test
	public void VerificarSaldoSuccessTest() {
		BancoService b = new BancoService();
		b.inserirConta(3);
		assertEquals(0.0, b.verificarSaldo(3), 0.1);
	}
	
	@Test
	public void VerificarSaldoFailTest() {
		BancoService b = new BancoService();
		b.inserirConta(4);
		assertEquals(Double.MAX_VALUE, b.verificarSaldo(5), 0.1);
	}
	
	@Test
	public void CreditarSuccessTest() {
		BancoService b = new BancoService();
		b.inserirConta(6);
		assertTrue(b.creditar(6, 50));
	}
	
	@Test
	public void CreditarSuccessSaldoTest() {
		BancoService b = new BancoService();
		b.inserirConta(7);
		b.creditar(7, 50);
		assertEquals(50,b.verificarSaldo(7), 0.1);
	}
	
	@Test
	public void CreditarFailTest() {
		BancoService b = new BancoService();
		assertFalse(b.creditar(8, 50));
	}
	
	@Test
	public void DebitarTest() {
		BancoService b = new BancoService();
		b.inserirConta(9);
		b.debitar(9, 50);
		assertEquals(-50,b.verificarSaldo(9), 0.1);
	}
	
	@Test
	public void TransferirOrigemTest() {
		BancoService b = new BancoService();
		b.inserirConta(10);
		b.inserirConta(11);
		b.transferir(10, 11, 50);
		assertEquals(-50, b.verificarSaldo(10), 0.1);
	}
	
	@Test
	public void TransferirDestinoTest() {
		BancoService b = new BancoService();
		b.inserirConta(12);
		b.inserirConta(13);
		b.transferir(12, 13, 50);
		assertEquals(50, b.verificarSaldo(13), 0.1);
	}
}
