package com.coringa.dto;

import com.coringa.entity.Coringa;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CoringaRequestDTO {

    @Size(min = 3, max = 100, message = "O titulo deve ter entre 3 ou 100 caracteres")
    private String coringaTitulo;

    @Positive
    private BigDecimal preco;

    @Min(value = 0, message = "O estoque deve um numero positivo")
    private Integer coringaEstoque;

    @Min(value = 0, message = "A classificacao deve ser maior que 0")
    private Integer coringaClassificacaoIndicada;

    public static Coringa dtoToEntity(CoringaRequestDTO coringaRequestDTO) {
        return Coringa.builder()
                .coringaTitulo(coringaRequestDTO.getCoringaTitulo())
                .preco(coringaRequestDTO.getPreco())
                .coringaClassificacaoIndicada(coringaRequestDTO.getCoringaClassificacaoIndicada())
                .coringaEstoque(coringaRequestDTO.getCoringaEstoque())
                .disponivel(coringaRequestDTO.getCoringaEstoque() > 0)
                .build();
    }
}
