package org.example.pedido;

import org.example.conexao.Conexao;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PedidoDAO {

    public static void inserir(Pedido pedido) {
        String sql = "INSERT INTO pedidos (cliente, data_pedido, total) VALUES (?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, pedido.getCliente());
            stmt.setDate(2, Date.valueOf(pedido.getData()));
            stmt.setDouble(3, pedido.getTotal());
            stmt.executeUpdate();

            System.out.println("Pedido inserido com sucesso!\n");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void listar() {
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String sql = "SELECT * FROM pedidos";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();


            while(rs.next()){
                String cliente = rs.getString("cliente");
                LocalDate data = rs.getDate("data_pedido").toLocalDate();
                double total = rs.getDouble("total");

                System.out.println("\nCliente: " + cliente +
                        "\nData do pedido: " + data.format(formatar) +
                        "\nTotal do pedido: " + total + "\n");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
