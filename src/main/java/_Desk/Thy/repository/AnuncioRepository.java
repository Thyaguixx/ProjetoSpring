package _Desk.Thy.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import _Desk.Thy.entity.Anuncio;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long>{
    @Query("select a from Anuncio a where a.nomeProduto LIKE %:nomeProduto% OR a.preco < :preco")
    public List<Anuncio> buscarPorNomeOuPreco(String nomeProduto, Float preco);

    @Query("select a from Anuncio a order by a.id desc limit 1")
    public Anuncio ultimoAnuncioCadastrado();
}
