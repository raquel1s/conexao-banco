package org.example.usuario;

import org.example.conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public static ArrayList<Usuario> listar() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT id, nome, email FROM usuarios";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");

                Usuario usuario = new Usuario(id, nome, email);
                usuarios.add(usuario);
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    public static ArrayList<Usuario> listarDominio(String dominio) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT id, nome, email FROM usuarios WHERE email LIKE '%@"+dominio+"'";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");

                Usuario usuario = new Usuario(id, nome, email);
                usuarios.add(usuario);
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    public static Usuario listarPorId(int id) {
        String sql = "SELECT id, nome, email FROM usuarios WHERE id = ?";
        int newId = 0;
        String nome = "";
        String email = "";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                newId = rs.getInt("id");
                nome = rs.getString("nome");
                email = rs.getString("email");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Usuario(newId, nome, email);
    }

    public static int qntRegistros() {
        int quantidade = 0;
        String sql = "SELECT COUNT(*) from usuarios";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                quantidade = rs.getInt(1);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return quantidade;
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

            System.out.println("Usuário removido com sucesso!\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
