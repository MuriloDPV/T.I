package com.example.eventos.repository;

import com.example.eventos.entity.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventoRepository extends JpaRepository<Eventos, Long> {
    boolean existsByTitulo(String titulo);

    Optional<Eventos> findByDescricao(String descricao);

    List<Eventos> findAllByOrderByDataEventoAsc();
}


