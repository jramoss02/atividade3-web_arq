package com.example.atividade3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.atividade3.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    @Query("SELECT f FROM Funcionario f LEFT JOIN FETCH f.projetos f WHERE f.id = :id")
    Funcionario findFuncionarioFetchProjetos(@Param("id") Long id);
}
