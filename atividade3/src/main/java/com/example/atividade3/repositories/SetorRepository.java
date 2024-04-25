package com.example.atividade3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.atividade3.models.Setor;

public interface SetorRepository extends JpaRepository<Setor, Long> {
    //No repositório SetorRepository crie um método que lista todos os setores
    //com os funcionários vinculados a cada setor.
    @Query("SELECT s FROM Setor s LEFT JOIN FETCH s.funcionarios s")
    List<Setor> findAllFetchFuncionarios();
}
