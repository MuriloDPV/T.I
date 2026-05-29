package br.com.exercicios.spring.coringas.dto;

import br.com.exercicios.spring.coringas.entity.Status;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CoringaRequestDTO {
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @NotBlank
    private String palestrante;
    @Email
    private String emailContato;
    @Min(1)
    private Integer cargaHoraria;
    @Positive
    private Integer quantidadeVagas;
    @FutureOrPresent
    private LocalDate dataCoringa;
    @DecimalMin("0.0")
    private BigDecimal valorInscricao;
    @NotNull
    private Status status;
}
