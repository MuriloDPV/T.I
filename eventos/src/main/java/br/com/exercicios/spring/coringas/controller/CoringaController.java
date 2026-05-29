package br.com.exercicios.spring.coringas.controller;

import br.com.exercicios.spring.coringas.dto.CoringaRequestDTO;
import br.com.exercicios.spring.coringas.dto.CoringaResponseDTO;
import br.com.exercicios.spring.coringas.service.CoringaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/coringas")
public class CoringaController {
    @Autowired
    private CoringaService coringaService;

    @PostMapping
    public CoringaResponseDTO save(@Valid @RequestBody CoringaRequestDTO coringaRequestDTO) {
        return coringaService.save(coringaRequestDTO);
    }

    @GetMapping("{id}")
    public CoringaResponseDTO findById(@PathVariable Long id) {
        return coringaService.findById(id);
    }

    @GetMapping
    public List<CoringaResponseDTO> findAll() {
        return coringaService.findAll();
    }

    @PutMapping("{id}")
    public CoringaResponseDTO update(@PathVariable Long id, @Valid @RequestBody CoringaRequestDTO coringaRequestDTO) {
        return coringaService.update(id, coringaRequestDTO);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        coringaService.delete(id);
    }
}
