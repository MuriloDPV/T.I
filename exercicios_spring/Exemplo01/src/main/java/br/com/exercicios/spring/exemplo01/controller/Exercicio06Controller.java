package br.com.exercicios.spring.exemplo01.controller;

import br.com.exercicios.spring.exemplo01.service.Exercicio05Service;
import br.com.exercicios.spring.exemplo01.service.Exercicio06Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/exercicio06")
public class Exercicio06Controller {

    @Autowired
    Exercicio06Service exercicio06Service;

    @GetMapping ("media-nota")
    public String fazermedia(@RequestParam double[] notas) {
        String media = exercicio06Service.calculaMedia(notas);
        return "media final: " + media;
    }



}