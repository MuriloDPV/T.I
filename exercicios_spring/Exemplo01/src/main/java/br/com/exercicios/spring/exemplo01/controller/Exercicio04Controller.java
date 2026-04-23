package br.com.exercicios.spring.exemplo01.controller;

import br.com.exercicios.spring.exemplo01.service.Exercicio03Service;
import br.com.exercicios.spring.exemplo01.service.Exercicio04Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exercicio04")
public class Exercicio04Controller {

    @Autowired
    Exercicio04Service exercicio04Service;

    @GetMapping("/palindromo")
    public String palindromo(@RequestParam String palavra) {
        // chama o servico na classe service
        return exercicio04Service.verificaPalindromo(palavra) ?
        "A palavra é um palindromo":
        "A palavra não é um palindromo";
    }
}