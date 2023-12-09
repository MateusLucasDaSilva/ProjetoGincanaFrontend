package br.edu.ifba.frontend.tela;

import lombok.Data;

@Data
public class CriterioTelaModel {

	private Integer id_Criterio;
	private String nome_Criterio;
	private Integer pontuacao_min_Criterio;
	private Integer pontuacao_max_Criterio;
	private Integer evento;

	public CriterioTelaModel() {
		super();
	}

	public CriterioTelaModel(Integer id_Criterio, String nome_Criterio, Integer pontuacao_min_Criterio,
			Integer pontuacao_max_Criterio, Integer evento) {
		super();
		this.id_Criterio = id_Criterio;
		this.nome_Criterio = nome_Criterio;
		this.pontuacao_min_Criterio = pontuacao_min_Criterio;
		this.pontuacao_max_Criterio = pontuacao_max_Criterio;
		this.evento = evento;
	}

	public Integer getId_Criterio() {
		return id_Criterio;
	}

	public void setId_Criterio(Integer id_Criterio) {
		this.id_Criterio = id_Criterio;
	}

	public String getNome_Criterio() {
		return nome_Criterio;
	}

	public void setNome_Criterio(String nome_Criterio) {
		this.nome_Criterio = nome_Criterio;
	}

	public Integer getPontuacao_min_Criterio() {
		return pontuacao_min_Criterio;
	}

	public void setPontuacao_min_Criterio(Integer pontuacao_min_Criterio) {
		this.pontuacao_min_Criterio = pontuacao_min_Criterio;
	}

	public Integer getPontuacao_max_Criterio() {
		return pontuacao_max_Criterio;
	}

	public void setPontuacao_max_Criterio(Integer pontuacao_max_Criterio) {
		this.pontuacao_max_Criterio = pontuacao_max_Criterio;
	}

	public Integer getEvento() {
		return evento;
	}

	public void setEvento(Integer evento) {
		this.evento = evento;
	}

	@Override
	public String toString() {
		return "CriterioTelaModel [id_Criterio=" + id_Criterio + ", nome_Criterio=" + nome_Criterio
				+ ", pontuacao_min_Criterio=" + pontuacao_min_Criterio + ", pontuacao_max_Criterio="
				+ pontuacao_max_Criterio + ", evento=" + evento + "]";
	}

}
