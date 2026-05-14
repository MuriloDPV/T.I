package br.com.exercicios.spring.exchange.dtos;


import br.com.exercicios.spring.exchange.entity.Corretor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CorretorResponseDTO {

    private String nome;
    private String email;

    public static CorretorResponseDTO entityToDto(Corretor corretor) {
        return CorretorResponseDTO.builder()
                .nome(corretor.getNome())
                .email(corretor.getEmail())
                .build();
    }
}
