package org.example.funcionario;

public class Funcionario {

    private String nome;
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "\nNome do funcionário: " + nome +
                "\nCargo: " + cargo +
                "\nSalário: " + salario + "\n";
    }
}
