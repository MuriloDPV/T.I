package br.com.exercicios.spring.exemplo01.controller;

import br.com.exercicios.spring.exemplo01.service.Exercicio06Service;
import br.com.exercicios.spring.exemplo01.service.Exercicio07Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exercicio07")
public class Exercicio07Controller {
    @Autowired
    Exercicio07Service exercicio07Service;

    @GetMapping("numero-primo")
    public String verseprimo(@RequestParam int n) {
        String primo = exercicio07Service.verificaPrimo(n);
        return "it's cousin? " + primo;
    }

}