package com.example.eventos.controller;

import com.example.eventos.dtos.EventoListResponseDTO;
import com.example.eventos.dtos.EventoRequestDTO;
import com.example.eventos.dtos.EventoResponseDTO;
import com.example.eventos.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    // POST — Cadastrar evento
    @PostMapping
    public ResponseEntity<EventoResponseDTO> cadastrar(@RequestBody @Valid EventoRequestDTO dto) {
        EventoResponseDTO criado = eventoService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    // GET ALL — Listar todos os eventos
    @GetMapping
    public ResponseEntity<List<EventoListResponseDTO>> listarTodos() {
        return ResponseEntity.ok(eventoService.listarTodos());
    }

    // GET — Buscar evento por ID
    @GetMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(eventoService.buscarPorId(id));
    }

    // PUT — Atualizar evento (payload igual ao POST)
    @PutMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid EventoRequestDTO dto) {
        return ResponseEntity.ok(eventoService.atualizar(id, dto));
    }

    // DELETE — Remover evento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        eventoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}

