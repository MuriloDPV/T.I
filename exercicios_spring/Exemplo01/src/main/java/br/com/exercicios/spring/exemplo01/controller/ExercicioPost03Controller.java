package br.com.exercicios.spring.exemplo01.controller;

import br.com.exercicios.spring.exemplo01.entity.Avaliacao;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/exercicio03")
public class ExercicioPost03Controller {
    @PostMapping("avaliacao")
    public Avaliacao dadosAvaliacao(@RequestBody Avaliacao avaliacao) {
        return avaliacao;
    }
}
