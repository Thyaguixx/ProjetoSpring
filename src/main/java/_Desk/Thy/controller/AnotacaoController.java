package _Desk.Thy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import _Desk.Thy.entity.View;
import _Desk.Thy.entity.Anotacao;
import _Desk.Thy.repository.AnotacaoRepository;

@RestController
@RequestMapping(value = "/anotacao")
@CrossOrigin
public class AnotacaoController {
    
    @Autowired
    private AnotacaoRepository repo;

    @JsonView({View.AnotacaoView.class})
    @GetMapping(value = "/allAnotacoes")
    public List<Anotacao> buscarTodas() {
        return repo.findAll();
    }
}

