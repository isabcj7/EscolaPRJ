package com.example.isajeronymo.Entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_aluno")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nomeAluno;
	
	@ManyToMany(fetch = FetchType.LAZY) //criacao da tabela de juncao - sem mapeamento
	@JoinTable(name = "tb_aluno_curso", //nome da tabela
	joinColumns = @JoinColumn(name = "aluno_id"), 
	inverseJoinColumns = @JoinColumn(name = "curso_id")) 
	private List<Curso> curso; 
	
	//construtores
	private Aluno () {
		
	}

	public Aluno(Long id, String nomeAluno, List<Curso> curso) {
		super();
		this.id = id;
		this.nomeAluno = nomeAluno;
		this.curso = curso;
	}

	//metodos get e set
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public List<Curso> getCurso() {
		return curso;
	}

	public void setCurso(List<Curso> curso) {
		this.curso = curso;
	}
	
}
