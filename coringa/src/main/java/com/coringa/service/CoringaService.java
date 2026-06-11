package com.coringa.service;

import com.coringa.dto.CoringaRequestDTO;
import com.coringa.dto.CoringaResponseDTO;
import com.coringa.entity.Coringa;
import com.coringa.handlers.CoringaException;
import com.coringa.repository.CoringaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoringaService {

    @Autowired
    private CoringaRepository coringaRepository;

    public CoringaResponseDTO save(CoringaRequestDTO dto) {
        return CoringaResponseDTO.fromEntity(coringaRepository.save(CoringaRequestDTO.dtoToEntity(dto)));
    }

    public CoringaResponseDTO findById(Long id) {
        Coringa coringa = coringaRepository.findById(id)
                .orElseThrow(() -> new CoringaException("Coringa nao encontrado para o id: " + id));
        return CoringaResponseDTO.fromEntity(coringa);
    }

    public List<CoringaResponseDTO> findAll() {
        return coringaRepository.findAll().stream()
                .map(CoringaResponseDTO::fromEntity)
                .toList();
    }

    public CoringaResponseDTO update(Long id, CoringaRequestDTO dto) {
        Coringa coringa = coringaRepository.findById(id)
                .orElseThrow(() -> new CoringaException("Coringa nao encontrado para o id: " + id));

        coringa.setCoringaTitulo(dto.getCoringaTitulo() != null ?
                dto.getCoringaTitulo() : coringa.getCoringaTitulo());

        coringa.setPreco(dto.getPreco() != null ?
                dto.getPreco() : coringa.getPreco());

        coringa.setCoringaEstoque(dto.getCoringaEstoque() != null ?
                dto.getCoringaEstoque() : coringa.getCoringaEstoque());

        coringa.setCoringaClassificacaoIndicada(dto.getCoringaClassificacaoIndicada() != null ?
                dto.getCoringaClassificacaoIndicada() : coringa.getCoringaClassificacaoIndicada());

        return CoringaResponseDTO.fromEntity(coringaRepository.save(coringa));
    }

    public void delete(Long id) {
        if (!coringaRepository.existsById(id)) {
            throw new CoringaException("Coringa nao encontrado para o id: " + id);
        }
        coringaRepository.deleteById(id);
    }
}
