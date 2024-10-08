package _Desk.Thy.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import _Desk.Thy.entity.Anuncio;
import _Desk.Thy.repository.AnuncioRepository;
import jakarta.transaction.Transactional;

@Service
public class AnuncioServiceImpl implements AnuncioService{
    @Autowired
    public AnuncioRepository anuncioRepository;

    @Override
    @Transactional
    public Anuncio novoAnuncio(Anuncio anuncio) {
        if (anuncio.getNomeProduto() == null || anuncio.getPreco() <= 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome do produto não pode ser vazio e preco tem que ser maior que zero!");
        }
        
        if (anuncio.getDataHora() == null) {
            anuncio.setDataHora(LocalDateTime.now());
        }

        return anuncioRepository.save(anuncio);
    }

    @Override
    public List<Anuncio> todosAnuncio() {
        List<Anuncio> anuncios = anuncioRepository.findAll();
        return anuncios;
    }

    @Override
    public Anuncio ultimoAnuncioCadastrado() {
        return anuncioRepository.ultimoAnuncioCadastrado();
    }

    @Override
    public List<Anuncio> buscarPorNomeOuPreco(String nomeProduto, Float preco) {
        List<Anuncio> anuncios = anuncioRepository.buscarPorNomeOuPreco(nomeProduto, preco);
        
        if (anuncios.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nao existe produtos com este nome ou com esta nota.");
        } else {
            return anuncios;
        }
    }

    
}
