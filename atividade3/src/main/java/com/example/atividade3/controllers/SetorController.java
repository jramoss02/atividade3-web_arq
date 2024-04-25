package com.example.atividade3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.atividade3.dtos.DadosSetorDTO;
import com.example.atividade3.dtos.SetorDTO;
import com.example.atividade3.models.Setor;
import com.example.atividade3.services.SetorService;

import java.util.Optional;

@RestController
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorService setorService;

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionar(@RequestBody SetorDTO setorDTO) {
        setorService.adicionarSetor(setorDTO);
    }

    @GetMapping("/{idSetor}")
    public ResponseEntity<DadosSetorDTO> buscarSetorPorId(@PathVariable Integer idSetor) {
        Optional<Setor> setorOptional = setorService.buscarSetorPorId(idSetor);
        if (setorOptional.isPresent()) {
            DadosSetorDTO dadosSetorDTO = new DadosSetorDTO(setorOptional.get());
            return ResponseEntity.ok(dadosSetorDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

