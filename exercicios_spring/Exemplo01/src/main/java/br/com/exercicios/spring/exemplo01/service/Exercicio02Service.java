package br.com.exercicios.spring.exemplo01.service;

import org.springframework.stereotype.Service;

@Service
public class Exercicio02Service {
    public String converteRomanoParaDecimal(String romano) {
        int decimal = toDecimal(romano);
        return String.valueOf(decimal);
    }

    private int toDecimal(String roman) {
        int total = 0;
        int lastValue = 0;
        for (int i = roman.length() - 1; i >= 0; i--) {
            int currentValue = switch (roman.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };
            if (currentValue < lastValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            lastValue = currentValue;
        }
        return total;
    }
}