package org.example;

import java.time.LocalDate;

public class Pedido {

    private String cliente;
    private LocalDate data;
    private double total;

    public Pedido(String cliente, LocalDate data, double total) {
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
}
