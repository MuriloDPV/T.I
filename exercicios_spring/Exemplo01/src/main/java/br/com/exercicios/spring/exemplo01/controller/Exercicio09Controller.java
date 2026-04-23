package br.com.exercicios.spring.exemplo01.controller;

import br.com.exercicios.spring.exemplo01.service.Exercicio09Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exercicio09")
public class Exercicio09Controller {
    @Autowired
    Exercicio09Service exercicio09Service;

    @GetMapping("area-triangulo")
    public String areatriangulo(@RequestParam double base, double altura) {
        String area = exercicio09Service.calculaAreaTriangulo(base, altura);
        return "área do triangulo: " + area;


    }
}