package br.com.exercicios.spring.exchange.repository;


import br.com.exercicios.spring.exchange.entity.Cryptomoeda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CriptoRepository extends JpaRepository<Cryptomoeda,Long> {

    Optional<Cryptomoeda> findByNome(String nome);

}
