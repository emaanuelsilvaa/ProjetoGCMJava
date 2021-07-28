package br.com.imd.gcmBank.servico;

import java.util.ArrayList;
import java.util.Iterator;

import br.com.imd.gcmBank.dados.BancoDAO;
import br.com.imd.gcmBank.modelo.Conta;
import br.com.imd.gcmBank.modelo.ContaBonus;

public class ContaBonusService {
	
	
	public double verificarSaldo( int numeroConta) {
		ArrayList<Conta> contas =  (ArrayList<Conta>) BancoDAO.findAll();
		
		for (Iterator iterator = contas.iterator(); iterator.hasNext();) {
			ContaBonus conta2 = (ContaBonus) iterator.next();
			if(conta2.getNumero() == numeroConta){
				return conta2.getSaldo();
			}
		}
		return Double.MAX_VALUE;
	}
	public boolean creditar(int numeroConta, double valor) {
		ArrayList<Conta> contas =  (ArrayList<Conta>) BancoDAO.findAll();
		
		for (Iterator iterator = contas.iterator(); iterator.hasNext();) {
			ContaBonus conta2 = (ContaBonus) iterator.next();
			if(conta2.getNumero() == numeroConta){
				if(valor > 100) {
					int pontosGanhos = (int) (valor/100);
					int pontuacaoAtual = conta2.getPontuacao();
					conta2.setPontuacao(pontuacaoAtual + pontosGanhos);	
					return true;
				}
				conta2.setSaldo(conta2.getSaldo() + valor);
				return true;
			}
		}
		
		return false;
	}
	public void debitar(int numeroConta, double valor) {
		ArrayList<Conta> conta =  (ArrayList<Conta>) BancoDAO.findAll();
		for (Iterator iterator = conta.iterator(); iterator.hasNext();) {
			ContaBonus conta2 = (ContaBonus) iterator.next();
			if(conta2.getNumero() == numeroConta){
				double saldoAtual = BancoDAO.get(numeroConta).getSaldo();
				BancoDAO.get(numeroConta).setSaldo(saldoAtual - valor );
			}
		}
	}
	public void transferir(int numeroContaOrigem, int numeroContaDestino, double valor) {
		
		if(!validarNumedoDaConta(numeroContaDestino) && !validarNumedoDaConta(numeroContaOrigem) )  {
			if(valor > 200) {
				ContaBonus conta2 = (ContaBonus) BancoDAO.get(numeroContaDestino);
				int pontosGanhos = (int) (valor/200);
				int pontuacaoAtual = conta2.getPontuacao();
				((ContaBonus) BancoDAO.get(numeroContaDestino)).setPontuacao(pontuacaoAtual + pontosGanhos);
			}	
			double saldoOrigem = BancoDAO.get(numeroContaOrigem).getSaldo();
			BancoDAO.get(numeroContaOrigem).setSaldo(saldoOrigem - valor);
			double saldoDestino = BancoDAO.get(numeroContaDestino).getSaldo();
			BancoDAO.get(numeroContaDestino).setSaldo(saldoDestino + valor);
		}
		else
			System.out.println("numero de conta invalida");
	}
	 
	 public boolean inserirConta(int numeroConta) {
			if(validarNumedoDaConta(numeroConta)) {
				criarConta(numeroConta);
				return true;
			}
			return false;
		}
	 
	 private void criarConta(int numeroConta) { BancoDAO.insert(new Conta(numeroConta)); }
	 
	 public boolean validarNumedoDaConta(int numeroConta) {
			ArrayList<Conta> conta =  (ArrayList<Conta>) BancoDAO.findAll();
			for (Iterator iterator = conta.iterator(); iterator.hasNext();) {
				Conta conta2 = (Conta) iterator.next();
				if(conta2.getNumero() == numeroConta){
					return false;
				}
			}
			return true;
	 }
}
