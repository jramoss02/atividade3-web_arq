package com.example.atividade3.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.atividade3.models.Projeto;
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
List<Projeto> findByNomeLike(String nome);
}
