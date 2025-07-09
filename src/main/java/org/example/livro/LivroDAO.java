package org.example.livro;

import org.example.conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public static ArrayList<Livro> listar() {
        ArrayList<Livro> livros = new ArrayList<>();
        String sql = "SELECT titulo, autor, ano_publicacao FROM livros";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int ano = rs.getInt("ano_publicacao");

                Livro livro = new Livro(titulo, autor, ano);
                livros.add(livro);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return livros;
    }

    public static void atualizar(String titulo, String novoAutor) {
        String sql = "UPDATE livros SET autor = ? WHERE titulo = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, novoAutor);
            stmt.setString(2, titulo);
            stmt.executeUpdate();

            System.out.println("Autor atualizado com sucesso!\n");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void excluir(String titulo) {
        String sql = "DELETE FROM livros WHERE titulo = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, titulo);
            stmt.executeUpdate();

            System.out.println("Livro removido com sucesso!\n");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
