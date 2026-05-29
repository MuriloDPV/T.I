package com.example.eventos.dtos;

import com.example.eventos.entity.Eventos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EventoResponseDTO {

    private String titulo;
    private String status;

    public static EventoResponseDTO entityToDto(Eventos eventos) {
        return EventoResponseDTO.builder()
                .titulo(eventos.getTitulo())
                .status(eventos.getStatus())
                .build();
    }
}