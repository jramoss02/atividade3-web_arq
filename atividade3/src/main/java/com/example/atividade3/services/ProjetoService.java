package com.example.atividade3.services; // Declaração do pacote onde a classe está localizada

import java.time.LocalDate; // Importação da classe LocalDate para lidar com datas
import java.util.HashSet; // Importação da classe HashSet para representar um conjunto sem duplicatas
import java.util.List; // Importação da classe List para representar uma lista de elementos
import java.util.NoSuchElementException; // Importação da classe NoSuchElementException para lidar com exceções de elementos não encontrados
import java.util.Set; // Importação da classe Set para representar um conjunto de elementos

import org.springframework.beans.factory.annotation.Autowired; // Importação da anotação @Autowired do Spring Framework
import org.springframework.stereotype.Service; // Importação da anotação @Service do Spring Framework

import com.example.atividade3.models.Funcionario; // Importação da classe Funcionario
import com.example.atividade3.models.Projeto; // Importação da classe Projeto
import com.example.atividade3.repositories.FuncionarioRepository; // Importação do repositório FuncionarioRepository
import com.example.atividade3.repositories.ProjetoRepository; // Importação do repositório ProjetoRepository

@Service // Anotação que indica que essa classe é um serviço gerenciado pelo Spring
public class ProjetoService { // Declaração da classe ProjetoService

    @Autowired // Anotação para injeção de dependência do repositório ProjetoRepository
    private ProjetoRepository projetoRepository;

    @Autowired // Anotação para injeção de dependência do repositório FuncionarioRepository
    private FuncionarioRepository funcionarioRepository;

    public void criarProjeto(Projeto projetoDTO) { // Método para criar um novo projeto
        Projeto projeto = new Projeto(); // Cria um novo objeto Projeto

        // Define os atributos do projeto com base nos dados recebidos no DTO
        projeto.setDescricao(projetoDTO.getDescricao());
        projeto.setDataInicio(projetoDTO.getDataInicio());
        projeto.setDataFim(projetoDTO.getDataFim());

        Set<Funcionario> funcionarios = new HashSet<>(); // Cria um conjunto para armazenar os funcionários associados ao projeto

        // Itera sobre os IDs dos funcionários recebidos no DTO e busca cada funcionário no banco de dados
        projetoDTO.getFuncionarios().forEach(idFuncionario -> {
            Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
                    .orElseThrow(); // Obtém o funcionário pelo ID e lança uma exceção se não for encontrado
            funcionarios.add(funcionario); // Adiciona o funcionário ao conjunto de funcionários
        });

        projeto.setFuncionarios(funcionarios); // Define os funcionários associados ao projeto
        projetoRepository.save(projeto); // Salva o projeto no banco de dados
    }

    public Projeto buscarProjetoPorId(Long id) { // Método para buscar um projeto pelo ID
        return projetoRepository.findById(id) // Busca o projeto pelo ID no repositório
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado com o id fornecido")); // Lança uma exceção se o projeto não for encontrado
    }

    public List<Projeto> buscarProjetosPorDataInicioFim(LocalDate dataInicio, LocalDate dataFim) { // Método para buscar projetos por intervalo de datas
        return projetoRepository.buscarProjetosPorDataInicioFim(dataInicio, dataFim); // Busca projetos no repositório por data de início e data de término
    }

    public void vincularFuncionario(Long idProjeto, Long idFuncionario) { // Método para vincular um funcionário a um projeto
        Projeto projeto = buscarProjetoPorId(idProjeto); // Busca o projeto pelo ID

        Funcionario funcionario = new Funcionario(); // Cria um novo objeto Funcionario
        funcionario.setId(idFuncionario); // Define o ID do funcionário

        funcionario = funcionarioRepository.findById(funcionario) // Busca o funcionário pelo ID no repositório
                .orElseThrow(() -> new NoSuchElementException("Funcionário não encontrado com o ID: " + idFuncionario)); // Lança uma exceção se o funcionário não for encontrado

        projeto.getFuncionarios().add(funcionario); // Adiciona o funcionário ao projeto
        projetoRepository.save(projeto); // Salva o projeto no banco de dados
    }
}
