package com.example.atividade3.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.atividade3.dtos.DadosFuncionarioDTO;
import com.example.atividade3.dtos.FuncionarioDTO;
import com.example.atividade3.models.Funcionario;

@Service
public interface FuncionarioService {
    List<DadosFuncionarioDTO> findAll();

    Funcionario create(FuncionarioDTO funcionario);

    DadosFuncionarioDTO findById(Long id);

    void delete(Long id);

    Funcionario update(Long id, FuncionarioDTO funcionario);
}