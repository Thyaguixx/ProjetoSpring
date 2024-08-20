package _Desk.Thy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import _Desk.Thy.entity.Usuario;
import _Desk.Thy.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    // @Autowired
    private UsuarioRepository repo;

    public UsuarioServiceImpl(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public Usuario novoUsuario(Usuario usuario) {
        if (usuario == null || usuario.getNome() == null || usuario.getSenha() == null || usuario.getNome().isBlank() || usuario.getSenha().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome ou senha inválidos.");
        }
        
        return repo.save(usuario);
    }

    @Override
    public List<Usuario> todosUsuarios() {
        List<Usuario> usuarios = new ArrayList<Usuario>();

        for (Usuario usuario: repo.findAll()){
            usuarios.add(usuario);
        }
        return usuarios;
    }

    @Override
    public Usuario buscarPeloID(Long id) {
        Optional<Usuario> usuarioOptional = repo.findById(id);

        if (usuarioOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado.");
        }

        return usuarioOptional.get();
    }

}
