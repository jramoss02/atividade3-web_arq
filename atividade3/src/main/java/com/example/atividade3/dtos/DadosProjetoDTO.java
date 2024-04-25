package com.example.atividade3.dtos; // Declaração do pacote onde a classe está localizada

import java.time.LocalDate; // Importação da classe LocalDate para lidar com datas
import java.util.List; // Importação da classe List para representar uma lista de elementos
import java.util.stream.Collectors; // Importação da classe Collectors para realizar operações de coleção em streams

import com.example.atividade3.models.Projeto; // Importação da classe Projeto do pacote com.example.atividade3.models

public class DadosProjetoDTO { // Declaração da classe DadosProjetoDTO

    private Integer id; // Declaração do campo id do tipo Integer
    private String descricao; // Declaração do campo descricao do tipo String
    private LocalDate dataInicio; // Declaração do campo dataInicio do tipo LocalDate para representar a data de início do projeto
    private LocalDate dataFim; // Declaração do campo dataFim do tipo LocalDate para representar a data de término do projeto
    private List<DadosFuncionarioDTO> funcionarios; // Declaração do campo funcionarios do tipo List<DadosFuncionarioDTO>, representando os funcionários que estão envolvidos no projeto

    // Construtor padrão sem argumentos
    public DadosProjetoDTO() {
    }

    // Construtor que recebe um objeto Projeto e inicializa os campos do DTO
    public DadosProjetoDTO(Projeto projeto) { 
        this.id = projeto.getId(); // Atribuição do id do projeto ao id do DTO
        this.descricao = projeto.getDescricao(); // Atribuição da descrição do projeto à descrição do DTO
        this.dataInicio = projeto.getDataInicio(); // Atribuição da data de início do projeto à data de início do DTO
        this.dataFim = projeto.getDataFim(); // Atribuição da data de término do projeto à data de término do DTO
        // Mapeamento dos funcionários do projeto para objetos DadosFuncionarioDTO e coleta em uma lista
        this.funcionarios = projeto.getFuncionarios().stream() 
                .map(funcionario -> new DadosFuncionarioDTO(funcionario)) // Mapeamento de cada funcionário para um objeto DadosFuncionarioDTO
                .collect(Collectors.toList()); // Coleta dos objetos em uma lista
    }
}
