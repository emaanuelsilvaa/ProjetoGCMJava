package br.com.imd.gcmBank;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import br.com.imd.gcmBank.modelo.ContaPoupanca;

public class ContaPoupancaTest {

	@Test
	public void testCriarConta() {
		ContaPoupanca cp = new ContaPoupanca(123, 0);
		assertEquals(0, cp.GetSaldoInicial(), 0.1);
	}
	@Test
	public void testCriarContaSaldo() {
		ContaPoupanca cp = new ContaPoupanca(123, 10);
		assertEquals(10, cp.GetSaldoInicial(), 0.1);
	}
	@Test
	@Ignore
	public void testRendimentoPoupanca() {
		ContaPoupanca cp = new ContaPoupanca(123, 100.0);
		assertEquals(10.0, cp.RendimentoPoupanca(10), 0.01);
	}
	
	@Test
	@Ignore
	public void testValorTotalComRendimento() {
		ContaPoupanca cp = new ContaPoupanca(123, 100.0);
		cp.ValorTotalComRendimento(10);
		assertEquals(110.0, cp.GetSaldoInicial(), 0.01);
	}
}
