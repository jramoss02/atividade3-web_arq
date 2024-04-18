package com.example.atividade3.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.example.atividade3.dtos.ProjetoDTO;
import com.example.atividade3.dtos.FuncionarioDTO;
import com.example.atividade3.dtos.SetorDTO;
import com.example.atividade3.exceptions.RegraNegocioException;
import com.example.atividade3.models.CategoriaFuncionario;
import com.example.atividade3.models.CategoriaSetor;
import com.example.atividade3.models.CategoriaProjeto;
import com.example.atividade3.models.Projeto;
import com.example.atividade3.models.Setor;
import com.example.atividade3.models.Funcionario;
import com.example.atividade3.repositories.ProjetoRepository;
import com.example.atividade3.repositories.SetorRepository;
import com.example.atividade3.repositories.FuncionarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ProjetoServiceImpl implements ProjetoService {
private final ProjetoRepository ProjetoRepository;
private final SetorRepository SetorRepository;
private final FuncionarioRepository FuncionarioRepository;
@Override
@Transactional
public Projeto salvar(ProjetoDTO ProjetoDTO) {
CategoriaProjeto categ = ProjetoRepository
.findById(ProjetoDTO.getProjetoId())
.orElseThrow(() -> new RegraNegocioException("Categoria não encontrada"));
Projeto projeto = new Projeto();
Projeto.setNome(ProjetoDTO.getNome());
Projeto.SetDataInicio(ProjetoDTO.getDataInicio());
Projeto.SetDataFim(ProjetoDTO.getDataFim());
return ProjetoRepository.save(Projeto);
}
@Override
public DadosCursoDTO obterCursoPorId(Long id) {
return cursoRepository.findById(id).map((Curso c) -> {
return DadosCursoDTO.builder()
.id(c.getId())
.nome(c.getNome())
.cargaHoraria(c.getCargaHoraria())
.categoria(CategoriaCursoDTO.builder()
.id(c.getCategoriaCurso().getId())
.nome(c.getCategoriaCurso().getNome())
.build())
.build();
}).orElseThrow(() -> new RegraNegocioException("Curso não encontrado."));
}
@Override
@Transactional
public void remover(Long id) {
cursoRepository.deleteById(id);
}
@Override
@Transactional
public void editar(Long id, CursoDTO cursoDto) {
Curso curso = cursoRepository.findById(id)
.orElseThrow(() -> new RegraNegocioException("Curso não encontrado"));
CategoriaCurso categoria = categoriaCursoRepository.findById(
cursoDto.getCategoriaCursoId())
.orElseThrow(() -> new RegraNegocioException("Categoria não encontrada"));
curso.setNome(cursoDto.getNome());
curso.setCargaHoraria(cursoDto.getCargaHoraria());
curso.setCategoriaCurso(categoria);
cursoRepository.save(curso);
}
@Override
public List<DadosCursoDTO> obterTodos() {
return cursoRepository.findAll().stream().map((Curso c) -> {
return DadosCursoDTO.builder()
.id(c.getId())
.nome(c.getNome())
.cargaHoraria(c.getCargaHoraria())
.categoria(CategoriaCursoDTO.builder()
.id(c.getCategoriaCurso().getId())
.nome(c.getCategoriaCurso().getNome())
.build())
.build();
}).collect(Collectors.toList());
}
@Override
public Projeto salvar(ProjetoDTO projetoDTO) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'salvar'");
}
@Override
public ProjetoDTO obterProjetoPorId(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'obterProjetoPorId'");
}
@Override
public void editar(Long id, ProjetoDTO ProjetoDTO) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'editar'");
}
}