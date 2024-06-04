package com.mycompany.projtrabdupla;

public class Cliente {
    private int cod;
    private String cpf, nome, telefone, date;

    public Cliente(int cod, String cpf, String nome, String telefone, String date) {
        this.cod = cod;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.date = date;
    }

    public Cliente() {
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cod=" + cod + ", cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", date=" + date + '}';
    }
    
}
        