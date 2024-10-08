package _Desk.Thy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import _Desk.Thy.entity.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long>{
    @Query("select t from Trabalho t where t.nota = ?1")
    public List<Trabalho> buscarPorNota(Integer nota);
}
