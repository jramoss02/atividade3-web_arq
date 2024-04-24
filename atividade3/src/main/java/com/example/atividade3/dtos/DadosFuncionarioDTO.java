package com.example.atividade3.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.example.atividade3.models.Funcionario;
import com.example.atividade3.models.Projeto;
import com.example.atividade3.models.Setor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DadosFuncionarioDTO {
    private Long id;
    private String nome;
    private DadosSetorDTO setor;
    private List<DadosProjetoDTO> projetos;

    public DadosFuncionarioDTO(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.setor = new DadosSetorDTO(); 
        this.projetos = funcionario.getProjetos().stream()
                .map(projeto -> new DadosProjetoDTO(projeto))
                .collect(Collectors.toList());
    }
}