package com.example.atividade3.services;

import java.util.*;
import com.example.atividade3.dtos.CursoDTO;
import com.example.atividade3.dtos.DadosCursoDTO;
import com.example.atividade3.models.Curso;
public interface CursoService {
Curso salvar(CursoDTO cursoDTO);
DadosCursoDTO obterCursoPorId(Long id);
void remover(Long id);
void editar(Long id, CursoDTO cursoDto);
List<DadosCursoDTO> obterTodos();
}