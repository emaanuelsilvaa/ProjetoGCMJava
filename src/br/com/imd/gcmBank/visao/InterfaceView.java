package br.com.imd.gcmBank.visao;

import java.util.Scanner;

import br.com.imd.gcmBank.dados.BancoDAO;
import br.com.imd.gcmBank.modelo.Conta;

public class InterfaceView {
	 public static void exibeMenu(){
	        System.out.println("---GCM-BANK---");
	        System.out.println("OPERA��ES DISPONIVEIS");
	        System.out.println("1 - Criar Conta");
	        System.out.println("2 - Consultar Saldo");
	        System.out.println("3 - Creditar");
	        System.out.println("4 - Debitar");
	        System.out.println("5 - Transfer�ncia");
	        System.out.println("6 - Para Sair");
	        System.out.println("Digite o c�digo de uma opera��o para prosseguir");
	    }
	 public static void opcaoNovaConta() {
		int NumeroConta = -1;
		System.out.println("---GCM-BANK---");
		System.out.println("Criar Conta");
     	System.out.println("Informe o numero da conta ou 0 para voltar");
     	Scanner scanConta = new Scanner(System.in);
     	NumeroConta = scanConta.nextInt();
     	if(NumeroConta == 0) {
     		//Inserir as valida��es de existencia de conta aqui
     		System.out.println("J� existe conta com esse numero, informe outro numero");
     	}
     	else {
     		//Adicionar as opera��es de constru��o de conta
     		System.out.println("Conta " + NumeroConta + " criada com sucesso");
     	}
	 }
	 public static void opcaoSaldo() {
		int numConta = -1;
		System.out.println("---GCM-BANK---");
		System.out.println("Consultar Saldo");
	    System.out.println("Informe o numero da conta ou 0 para voltar");
	    double saldoAtual = 10.0;
	    Scanner scanConta = new Scanner(System.in);
	    numConta = scanConta.nextInt();
	     	if(numConta >= 1 && numConta <= 50) { //adicionar opera��o de consulda de saldo
	     		System.out.println("Saldo da Conta " + numConta + " � de R$" + saldoAtual);
	     	}
	     	else if (numConta > 50) { //Conectar Opera��o de valida��o de conta
	     		System.out.println("Conta insexistente");
	     	}
	     	else {
	     		System.out.println("Rotornando");
	     		return;
	     	}
	 }
	 public static void opcaoCreditar() {
		 int numConta = -1;
		 double valorCreditado = 0.0;
		 System.out.println("---GCM-BANK---");
		 System.out.println("Creditar");
		 System.out.println("Informe o numero da conta ou 0 para voltar");
		 Scanner scanCredito = new Scanner(System.in);
		 numConta = scanCredito.nextInt();
		 if(numConta > 0) { //Adicionar opera��o de conta existente
			 System.out.println("Informe o valor a ser creditado");
			 valorCreditado = scanCredito.nextDouble();
			 if(valorCreditado > 0.0) {
				 System.out.println("Opera��o realizada com Sucesso");
				 System.out.println("Conta: " + numConta);
				 System.out.println("Valor creditado: " + valorCreditado);
				 System.out.println("Novo Saldo: " + valorCreditado); //Alterar para receber dados do objeto.
			 }
		 }
		 else {
			 System.out.println("Opera��o cancelada");
			 
			 
		 }
	 }
	 
	 public static void opcaoDebitar() {
		 int numConta = -1;
		 double valorDebitado = 0.0;
		 Scanner scanDebito = new Scanner(System.in);
		 System.out.println("---GCM-BANK---");
		 System.out.println("Debitar");
		 System.out.println("Informe o numero da conta ou 0 para voltar");
		 numConta = scanDebito.nextInt();
		 if(numConta > 0) { //adicionar valida��o de conta existente
			 System.out.println("Informe o valor debitado ou 0 para voltar");
			 valorDebitado = scanDebito.nextDouble();
			 if(valorDebitado > 0.0) {
				 System.out.println("Opera��o realizada com Sucesso");
				 System.out.println("Conta: " + numConta);
				 System.out.println("Valor debitado: " + valorDebitado);
				 System.out.println("Novo Saldo: " + valorDebitado); //Alterar para receber dados do objeto.
			 }
		 }
		 else {
			 System.out.println("Opera��o cancelada");
		 }
	 }
	 
	 public static void opcaoTransferencia() {
		int contaOrigem = -1;
		int contaDestino = -1;
		double valorTransferencia = 0.0;
		System.out.println("---GCM-BANK---");
		System.out.println("Transfer�ncia");
		System.out.println("Informe o numero da conta de origem ou 0 para encerrar a opera��o");
		Scanner scanTransf = new Scanner(System.in);
		contaOrigem = scanTransf.nextInt();
		if(contaOrigem > 0) { //adicionar opera��ode valida��o de conta existente
			System.out.println("Informe o numero da conta de destino ou 0 para encerrar a opera��o");
			contaDestino = scanTransf.nextInt();
			if(contaDestino > 0) { //adicionar valida��o de conta existente
				System.out.println("Informe o valor a ser transferido");
				valorTransferencia = scanTransf.nextDouble();
				if(valorTransferencia > 0.0) {
					System.out.println("Transferencia Realizada: ");
					System.out.println("Conta Origem: " + contaOrigem);
					System.out.println("Conta Destino: " + contaDestino);
					System.out.println("Valor Transferido: " + valorTransferencia);
				}
			}
		}
		else {
			System.out.println("Opera��o cancelada");
		}
	 }
	    public static void main(String[] args) {
	        int menuOpcao = 0;
	        Scanner scanIn = new Scanner(System.in);
	        while(menuOpcao != 6){
	            menuOpcao = 0;
	            exibeMenu();
	            menuOpcao = scanIn.nextInt();
	            
	            if(menuOpcao == 1) {
	            	opcaoNovaConta();
	            }
	            if(menuOpcao == 2) {
	            	opcaoSaldo();
	            }
	            if(menuOpcao == 3) {
	            	opcaoCreditar();
	            }
	            if(menuOpcao == 4) {
	            	opcaoDebitar();
	            }
	            if(menuOpcao == 5) {
	            	opcaoTransferencia();
	            }
	        }
	        scanIn.close();
	        System.out.println("Encerrou");
	    };
}
