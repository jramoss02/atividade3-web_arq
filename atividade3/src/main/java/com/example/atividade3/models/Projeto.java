package com.example.atividade3.models;

import java.sql.Date;

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
public class Projeto {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(length = 200, nullable = false)
private String descricao;
@Column(nullable = false)
private Date dataInicio;
@Column(nullable = false)
private Date dataFim;
@ManyToOne
@JoinColumn(name = "projeto_id")
private CategoriaProjeto categoriaProjeto;
}
