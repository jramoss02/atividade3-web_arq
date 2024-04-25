package com.example.atividade3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.atividade3.dtos.DadosProjetoDTO;
import com.example.atividade3.models.Projeto;
import com.example.atividade3.services.ProjetoService;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public void adicionarProjeto(@RequestBody Projeto projetoDTO) {
        projetoService.criarProjeto(projetoDTO);
    }

    @GetMapping("/{id}")
    public DadosProjetoDTO buscarProjetoPorId(@PathVariable Long id) {
        Projeto projeto = projetoService.buscarProjetoPorId(id);
        return new DadosProjetoDTO(projeto);
    }

    @PutMapping("/{id}/funcionarios/{idFuncionario}")
    public void vincularFuncionario(@PathVariable Integer idProjeto, @PathVariable Integer idFuncionario) {
        projetoService.vincularFuncionario(idProjeto, idFuncionario);
    }
}