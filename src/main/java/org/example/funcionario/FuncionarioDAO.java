package org.example.funcionario;

import org.example.conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public static void listar() {
        String sql = "SELECT * FROM funcionarios";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String nome = rs.getString("nome");
                String cargo = rs.getString("cargo");
                double salario = rs.getDouble("salario");

                System.out.println("\nNome do funcionário: " + nome +
                        "\nCargo: " + cargo +
                        "\nSalário: " + salario + "\n");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
