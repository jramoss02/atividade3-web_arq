package com.example.atividade3.dtos; // Declaração do pacote onde a classe está localizada

import java.util.List; // Importação da classe List do pacote java.util
import java.util.stream.Collectors; // Importação da classe Collectors do pacote java.util.stream

import com.example.atividade3.models.Funcionario; // Importação da classe Funcionario do pacote com.example.atividade3.models

import lombok.*; // Importação das classes do projeto Lombok

@Data // Anotação Lombok para gerar automaticamente métodos como getters, setters, toString, equals, hashCode
@NoArgsConstructor // Anotação Lombok para gerar um construtor sem argumentos
@AllArgsConstructor // Anotação Lombok para gerar um construtor com todos os argumentos
@Builder // Anotação Lombok para gerar um construtor de construção
public class DadosFuncionarioDTO { // Declaração da classe DadosFuncionarioDTO
    
    private Long id; // Declaração do campo id do tipo Long
    private String nome; // Declaração do campo nome do tipo String
    private DadosSetorDTO setor; // Declaração do campo setor do tipo DadosSetorDTO
    private List<DadosProjetoDTO> projetos; // Declaração do campo projetos do tipo List<DadosProjetoDTO>, representando os projetos em que o funcionário está envolvido

    // Construtor que recebe um objeto Funcionario e inicializa os campos do DTO
    public DadosFuncionarioDTO(Funcionario funcionario) { 
        this.id = funcionario.getId(); // Atribuição do id do funcionário ao id do DTO
        this.nome = funcionario.getNome(); // Atribuição do nome do funcionário ao nome do DTO
        this.setor = new DadosSetorDTO(); // Inicialização de um novo objeto DadosSetorDTO para o campo setor do DTO
        // Mapeamento dos projetos do funcionário para objetos DadosProjetoDTO e coleta em uma lista
        this.projetos = funcionario.getProjetos().stream() 
                .map(projeto -> new DadosProjetoDTO(projeto)) // Mapeamento de cada projeto para um objeto DadosProjetoDTO
                .collect(Collectors.toList()); // Coleta dos objetos em uma lista
    }
}
