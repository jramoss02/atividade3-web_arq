package com.example.atividade3.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255, nullable = false)
    @NonNull
    private String descricao;

    @Column(nullable = false)
    @NonNull
    private LocalDate dataInicio;

    @Column(nullable = false)
    @NonNull
    private LocalDate dataFim;

    @ManyToMany(mappedBy = "projetos")
    private Set<Funcionario> funcionarios;

    @ManyToMany(mappedBy = "projetos")
    private List<Funcionario> functionarios;
}