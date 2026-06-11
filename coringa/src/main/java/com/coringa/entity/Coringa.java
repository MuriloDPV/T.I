package com.coringa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Coringa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String coringaTitulo;
    private BigDecimal preco;
    private Integer coringaEstoque;
    private Integer coringaClassificacaoIndicada;
    private Boolean disponivel;
    private String coringaCodigoInterno;

    @PrePersist
    public void prePersist() {
        if (coringaCodigoInterno == null || coringaCodigoInterno.isBlank()) {
            coringaCodigoInterno = UUID.randomUUID().toString();
        }
    }
}
