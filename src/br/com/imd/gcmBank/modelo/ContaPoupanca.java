package br.com.imd.gcmBank.modelo;

public class ContaPoupanca extends Conta {
	
	public ContaPoupanca(int numero) {
		super(numero);
		// TODO Auto-generated constructor stub
	}
	
	public void renderJuros(double taxaPercentual) {
		double valorAtual = getSaldo();
		double valorSobreTaxa = valorAtual * (taxaPercentual/100);
		setSaldo(valorSobreTaxa);
	}

}
