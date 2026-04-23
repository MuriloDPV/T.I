package br.com.exercicios.spring.exemplo01.service;

import org.springframework.stereotype.Service;

@Service
public class Exemplo01Service {

    public int soma (int a, int b){
        return a + b;
    }
}
