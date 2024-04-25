package com.example.atividade3.repositories;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.atividade3.models.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    //No repositório ProjetoRepository crie um método que passamos o ID do
    //projeto e ele retornará os dados do projeto e a lista de funcionários
    //vinculados aquele projeto.
    @Query("SELECT p from Projeto p LEFT JOIN FETCH p.funcionarios p WHERE p.id = :id")
    Projeto findProjetoFetchFuncionarios(@Param("id") Long id);


    //No repositório ProjetoRepository crie um método que passamos uma data
    //de início e fim e é retornado todos os projetos que iniciam entre as datas
    //informadas.
    List<Projeto> findByDataFimBetween(LocalDate dataFim);

    List<Projeto> buscarProjetosPorDataInicioFim(LocalDate dataInicio, LocalDate dataFim);
}

