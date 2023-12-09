package br.edu.ifba.frontend.tela;

import lombok.Data;

@Data
public class EquipeTelaModel {

	private Integer id_Equipe;
	private String nome_Equipe;
	private String descricao_Equipe;
	private Integer gincana;
	private Integer curso;
	private Integer usuario;

	public EquipeTelaModel() {
		super();
	}

	public EquipeTelaModel(Integer id_Equipe, String nome_Equipe, String descricao_Equipe, Integer gincana,
			Integer curso, Integer usuario) {
		super();
		this.id_Equipe = id_Equipe;
		this.nome_Equipe = nome_Equipe;
		this.descricao_Equipe = descricao_Equipe;
		this.gincana = gincana;
		this.curso = curso;
		this.usuario = usuario;
	}

	public Integer getId_Equipe() {
		return id_Equipe;
	}

	public void setId_Equipe(Integer id_Equipe) {
		this.id_Equipe = id_Equipe;
	}

	public String getNome_Equipe() {
		return nome_Equipe;
	}

	public void setNome_Equipe(String nome_Equipe) {
		this.nome_Equipe = nome_Equipe;
	}

	public String getDescricao_Equipe() {
		return descricao_Equipe;
	}

	public void setDescricao_Equipe(String descricao_Equipe) {
		this.descricao_Equipe = descricao_Equipe;
	}

	public Integer getGincana() {
		return gincana;
	}

	public void setGincana(Integer gincana) {
		this.gincana = gincana;
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "EquipeTelaModel [id_Equipe=" + id_Equipe + ", nome_Equipe=" + nome_Equipe + ", descricao_Equipe="
				+ descricao_Equipe + ", gincana=" + gincana + ", curso=" + curso + ", usuario=" + usuario + "]";
	}

}
