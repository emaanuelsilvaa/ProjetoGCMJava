package br.com.imd.gcmBank.servico;

import java.util.ArrayList;
import java.util.Iterator;

import br.com.imd.gcmBank.dados.BancoDAO;
import br.com.imd.gcmBank.modelo.Conta;

public class BancoService {
	
	
	
	public boolean inserirConta(int numeroConta) {
		ArrayList<Conta> conta =  (ArrayList<Conta>) BancoDAO.findAll();
		
		for (Iterator iterator = conta.iterator(); iterator.hasNext();) {
			Conta conta2 = (Conta) iterator.next();
			if(conta2.getNumero() == numeroConta){
			}
			
		}
		
		return true;
		
	}
	public void verificarSaldo( int numeroConta) {
		
	}
	
	public void creditar( int numeroConta, double valor) {
		
	}
	
	public void debitar(int numero, double valor) {
	}
	
	public void transferir(int numeroContaOrigen, int numeroContaDestino, double valor) {
		
	}
	
}
