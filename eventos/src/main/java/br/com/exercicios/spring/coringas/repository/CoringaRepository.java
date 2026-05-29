package br.com.exercicios.spring.coringas.repository;

import br.com.exercicios.spring.coringas.entity.Coringas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoringaRepository extends JpaRepository<Coringas, Long> {
}
