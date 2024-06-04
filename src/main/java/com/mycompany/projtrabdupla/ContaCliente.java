package com.mycompany.projtrabdupla;
public class ContaCliente  {    
    private boolean titular;
    private Cliente cliente;
    private ContaCorrente conta;

    public ContaCliente() {
    }

    public ContaCliente(boolean titular, Cliente cliente, ContaCorrente conta) {
        this.titular = titular;
        this.cliente = cliente;
        this.conta = conta;
    }

    public boolean isTitular() {
        return titular;
    }

    public void setTitular(boolean titular) {
        this.titular = titular;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ContaCorrente getConta() {
        return conta;
    }

    public void setConta(ContaCorrente conta) {
        this.conta = conta;
    }

    @Override
    public String toString() {
        return "ContaCliente{" + "titular=" + titular + ", cliente=" + cliente + ", conta=" + conta + '}';
    }

    
}
