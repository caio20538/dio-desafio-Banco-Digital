package Banco;

import Cliente.Cliente;

public abstract class Conta implements InterfaceConta{

    private int agencia;
    private int numero;
    private double saldo;
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }

    String clienteNome(){
        return cliente.getNome();
    }

    protected int getAgencia() {
        return agencia;
    }

    protected int getNumero() {
        return numero;
    }

    protected double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns() {
        System.out.printf("Titular: %s%n", cliente.getNome());
        System.out.printf("Agência: %d%n", this.getAgencia());
        System.out.printf("Numero: %d%n", this.getNumero());
        System.out.printf("Saldo: %.2f%n", this.getSaldo());
    }

    @Override
    public String toString() {
        return "Conta "+
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                ", cliente=" + cliente;
    }
}
