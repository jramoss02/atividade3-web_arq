package com.example.atividade3.dtos;

import com.example.atividade3.models.Setor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosSetorDTO {
    private Long id;
    private String nome;

    public DadosSetorDTO(Setor setor) {
        this.id = setor.getId();
        this.nome = setor.getNome();
    }
}