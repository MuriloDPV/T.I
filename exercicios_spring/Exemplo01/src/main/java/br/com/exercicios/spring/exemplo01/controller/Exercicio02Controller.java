package br.com.exercicios.spring.exemplo01.controller;

import br.com.exercicios.spring.exemplo01.service.Exercicio02Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exercicio02")
public class Exercicio02Controller {

    @Autowired
    Exercicio02Service exercicio02Service;

    @GetMapping("/romano-para-decimal")
    public String romanoParaDecimal(@RequestParam String romano) {
        // chama o servico na classe service
        return "O valor em decimal e " + exercicio02Service.converteRomanoParaDecimal(romano.toUpperCase());
    }
}