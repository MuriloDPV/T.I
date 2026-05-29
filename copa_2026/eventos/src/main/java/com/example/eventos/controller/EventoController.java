package com.example.eventos.controller;

import com.example.eventos.dtos.EventoRequestDTO;
import com.example.eventos.dtos.EventoResponseDTO;
import com.example.eventos.entity.Eventos;
import com.example.eventos.handlers.MinhaException;
import com.example.eventos.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")

public class EventoController {
    @Autowired
    private EventoService eventoService;
//
    @PostMapping
    public EventoResponseDTO cadastrarEvento(@RequestBody @Valid EventoRequestDTO dto) {

          return eventoService.salvarEvento(dto);

   }

    @GetMapping
    public List<EventoResponseDTO> buscarTodosOsEventos() {
        return eventoService.listarTodosOsEventos();
    }




    @DeleteMapping("/id/{id}")
    public String deletarEvento(@PathVariable Long id) {
        return eventoService.deletarEventoPorId(id);
    }


    @GetMapping("/id/{id}")
    public EventoResponseDTO buscarEventoPorId(@PathVariable Long id) {
        return eventoService.listarEventoPorID(id);
    }


    @PutMapping("/id/{id}")
    public EventoResponseDTO editarEventoPorID(@PathVariable Long id, @RequestBody @Valid EventoRequestDTO eventoAtualizada) {
        return eventoService.editarEventoPorID(id, eventoAtualizada);

    }

    @PutMapping("/descricao/{descricao}")
    public Eventos editarEventoPorDescricao(@PathVariable String descricao, @RequestBody @Valid Eventos eventoAtualizada) {
        return eventoService.editarEventoPorDescricao(descricao, eventoAtualizada);
    }
}
