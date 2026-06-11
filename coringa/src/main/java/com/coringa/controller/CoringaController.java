package com.coringa.controller;

import com.coringa.dto.CoringaRequestDTO;
import com.coringa.dto.CoringaResponseDTO;
import com.coringa.service.CoringaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/coringa")
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
