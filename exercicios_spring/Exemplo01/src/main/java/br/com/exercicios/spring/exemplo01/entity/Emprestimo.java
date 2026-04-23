package br.com.exercicios.spring.exemplo01.entity;

public class Emprestimo {

    private String nomeUsuario;
    private String itemEmprestado;
    private String data;

    public Emprestimo() {
    }

    public Emprestimo(String nomeUsuario, String itemEmprestado, String data) {
        this.nomeUsuario = nomeUsuario;
        this.itemEmprestado = itemEmprestado;
        this.data = data;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getItemEmprestado() {
        return itemEmprestado;
    }

    public void setItemEmprestado(String itemEmprestado) {
        this.itemEmprestado = itemEmprestado;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
