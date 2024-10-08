package _Desk.Thy.service;

import java.time.LocalDateTime;
// import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import _Desk.Thy.entity.Trabalho;
import _Desk.Thy.repository.TrabalhoRepository;
import jakarta.transaction.Transactional;

@Service
public class TrabalhoServiceImpl implements TrabalhoService{
    private TrabalhoRepository repository;

    public TrabalhoServiceImpl(TrabalhoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Trabalho> todosTrabalhos() {
        List<Trabalho> trabalhos = repository.findAll();
        return trabalhos;
    }

    @Override
    @Transactional
    public Trabalho novoTrabalho(Trabalho trabalho) {
        if (trabalho.getNota() == null || trabalho.getDescricao() == null || trabalho.getTitulo() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nota, Descricao ou Titulo nao pode ser vazio.");
        }
        
        if(trabalho.getDataHora() == null){
            trabalho.setDataHora(LocalDateTime.now());
        }

        return repository.save(trabalho);
    }

    @Override
    public Trabalho buscarPeloID(Long id) {
        Optional<Trabalho> trabalhoOptional = repository.findById(id);

        if (trabalhoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trabalho não encontrado.");
        } else {
            return trabalhoOptional.get();
        }
    }

    @Override
    public List<Trabalho> buscarPorNota(Integer nota) {
        List<Trabalho> trabalhos = repository.buscarPorNota(nota);
        
        if (trabalhos.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não possui trabalhos com esta nota.");
        } else {
            return trabalhos;
        }
    }
}
