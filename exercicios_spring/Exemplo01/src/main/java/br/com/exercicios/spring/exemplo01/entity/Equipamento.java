package br.com.exercicios.spring.exemplo01.entity;

public class Equipamento {

    private String nome;
    private String descricao;
    private String numeroPatrimonio;

    public Equipamento() {
    }

    public Equipamento(String nome, String descricao, String numeroPatrimonio) {
        this.nome = nome;
        this.descricao = descricao;
        this.numeroPatrimonio = numeroPatrimonio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNumeroPatrimonio() {
        return numeroPatrimonio;
    }

    public void setNumeroPatrimonio(String numeroPatrimonio) {
        this.numeroPatrimonio = numeroPatrimonio;
    }
}
