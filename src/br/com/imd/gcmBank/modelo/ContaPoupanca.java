package br.com.imd.gcmBank.modelo;

public class ContaPoupanca extends Conta {
	
	private double saldoInicial = 0;
	
	public ContaPoupanca(int numero, double saldoInicial) {
		super(numero);
		this.saldoInicial = saldoInicial;
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
	
	public double GetSaldoInicial() {
		return saldoInicial;
	}
	
	public void SetSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}
}
