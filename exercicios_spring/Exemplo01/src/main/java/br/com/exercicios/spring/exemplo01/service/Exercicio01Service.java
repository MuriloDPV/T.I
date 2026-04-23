package br.com.exercicios.spring.exemplo01.service;

import org.springframework.stereotype.Service;

@Service
public class Exercicio01Service {
    public String converteBinarioEmDecimal(String binario){
        int decimal = Integer.parseInt(binario, 2);
        return decimal+"";
    }
}
