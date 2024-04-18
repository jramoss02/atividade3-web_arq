package com.example.atividade3.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.atividade3.models.Setor;
public interface SetorRepository extends JpaRepository<Setor, Long> {
List<Setor> findByNomeLike(String nome);
}
