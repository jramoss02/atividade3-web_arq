package com.example.atividade3.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(length = 200, nullable = false)
private String nome;
@ManyToOne
@JoinColumn(name = "funcionario_id")
private CategoriaFuncionario categoriaFuncionario;
}
