package br.com.exercicios.spring.exchange.repository;


import br.com.exercicios.spring.exchange.entity.Cryptomoeda;
import br.com.exercicios.spring.exchange.entity.enums.Risco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CriptoRepository extends JpaRepository<Cryptomoeda,Long> {

    Optional<List<Cryptomoeda>> findByNome(String nome);


    Optional<Cryptomoeda> findByAbreviacao(String abreviacao);

    void deleteByAbreviacao(String abreviacao);

    List<Cryptomoeda> findCryptomoedaByAbreviacao(String abreviacao);

    List<Cryptomoeda> findAllByOrderByPrecoAsc();


    List<Cryptomoeda> findCryptomoedaByNivelDeRisco(Risco nivelDeRisco);
}
