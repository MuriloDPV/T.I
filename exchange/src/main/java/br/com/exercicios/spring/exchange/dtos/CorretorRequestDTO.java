package br.com.exercicios.spring.exchange.dtos;

import br.com.exercicios.spring.exchange.entity.Corretor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

    @AllArgsConstructor
    @Builder
    @Data
    @NoArgsConstructor


public class CorretorRequestDTO {

        @Size(min = 1, max = 100, message = "O nome deve ter entre 2 ou 100 caracteres")
        private String nome;


        @Email(message = "O email deve ser válido")
        private String email;



        @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
        private String senha;

        @Min(value = 0, message = "A idade deve ser um valor postitivo")
        private Integer idade;


        public static Corretor dtoToEntity(CorretorRequestDTO corretorRequestDTO) {
            return Corretor.builder()
                    .nome(corretorRequestDTO.nome)
                    .email(corretorRequestDTO.email)
                    .senha(corretorRequestDTO.senha)
                    .idade(corretorRequestDTO.idade)
                    .codigoInterno(java.util.UUID.randomUUID().toString()).build();

        }




}
