package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        do{

            System.out.println("=== SISTEMA DE CADASTRO ===");
            System.out.println("1 - Usuário");
            System.out.println("2 - Aluno");
            System.out.println("3 - Produto");
            System.out.println("4 - Pedido");
            System.out.println("5 - Livro");
            System.out.println("6 - Funcionário");
            System.out.println("7 - Sair");
            opcao = sc.nextInt();

            switch (opcao){
                case 1 -> {
                    System.out.println("Digite o nome: ");
                    String nome = sc.nextLine();

                    System.out.println("Digite o email: ");
                    String email = sc.nextLine();

                    Usuario usuario = new Usuario(nome, email);
                    UsuarioDAO.inserir(usuario);
                }
                case 2 -> {
                    System.out.println("Digite o nome: ");
                    String nome = sc.nextLine();

                    System.out.println("Digite a matrícula: ");
                    String matricula = sc.nextLine();

                    System.out.println("Digite o curso: ");
                    String curso = sc.nextLine();

                    Aluno aluno = new Aluno(nome, matricula, curso);
                    AlunoDAO.inserir(aluno);
                }
                case 3 -> {
                    System.out.println("Digite o nome do cliente: ");
                    String cliente = sc.nextLine();

                    System.out.println("Digite o total da compra: ");
                    double total = sc.nextDouble();

                    LocalDate dataPedido = LocalDate.now();

                    Pedido pedido = new Pedido(cliente, dataPedido, total);
                    PedidoDAO.inserir(pedido);
                }
                case 4 -> {

                }
                case 5 -> {

                }
                case 6 -> {

                }
                default -> System.out.println("Opcão Inválida.");
            }

        }while(opcao != 7);

    }
}