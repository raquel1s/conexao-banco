package org.example.aluno;

import org.example.conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoDAO {

    public static void inserir(Aluno aluno) {
        String sql = "INSERT INTO alunos (nome, matricula, curso) VALUES (?, ?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getMatricula());
            stmt.setString(3, aluno.getCurso());
            stmt.executeUpdate();

            System.out.println("Aluno inserido com sucesso!\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listar() {
        String sql = "SELECT * FROM alunos";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                String nome = rs.getString("nome");
                String matricula = rs.getString("matricula");
                String curso = rs.getString("curso");

                System.out.println("\nNome: " + nome +
                        "\nMatrícula: " + matricula +
                        "\nCurso: " + curso + "\n");
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void atualizar(String matricula, String novocurso) {

    }
}
