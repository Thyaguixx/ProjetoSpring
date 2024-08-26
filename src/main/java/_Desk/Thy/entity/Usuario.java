package _Desk.Thy.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usr_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    @JsonView({ View.UsuarioView.class, View.AnotacaoView.class })
    private Long id;

    @Column(name = "usr_nome")
    @JsonView({ View.UsuarioView.class, View.AnotacaoView.class })
    private String nome;

    @Column(name = "usr_senha")
    private String senha;

    @OneToMany(mappedBy = "usuario")
    @JsonView({ View.UsuarioView.class, View.AnotacaoView.class })
    private Set<Anotacao> anotacoes;

    @ManyToMany
    @JoinTable(name = "uau_usuario_autorizacao",
        joinColumns = { @JoinColumn(name = "usr_id") },
        inverseJoinColumns = {@JoinColumn(name = "aut_id")})
    @JsonView({View.UsuarioView.class})
    public Set<Autorizacao> autorizacoes;

    public Usuario() {
        setAnotacoes(new HashSet<Anotacao>());
    }

    public Usuario(String nome, String senha) {
        this();
        setNome(nome);
        setSenha(senha);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Anotacao> getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(Set<Anotacao> anotacoes) {
        this.anotacoes = anotacoes;
    }

    public Set<Autorizacao> getAutorizacoes() {
        return autorizacoes;
    }

    public void setAutorizacoes(Set<Autorizacao> autorizacoes) {
        this.autorizacoes = autorizacoes;
    }
    
}