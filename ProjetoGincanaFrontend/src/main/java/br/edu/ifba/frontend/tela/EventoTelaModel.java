package br.edu.ifba.frontend.tela;

import java.sql.Date;

import lombok.Data;

@Data
public class EventoTelaModel {

	private Integer id_Evento;
	private String nome_Evento;
	private String descricao_Evento;
	private String tipo_Evento;
	private Date data_Evento;
	private String horario_Evento;
	private String local_Evento;
	private Integer gincana;
	private Integer status;

	public EventoTelaModel() {
		super();
	}

	public EventoTelaModel(Integer id_Evento, String nome_Evento, String descricao_Evento, String tipo_Evento,
			Date data_Evento, String horario_Evento, String local_Evento, Integer gincana, Integer status) {
		super();
		this.id_Evento = id_Evento;
		this.nome_Evento = nome_Evento;
		this.descricao_Evento = descricao_Evento;
		this.tipo_Evento = tipo_Evento;
		this.data_Evento = data_Evento;
		this.horario_Evento = horario_Evento;
		this.local_Evento = local_Evento;
		this.gincana = gincana;
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

	public Integer getGincana() {
		return gincana;
	}

	public void setGincana(Integer gincana) {
		this.gincana = gincana;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "EventoTelaModel [id_Evento=" + id_Evento + ", nome_Evento=" + nome_Evento + ", descricao_Evento="
				+ descricao_Evento + ", tipo_Evento=" + tipo_Evento + ", data_Evento=" + data_Evento
				+ ", horario_Evento=" + horario_Evento + ", local_Evento=" + local_Evento + ", gincana=" + gincana
				+ ", status=" + status + "]";
	}

}
