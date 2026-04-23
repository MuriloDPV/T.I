package br.com.exercicios.spring.copa_2026.service;

import br.com.exercicios.spring.copa_2026.entity.Copa;
import br.com.exercicios.spring.copa_2026.repository.CopaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CopaService {

    @Autowired
    private CopaRepository copaRepository;

    public Copa salvarCopa(Copa copa) {
        Optional<Copa> copaSalvaPorAno = copaRepository.findByAno(copa.getAno());
        if(copaSalvaPorAno.isPresent()){
            throw new RuntimeException("Já existe uma copa cadastrada");
        }
        if(copa.getAno() % 4 != 2){
            throw new RuntimeException("O ano da copa não é válido");
        }
        return copaRepository.save(copa);
    }

    public List<Copa> listarTodasAsCopas() {
        return copaRepository.findAll();
    }

    public String deletarCopa(Long id) {
        Optional<Copa> copa = copaRepository.findById(id);
        if (copa.isPresent()) {
            copaRepository.deleteById(id);
            return "Copa deletada com sucesso!";
        } else {
            return "Copa não encontrada para o ID: " + id;
        }
    }

    public Copa editarCopa(Long id, Copa copaAtualizada) {
        Optional<Copa> copa = copaRepository.findById(id);
        if (copa.isPresent()) {
            Copa copaExistente = copa.get();
            copaExistente.setLocal(copaAtualizada.getLocal() != null ?
                    copaAtualizada.getLocal() : copaExistente.getLocal());

            copaExistente.setDataInicio(copaAtualizada.getDataInicio() != null ?
                    copaAtualizada.getDataInicio() : copaExistente.getDataInicio());

            copaExistente.setDataFim(copaAtualizada.getDataFim() != null ?
                    copaAtualizada.getDataFim() : copaExistente.getDataFim());

            copaExistente.setDuracao(copaAtualizada.getDuracao() != null ?
                    copaAtualizada.getDuracao() : copaExistente.getDuracao());

            copaExistente.setQuantidadeSelecoes(copaAtualizada.getQuantidadeSelecoes() != null ?
                    copaAtualizada.getQuantidadeSelecoes() : copaExistente.getQuantidadeSelecoes());

            return copaRepository.save(copaExistente);
        } else {
            throw new RuntimeException("Copa não encontrada para o id: " + id);

        }

    }
}
