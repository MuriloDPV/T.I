package br.com.exercicios.spring.exemplo01.service;

import org.springframework.stereotype.Service;

@Service
public class Exercicio03Service {

    public String fatorial(int n) {
        if (n < 0) {
            return "Numero invalido: n deve ser >= 0";
        }
        long resultado = 1L;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return String.valueOf(resultado);
    }
}