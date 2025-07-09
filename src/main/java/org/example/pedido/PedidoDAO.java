package org.example.pedido;

import org.example.conexao.Conexao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

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

    public static ArrayList<Pedido> listar() {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT id, cliente, data_pedido, total FROM pedidos";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String cliente = rs.getString("cliente");
                LocalDate data = rs.getDate("data_pedido").toLocalDate();
                double total = rs.getDouble("total");

                Pedido pedido = new Pedido(id, cliente, data, total);
                pedidos.add(pedido);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return pedidos;
    }

    public static void atualizar(int id, double novoTotal) {
        String sql = "UPDATE pedidos SET total = ? WHERE id = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setDouble(1, novoTotal);
            stmt.setInt(2, id);
            stmt.executeUpdate();

            System.out.println("Total atualizado com sucesso!\n");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void excluir(int id) {
        String sql = "DELETE FROM pedidos WHERE id = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Pedido removido com sucesso!\n");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
