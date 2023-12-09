package br.edu.ifba.frontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusModel {
	private Integer id_Status;
	private String situacao_Status;

	public StatusModel() {
		super();
	}

	public StatusModel(Integer id_Status, String situacao_Status) {
		super();
		this.id_Status = id_Status;
		this.situacao_Status = situacao_Status;
	}

	public Integer getId_Status() {
		return id_Status;
	}

	public void setId_Status(Integer id_Status) {
		this.id_Status = id_Status;
	}

	public String getSituacao_Status() {
		return situacao_Status;
	}

	public void setSituacao_Status(String situacao_Status) {
		this.situacao_Status = situacao_Status;
	}

	@Override
	public String toString() {
		return "StatusModel [id_Status=" + id_Status + ", situacao_Status=" + situacao_Status + "]";
	}
	
	

}