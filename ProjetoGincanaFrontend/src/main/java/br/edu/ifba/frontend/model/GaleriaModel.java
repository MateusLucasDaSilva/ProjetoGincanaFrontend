package br.edu.ifba.frontend.model;

import lombok.Data;

@Data
public class GaleriaModel {

	private Integer id_Galeria;
	private String nome_Galeria;
	private String descricao_Galeria;
	private GincanaModel gincana;

	public GaleriaModel() {
		super();
	}

	public GaleriaModel(Integer id_Galeria, String nome_Galeria, String descricao_Galeria, GincanaModel gincana) {
		super();
		this.id_Galeria = id_Galeria;
		this.nome_Galeria = nome_Galeria;
		this.descricao_Galeria = descricao_Galeria;
		this.gincana = gincana;
	}

	public Integer getId_Galeria() {
		return id_Galeria;
	}

	public void setId_Galeria(Integer id_Galeria) {
		this.id_Galeria = id_Galeria;
	}

	public String getNome_Galeria() {
		return nome_Galeria;
	}

	public void setNome_Galeria(String nome_Galeria) {
		this.nome_Galeria = nome_Galeria;
	}

	public String getDescricao_Galeria() {
		return descricao_Galeria;
	}

	public void setDescricao_Galeria(String descricao_Galeria) {
		this.descricao_Galeria = descricao_Galeria;
	}

	public GincanaModel getGincana() {
		return gincana;
	}

	public void setGincana(GincanaModel gincana) {
		this.gincana = gincana;
	}

	@Override
	public String toString() {
		return "GaleriaModel [id_Galeria=" + id_Galeria + ", nome_Galeria=" + nome_Galeria + ", descricao_Galeria="
				+ descricao_Galeria + ", gincana=" + gincana + "]";
	}

}
