package br.com.imd.gcmBank.visao;

import br.com.imd.gcmBank.dados.BancoDAO;
import br.com.imd.gcmBank.modelo.Conta;

public class InterfaceView {

	public static void main(String[] args) {
		
		Conta c1 = new Conta(1000);
		
		BancoDAO.insert(c1);
		
		System.out.println();

	}

}
