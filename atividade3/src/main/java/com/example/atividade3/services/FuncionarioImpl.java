package com.example.atividade3.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.atividade3.dtos.DadosFuncionarioDTO;
import com.example.atividade3.dtos.DadosProjetoDTO;
import com.example.atividade3.dtos.DadosSetorDTO;
import com.example.atividade3.dtos.FuncionarioDTO;
import com.example.atividade3.models.Funcionario;
import com.example.atividade3.models.Setor;
import com.example.atividade3.repositories.FuncionarioRepository;
import com.example.atividade3.repositories.SetorRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuncionarioImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final SetorRepository setorRepository;

    @Override
    public List<DadosFuncionarioDTO> findAll() {
        return funcionarioRepository.findAll()
                .stream()
                .map(this::toDadosFuncionarioDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Funcionario create(FuncionarioDTO funcionarioDTO) {
        validateFuncionarioDTO(funcionarioDTO);

        Setor setor = setorRepository.findById(funcionarioDTO.getSetorId())
                .orElseThrow(() -> new RuntimeException("Setor não encontrado"));

        Funcionario funcionario = new Funcionario();
        funcionario.setId(funcionarioDTO.getId());
        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setSetor(setor);

        return funcionarioRepository.save(funcionario);
    }

    @Override
    public DadosFuncionarioDTO findById(Long id) {
        return funcionarioRepository.findById(id)
                .map(this::toDadosFuncionarioDTO)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o id fornecido"));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Funcionario update(Long id, FuncionarioDTO funcionarioDTO) {
        validateFuncionarioDTO(funcionarioDTO);

        Funcionario funcionarioToUpdate = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o id fornecido"));

        Setor setor = setorRepository.findById(funcionarioDTO.getSetorId())
                .orElseThrow(() -> new RuntimeException("Setor não encontrado com o id fornecido"));

        funcionarioToUpdate.setNome(funcionarioDTO.getNome());
        funcionarioToUpdate.setSetor(setor);

        return funcionarioRepository.save(funcionarioToUpdate);
    }

    private void validateFuncionarioDTO(FuncionarioDTO funcionarioDTO) {
        if (funcionarioDTO.getNome() == null || funcionarioDTO.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do funcionário é obrigatório");
        }

        if (funcionarioDTO.getSetorId() == null) {
            throw new IllegalArgumentException("Id do setor é obrigatório");
        }
    }

    private DadosFuncionarioDTO toDadosFuncionarioDTO(Funcionario funcionario) {
        List<DadosProjetoDTO> projetosDTO = funcionario.getProjetos().stream()
                .map(projeto -> new DadosProjetoDTO(projeto))
                .collect(Collectors.toList());
    
        return DadosFuncionarioDTO.builder()
                .id(funcionario.getId())
                .nome(funcionario.getNome())
                .setor(new DadosSetorDTO(funcionario.getSetor()))
                .projetos(projetosDTO)
                .build();
    }

    @Override
    public void adicionarFuncionario(FuncionarioDTO funcionarioDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarFuncionario'");
    }
}
