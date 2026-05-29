package br.com.exercicios.spring.coringas.service;

import br.com.exercicios.spring.coringas.dto.CoringaRequestDTO;
import br.com.exercicios.spring.coringas.dto.CoringaResponseDTO;
import br.com.exercicios.spring.coringas.entity.Coringas;
import br.com.exercicios.spring.coringas.handlers.MinhaException;
import br.com.exercicios.spring.coringas.repository.CoringaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CoringaService {
    @Autowired
    private CoringaRepository coringaRepository;

    public CoringaResponseDTO save(CoringaRequestDTO dto) {
        Coringas coringa = Coringas.builder()
                .titulo(dto.getTitulo())
                .descricao(dto.getDescricao())
                .palestrante(dto.getPalestrante())
                .emailContato(dto.getEmailContato())
                .cargaHoraria(dto.getCargaHoraria())
                .dataCoringa(dto.getDataCoringa())
                .quantidadeVagas(dto.getQuantidadeVagas())
                .valorInscricao(dto.getValorInscricao())
                .status(dto.getStatus())
                .build();
        return CoringaResponseDTO.fromEntity(coringaRepository.save(coringa));
    }

    public CoringaResponseDTO findById(Long id) {
        Coringas coringa = coringaRepository.findById(id)
                .orElseThrow(() -> new MinhaException("Coringa nao encontrado para o id: " + id));
        return CoringaResponseDTO.fromEntity(coringa);
    }

    public List<CoringaResponseDTO> findAll() {
        return coringaRepository.findAll().stream()
                .map(CoringaResponseDTO::fromEntity)
                .toList();
    }

    public CoringaResponseDTO update(Long id, CoringaRequestDTO dto) {
        Coringas coringa = coringaRepository.findById(id)
                .orElseThrow(() -> new MinhaException("Coringa nao encontrado para o id: " + id));

        coringa.setTitulo(dto.getTitulo());
        coringa.setDescricao(dto.getDescricao());
        coringa.setPalestrante(dto.getPalestrante());
        coringa.setEmailContato(dto.getEmailContato());
        coringa.setCargaHoraria(dto.getCargaHoraria());
        coringa.setDataCoringa(dto.getDataCoringa());
        coringa.setQuantidadeVagas(dto.getQuantidadeVagas());
        coringa.setValorInscricao(dto.getValorInscricao());
        coringa.setStatus(dto.getStatus());

        return CoringaResponseDTO.fromEntity(coringaRepository.save(coringa));
    }

    public void delete(Long id) {
        if (!coringaRepository.existsById(id)) {
            throw new MinhaException("Coringa nao encontrado para o id: " + id);
        }
        coringaRepository.deleteById(id);
    }
}
