package com.mycompany.projtrabdupla;

public interface IntConta {
    public class Movimentacao {
        private String tipo, data, hora;
        private double valorMovimentacao, saldoAntes, saldoDepois;
        public Movimentacao() {}
        public Movimentacao(String tipo, String data, String hora, double valorMovi, double saldoAntes, double saldoDepois) {
            this.tipo = tipo;
            this.data = data;
            this.hora = hora;
            this.valorMovimentacao = valorMovi;
            this.saldoAntes = saldoAntes;
            this.saldoDepois = saldoDepois;
        }
        public String getTipo() { return tipo; }
        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
        public String getData() {
            return data;
        }
        public void setData(String data) {
            this.data = data;
        }
        public String getHora() {
            return hora;
        }
        public void setHora(String hora) {
            this.hora = hora;
        }
        public double getValorMovi() {
            return valorMovimentacao;
        }
        public void setValorMovi(double valorMovi) {
            this.valorMovimentacao = valorMovi;
        }
        public double getSaldoAntes() {
            return saldoAntes;
        }
        public void setSaldoAntes(double saldoAntes) {
            this.saldoAntes = saldoAntes;
        }

        public double getSaldoDepois() {
            return saldoDepois;
        }
        public void setSaldoDepois(double saldoDepois) {
            this.saldoDepois = saldoDepois;
        }
        @Override
        public String toString() {
            return tipo + ", " + data + ", " + hora + ", Valor: " + valorMovimentacao
            + ", saldo antes=" + saldoAntes + ", saldo depois=" + saldoDepois;
        }
        
    }
    //Se transferência for "true" o tipo de movimentação é "envio de transferência". Caso contrário "depósito"
    public void depositar(double valor, boolean transferencia);
    //Se transferência for "true" o tipo de movimentação é "recebimento de transferência". Caso contrário "saque"
    public boolean sacar(double valor, boolean transferencia);
    public String transferir(ContaCorrente contaDestino, double valor);
    public double verDisponivel();
    public String verExtrato();
    //Pegar a data e hora do sistema.
    public void addMovimentacao(String tipo, double valor, double saldoAntes, double saldoDepois);
}
