package com.example.atividade3.services;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividade3.models.Funcionario;
import com.example.atividade3.models.Projeto;
import com.example.atividade3.repositories.FuncionarioRepository;
import com.example.atividade3.repositories.ProjetoRepository;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void criarProjeto(Projeto projetoDTO) {
        Projeto projeto = new Projeto();
        projeto.setDescricao(projetoDTO.getDescricao());
        projeto.setDataInicio(projetoDTO.getDataInicio());
        projeto.setDataFim(projetoDTO.getDataFim());

        Set<Funcionario> funcionarios = new HashSet<>();
        projetoDTO.getFuncionarios().forEach(idFuncionario -> {
            Funcionario funcionario = funcionarioRepository.findById(idFuncionario).orElseThrow();
            funcionarios.add(funcionario);
        });

        projeto.setFuncionarios(funcionarios);
        projetoRepository.save(projeto);
    }

    public Projeto buscarProjetoPorId(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado com o id fornecido"));
    }

    public List<Projeto> buscarProjetosPorDataInicioFim(LocalDate dataInicio, LocalDate dataFim) {
        return projetoRepository.buscarProjetosPorDataInicioFim(dataInicio, dataFim);
    }

    public void vincularFuncionario(Long idProjeto, Long idFuncionario) {
        Projeto projeto = buscarProjetoPorId(idProjeto);
        Funcionario funcionario = new Funcionario();

        funcionario.setId(idFuncionario);
        funcionario = funcionarioRepository.findById(funcionario).orElseThrow(() -> new NoSuchElementException("Funcionário não encontrado com o ID: " + idFuncionario));
    
        projeto.getFuncionarios().add(funcionario);
        projetoRepository.save(projeto);
    }
}

