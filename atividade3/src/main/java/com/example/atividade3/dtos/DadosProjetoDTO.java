package com.example.atividade3.dtos;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.example.atividade3.models.Projeto;

public class DadosProjetoDTO {

    private Integer id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<DadosFuncionarioDTO> funcionarios;

    public DadosProjetoDTO() {
    }

    public DadosProjetoDTO(Projeto projeto) {
        this.id = projeto.getId();
        this.descricao = projeto.getDescricao();
        this.dataInicio = projeto.getDataInicio();
        this.dataFim = projeto.getDataFim();
        this.funcionarios = projeto.getFuncionarios().stream()
                .map(funcionario -> new DadosFuncionarioDTO(funcionario))
                .collect(Collectors.toList());
    }
}
