package com.example.eventos.service;

import com.example.eventos.dtos.EventoRequestDTO;
import com.example.eventos.dtos.EventoResponseDTO;
import com.example.eventos.entity.Eventos;
import com.example.eventos.handlers.MinhaException;
import com.example.eventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public EventoResponseDTO salvarEvento(EventoRequestDTO evento) {
        Optional<EventoResponseDTO>  eventoSalvaPorTitulo = eventoRepository.findByTitulo(evento.getTitulo());

        if (!eventoSalvaPorTitulo.isEmpty()){
            throw new MinhaException("Já existe uma evento com esse titulo");
        }







        return eventoRepository.save(evento);
    }

    public List<EventoResponseDTO> listarTodosOsEventos() {
        return eventoRepository.findAll();
    }


//    public List<Eventos> listarEventoPorPalestrante() {
//        return eventoRepository.findAllByOrderByPalestranteAsc();
//    }




    @Transactional
    public String deletarEventoPorId(Long id) {
        Optional<EventosResponseDTO> evento = eventoRepository.findById(id);
        if (evento.isPresent()) {
            return evento.get().toString();
        }
        return "Evento nao encontrado para o ID: " + id;
    }

    @Transactional
    public EventoResponseDTO listarEventoPorID(Long id) {
        Optional<EventoRequestDTO> eventos = eventoRepository.findById(id);
        if (eventos.isPresent()) {
            return eventos.get();
        }
        throw new MinhaException( "Evento nao encontrado para o ID: " + id);
    }

//    @Transactional
//    public String deletarEventoPorDescricao(String descricao) {
//        Optional<Eventos> evento = eventoRepository.findByDescricao(descricao);
//        if (evento.isPresent()) {
//            eventoRepository.deleteByDescricao(descricao);
//            return "Eventos deletada com sucesso!";
//        }
//        return "Eventos nao encontrada para a descricao: " + descricao;
//    }

    public EventoResponseDTO editarEventoPorID(Long id, EventoRequestDTO eventoAtualizada) {
        Optional<Eventos> evento = eventoRepository.findById(id);
        if (evento.isPresent()) {
            EventoRequestDTO eventoExistente = evento.get();
            eventoExistente.setDescricao(eventoAtualizada.getDescricao() != null ?
                    eventoAtualizada.getDescricao() : eventoExistente.getDescricao());
            eventoExistente.setTitulo(eventoAtualizada.getTitulo() != null ?
                    eventoAtualizada.getTitulo() : eventoExistente.getTitulo());
            eventoExistente.setPalestrante(eventoAtualizada.getPalestrante() != null ?
                    eventoAtualizada.getPalestrante() : eventoExistente.getPalestrante());

            eventoExistente.setEmailContato(eventoAtualizada.getEmailContato() != null ?
                    eventoAtualizada.getEmailContato() : eventoExistente.getEmailContato());

            eventoExistente.setValorInscricao(eventoAtualizada.getValorInscricao() != null ?
                    eventoAtualizada.getValorInscricao() : eventoExistente.getValorInscricao());

            eventoExistente.setQuantidadeVagas(eventoAtualizada.getQuantidadeVagas() != null ?
                    eventoAtualizada.getQuantidadeVagas() : eventoExistente.getQuantidadeVagas());

            eventoExistente.setCargaHoraria(eventoAtualizada.getCargaHoraria() != null ?
                    eventoAtualizada.getCargaHoraria() : eventoExistente.getCargaHoraria());
            return eventoRepository.save(eventoExistente);
        }
        throw new RuntimeException("Evento nao encontrada para o id: " + id);
    }

    public Eventos editarEventoPorDescricao(String descricao, Eventos eventoAtualizada) {
        Optional<Eventos> evento = eventoRepository.findByDescricao(descricao);
        if (evento.isPresent()) {
            Eventos eventoExistente = evento.get();
            eventoExistente.setDescricao(eventoAtualizada.getDescricao());
            eventoExistente.setTitulo(eventoAtualizada.getTitulo());
            eventoExistente.setPalestrante(eventoAtualizada.getPalestrante());
            eventoExistente.setEmailContato(eventoAtualizada.getEmailContato());
            eventoExistente.setCargaHoraria(eventoAtualizada.getCargaHoraria());
            eventoExistente.setDataEvento(eventoAtualizada.getDataEvento());
            eventoExistente.setValorInscricao(eventoAtualizada.getValorInscricao());
            eventoExistente.setQuantidadeVagas(eventoAtualizada.getQuantidadeVagas());






            return eventoRepository.save(eventoExistente);
        }
        throw new RuntimeException("Evento nao encontrada para a descricao: " + descricao);
    }










}
