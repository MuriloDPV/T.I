package com.example.eventos.entity;

import com.example.eventos.entity.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "eventos", schema = "public")
public class Eventos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    private String palestrante;

    private String emailContato;

    private Integer cargaHoraria;

    private LocalDate dataEvento;

    private Integer quantidadeVagas;

    private BigDecimal valorInscricao;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(updatable = false)
    private LocalDateTime dataCadastro;

    @Column(updatable = false)
    private String codigoInterno;

    @PrePersist
    void prePersist() {
        if (dataCadastro == null) {
            dataCadastro = LocalDateTime.now();
        }
        if (codigoInterno == null || codigoInterno.isBlank()) {
            codigoInterno = UUID.randomUUID().toString();
        }
    }
}

