package com.example.atividade3.services;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividade3.models.Funcionario;
import com.example.atividade3.models.Projeto;
<<<<<<< Updated upstream
import com.example.atividade3.repositories.FuncionarioRepository;
import com.example.atividade3.repositories.ProjetoRepository;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void criarProjeto(ProjetoDTO projetoDTO) {
        Projeto projeto = new Projeto();
        projeto.setDescricao(projetoDTO.getDescricao());
        projeto.setDataInicio(projetoDTO.getDataInicio());
        projeto.setDataFim(projetoDTO.getDataFim());

        Set<Funcionario> funcionarios = new HashSet<>();
        projetoDTO.getIdsFuncionarios().forEach(idFuncionario -> {
            Funcionario funcionario = funcionarioRepository.findById(idFuncionario).orElseThrow();
            funcionarios.add(funcionario);
        });

        projeto.setFuncionarios(funcionarios);
        projetoRepository.save(projeto);
    }

    public Projeto buscarProjetoPorId(Integer id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado com o id fornecido"));
    }

    public List<Projeto> buscarProjetosPorDataInicioFim(LocalDate dataInicio, LocalDate dataFim) {
        return projetoRepository.buscarProjetosPorDataInicioFim(dataInicio, dataFim);
    }

    public void vincularFuncionario(Integer idProjeto, Integer idFuncionario) {
        Projeto projeto = buscarProjetoPorId(idProjeto);
        Funcionario funcionario = funcionarioRepository.findById(idFuncionario).orElseThrow();

        projeto.getFuncionarios().add(funcionario);
        projetoRepository.save(projeto);
    }
}

=======
public interface ProjetoService {
    Projeto salvar(ProjetoDTO projetoDTO);
    ProjetoDTO obterProjetoPorId(Long id);
    void remover(Long id);
    void editar(Long id, ProjetoDTO ProjetoDTO);
    List<ProjetoDTO> obterTodos();
}
>>>>>>> Stashed changes
