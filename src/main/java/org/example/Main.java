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

    private static final Scanner sc = new Scanner(System.in);
    private static int opcao = 0;

    public static void main(String[] args) {
        do{
            System.out.println("=== OPERAÇÕES ===");
            System.out.println("1. CADASTRAR");
            System.out.println("2. ATUALIZAR");
            System.out.println("3. EXCLUIR");
            System.out.println("4. LISTAR");
            System.out.println("5. SAIR");
            System.out.print("Escolha uma opção_ ");
            opcao = sc.nextInt();

            switch (opcao){
                case 1 -> cadastrar();
                case 2 -> atualizar();
                case 3 -> excluir();
                case 4 -> listar();
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção Inválida.");
            }
        }while(opcao != 5);
    }

    private static void listar() {
        do{
            System.out.println("=== LISTAR ===");
            System.out.println("1 - Usuário");
            System.out.println("2 - Aluno");
            System.out.println("3 - Produto");
            System.out.println("4 - Pedido");
            System.out.println("5 - Livro");
            System.out.println("6 - Funcionário");
            System.out.println("7 - Voltar");
            System.out.print("Escolha uma opção_ ");
            opcao = sc.nextInt();

            switch (opcao){
                case 1 -> UsuarioDAO.listar();
                case 2 -> AlunoDAO.listar();
                case 3 -> ProdutoDAO.listar();
                case 4 -> PedidoDAO.listar();
                case 5 -> LivroDAO.listar();
                case 6 -> FuncionarioDAO.listar();
                case 7 -> System.out.println("Voltando ao menu principal...");
            }
        }while(opcao != 7);
    }

    private static void atualizar() {
        do{
            System.out.println("=== ATUALIZAR ===");
            System.out.println("1 - Usuário");
            System.out.println("2 - Aluno");
            System.out.println("3 - Produto");
            System.out.println("4 - Pedido");
            System.out.println("5 - Livro");
            System.out.println("6 - Funcionário");
            System.out.println("7 - Voltar");
            System.out.print("Escolha uma opção_ ");
            opcao = sc.nextInt();

            switch (opcao){
                case 1 -> {
                    System.out.println("Digite o nome do usuário: ");
                    String nome = sc.next();

                    System.out.println("Digite o novo email do usuario: ");
                    String novoEmail = sc.next();

                    UsuarioDAO.atualizar(nome, novoEmail);
                }
                case 2 -> {
                    System.out.println("Digite a matrícula do aluno: ");
                    String matricula = sc.nextLine();

                    System.out.println("Digite o novo curso do aluno: ");
                    String novoCurso = sc.nextLine();

                    AlunoDAO.atualizar(matricula, novoCurso);
                }
                case 3 -> {

                }
                case 4 -> {

                }
                case 5 -> {

                }
                case 6 -> {

                }
                case 7 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção Inválida.");
            }

        }while(opcao != 7);
    }

    private static void excluir() {
        do{
            System.out.println("=== EXCLUIR ===");
            System.out.println("1 - Usuário");
            System.out.println("2 - Aluno");
            System.out.println("3 - Produto");
            System.out.println("4 - Pedido");
            System.out.println("5 - Livro");
            System.out.println("6 - Funcionário");
            System.out.println("7 - Voltar");
            System.out.print("Escolha uma opção_ ");
            opcao = sc.nextInt();

            switch (opcao){
                case 1 -> {
                    System.out.println("Digite o nome do usuario que deseja excluir: ");
                    String nomeUsuario = sc.next();

                    UsuarioDAO.excluir(nomeUsuario);
                }
                case 2 -> {
                    System.out.println("Digite a matrícula do aluno que deseja excluir: ");
                    String matricula = sc.next();

                    //AlunoDAO.excluir(matricula);
                }
                case 3 -> {
                    System.out.println("Digite o nome do produto que deseja excluir: ");
                    String nomeProduto = sc.next();

                    //ProdutoDAO.excluir(nomeProduto);
                }
                case 4 -> {
                    System.out.println("Digite o id do pedido que deseja excluir: ");
                    int id = sc.nextInt();

                    //PedidoDAO.excluir(id);
                }
                case 5 -> {
                    System.out.println("Digite o título do livro que deseja excluir: ");
                    String titulo = sc.next();

                    //LivroDAO.excluir(titulo);
                }
                case 6 -> {
                    System.out.println("Digite o nome do funcionário que deseja excluir: ");
                    String nomeFuncionario = sc.next();

                    //FuncionarioDAO.excluir(nomeFuncionario);
                }
                case 7 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção Inválida.");
            }
        }while(opcao != 7);
    }

    public static void cadastrar() {
        do{
            System.out.println("=== CADASTRAR ===");
            System.out.println("1 - Usuário");
            System.out.println("2 - Aluno");
            System.out.println("3 - Produto");
            System.out.println("4 - Pedido");
            System.out.println("5 - Livro");
            System.out.println("6 - Funcionário");
            System.out.println("7 - Voltar");
            System.out.print("Escolha uma opção_ ");
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
                case 7 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opcão Inválida.");
            }

        }while(opcao != 7);
    }
}