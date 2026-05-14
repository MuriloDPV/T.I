package br.com.exercicios.spring.exchange.service;

import br.com.exercicios.spring.exchange.entity.Cryptomoeda;
import br.com.exercicios.spring.exchange.entity.enums.Risco;
import br.com.exercicios.spring.exchange.handlers.MinhaException;
import br.com.exercicios.spring.exchange.repository.CriptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CriptoService {

    @Autowired
    private CriptoRepository criptoRepository;

    public Cryptomoeda salvarCripto(Cryptomoeda cripto) {
        Optional<List<Cryptomoeda>>  criptoSalvaPorNome = criptoRepository.findByNome(cripto.getNome());

        if (!criptoSalvaPorNome.isEmpty()){
            throw new MinhaException("Já existe uma criptomoeda com esse nome");
        }

        Optional<Cryptomoeda> criptoSalvaPorAbreviacao = criptoRepository.findByAbreviacao(cripto.getAbreviacao());

        if (criptoSalvaPorAbreviacao.isPresent()){
            throw new MinhaException("Já existe uma criptomoeda com essa abreviacao");
        }



        return criptoRepository.save(cripto);
    }

    public List<Cryptomoeda> listarTodasAsCriptos() {
        return criptoRepository.findAll();
    }

    public List<Cryptomoeda> listarCriptoPorAbreviacao(String abreviacao) {
        return criptoRepository.findCryptomoedaByAbreviacao(abreviacao);
    }

    public List<Cryptomoeda> listarCriptoPorPreco() {
        return criptoRepository.findAllByOrderByPrecoAsc();
    }

    public List<Cryptomoeda> listarCriptoPorRisco(Risco nivelDeRisco) {
        return criptoRepository.findCryptomoedaByNivelDeRisco(nivelDeRisco);
    }


    @Transactional
    public String deletarCriptoPorId(Long id) {
        Optional<Cryptomoeda> cripto = criptoRepository.findById(id);
        if (cripto.isPresent()) {
            criptoRepository.deleteById(id);
            return "Cryptomoeda deletada com sucesso!";
        }
        return "Cryptomoeda nao encontrada para o ID: " + id;
    }

    @Transactional
    public String deletarCriptoPorAbreviacao(String abreviacao) {
        Optional<Cryptomoeda> cripto = criptoRepository.findByAbreviacao(abreviacao);
        if (cripto.isPresent()) {
            criptoRepository.deleteByAbreviacao(abreviacao);
            return "Cryptomoeda deletada com sucesso!";
        }
        return "Cryptomoeda nao encontrada para a abreviacao: " + abreviacao;
    }

    public Cryptomoeda editarCriptoPorID(Long id, Cryptomoeda criptoAtualizada) {
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
        }
        throw new RuntimeException("Cripto nao encontrada para o id: " + id);
    }

    public Cryptomoeda editarCriptoPorAbreviacao(String abreviacao, Cryptomoeda criptoAtualizada) {
        Optional<Cryptomoeda> cripto = criptoRepository.findByAbreviacao(abreviacao);
        if (cripto.isPresent()) {
            Cryptomoeda criptoExistente = cripto.get();
            criptoExistente.setAbreviacao(criptoAtualizada.getAbreviacao());
            criptoExistente.setNome(criptoAtualizada.getNome());
            criptoExistente.setPreco(criptoAtualizada.getPreco());
            criptoExistente.setVolumeNegociado(criptoAtualizada.getVolumeNegociado());
            criptoExistente.setNivelDeRisco(criptoAtualizada.getNivelDeRisco());
            return criptoRepository.save(criptoExistente);
        }
        throw new RuntimeException("Cripto nao encontrada para a abreviacao: " + abreviacao);
    }










}
