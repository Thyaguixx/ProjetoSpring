package _Desk.Thy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import _Desk.Thy.entity.Anuncio;
import _Desk.Thy.service.AnuncioService;

@RestController
@RequestMapping(value = "/anuncio")
@CrossOrigin
public class AnuncioController {
    
    @Autowired
    public AnuncioService anuncioService;

    @GetMapping(value = "/allAnuncios")
    public List<Anuncio> tododAnuncios() {
        List<Anuncio> anuncios = anuncioService.todosAnuncio();
        return anuncios;
    }

    @PostMapping(value = "/cadastrarAnuncio")
    public Anuncio cadastrarAnuncio(@RequestBody Anuncio anuncio) {
        return anuncioService.novoAnuncio(anuncio);
    }

    @GetMapping(value = "buscarPorNomeOuPreco")
    public List<Anuncio> buscarPorNomeOuPreco (@RequestParam String nomeProduto, @RequestParam Float preco) {
        return anuncioService.buscarPorNomeOuPreco(nomeProduto, preco);
    }

    @GetMapping(value = "/ultimoAnuncioCadastrado")
    public Anuncio ultimoAnuncioCadastrado () {
        return anuncioService.ultimoAnuncioCadastrado();
    }
}
