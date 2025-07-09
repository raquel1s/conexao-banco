package org.example.usuario;

import org.example.conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public static void inserir(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.executeUpdate();

            System.out.println("Usuário inserido com sucesso!\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listar() {
        String sql = "SELECT * FROM usuarios";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");

                System.out.println("\nNome: " + nome +
                        "\nEmail: " + email + "\n");
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

    }

    public static void atualizar(String nome, String novoEmail) {
        String sql = "UPDATE usuarios SET email = ? WHERE nome = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoEmail);
            stmt.setString(2, nome);
            stmt.executeUpdate();

            System.out.println("Email atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void excluir(String nome) {
        String sql = "DELETE FROM usuarios WHERE nome = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.executeUpdate();

            System.out.println("Usuário deletado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
