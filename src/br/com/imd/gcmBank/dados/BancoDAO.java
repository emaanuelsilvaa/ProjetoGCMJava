package br.com.imd.gcmBank.dados;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.imd.gcmBank.modelo.Conta;

public final class BancoDAO {
	
	public static List<Conta> listaDeContas = new ArrayList<Conta>();
	
	public static final List<Conta> findAll(){
		return new ArrayList<Conta>(listaDeContas);
	}
	
	public static final Conta get(int numero) {
		
		for (Iterator<Conta> iterator = listaDeContas.iterator(); iterator.hasNext();) {
			Conta conta = (Conta) iterator.next();
			if(conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
	
	public static final boolean insert(Conta conta) {
		try{
			listaDeContas.add(conta);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public static final boolean delete(Conta conta) {
		
		return listaDeContas.remove(conta);
		
	}
}
