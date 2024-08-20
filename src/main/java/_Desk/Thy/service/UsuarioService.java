package _Desk.Thy.service;

import java.util.List;

import _Desk.Thy.entity.Usuario;

public interface UsuarioService {
    public Usuario novoUsuario(Usuario usuario);
    public List<Usuario> todosUsuarios();
    public Usuario buscarPeloID(Long id);
}
