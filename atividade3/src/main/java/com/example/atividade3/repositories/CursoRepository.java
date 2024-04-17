package com.example.atividade3.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.atividade3.models.Curso;
public interface CursoRepository extends JpaRepository<Curso, Long> {
List<Curso> findByNomeLike(String nome);
}
