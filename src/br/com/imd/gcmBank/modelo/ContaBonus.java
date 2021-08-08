package br.com.imd.gcmBank.modelo;

public class ContaBonus extends Conta {
	private int pontuacao = 10;
	

	public ContaBonus(int numero) {
		super(numero);
	}


	public int getPontuacao() {
		return pontuacao;
	}


	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}	

}
