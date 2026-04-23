package br.com.exercicios.spring.exemplo01.controller;

import br.com.exercicios.spring.exemplo01.service.Exercicio02Service;
import br.com.exercicios.spring.exemplo01.service.Exercicio03Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exercicio03")
public class Exercicio03Controller {

    @Autowired
    Exercicio03Service exercicio03Service;

    @GetMapping("/fatorial-de-numero")
    public String fatorial(@RequestParam int fator) {
        // chama o servico na classe service
        return "O valor decimal é " + exercicio03Service.fatorial(fator);
    }
}