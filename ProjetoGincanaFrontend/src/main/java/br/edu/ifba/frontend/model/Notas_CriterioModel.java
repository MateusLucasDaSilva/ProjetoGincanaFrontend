package br.edu.ifba.frontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notas_CriterioModel {

	private Integer nota_criterio;
	private CriterioModel criterio;
	private EquipeModel equipe;

	public Integer getNota_criterio() {
		return nota_criterio;
	}

	public void setNota_criterio(Integer nota_criterio) {
		this.nota_criterio = nota_criterio;
	}

	public CriterioModel getCriterio() {
		return criterio;
	}

	public void setCriterio(CriterioModel criterio) {
		this.criterio = criterio;
	}

	public EquipeModel getEquipe() {
		return equipe;
	}

	public void setEquipe(EquipeModel equipe) {
		this.equipe = equipe;
	}

	@Override
	public String toString() {
		return "Notas_CriterioModel [nota_criterio=" + nota_criterio + ", criterio=" + criterio + ", equipe=" + equipe
				+ "]";
	}

}
