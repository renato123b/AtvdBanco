package com.mycompany.projtrabdupla;
public class ContaEspecial extends ContaCorrente {
    private double limite;
    private Movimentacao movimentacao;

    public ContaEspecial(double limite) {
        this.limite = limite;
    }

    public ContaEspecial(double limite, int numero, Agencia agencia, ContaCliente cliente, double saldo, String dataCriacao, Movimentacao movimentacao) {
        super(numero, agencia, cliente, saldo, dataCriacao, movimentacao);
        this.limite = limite;
    }

    
    public double getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }
    
    @Override
    public boolean sacar(double valor, boolean transferencia) {
        double valorDisponivel= getSaldo()+limite;
        if (valorDisponivel>=valor){
            double valorF=valorDisponivel-valor;
            if (transferencia== true){
                addMovimentacao("recebimento de transferência",valor,getSaldo(),valorF);
            }else{
                addMovimentacao("saque",valor,getSaldo(),valorF);
            }
            setSaldo((valorDisponivel-valor)-limite);
            return true;
        }
        return false;
    }
    @Override
    public double verDisponivel(){
        return getSaldo()+limite;
    }
    
    @Override
    public String verExtrato() {
        return "Número da conta:"+ getNumero() + ", cliente=" + getCliente()+ ", tipo: Conta Corrente"+ ", movimentacao=" + movimentacao +", limite:"+ limite +", saldo:"+ getSaldo() +", valor disponivel:"+ getSaldo();
    }
    
    @Override
    public String toString() {
        return super.toString()+"ContaEspecial{" + "limite=" + limite + '}';
    }
        
    
}
