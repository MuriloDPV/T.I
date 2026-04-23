package br.com.exercicios.spring.exemplo01.service;

import org.springframework.stereotype.Service;

@Service
public class Exercicio07Service {

    public String verificaPrimo(int n) {
        if (n <= 1) {
            return "false";
        }
        if (n == 2) {
            return "true";
        }
        if (n % 2 == 0) {
            return "false";
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return "false";
            }
        }
        return "true";
    }
}