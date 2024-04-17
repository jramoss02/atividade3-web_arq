package com.example.atividade3.models;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriaSetor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String nome;
private int cargaHoraria;
@OneToMany(mappedBy = "categoriaFuncionario")
private List<Setor> Setor;
@Override
public String toString() {
return "CategoriaFuncionario [id=" + id + ", nome=" + nome + ", cargaHoraria=" + cargaHoraria +"]";
}
}