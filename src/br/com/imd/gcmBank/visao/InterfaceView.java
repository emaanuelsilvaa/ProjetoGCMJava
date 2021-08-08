package br.com.imd.gcmBank.visao;

import java.util.Scanner;

import br.com.imd.gcmBank.dados.BancoDAO;
import br.com.imd.gcmBank.modelo.Conta;
import br.com.imd.gcmBank.modelo.ContaPoupanca;
import br.com.imd.gcmBank.servico.BancoService;
import br.com.imd.gcmBank.servico.ContaPoupancaService;
import br.com.imd.gcmBank.servico.ContaBonusService;


public class InterfaceView {
	 public static void exibeMenu(){
	        System.out.println("---GCM-BANK---");
	        System.out.println("OPERAÇÔES DISPONIVEIS");
	        System.out.println("1 - Criar Conta");
	        System.out.println("2 - Consultar Saldo");
	        System.out.println("3 - Creditar");
	        System.out.println("4 - Debitar");
	        System.out.println("5 - Transferência");
	        System.out.println("6 - Render Juros");
	        System.out.println("0 - Para Sair");
	        System.out.println("Digite o código de uma operação para prosseguir");
	    }

	 public static void opcaoNovaConta(BancoService b, ContaBonusService cb, ContaPoupancaService cp) {
		int numeroConta = -1;
		int tipoConta = -1;
		System.out.println("---GCM-BANK---");
		System.out.println("Criar Conta");
     	System.out.println("Informe o tipo da conta ou 0 para voltar");
     	System.out.println("1- Conta Simples");
      System.out.println("2- Conta Bonus");
     	System.out.println("3- Conta Poupanca");
     	Scanner scanConta = new Scanner(System.in);
     	tipoConta = scanConta.nextInt();
     	if(tipoConta < 1) {
     		System.out.println("Retornando");
     		return;
     	}
     	System.out.println("Informe o numero da conta ou 0 para voltar");
     	numeroConta = scanConta.nextInt();
     	if(numeroConta != 0 && b.validarNumedoDaConta(numeroConta)) {
     		if(tipoConta == 1) {
     		b.inserirConta(numeroConta);
     		System.out.println("Conta " + numeroConta + " criada com sucesso");
     		}
        if(tipoConta == 2) {
     			cb.inserirConta(numeroConta);
     			System.out.println("Conta bonus " + numeroConta + " criada com sucesso");
     		}
     		if(tipoConta == 3) {
     			cp.inserirConta(numeroConta);
     			System.out.println("Conta poupanca" + numeroConta + " criada com sucesso");

     		}
     		//System.out.println("Já existe conta com esse numero, informe outro numero");
     	}
     	else{
     		//Adicionar as operações de construção de conta
     		System.out.println("Já existe conta com esse numero, informe outro numero");
     	}
	 }
	 public static void opcaoSaldo(BancoService b) {
		int numeroConta = -1;
		System.out.println("---GCM-BANK---");
		System.out.println("Consultar Saldo");
	    System.out.println("Informe o numero da conta ou 0 para voltar");
	    double saldoAtual = 0;
	    Scanner scanConta = new Scanner(System.in);
	    numeroConta = scanConta.nextInt();
	     	if(!b.validarNumedoDaConta(numeroConta)) { //adicionar operação de consulda de saldo
	     		saldoAtual = b.verificarSaldo(numeroConta);
	     		System.out.println("Saldo atual da Conta " + numeroConta + ": R$" + saldoAtual);
	     	}
	     	else {
	     		System.out.println("Conta insexistente");
	     	}
	 }

	 public static void opcaoCreditar(BancoService b, ContaBonusService cb, ContaPoupancaService cp) {

		 int numeroConta = -1;
		 double valorCreditado = 0.0;
		 System.out.println("---GCM-BANK---");
		 System.out.println("Creditar");
		 System.out.println("Informe o numero da conta ou 0 para voltar");
		 Scanner scanCredito = new Scanner(System.in);
		 numeroConta = scanCredito.nextInt();
		 if(numeroConta > 0 && !b.validarNumedoDaConta(numeroConta)) { //Adicionar operação de conta existente
			 System.out.println("Informe o valor a ser creditado");
			 valorCreditado = scanCredito.nextDouble();
			 if(valorCreditado > 0.0 && !cb.isContaBonus(numeroConta)) {
				 b.creditar(numeroConta, valorCreditado);
				 System.out.println("Operação realizada com Sucesso");
				 System.out.println("Conta: " + numeroConta);
				 System.out.println("Valor creditado: " + valorCreditado);
				 System.out.println("Novo Saldo: " + b.verificarSaldo(numeroConta)); //Alterar para receber dados do objeto.
			 }
			 else {
				 cb.creditar(numeroConta, valorCreditado);
				 System.out.println("Operação realizada com Sucesso");
				 System.out.println("Conta: " + numeroConta);
				 System.out.println("Valor creditado: " + valorCreditado);
				 System.out.println("Novo Saldo: " + cb.verificarSaldo(numeroConta)); //Alterar para receber dados do objeto
			 }
		 }
		 else {
			 System.out.println("Operação cancelada");
			 
			 
		 }
	 }
	 
