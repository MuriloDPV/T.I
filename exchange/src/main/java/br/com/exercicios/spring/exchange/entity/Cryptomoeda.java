package br.com.exercicios.spring.exchange.entity;

import br.com.exercicios.spring.exchange.entity.enums.Risco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "cripto", schema = "public")
public class Cryptomoeda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String abreviacao;
    private Double preco;
    private Double volumeNegociado;

    @Enumerated(EnumType.STRING)
    private Risco nivelDeRisco;
}

