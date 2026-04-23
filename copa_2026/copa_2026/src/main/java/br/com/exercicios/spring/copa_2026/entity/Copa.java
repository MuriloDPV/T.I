package br.com.exercicios.spring.copa_2026.entity;

import br.com.exercicios.spring.copa_2026.entity.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Copa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer ano;
    private String local;
    private Integer quantidadeSelecoes;
    private Integer duracao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Status status;
}
