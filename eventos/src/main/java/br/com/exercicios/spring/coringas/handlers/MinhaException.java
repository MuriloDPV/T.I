package br.com.exercicios.spring.coringas.handlers;

public class MinhaException extends  RuntimeException {

    public MinhaException(String mensagem){
        super(mensagem);
    }
}
