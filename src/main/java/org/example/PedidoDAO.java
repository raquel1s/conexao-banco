package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoDAO {

    public static void inserir(Pedido pedido) {
        String sql = "INSERT INTO pedidos (cliente, data_pedido, total) VALUES (?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, pedido.getCliente());
            stmt.setString(2, pedido.getData());

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
