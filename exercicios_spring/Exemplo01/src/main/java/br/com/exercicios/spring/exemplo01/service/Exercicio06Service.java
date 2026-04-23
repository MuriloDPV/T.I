package br.com.exercicios.spring.exemplo01.service;

import org.springframework.stereotype.Service;

@Service
public class Exercicio06Service {

    public String calculaMedia(double[] notas) {
        if (notas == null || notas.length == 0) {
            return "0";
        }
        double soma = 0.0;
        for (double nota : notas) {
            soma += nota;
        }
        double media = soma / notas.length;
        return String.valueOf(media);
    }
}