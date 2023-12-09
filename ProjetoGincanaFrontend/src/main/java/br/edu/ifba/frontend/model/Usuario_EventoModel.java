package br.edu.ifba.frontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario_EventoModel {
	private UsuarioModel usuario;
	private UsuarioModel gincana;
	private EventoModel evento;

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public UsuarioModel getGincana() {
		return gincana;
	}

	public void setGincana(UsuarioModel gincana) {
		this.gincana = gincana;
	}

	public EventoModel getEvento() {
		return evento;
	}

	public void setEvento(EventoModel evento) {
		this.evento = evento;
	}

	@Override
	public String toString() {
		return "Usuario_EventoModel [usuario=" + usuario + ", gincana=" + gincana + ", evento=" + evento + "]";
	}

}
