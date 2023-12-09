package br.edu.ifba.frontend.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoModel {

	private Integer id_Evento;
	private String nome_Evento;
	private String descricao_Evento;
	private String tipo_Evento;
	private Date data_Evento;
	private String horario_Evento;
	private String local_Evento;
	private GincanaModel gincana;
	private StatusModel status;

	public GincanaModel getGincana() {
		return gincana;
	}

	public void setGincana(GincanaModel gincana) {
		this.gincana = gincana;
	}

	public StatusModel getStatus() {
		return status;
	}

	public void setStatus(StatusModel status) {
		this.status = status;
	}

	public Integer getId_Evento() {
		return id_Evento;
	}

	public void setId_Evento(Integer id_Evento) {
		this.id_Evento = id_Evento;
	}

	public String getNome_Evento() {
		return nome_Evento;
	}

	public void setNome_Evento(String nome_Evento) {
		this.nome_Evento = nome_Evento;
	}

	public String getDescricao_Evento() {
		return descricao_Evento;
	}

	public void setDescricao_Evento(String descricao_Evento) {
		this.descricao_Evento = descricao_Evento;
	}

	public String getTipo_Evento() {
		return tipo_Evento;
	}

	public void setTipo_Evento(String tipo_Evento) {
		this.tipo_Evento = tipo_Evento;
	}

	public Date getData_Evento() {
		return data_Evento;
	}

	public void setData_Evento(Date data_Evento) {
		this.data_Evento = data_Evento;
	}

	public String getHorario_Evento() {
		return horario_Evento;
	}

	public void setHorario_Evento(String horario_Evento) {
		this.horario_Evento = horario_Evento;
	}

	public String getLocal_Evento() {
		return local_Evento;
	}

	public void setLocal_Evento(String local_Evento) {
		this.local_Evento = local_Evento;
	}

	@Override
	public String toString() {
		return "EventoModel [id_Evento=" + id_Evento + ", nome_Evento=" + nome_Evento + ", descricao_Evento="
				+ descricao_Evento + ", tipo_Evento=" + tipo_Evento + ", data_Evento=" + data_Evento
				+ ", horario_Evento=" + horario_Evento + ", local_Evento=" + local_Evento + ", gincana=" + gincana
				+ ", status=" + status + "]";
	}

}
