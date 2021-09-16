package br.com.imd.gcmBank;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.imd.gcmBank.modelo.Conta;

public class ContaTest {

	@Test
	public void testGetNumero() {
		Conta c = new Conta(123);
		assertEquals(c.getNumero(), 123);
	}
	@Test
	public void testSetNumero() {
		Conta c = new Conta(123);
		c.setNumero(456);
		assertEquals(c.getNumero(), 456);
	}
	
	@Test
	public void testGetSaldo() {
		Conta c = new Conta(123);
		assertEquals(c.getSaldo(), 0, 0.1);
	}
	
	@Test
	public void testSetSaldo() {
		Conta c = new Conta(123);
		c.setSaldo(50);
		assertEquals(c.getSaldo(), 50, 0.1);
	}
}
