package br.com.exercicios.spring.coringas.dto;

import br.com.exercicios.spring.coringas.entity.Coringas;
import br.com.exercicios.spring.coringas.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoringaResponseDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private String palestrante;
    private String emailContato;
    private Integer cargaHoraria;
    private Integer quantidadeVagas;
    private LocalDate dataCoringa;
    private BigDecimal valorInscricao;
    private Status status;
    private LocalDate dataCadastro;

    public static CoringaResponseDTO fromEntity(Coringas entity) {
        return CoringaResponseDTO.builder()
                .id(entity.getId())
                .titulo(entity.getTitulo())
                .descricao(entity.getDescricao())
                .palestrante(entity.getPalestrante())
                .emailContato(entity.getEmailContato())
                .cargaHoraria(entity.getCargaHoraria())
                .quantidadeVagas(entity.getQuantidadeVagas())
                .dataCoringa(entity.getDataCoringa())
                .valorInscricao(entity.getValorInscricao())
                .status(entity.getStatus())
                .dataCadastro(entity.getDataCadastro())
                .build();
    }
}
