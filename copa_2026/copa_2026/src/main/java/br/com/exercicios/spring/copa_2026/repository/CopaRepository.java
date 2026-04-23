package br.com.exercicios.spring.copa_2026.repository;

import br.com.exercicios.spring.copa_2026.entity.Copa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.OptionPaneUI;
import java.util.Optional;

@Repository
public interface CopaRepository extends JpaRepository<Copa,Long> {

    Optional<Copa> findByAno(Integer ano);

}
