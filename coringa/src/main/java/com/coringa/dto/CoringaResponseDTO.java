package com.coringa.dto;

import com.coringa.entity.Coringa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoringaResponseDTO {

    private String coringaTitulo;
    private BigDecimal preco;
    private Integer coringaClassificacaoIndicada;
    private Boolean disponivel;

    public static CoringaResponseDTO fromEntity(Coringa entity) {
        return CoringaResponseDTO.builder()
                .coringaTitulo(entity.getCoringaTitulo())
                .preco(entity.getPreco())
                .coringaClassificacaoIndicada(entity.getCoringaClassificacaoIndicada())
                .disponivel(entity.getDisponivel())
                .build();
    }
}
