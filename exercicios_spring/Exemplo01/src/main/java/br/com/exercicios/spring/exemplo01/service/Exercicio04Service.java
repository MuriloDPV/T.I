package br.com.exercicios.spring.exemplo01.service;

import org.springframework.stereotype.Service;

@Service
public class Exercicio04Service {

    public boolean verificaPalindromo(String palavra) {
        if (palavra == null) {
            return false;
        }
        String limpa = palavra.replaceAll("\\s+", "").toLowerCase();
        String invertida = new StringBuilder(limpa).reverse().toString();
        return (limpa.equals(invertida));
    }
}