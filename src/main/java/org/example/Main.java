package org.example;

import org.example.aluno.Aluno;
import org.example.aluno.AlunoDAO;
import org.example.funcionario.Funcionario;
import org.example.funcionario.FuncionarioDAO;
import org.example.livro.Livro;
import org.example.livro.LivroDAO;
import org.example.pedido.Pedido;
import org.example.pedido.PedidoDAO;
import org.example.produto.Produto;
import org.example.produto.ProdutoDAO;
import org.example.usuario.Usuario;
import org.example.usuario.UsuarioDAO;

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
                    sc.nextLine();

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
                    sc.nextLine();

                    System.out.println("Digite o nome do produto: ");
                    String nome = sc.nextLine();

                    System.out.println("Digite o preço do produto: ");
                    double preco = sc.nextDouble();

                    System.out.println("Digite o quantidade do produto: ");
                    int quantidade = sc.nextInt();

                    Produto produto = new Produto(nome, preco, quantidade);
                    ProdutoDAO.inserir(produto);
                }
                case 4 -> {
                    sc.nextLine();

                    System.out.println("Digite o nome do cliente: ");
                    String cliente = sc.nextLine();

                    System.out.println("Digite o total da compra: ");
                    double total = sc.nextDouble();

                    LocalDate dataPedido = LocalDate.now();

                    Pedido pedido = new Pedido(cliente, dataPedido, total);
                    PedidoDAO.inserir(pedido);
                }
                case 5 -> {
                    sc.nextLine();

                    System.out.println("Digite o título do livro: ");
                    String titulo = sc.nextLine();

                    System.out.println("Digite o nome do autor do livro: ");
                    String autor = sc.nextLine();

                    System.out.println("Digite o ano do livro: ");
                    int ano = sc.nextInt();

                    Livro livro = new Livro(titulo, autor, ano);
                    LivroDAO.inserir(livro);
                }
                case 6 -> {
                    sc.nextLine();

                    System.out.println("Digite o nome do funcionário: ");
                    String nome = sc.nextLine();

                    System.out.println("Digite o cargo do funcionário: ");
                    String cargo = sc.nextLine();

                    System.out.println("Digite o salário do funcionário: ");
                    double salario = sc.nextDouble();

                    Funcionario funcionario = new Funcionario(nome, cargo, salario);
                    FuncionarioDAO.inserir(funcionario);
                }
                case 7 -> System.out.println("Saindo...");
                default -> System.out.println("Opcão Inválida.");
            }

        }while(opcao != 7);

    }
}