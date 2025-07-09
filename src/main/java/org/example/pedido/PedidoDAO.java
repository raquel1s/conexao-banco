package org.example.pedido;

import org.example.conexao.Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
