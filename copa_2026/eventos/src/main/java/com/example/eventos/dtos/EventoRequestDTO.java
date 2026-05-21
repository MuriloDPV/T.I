package com.example.eventos.dtos;

import com.example.eventos.entity.enums.Status;
import jakarta.validation.constraints.*;
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
public class EventoRequestDTO {
    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotBlank
    private String palestrante;

    @NotBlank
    @Email
    private String emailContato;

    @NotNull
    @Min(1)
    private Integer cargaHoraria;

    @NotNull
    @FutureOrPresent
    private LocalDate dataEvento;

    @NotNull
    @Positive
    private Integer quantidadeVagas;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal valorInscricao;

    @NotNull
    private Status status;
}

