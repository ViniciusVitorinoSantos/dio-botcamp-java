package com.example.evilcorp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       ContaTerminal conta = new ContaTerminal(1021, "Agencia 067-8", "Mario Andrade", 273.48);
       System.out.println("Número da conta: " + conta.getNumeroConta());
       System.out.println("Agência: " + conta.getAgencia());
       System.out.println("Nome do cliente: " + conta.getNomecliente());
       System.out.println("Saldo: " + conta.getSaldo());
    

    Scanner scanner = new Scanner(System.in);
        List<ContaTerminal> contas = new ArrayList<>();
        
        while (true) {
            System.out.println("\nDeseja criar uma nova conta? (s/n)");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                break;
            }

            int numeroConta;
            while (true) {
                System.out.println("Por favor, digite o número da Conta (somente números):");
                String entrada = scanner.nextLine();
                if (entrada.matches("\\d+")) {
                    numeroConta = Integer.parseInt(entrada);
                    break;
                } else {
                    System.out.println("Número inválido! Digite apenas números.");
                }
            }

            String agencia;
            while (true) {
                System.out.println("Por favor, digite o número da Agência (formato 000-X):");
                agencia = scanner.nextLine();
                if (agencia.matches("\\d{3}-[Xx0-9]")) {
                    break;
                } else {
                    System.out.println("Formato inválido! Use o formato 000-X (exemplo: 123-4).");
                }
            }

            System.out.println("Por favor, digite o nome do Cliente:");
            String nomeCliente = scanner.nextLine();
            
            System.out.println("Por favor, digite o saldo inicial:");
            double saldo = scanner.nextDouble();
            scanner.nextLine();

            ContaTerminal novaConta = new ContaTerminal(numeroConta, agencia, nomeCliente, saldo);
            contas.add(novaConta);
            novaConta.exibirMensagem();
        }

        System.out.println("\nContas cadastradas:");
        for (ContaTerminal contaCadastrada : contas) {
            System.out.println("Conta: " + contaCadastrada.getNumeroConta() + " | Agência: " + contaCadastrada.getAgencia() + " | Cliente: " + contaCadastrada.getNomeCliente() + " | Saldo: R$ " + contaCadastrada.getSaldo());
        }

        System.out.println("\nPrograma encerrado.");
        scanner.close();
    }
}


