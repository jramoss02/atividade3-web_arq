package com.example.atividade3.services;

import org.springframework.stereotype.Service;
import com.example.atividade3.dtos.CategoriaCursoDTO;
import com.example.atividade3.models.CategoriaCurso;
import com.example.atividade3.repositories.CategoriaCursoRepository;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CategoriaCursoServiceImpl implements CategoriaCursoService {
private final CategoriaCursoRepository categoriaCursoRepository;
@Override
public CategoriaCurso salvar(CategoriaCursoDTO dto) {
CategoriaCurso categ = new CategoriaCurso();
categ.setNome(dto.getNome());
return categoriaCursoRepository.save(categ);
}
}