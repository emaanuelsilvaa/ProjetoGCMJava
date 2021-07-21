package br.com.imd.gcmBank.modelo;

public class Conta {
	private int numero;
	private double saldo = 0;
	
	
	public Conta(int numero) {
		super();
		this.numero = numero;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
