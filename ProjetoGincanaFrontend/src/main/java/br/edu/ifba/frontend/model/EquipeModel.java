package br.edu.ifba.frontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipeModel {

	private Integer id_Equipe;
	private String nome_Equipe;
	private String descricao_Equipe;
	private GincanaModel gincana;
	private CursoModel curso;
	private UsuarioModel usuario;

	public EquipeModel() {
		super();
	}

	public EquipeModel(Integer id_Equipe, String nome_Equipe, String descricao_Equipe, GincanaModel gincana,
			CursoModel curso, UsuarioModel usuario) {
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

	public GincanaModel getGincana() {
		return gincana;
	}

	public void setGincana(GincanaModel gincana) {
		this.gincana = gincana;
	}

	public CursoModel getCurso() {
		return curso;
	}

	public void setCurso(CursoModel curso) {
		this.curso = curso;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "EquipeModel [id_Equipe=" + id_Equipe + ", nome_Equipe=" + nome_Equipe + ", descricao_Equipe="
				+ descricao_Equipe + ", gincana=" + gincana + ", curso=" + curso + ", usuario=" + usuario + "]";
	}

}