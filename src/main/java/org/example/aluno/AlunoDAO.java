package org.example.aluno;

import org.example.conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public static ArrayList<Aluno> listar() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT nome, matricula, curso FROM alunos";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                String nome = rs.getString("nome");
                String matricula = rs.getString("matricula");
                String curso = rs.getString("curso");

                Aluno aluno = new Aluno(nome, matricula, curso);
                alunos.add(aluno);
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return alunos;
    }

    public static void atualizar(String matricula, String novocurso) {
        String sql = "UPDATE alunos SET curso = ? WHERE matricula = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, novocurso);
            stmt.setString(2, matricula);
            stmt.executeUpdate();

            System.out.println("Curso atualizado com sucesso!\n");

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void excluir(String matricula) {
        String sql = "DELETE FROM alunos WHERE matricula = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, matricula);
            stmt.executeUpdate();

            System.out.println("Aluno removido com sucesso!\n");

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
