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

import com.fasterxml.jackson.annotation.JsonView;

import _Desk.Thy.entity.Usuario;
import _Desk.Thy.entity.View;
import _Desk.Thy.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @JsonView({View.UsuarioView.class})
    @GetMapping(value = "/allUsers")
    public List<Usuario> todosUsuarios() {
        return usuarioService.todosUsuarios();
    }

    @PostMapping(value = "/newUser")
    public Usuario novoUsuario(@RequestBody Usuario usuario) {
        return usuarioService.novoUsuario(usuario);
    }

    @GetMapping(value = "/{id}")
    public Usuario buscarPeloId(@PathVariable("id") Long id) {
        return usuarioService.buscarPeloID(id);
    }
}
