package br.edu.ifba.frontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CursoModel {
	private Integer id_Curso;
	private String nome_Curso;
	private String modalidade_Curso;

	public CursoModel() {
		super();
	}

	public CursoModel(Integer id_Curso, String nome_Curso, String modalidade_Curso) {
		super();
		this.id_Curso = id_Curso;
		this.nome_Curso = nome_Curso;
		this.modalidade_Curso = modalidade_Curso;
	}

	public Integer getId_Curso() {
		return id_Curso;
	}

	public void setId_Curso(Integer id_Curso) {
		this.id_Curso = id_Curso;
	}

	public String getNome_Curso() {
		return nome_Curso;
	}

	public void setNome_Curso(String nome_Curso) {
		this.nome_Curso = nome_Curso;
	}

	public String getModalidade_Curso() {
		return modalidade_Curso;
	}

	public void setModalidade_Curso(String modalidade_Curso) {
		this.modalidade_Curso = modalidade_Curso;
	}

	@Override
	public String toString() {
		return "CursoModel [id_Curso=" + id_Curso + ", nome_Curso=" + nome_Curso + ", modalidade_Curso="
				+ modalidade_Curso + "]";
	}

}