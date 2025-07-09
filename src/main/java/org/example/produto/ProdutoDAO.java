package org.example.produto;

import org.example.conexao.Conexao;

import java.lang.invoke.StringConcatFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {

    public static void inserir(Produto produto) {
        String sql = "INSERT INTO produtos (nome, preco, quantidade) VALUES (?, ?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.executeUpdate();

            System.out.println("Produto inserido com sucesso!\n");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Produto> listar() {
        ArrayList<Produto> produtos = new ArrayList<>();
        String sql = "SELECT nome, preco, quantidade FROM produtos";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                int quantidade = rs.getInt("quantidade");

                Produto produto = new Produto(nome, preco, quantidade);
                produtos.add(produto);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    return produtos;
    }

    public static void atualizar(String nome, Double novoPreco) {
        String sql = "UPDATE produtos SET preco = ? WHERE nome = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setDouble(1, novoPreco);
            stmt.setString(2, nome);
            stmt.executeUpdate();

            System.out.println("Preço atualizado com sucesso!\n");

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void excluir(String nomeProduto) {
        String sql = "DELETE FROM produtos WHERE nome = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, nomeProduto);
            stmt.executeUpdate();

            System.out.println("Produto removido com sucesso!\n");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
