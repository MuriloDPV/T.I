package br.com.exercicios.spring.exchange.controller;


import br.com.exercicios.spring.exchange.dtos.CorretorRequestDTO;
import br.com.exercicios.spring.exchange.dtos.CorretorResponseDTO;
import br.com.exercicios.spring.exchange.entity.Corretor;
import br.com.exercicios.spring.exchange.service.CorretorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
@RequestMapping("api/corretores")

public class CorretorControler {
    @Autowired
    private CorretorService corretorService;

    @PostMapping
    public CorretorResponseDTO criarCorretor(@RequestBody @Valid CorretorRequestDTO dto){
        return corretorService.save(dto);

    }


}
