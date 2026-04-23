package br.com.exercicios.spring.exemplo01.controller;

import br.com.exercicios.spring.exemplo01.entity.Emprestimo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/exercicio06")
public class ExercicioPost06Controller {
    @PostMapping("emprestimo")
    public String registrarEmprestimo(@RequestBody Emprestimo emprestimo) {
        return "Empréstimo registrado para: " + emprestimo.getNomeUsuario()
                + " (Item: " + emprestimo.getItemEmprestado() + ")";
    }
}
