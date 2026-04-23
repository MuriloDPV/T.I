package br.com.exercicios.spring.exemplo01.service;

import org.springframework.stereotype.Service;

@Service
public class Exercicio08Service {

    public String converteHorasParaMinutos(int horas) {
        int minutos = horas * 60;
        return String.valueOf(minutos);
    }
}