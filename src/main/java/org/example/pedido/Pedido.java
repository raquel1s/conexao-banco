package org.example.pedido;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pedido {

    private int id;
    private String cliente;
    private LocalDate data;
    private double total;

    public Pedido(String cliente, LocalDate data, double total) {
        this.cliente = cliente;
        this.data = data;
        this.total = total;
    }

    public Pedido(int id, String cliente, LocalDate data, double total) {
        this.id = id;
        this.cliente = cliente;
        this.data = data;
        this.total = total;
    }

    public String getCliente() {
        return cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "\nId: " + id +
                "\nCliente: " + cliente +
                "\nData do pedido: " + data.format(formatar) +
                "\nTotal do pedido: " + total + "\n";
    }
}
