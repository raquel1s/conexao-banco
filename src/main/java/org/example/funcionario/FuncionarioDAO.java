package org.example.funcionario;

import org.example.conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDAO {

    public static void inserir(Funcionario funcionario) {
        String sql = "INSERT INTO funcionarios (nome, cargo, salario) VALUES (?, ?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setDouble(3, funcionario.getSalario());
            stmt.executeUpdate();

            System.out.println("Funcionário inserido com sucesso!\n");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Funcionario> listar() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT nome, cargo, salario FROM funcionarios";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String nome = rs.getString("nome");
                String cargo = rs.getString("cargo");
                double salario = rs.getDouble("salario");

                Funcionario funcionario = new Funcionario(nome, cargo, salario);
                funcionarios.add(funcionario);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return funcionarios;
    }

    public static void atualizar(String nome, double novoSalario) {
        String sql = "UPDATE funcionarios SET salario = ? WHERE nome = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setDouble(1, novoSalario);
            stmt.setString(2, nome);
            stmt.executeUpdate();

            System.out.println("Salário atualizado com sucesso!\n");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void excluir(String nomeFuncionario) {
        String sql = "DELETE FROM funcionarios WHERE nome = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, nomeFuncionario);
            stmt.executeUpdate();

            System.out.println("Funcionário removido com sucesso!\n");

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
