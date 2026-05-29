package br.com.exercicios.spring.coringas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Coringas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String palestrante;
    private String emailContato;
    private Integer cargaHoraria;
    private LocalDate dataCoringa;
    private LocalDate dataCadastro;
    private Integer quantidadeVagas;
    private BigDecimal valorInscricao;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = false, unique = true, updatable = false)
    private String codigoInterno;

    @PrePersist
    public void prePersist() {
        if (dataCadastro == null) {
            dataCadastro = LocalDate.now();
        }
        if (codigoInterno == null || codigoInterno.isBlank()) {
            codigoInterno = UUID.randomUUID().toString();
        }
    }
}
