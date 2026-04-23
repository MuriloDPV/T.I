package br.com.exercicios.spring.exemplo01.entity;

public class Avaliacao {
    private String nomeDisciplina;
    private double nota;
    private String nome;

    public Avaliacao() {
    }

    public Avaliacao(String nomeDisciplina, double nota, String nome) {
        this.nomeDisciplina = nomeDisciplina;
        this.nota = nota;
        this.nome = nome;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