	 public static void opcaoDebitar(BancoService b) {
		 int numeroConta = -1;
		 double valorDebitado = 0.0;
		 Scanner scanDebito = new Scanner(System.in);
		 System.out.println("---GCM-BANK---");
		 System.out.println("Debitar");
		 System.out.println("Informe o numero da conta ou 0 para voltar");
		 numeroConta = scanDebito.nextInt();
		 if(numeroConta > 0 && !b.validarNumedoDaConta(numeroConta)) { //adicionar validação de conta existente
			 System.out.println("Informe o valor debitado ou 0 para voltar");
			 valorDebitado = scanDebito.nextDouble();
			 if(valorDebitado > 0.0) {
				 b.debitar(numeroConta, valorDebitado);
				 System.out.println("Operação realizada com Sucesso");
				 System.out.println("Conta: " + numeroConta);
				 System.out.println("Valor debitado: " + valorDebitado);
				 System.out.println("Novo Saldo: " + b.verificarSaldo(numeroConta)); //Alterar para receber dados do objeto.
			 }
		 }
		 else {
			 System.out.println("Operação cancelada");
		 }
	 }
	 
	 public static void opcaoTransferencia(BancoService b) {
		int contaOrigem = -1;
		int contaDestino = -1;
		double valorTransferencia = 0.0;
		System.out.println("---GCM-BANK---");
		System.out.println("Transferência");
		System.out.println("Informe o numero da conta de origem ou 0 para encerrar a operação");
		Scanner scanTransf = new Scanner(System.in);
		contaOrigem = scanTransf.nextInt();
		if(contaOrigem > 0 && !b.validarNumedoDaConta(contaOrigem)) { //adicionar operaçãode validação de conta existente
			System.out.println("Informe o numero da conta de destino ou 0 para encerrar a operação");
			contaDestino = scanTransf.nextInt();
			if(contaDestino > 0 && !b.validarNumedoDaConta(contaDestino)) { //adicionar validação de conta existente
				System.out.println("Informe o valor a ser transferido");
				valorTransferencia = scanTransf.nextDouble();
				if(valorTransferencia > 0.0) {
					b.transferir(contaOrigem, contaDestino, valorTransferencia);
					System.out.println("Transferencia Realizada: ");
					System.out.println("Conta Origem: " + contaOrigem);
					System.out.println("Conta Destino: " + contaDestino);
					System.out.println("Valor Transferido: " + valorTransferencia);
					System.out.println("Novo Saldo Conta Origem: " + b.verificarSaldo(contaOrigem));
					System.out.println("Novo Saldo Conta Destino: " + b.verificarSaldo(contaDestino));
				}
			}
		}
		else {
			System.out.println("Operação cancelada");
		}
	 }
	 
	 public static void opcaoRenderJuros(BancoService b, ContaPoupancaService cp) {
		 int numeroConta = -1;
		 double valorRendimento = 0;
		System.out.println("---GCM-BANK---");
		System.out.println("Rendimento de Juros para Poupança");
		System.out.println("Informe o numero da conta POUPANCA ou 0 para encerrar a operação");
		Scanner scanJuros = new Scanner(System.in);
		numeroConta = scanJuros.nextInt();
		if(numeroConta > 0) {
			if(!cp.validarNumedoDaConta(numeroConta) && cp.isContaPoupanca(numeroConta)) {
				System.out.println("Informe o percentual de juros a serem aplicados ou 0 para voltar");
				valorRendimento = scanJuros.nextDouble();
				if(valorRendimento > 0.0) {
					double saldoAnterior = cp.verificarSaldo(numeroConta);
					double novoSaldo = cp.obterRendimentoDeJuros(numeroConta, valorRendimento);
					System.out.println("Operação realizada com sucesso");
					System.out.println("Saldo Anterior: RS " + saldoAnterior);
					System.out.println("Novo Saldo: RS " + novoSaldo);
				}
				else {
					System.out.println("Retornando");
					return;
				}
			}
			else {
				System.out.println("Conta invalida");
			}
		}
		 
	 }
	    public static void main(String[] args) {
	    	BancoService b = new BancoService();
	    	ContaPoupancaService cp = new ContaPoupancaService();
	        int menuOpcao = -1;

	        Scanner scanIn = new Scanner(System.in);
	        while(menuOpcao != 0){
	            menuOpcao = -1;
	            exibeMenu();
	            menuOpcao = scanIn.nextInt();
	            
	            if(menuOpcao == 1) {
	            	opcaoNovaConta(b, cb, cp);

	            }
	            if(menuOpcao == 2) {
	            	opcaoSaldo(b);
	            }
	            if(menuOpcao == 3) {
	            	opcaoCreditar(b, cb, cp);

	            }
	            if(menuOpcao == 4) {
	            	opcaoDebitar(b);
	            }
	            if(menuOpcao == 5) {
	            	opcaoTransferencia(b);
	            }
	            if(menuOpcao == 6) {
	            	opcaoRenderJuros(b, cp);
	            }
	        }
	        scanIn.close();
	        System.out.println("Encerrou");
	    };
}
