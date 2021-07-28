package br.com.imd.gcmBank.servico;

import java.util.ArrayList;
import java.util.Iterator;

import br.com.imd.gcmBank.dados.BancoDAO;
import br.com.imd.gcmBank.modelo.Conta;

public class BancoService {
	
	
	
	public boolean inserirConta(int numeroConta) {
		if(validarNumedoDaConta(numeroConta)) {
			criarConta(numeroConta);
			return true;
		}
		return false;
	}
	
	public double verificarSaldo( int numeroConta) {
		ArrayList<Conta> contas =  (ArrayList<Conta>) BancoDAO.findAll();
		
		for (Iterator iterator = contas.iterator(); iterator.hasNext();) {
			Conta conta2 = (Conta) iterator.next();
			if(conta2.getNumero() == numeroConta){
				return conta2.getSaldo();
			}
		}
		return Double.MAX_VALUE;
	}
	
	public boolean creditar(int numeroConta, double valor) {
		ArrayList<Conta> contas =  (ArrayList<Conta>) BancoDAO.findAll();
		
		for (Iterator iterator = contas.iterator(); iterator.hasNext();) {
			Conta conta2 = (Conta) iterator.next();
			if(conta2.getNumero() == numeroConta){
				conta2.setSaldo(conta2.getSaldo() + valor);
				return true;
			}
		}
		
		return false;
	}
	
	public void debitar(int numeroConta, double valor) {
		ArrayList<Conta> conta =  (ArrayList<Conta>) BancoDAO.findAll();
		for (Iterator iterator = conta.iterator(); iterator.hasNext();) {
			Conta conta2 = (Conta) iterator.next();
			if(conta2.getNumero() == numeroConta){
				double saldoAtual = BancoDAO.get(numeroConta).getSaldo();
				BancoDAO.get(numeroConta).setSaldo(saldoAtual - valor );
			}
		}
	}
	
	public void transferir(int numeroContaOrigen, int numeroContaDestino, double valor) {
		
	}
	
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
	private void criarConta(int numeroConta) {
		BancoDAO.insert(new Conta(numeroConta));
	}
	
}
