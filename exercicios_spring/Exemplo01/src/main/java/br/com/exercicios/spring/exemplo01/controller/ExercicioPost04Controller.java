package br.com.exercicios.spring.exemplo01.controller;

import br.com.exercicios.spring.exemplo01.entity.Mensagem;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/exercicio04")
public class ExercicioPost04Controller {
    @PostMapping("mensagem")
    public Mensagem dadosMensagem(@RequestBody Mensagem mensagem) {
        return mensagem;
    }
}
