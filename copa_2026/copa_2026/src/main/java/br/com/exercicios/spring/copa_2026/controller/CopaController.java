package br.com.exercicios.spring.copa_2026.controller;

import br.com.exercicios.spring.copa_2026.entity.Copa;
import br.com.exercicios.spring.copa_2026.service.CopaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/copa")
public class CopaController {
    @Autowired
    private CopaService copaService;

    @PostMapping
    public Copa cadastrarCopa(@RequestBody Copa copa) {

        return copaService.salvarCopa(copa);
    }
        @GetMapping
                public List<Copa> buscarTodasAsCopas(){
            return copaService.listarTodasAsCopas();
        }
        @DeleteMapping
    public String deletarCopa(@RequestParam Long id){
        return copaService.deletarCopa(id);
        }
        @PutMapping
    public Copa editarCopa(@RequestParam Long id, @RequestBody Copa copaAtualizada){
        return copaService.editarCopa(id, copaAtualizada);
        }
    }

