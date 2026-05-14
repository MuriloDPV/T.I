package br.com.exercicios.spring.exchange.handlers;

public class MinhaException extends  RuntimeException {

    public MinhaException(String mensagem){
        super(mensagem);
    }
}
