package org.example.livro;

import org.example.conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LivroDAO {

    public static void inserir(Livro livro) {
        String sql = "INSERT INTO livros (titulo, autor, ano_publicacao) VALUES (?, ?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno());
            stmt.executeUpdate();

            System.out.println("Livro inserido com sucesso!\n");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void listar() {

        String sql = "SELECT * FROM livros";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int ano = rs.getInt("ano_publicacao");

                System.out.println("\nTítulo: " + titulo +
                        "\nAutor: " + autor +
                        "\nAno de publicação: " + ano + "\n");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
