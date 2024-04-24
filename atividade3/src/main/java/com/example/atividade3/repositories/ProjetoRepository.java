package com.example.atividade3.repositories;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.atividade3.models.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    @Query("SELECT p from Projeto p LEFT JOIN FETCH p.funcionarios p WHERE p.id = :id")
    Projeto findProjetoFetchFuncionarios(@Param("id") Long id);
    
    List<Projeto> findByDataFimBetween(LocalDate dataFim);
}
