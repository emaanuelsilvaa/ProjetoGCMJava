package br.com.imd.gcmBank.visao;

import java.util.Scanner;

import br.com.imd.gcmBank.dados.BancoDAO;
import br.com.imd.gcmBank.modelo.Conta;

public class InterfaceView {
	 public static void exibeMenu(){
	        System.out.println("---GCM-BANK---");
	        System.out.println("OPERAÇÔES DISPONIVEIS");
	        System.out.println("1 - Criar Conta");
	        System.out.println("2 - Consultar Saldo");
	        System.out.println("3 - Creditar");
	        System.out.println("4 - Debitar");
	        System.out.println("5 - Transferência");
	        System.out.println("6 - Para Sair");
	        System.out.println("Digite o código de uma operação para prosseguir");
	    }

	    public static void main(String[] args) {
	        int menuOpcao = 0;
	        while(menuOpcao != 6){
	            menuOpcao = 0;
	            exibeMenu();
	            Scanner scanIn = new Scanner(System.in);
	            menuOpcao = scanIn.nextInt();

	            scanIn.close();
	        }

	    };
}
