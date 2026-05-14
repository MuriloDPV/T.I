package br.com.exercicios.spring.exchange.service;

import br.com.exercicios.spring.exchange.dtos.CorretorRequestDTO;
import br.com.exercicios.spring.exchange.dtos.CorretorResponseDTO;
import br.com.exercicios.spring.exchange.entity.Corretor;
import br.com.exercicios.spring.exchange.repository.CorretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorretorService {
    @Autowired
    private CorretorRepository corretorRepository;

    public CorretorResponseDTO save(CorretorRequestDTO dto){
        Corretor corretor = corretorRepository.save(CorretorRequestDTO.dtoToEntity(dto));
        return CorretorResponseDTO.entityToDto(corretor);
    }

}
