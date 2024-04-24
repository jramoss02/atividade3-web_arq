package com.example.atividade3.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.atividade3.dtos.DadosSetorDTO;
import com.example.atividade3.dtos.SetorDTO;
import com.example.atividade3.models.Setor;

@Service
public interface SetorService {
    List<DadosSetorDTO> findAll();

    Setor create(SetorDTO setor);

    DadosSetorDTO findById(Long id);

    void delete(Long id);

    Setor update(Long id, SetorDTO setor);
}