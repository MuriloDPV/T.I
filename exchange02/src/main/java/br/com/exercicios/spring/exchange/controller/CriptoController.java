package br.com.exercicios.spring.exchange.controller;

import br.com.exercicios.spring.exchange.entity.Cryptomoeda;
import br.com.exercicios.spring.exchange.entity.enums.Risco;
import br.com.exercicios.spring.exchange.handlers.MinhaException;
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

        if(cripto.getPreco() > 0) {

           throw new MinhaException( "A criptomoeda precisa ter um preço maior que R$0");
        }


        if (cripto.getVolumeNegociado() < 0) {

            throw new MinhaException("A criptomoeda precisa ter um volume negociado maior que R$0");
        }
        return criptoService.salvarCripto(cripto);

    }

    @GetMapping
    public List<Cryptomoeda> buscarTodasAsCriptos() {
        return criptoService.listarTodasAsCriptos();
    }

    @GetMapping("/ordenar/preco")
    public List<Cryptomoeda> OrdenarCiptoCrescente() {
        return criptoService.listarCriptoPorPreco();
    }

    @GetMapping("/abreviacao/{abreviacao}")
    public List<Cryptomoeda> buscarCriptoPorAbreviacao(@PathVariable String abreviacao) {
        return criptoService.listarCriptoPorAbreviacao(abreviacao);
    }



    @GetMapping("/risco/{nivelDeRisco}")
    public List<Cryptomoeda> buscarCriptoPorRisco(@PathVariable Risco nivelDeRisco) {
        return criptoService.listarCriptoPorRisco(nivelDeRisco);
    }


    @DeleteMapping("/id/{id}")
    public String deletarCripto(@PathVariable Long id) {
        return criptoService.deletarCriptoPorId(id);
    }

    @DeleteMapping("/abreviacao/{abreviacao}")
    public String deletarCriptoPorAbreviacao(@PathVariable String abreviacao) {
        return criptoService.deletarCriptoPorAbreviacao(abreviacao);
    }

    @PutMapping("/id/{id}")
    public Cryptomoeda editarCriptoPorID(@PathVariable Long id, @RequestBody Cryptomoeda criptoAtualizada) {
        return criptoService.editarCriptoPorID(id, criptoAtualizada);

    }

    @PutMapping("/abreviacao/{abreviacao}")
    public Cryptomoeda editarCriptoPorAbreviacao(@PathVariable String abreviacao, @RequestBody Cryptomoeda criptoAtualizada) {
        return criptoService.editarCriptoPorAbreviacao(abreviacao, criptoAtualizada);
    }
}
