package com.example.atividade3.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.atividade3.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    //No repositório FuncionarioRepository crie um método que passamos o ID
    //do funcionário e é retornado todos os projetos em que ele está vinculado
    @Query("SELECT f FROM Funcionario f LEFT JOIN FETCH f.projetos f WHERE f.id = :id")
    Funcionario findFuncionarioFetchProjetos(@Param("id") Long id);

    Optional<Funcionario> findById(Funcionario idFuncionario);
}


