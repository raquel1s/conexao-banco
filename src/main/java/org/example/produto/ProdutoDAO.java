package org.example.produto;

import org.example.conexao.Conexao;

import java.lang.invoke.StringConcatFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public static void listar() {
        String sql = "SELECT * FROM produtos";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                int quantidade = rs.getInt("quantidade");

                System.out.println("\nNome do produto: " + nome +
                        "\nPreço: " + preco +
                        "\nQuantidade: " + quantidade + "\n");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
