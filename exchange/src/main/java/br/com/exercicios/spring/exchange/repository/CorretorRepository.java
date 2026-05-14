package br.com.exercicios.spring.exchange.repository;

import br.com.exercicios.spring.exchange.entity.Corretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorretorRepository extends JpaRepository< Corretor,  Long>{

}
