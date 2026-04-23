package br.com.exercicios.spring.exemplo01.controller;

import br.com.exercicios.spring.exemplo01.entity.Aluno;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/exercicio01")
public class ExercicioPost01Controller {
    @PostMapping("aluno")
    public Aluno dadosAluno(@RequestBody Aluno aluno) {
        return aluno;
    }
}
