package com.example.eventos.dtos;

import com.example.eventos.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoListResponseDTO {
    private Long id;
    private String titulo;
    private LocalDate dataEvento;
    private Status status;
    private Integer quantidadeVagas;
    private BigDecimal valorInscricao;
}

