package _Desk.Thy.service;

import java.util.List;

import _Desk.Thy.entity.Anuncio;

public interface AnuncioService {
    public Anuncio novoAnuncio(Anuncio anuncio);
    public List<Anuncio> todosAnuncio();
    public Anuncio ultimoAnuncioCadastrado();
    public List<Anuncio> buscarPorNomeOuPreco(String nomeProduto, Float preco);
}
