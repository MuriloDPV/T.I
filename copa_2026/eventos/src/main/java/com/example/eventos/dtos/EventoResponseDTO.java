package com.example.eventos.dtos;

import com.example.eventos.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoResponseDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private String palestrante;
    private String emailContato;
    private Integer cargaHoraria;
    private LocalDate dataEvento;
    private Integer quantidadeVagas;
    private BigDecimal valorInscricao;
    private Status status;
    private LocalDateTime dataCadastro;
}

