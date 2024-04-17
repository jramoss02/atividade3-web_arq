package com.example.atividade3.models;

import java.sql.Date;
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
public class CategoriaProjeto {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String descricao;
private Date dataInicio;
private Date dataFim;
@OneToMany(mappedBy = "categoriaProjeto")
private List<Projeto> projetos;
@Override
public String toString() {
return "Categoria Projeto [id=" + id + ", descricao=" + descricao +", dataInicio=" + dataInicio + " dataFim=" + dataFim + "]";
}
}