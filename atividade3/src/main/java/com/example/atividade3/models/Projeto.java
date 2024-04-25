package com.example.atividade3.models; // Declaração do pacote onde a classe está localizada

import java.time.LocalDate; // Importação da classe LocalDate para lidar com datas
import java.util.List; // Importação da classe List para representar uma lista de elementos
import java.util.Set; // Importação da classe Set para representar um conjunto de elementos

import jakarta.persistence.Column; // Importação das anotações do JPA para mapeamento de entidades
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Projeto { // Declaração da classe Projeto
    
    @Id // Anotação que indica que esse campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotação que especifica que o valor do campo será gerado automaticamente pelo banco de dados
    private Integer id; // Declaração do campo id do tipo Integer

    @Column(length = 255, nullable = false) // Anotação que especifica que esse campo é uma coluna no banco de dados com tamanho máximo de 255 caracteres e não pode ser nulo
    @NonNull // Anotação Lombok para indicar que esse campo não pode ser nulo
    private String descricao; // Declaração do campo descricao do tipo String

    @Column(nullable = false) // Anotação que especifica que esse campo é uma coluna no banco de dados e não pode ser nulo
    @NonNull // Anotação Lombok para indicar que esse campo não pode ser nulo
    private LocalDate dataInicio; // Declaração do campo dataInicio do tipo LocalDate para representar a data de início do projeto

    @Column(nullable = false) // Anotação que especifica que esse campo é uma coluna no banco de dados e não pode ser nulo
    @NonNull // Anotação Lombok para indicar que esse campo não pode ser nulo
    private LocalDate dataFim; // Declaração do campo dataFim do tipo LocalDate para representar a data de término do projeto

    @ManyToMany(mappedBy = "projetos") // Anotação que especifica que essa é uma associação Many-to-Many com a entidade Funcionario, indicando que o mapeamento é feito pelo atributo 'projetos' na classe Funcionario
    private Set<Funcionario> funcionarios; // Declaração do campo funcionarios do tipo Set<Funcionario>, representando os funcionários que estão envolvidos no projeto

    @ManyToMany(mappedBy = "projetos") // Anotação que especifica que essa é uma associação Many-to-Many com a entidade Funcionario, indicando que o mapeamento é feito pelo atributo 'projetos' na classe Funcionario
    private List<Funcionario> functionarios; // Declaração do campo functionarios do tipo List<Funcionario>, representando os funcionários que estão envolvidos no projeto
}
