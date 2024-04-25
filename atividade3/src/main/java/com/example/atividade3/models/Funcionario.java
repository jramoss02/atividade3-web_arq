package com.example.atividade3.models; // Declaração do pacote onde a classe está localizada

import java.util.List; // Importação da classe List para representar uma lista de elementos

import jakarta.persistence.Column; // Importação das anotações do JPA para mapeamento de entidades
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter; // Importação das anotações Lombok para geração automática de getters, setters, toString, entre outros
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // Anotação que indica que essa classe é uma entidade JPA
@NoArgsConstructor // Anotação Lombok para gerar um construtor sem argumentos
@RequiredArgsConstructor // Anotação Lombok para gerar um construtor com todos os argumentos obrigatórios
@Getter // Anotação Lombok para gerar automaticamente um método getter para cada campo da classe
@Setter // Anotação Lombok para gerar automaticamente um método setter para cada campo da classe
@ToString // Anotação Lombok para gerar automaticamente um método toString para a classe
public class Funcionario { // Declaração da classe Funcionario

    @Id // Anotação que indica que esse campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotação que especifica que o valor do campo será gerado automaticamente pelo banco de dados
    private Long id; // Declaração do campo id do tipo Long

    @Column(length = 255, nullable = false) // Anotação que especifica que esse campo é uma coluna no banco de dados com tamanho máximo de 255 caracteres e não pode ser nulo
    @NonNull // Anotação Lombok para indicar que esse campo não pode ser nulo
    private String nome; // Declaração do campo nome do tipo String

    @ManyToOne // Anotação que especifica que essa é uma associação Many-to-One com a entidade Setor
    @JoinColumn(name = "setor_id") // Anotação que especifica o nome da coluna na tabela de banco de dados que representa essa associação
    private Setor setor; // Declaração do campo setor do tipo Setor, representando o setor ao qual o funcionário está associado

    @ManyToMany // Anotação que especifica que essa é uma associação Many-to-Many com a entidade Projeto
    @JoinTable(name = "funcionario_projeto", // Anotação que especifica o nome da tabela de associação no banco de dados
        joinColumns = @JoinColumn(name = "funcionario_id"), // Anotação que especifica o nome da coluna que referencia o funcionário na tabela de associação
        inverseJoinColumns = @JoinColumn(name = "projeto_id")) // Anotação que especifica o nome da coluna que referencia o projeto na tabela de associação
    private List<Projeto> projetos; // Declaração do campo projetos do tipo List<Projeto>, representando os projetos em que o funcionário está envolvido
}
