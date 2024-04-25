package com.example.atividade3.dtos; // Declaração do pacote onde a classe está localizada

import lombok.AllArgsConstructor; // Importação da anotação Lombok @AllArgsConstructor para gerar um construtor com todos os argumentos
import lombok.Data; // Importação da anotação Lombok @Data para gerar automaticamente métodos como getters, setters, toString, equals, hashCode
import lombok.NoArgsConstructor; // Importação da anotação Lombok @NoArgsConstructor para gerar um construtor sem argumentos

@Data // Anotação Lombok para gerar automaticamente métodos como getters, setters, toString, equals, hashCode
@NoArgsConstructor // Anotação Lombok para gerar um construtor sem argumentos
@AllArgsConstructor // Anotação Lombok para gerar um construtor com todos os argumentos
public class FuncionarioDTO { // Declaração da classe FuncionarioDTO
    
    private Long id; // Declaração do campo id do tipo Long
    private String nome; // Declaração do campo nome do tipo String
    private Long setorId; // Declaração do campo setorId do tipo Long, que representa o ID do setor ao qual o funcionário está associado
}
