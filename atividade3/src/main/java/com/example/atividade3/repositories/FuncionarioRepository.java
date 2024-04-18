package com.example.atividade3.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.atividade3.models.Funcionario;
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
List<Funcionario> findByNomeLike(String nome);
}
