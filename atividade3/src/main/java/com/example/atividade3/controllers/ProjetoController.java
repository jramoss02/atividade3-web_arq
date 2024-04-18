package com.example.atividade3.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.atividade3.dtos.CursoDTO;
import com.example.atividade3.dtos.DadosCursoDTO;
import com.example.atividade3.dtos.ProjetoDTO;
import com.example.atividade3.models.Curso;
import com.example.atividade3.models.Projeto;
import com.example.atividade3.services.CursoService;
import com.example.atividade3.services.ProjetoService;

import java.util.List;
@RestController
@RequestMapping("/api/curso")
public class ProjetoController {
private CursoService cursoService;
public ProjetoController(CursoService cursoService) {
    this.cursoService = cursoService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Projeto salvar(@RequestBody ProjetoDTO ProjetoDTO) {
    Projeto p = ProjetoService.salvar(ProjetoDTO);
    return p;
    }
    @GetMapping("{id}")
    public Projeto getProjetoPorId(@PathVariable Long id) {
    return ProjetoService.obterProjetoPorId(id);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCurso(@PathVariable Long id) {
    cursoService.remover(id);
    }
    @PutMapping("{id}")
    public void editCurso(@PathVariable Long id, @RequestBody CursoDTO dto) {
    cursoService.editar(id, dto);
    }
    @GetMapping
    public List<DadosCursoDTO> getCursos() {
    return cursoService.obterTodos();
    }
}