package com.example.atividade3.services;

import java.util.*;
import com.example.atividade3.dtos.ProjetoDTO;
import com.example.atividade3.models.Projeto;
public interface ProjetoService {
Projeto salvar(ProjetoDTO projetoDTO);
ProjetoDTO obterProjetoPorId(Long id);
void remover(Long id);
void editar(Long id, ProjetoDTO ProjetoDTO);
List<ProjetoDTO> obterTodos();
}