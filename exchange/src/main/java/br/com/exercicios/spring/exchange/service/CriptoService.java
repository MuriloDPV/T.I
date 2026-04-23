package br.com.exercicios.spring.exchange.service;

import br.com.exercicios.spring.exchange.entity.Cryptomoeda;
import br.com.exercicios.spring.exchange.repository.CriptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriptoService {

    @Autowired
    private CriptoRepository criptoRepository;

    public Cryptomoeda salvarCripto(Cryptomoeda cripto) {
        Optional<Cryptomoeda> criptoSalvaPorNome = criptoRepository.findByNome(cripto.getNome());
        return criptoRepository.save(cripto);
    }

    public List<Cryptomoeda> listarTodasAsCriptos() {
        return criptoRepository.findAll();
    }

    public String deletarCripto(Long id) {
        Optional<Cryptomoeda> cripto = criptoRepository.findById(id);
        if (cripto.isPresent()) {
            criptoRepository.deleteById(id);
            return "Cryptomoeda deletada com sucesso!";
        } else {
            return "Cryptomoeda não encontrada para o ID: " + id;
        }
    }

    public Cryptomoeda editarCripto(Long id, Cryptomoeda criptoAtualizada) {
        Optional<Cryptomoeda> cripto = criptoRepository.findById(id);
        if (cripto.isPresent()) {
            Cryptomoeda criptoExistente = cripto.get();
            criptoExistente.setAbreviacao(criptoAtualizada.getAbreviacao() != null ?
                    criptoAtualizada.getAbreviacao() : criptoExistente.getAbreviacao());

            criptoExistente.setNome(criptoAtualizada.getNome() != null ?
                    criptoAtualizada.getNome() : criptoExistente.getNome());

            criptoExistente.setPreco(criptoAtualizada.getPreco() != null ?
                    criptoAtualizada.getPreco() : criptoExistente.getPreco());

            criptoExistente.setVolumeNegociado(criptoAtualizada.getVolumeNegociado() != null ?
                    criptoAtualizada.getVolumeNegociado() : criptoExistente.getVolumeNegociado());

            criptoExistente.setNivelDeRisco(criptoAtualizada.getNivelDeRisco() != null ?
                    criptoAtualizada.getNivelDeRisco() : criptoExistente.getNivelDeRisco());

            return criptoRepository.save(criptoExistente);
        } else {
            throw new RuntimeException("Cripto não encontrada para o id: " + id);
        }
    }
}
