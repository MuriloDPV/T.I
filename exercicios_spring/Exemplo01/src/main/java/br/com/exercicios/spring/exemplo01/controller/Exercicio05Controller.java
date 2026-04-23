package br.com.exercicios.spring.exemplo01.controller;

import br.com.exercicios.spring.exemplo01.service.Exercicio05Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exercicio05")
public class Exercicio05Controller {

    @Autowired
    Exercicio05Service exercicio05Service;

    @GetMapping("celsius-para-fahrenheit")
    public String converter(@RequestParam double celsius ) {
        // chama o servico na classe service
        String fahrenheit = exercicio05Service.converteCelsiusParaFahrenheit(celsius);
        return "Temperatura em fahreinheit: " + fahrenheit;
    }
}