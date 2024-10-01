package _Desk.Thy.service;

import java.util.List;

import _Desk.Thy.entity.Trabalho;

public interface TrabalhoService {
    public Trabalho novoTrabalho(Trabalho trabalho);
    public List<Trabalho> todosTrabalhos();
    public Trabalho buscarPeloID(Long id);
    public List<Trabalho> buscarPorNota();
}
