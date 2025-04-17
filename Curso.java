package com.example.isajeronymo.Entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_curso")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //ter independencia entre as tabelas
	private Long id;
	
	private String nomeCurso;
	
	//fazer requisições a servidores
	@ManyToMany(mappedBy = "curso", fetch = FetchType.LAZY) //classe curso vai cuidar da chave estrangeira
	private List<Aluno> alunos; //chamando/ligacao com a classe aluno

	//construtores
	
	//sem parametro
	public Curso() {
		
	}
	
	//com parametro
	public Curso(Long id, String nomeCurso, List<Aluno> alunos) {
		super();
		this.id = id;
		this.nomeCurso = nomeCurso;
		this.alunos = alunos;
	}

	//metodos get e set
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
	
	
	
}
