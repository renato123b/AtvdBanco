package com.mycompany.projtrabdupla;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContaCorrente implements IntConta{
    private int numero;
    private Agencia agencia;
    private ContaCliente cliente;
    private double saldo;
    private String dataCriacao;
    private  Movimentacao movimentacao; 

    public ContaCorrente() {
    }

    public ContaCorrente(int numero, Agencia agencia, ContaCliente cliente, double saldo, String dataCriacao, Movimentacao movimentacao) {
        this.numero = numero;
        this.agencia = agencia;
        this.cliente = cliente;
        this.saldo = saldo;
        this.dataCriacao = dataCriacao;
        this.movimentacao = movimentacao;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public ContaCliente getCliente() {
        return cliente;
    }

    public void setCliente(ContaCliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" + "numero=" + numero + ", agencia=" + agencia + ", cliente=" + cliente + ", saldo=" + saldo + ", dataCriacao=" + dataCriacao + ", movimentacao=" + movimentacao + '}';
    }
    @Override
    public void depositar(double valor, boolean transferencia) {
        double valorf= saldo+valor;
        if (transferencia== true){
            addMovimentacao("envio de transferência",valor,saldo,valorf);
        }else{
            addMovimentacao("déposito",valor,saldo,valorf);
        }
        saldo=saldo+valor;
    }

    @Override
    public boolean sacar(double valor, boolean transferencia) {
        if (saldo>=valor){
            if (transferencia== true){
                addMovimentacao("recebimento de transferência",valor,saldo,saldo-valor);
            }else{
                addMovimentacao("saque",valor,saldo,saldo-valor);
            }
            saldo=saldo-valor;
            return true;
        }
        return false;
    }

    @Override
    public String transferir(ContaCorrente contaDestino, double valor) {
        double valorf= saldo-valor;
        if (saldo>=valor){
            contaDestino.depositar(valor, true);
            sacar(valor,true);
            addMovimentacao("transferência",valor,saldo,valorf);
            saldo=saldo-valor;
        }else{
            return "saldo insuficiente";
        }
        return null;
    }

    @Override
    public double verDisponivel() {
        return saldo;
    }

    @Override
    public String verExtrato() {
        return "Número da conta:"+ numero + ", cliente=" + cliente+ ", tipo: Conta Corrente"+ ", movimentacao=" + movimentacao + ", saldo:"+ saldo +", valor disponivel:"+ saldo;
    }
    
    @Override
    public void addMovimentacao(String tipo, double valor, double saldoAntes, double saldoDepois) {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String data = agora.format(formatadorData);
        String hora = agora.format(formatadorHora);
        movimentacao.setTipo(tipo);
        movimentacao.setData(data);
        movimentacao.setHora(hora);
        movimentacao.setValorMovi(valor);
        movimentacao.setSaldoAntes(saldoAntes);
        movimentacao.setSaldoDepois(saldoDepois);
    }
    
}
