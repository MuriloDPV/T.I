package com.coringa.repository;

import com.coringa.entity.Coringa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoringaRepository extends JpaRepository<Coringa, Long> {
}
