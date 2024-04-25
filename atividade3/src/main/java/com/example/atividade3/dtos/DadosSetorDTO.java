package com.example.atividade3.dtos; // Declaração do pacote onde a classe está localizada

import com.example.atividade3.models.Setor; // Importação da classe Setor do pacote com.example.atividade3.models

import lombok.AllArgsConstructor; // Importação da anotação Lombok @AllArgsConstructor para gerar um construtor com todos os argumentos
import lombok.Data; // Importação da anotação Lombok @Data para gerar automaticamente métodos como getters, setters, toString, equals, hashCode
import lombok.NoArgsConstructor; // Importação da anotação Lombok @NoArgsConstructor para gerar um construtor sem argumentos

@Data // Anotação Lombok para gerar automaticamente métodos como getters, setters, toString, equals, hashCode
@NoArgsConstructor // Anotação Lombok para gerar um construtor sem argumentos
@AllArgsConstructor // Anotação Lombok para gerar um construtor com todos os argumentos
public class DadosSetorDTO { // Declaração da classe DadosSetorDTO
    
    private Long id; // Declaração do campo id do tipo Long
    private String nome; // Declaração do campo nome do tipo String

    // Construtor que recebe um objeto Setor e inicializa os campos do DTO
    public DadosSetorDTO(Setor setor) { 
        this.id = setor.getId(); // Atribuição do id do setor ao id do DTO
        this.nome = setor.getNome(); // Atribuição do nome do setor ao nome do DTO
    }
}
