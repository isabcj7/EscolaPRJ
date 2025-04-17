package com.example.isajeronymo.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isajeronymo.Entities.Curso;
import com.example.isajeronymo.Repositories.CursoRepository;

@Service
public class CursoService {
	private final CursoRepository cursoRepository;
	
	@Autowired
	public CursoService(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}
	
	public Curso findCursoById(Long id) {
		Optional<Curso> curso = cursoRepository.findById(id);
		return curso.orElse(null);
	}
	
	public List<Curso> findAllCursos() {
		return cursoRepository.findAll();
	}
	
	public Curso saveCurso(Curso curso) {
		return cursoRepository.save(curso);
	}
}
