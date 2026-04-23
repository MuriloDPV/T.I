package br.com.exercicios.spring.exemplo01.service;

import org.springframework.stereotype.Service;

@Service
public class Exercicio09Service {

    public String calculaAreaTriangulo(double base, double altura) {
        double area = (base * altura) / 2.0;
        return String.valueOf(area);
    }
}