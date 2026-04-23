package br.com.exercicios.spring.exchange.controller;

import br.com.exercicios.spring.exchange.entity.Cryptomoeda;
import br.com.exercicios.spring.exchange.service.CriptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cripto")

public class CriptoController {
    @Autowired
    private CriptoService criptoService;

    @PostMapping
    public Cryptomoeda cadastrarCripto(@RequestBody Cryptomoeda cripto) {

        return criptoService.salvarCripto(cripto);
    }
    @GetMapping
    public List<Cryptomoeda> buscarTodasAsCriptos(){
        return criptoService.listarTodasAsCriptos();
    }
    @DeleteMapping
    public String deletarCripto(@RequestParam Long id){
        return criptoService.deletarCripto(id);
    }
    @PutMapping
    public Cryptomoeda editarCripto(@RequestParam Long id, @RequestBody Cryptomoeda criptoAtualizada){
        return criptoService.editarCripto(id, criptoAtualizada);
    }
}
