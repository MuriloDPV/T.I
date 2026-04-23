package br.com.exercicios.spring.exemplo01.controller;

import br.com.exercicios.spring.exemplo01.service.Exemplo01Service;
import br.com.exercicios.spring.exemplo01.service.Exercicio01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exercicio01")
public class Exercicio01Controller {

    @Autowired
    Exercicio01Service exercicio01Service;

    @GetMapping("binario-para-decimal")
    public String binarioParaDecimal(@RequestParam String binario){
        return exercicio01Service.converteBinarioEmDecimal(binario);
    }
}
