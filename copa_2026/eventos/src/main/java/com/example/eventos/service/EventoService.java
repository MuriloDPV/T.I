package com.example.eventos.service;

import com.example.eventos.dtos.EventoListResponseDTO;
import com.example.eventos.dtos.EventoRequestDTO;
import com.example.eventos.dtos.EventoResponseDTO;
import com.example.eventos.entity.Eventos;
import com.example.eventos.handlers.MinhaException;
import com.example.eventos.handlers.RecursoNaoEncontradoException;
import com.example.eventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Transactional
    public EventoResponseDTO cadastrar(EventoRequestDTO dto) {
        if (eventoRepository.existsByTitulo(dto.getTitulo())) {
            throw new MinhaException("Ja existe um evento com esse titulo");
        }

        Eventos evento = new Eventos();
        applyDto(evento, dto);
        Eventos salvo = eventoRepository.save(evento);
        return toResponseDto(salvo);
    }

    @Transactional(readOnly = true)
    public EventoResponseDTO buscarPorId(Long id) {
        Eventos evento = eventoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Evento nao encontrado para o ID: " + id));
        return toResponseDto(evento);
    }

    @Transactional(readOnly = true)
    public List<EventoListResponseDTO> listarTodos() {
        return eventoRepository.findAllByOrderByDataEventoAsc().stream()
                .map(this::toListResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public EventoResponseDTO atualizar(Long id, EventoRequestDTO dto) {
        Eventos existente = eventoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Evento nao encontrado para o ID: " + id));

        // Nao permite alterar: id, dataCadastro, codigoInterno (campos nao estao no DTO)
        applyDto(existente, dto);
        Eventos salvo = eventoRepository.save(existente);
        return toResponseDto(salvo);
    }

    @Transactional
    public void remover(Long id) {
        Eventos existente = eventoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Evento nao encontrado para o ID: " + id));
        eventoRepository.delete(existente);
    }

    private void applyDto(Eventos evento, EventoRequestDTO dto) {
        evento.setTitulo(dto.getTitulo());
        evento.setDescricao(dto.getDescricao());
        evento.setPalestrante(dto.getPalestrante());
        evento.setEmailContato(dto.getEmailContato());
        evento.setCargaHoraria(dto.getCargaHoraria());
        evento.setDataEvento(dto.getDataEvento());
        evento.setQuantidadeVagas(dto.getQuantidadeVagas());
        evento.setValorInscricao(dto.getValorInscricao());
        evento.setStatus(dto.getStatus());
    }

    private EventoResponseDTO toResponseDto(Eventos e) {
        return EventoResponseDTO.builder()
                .id(e.getId())
                .titulo(e.getTitulo())
                .descricao(e.getDescricao())
                .palestrante(e.getPalestrante())
                .emailContato(e.getEmailContato())
                .cargaHoraria(e.getCargaHoraria())
                .dataEvento(e.getDataEvento())
                .quantidadeVagas(e.getQuantidadeVagas())
                .valorInscricao(e.getValorInscricao())
                .status(e.getStatus())
                .dataCadastro(e.getDataCadastro())
                .build();
    }

    private EventoListResponseDTO toListResponseDto(Eventos e) {
        return EventoListResponseDTO.builder()
                .id(e.getId())
                .titulo(e.getTitulo())
                .dataEvento(e.getDataEvento())
                .status(e.getStatus())
                .quantidadeVagas(e.getQuantidadeVagas())
                .valorInscricao(e.getValorInscricao())
                .build();
    }
}

