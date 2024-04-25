package com.example.atividade3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.atividade3.dtos.DadosProjetoDTO;
import com.example.atividade3.dtos.FuncionarioDTO;
import com.example.atividade3.models.Projeto;
import com.example.atividade3.services.FuncionarioService;
import com.example.atividade3.services.ProjetoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private ProjetoService projetoService;

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionar(@RequestBody FuncionarioDTO funcionarioDTO) {
        funcionarioService.adicionarFuncionario(funcionarioDTO);
    }

    @GetMapping("/{idFuncionario}/projetos")
    public ResponseEntity<List<DadosProjetoDTO>> buscarProjetos(@PathVariable Long idFuncionario) {
        List<Projeto> projetos = projetoService.buscarProjetoPorId(idFuncionario);
        List<DadosProjetoDTO> dadosProjetosDTO = projetos.stream()
                .map(projeto -> new DadosProjetoDTO(projeto))
                .collect(Collectors.toList());
        return ResponseEntity.ok(dadosProjetosDTO);
    }
}
