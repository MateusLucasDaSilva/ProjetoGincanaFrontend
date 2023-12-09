package br.edu.ifba.frontend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.edu.ifba.frontend.model.UsuarioModel;
import reactor.core.publisher.Mono;


@Service
public class UsuarioService {
	@Autowired
	private WebClient webClient;
	
	public UsuarioModel getUsuario(Integer id) {
		
		Mono<UsuarioModel> usuarioModel = this.webClient
											.method(HttpMethod.GET)
											.uri("usuario/{id}", id)
											.retrieve()
											.bodyToMono(UsuarioModel.class);
		
		UsuarioModel um = usuarioModel.block();
		return um;
	}
	
	public List<UsuarioModel> getUsuarios() {
		
		Mono<UsuarioModel[]> usuarioModel = this.webClient
											.method(HttpMethod.GET)
											.uri("usuario/listall")
											.retrieve()
											.bodyToMono(UsuarioModel[].class);
		
		List<UsuarioModel> list = new ArrayList<UsuarioModel>();
		UsuarioModel[] um = usuarioModel.block();
		for (UsuarioModel usuarioModel2 : um) {
			list.add(usuarioModel2);
		}
		
		return list;
	}
	
	public Boolean deleteUsuario(Integer id) {
		Mono<Boolean> usuarioDel = this.webClient
											.method(HttpMethod.DELETE)
											.uri("usuario/{id}", id)
											.retrieve()
											.bodyToMono(Boolean.class);
		
		
		Boolean result = usuarioDel.block();
		return result;
	}
	
	public Boolean insert(UsuarioModel usuarioModel) {
		Mono<Boolean> usuario = this.webClient
									.method(HttpMethod.POST)
									.uri("usuario/")
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.body(Mono.just(usuarioModel), UsuarioModel.class)
									.retrieve()
									.bodyToMono(Boolean.class);
		Boolean result = usuario.block();
		return result;
	}
	
	public UsuarioModel update(UsuarioModel usuarioModel) {
		System.out.println("update: " + usuarioModel);
		Mono<UsuarioModel> usuario = this.webClient
									.method(HttpMethod.PUT)
									.uri("usuario/{id}", usuarioModel.getId_Usuario())
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.body(Mono.just(usuarioModel), UsuarioModel.class)
									.retrieve()
									.bodyToMono(UsuarioModel.class);
		UsuarioModel result = usuario.block();
		return result;
	}
	
	
	
}
