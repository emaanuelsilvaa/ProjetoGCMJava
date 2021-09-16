package test.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
