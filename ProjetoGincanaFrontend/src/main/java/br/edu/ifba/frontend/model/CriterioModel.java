package br.edu.ifba.frontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CriterioModel {

	private Integer id_Criterio;
	private String nome_Criterio;
	private Integer pontuacao_min_Criterio;
	private Integer pontuacao_max_Criterio;
	private EventoModel evento;

	public CriterioModel() {
		super();
	}

	public CriterioModel(Integer id_Criterio, String nome_Criterio, Integer pontuacao_min_Criterio,
			Integer pontuacao_max_Criterio, EventoModel evento) {
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

	public EventoModel getEvento() {
		return evento;
	}

	public void setEvento(EventoModel evento) {
		this.evento = evento;
	}

	@Override
	public String toString() {
		return "CriterioModel [id_Criterio=" + id_Criterio + ", nome_Criterio=" + nome_Criterio
				+ ", pontuacao_min_Criterio=" + pontuacao_min_Criterio + ", pontuacao_max_Criterio="
				+ pontuacao_max_Criterio + ", evento=" + evento + "]";
	}

}