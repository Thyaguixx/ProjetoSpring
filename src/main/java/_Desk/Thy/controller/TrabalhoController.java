package _Desk.Thy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import _Desk.Thy.entity.Trabalho;
import _Desk.Thy.service.TrabalhoService;

@RestController
@RequestMapping(value = "/trabalho")
@CrossOrigin
public class TrabalhoController {
    @Autowired
    public TrabalhoService trabalhoService;

    @GetMapping(value = "/allTrabalhos")
    public List<Trabalho> todosTrabalhos() {
        List<Trabalho> trabalhos = trabalhoService.todosTrabalhos();
        return trabalhos;
    }

    @PostMapping(value = "/cadastrarTrabalho")
    public Trabalho cadastrarTrabalho(@RequestBody Trabalho trabalho) {
        return trabalhoService.novoTrabalho(trabalho);
    }

    @GetMapping(value = "/buscarPorNota/{nota}")
    public List<Trabalho> buscarPorNota (@PathVariable("nota") Integer nota) {
        return trabalhoService.buscarPorNota(nota);
    }

    @GetMapping(value = "/{id}")
    public Trabalho buscarPorNota (@PathVariable("id") Long id) {
        return trabalhoService.buscarPeloID(id);
    }
}
