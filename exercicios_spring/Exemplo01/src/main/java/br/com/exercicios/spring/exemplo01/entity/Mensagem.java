package br.com.exercicios.spring.exemplo01.entity;

public class Mensagem {
    private String remetente;
    private String destino;
    private String conteudo;

    public Mensagem() {
    }

    public Mensagem(String remetente, String destino, String conteudo) {
        this.remetente = remetente;
        this.destino = destino;
        this.conteudo = conteudo;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
