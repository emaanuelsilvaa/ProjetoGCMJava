package br.com.imd.gcmBank;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.imd.gcmBank.modelo.ContaBonus;

public class ContaBonusTest {

	@Test
	public void testPontuacaoInicial() {
		ContaBonus cb = new ContaBonus(123);
		assertEquals(cb.getPontuacao(), 10);
	}
	@Test
	public void testSetPontuacao() {
		ContaBonus cb = new ContaBonus(123);
		cb.setPontuacao(30);
		assertEquals(cb.getPontuacao(), 30);
	}
}
