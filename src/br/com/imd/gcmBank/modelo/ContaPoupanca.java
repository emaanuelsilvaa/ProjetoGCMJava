package br.com.imd.gcmBank.modelo;

public class ContaPoupanca extends Conta {
	
	public ContaPoupanca(int numero) {
		super(numero);
		// TODO Auto-generated constructor stub
	}
	
	public double RendimentoPoupanca(double taxaPercentual) {
		double valorAtual = getSaldo();
		double rendimento = valorAtual * (taxaPercentual/100);
		return rendimento;
	}
	
	public void ValorTotalComRendimento(double taxaPercentual) {
		double saldoAtual = getSaldo();
		double valorTotal = saldoAtual + RendimentoPoupanca(taxaPercentual);
		setSaldo(valorTotal);
	}
}
