package br.edu.ifba.frontend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.edu.ifba.frontend.model.PerfilModel;
import reactor.core.publisher.Mono;


@Service
public class PerfilService {
	@Autowired
	private WebClient webClient;
	
	public PerfilModel getPerfil(Integer id) {
		
		Mono<PerfilModel> perfilModel = this.webClient
											.method(HttpMethod.GET)
											.uri("perfil/{id}", id)
											.retrieve()
											.bodyToMono(PerfilModel.class);
		
		PerfilModel pm = perfilModel.block();
		return pm;
	}
	
	public List<PerfilModel> getPerfis() {
		
		Mono<PerfilModel[]> perfilModel = this.webClient
											.method(HttpMethod.GET)
											.uri("perfil/listall")
											.retrieve()
											.bodyToMono(PerfilModel[].class);
		
		List<PerfilModel> list = new ArrayList<PerfilModel>();
		PerfilModel[] pm = perfilModel.block();
		for (PerfilModel perfilModel2 : pm) {
			list.add(perfilModel2);
		}
		
		return list;
	}
	
	public Boolean deletePerfil(Integer id) {
		Mono<Boolean> perfilDel = this.webClient
											.method(HttpMethod.DELETE)
											.uri("perfil/{id}", id)
											.retrieve()
											.bodyToMono(Boolean.class);
		
		
		Boolean result = perfilDel.block();
		return result;
	}
	
	public Boolean insert(PerfilModel perfilModel) {
		Mono<Boolean> perfil = this.webClient
									.method(HttpMethod.POST)
									.uri("perfil/")
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.body(Mono.just(perfilModel), PerfilModel.class)
									.retrieve()
									.bodyToMono(Boolean.class);
		Boolean result = perfil.block();
		return result;
	}
	
	public PerfilModel update(PerfilModel perfilModel) {
		System.out.println("update: " + perfilModel);
		Mono<PerfilModel> perfil = this.webClient
									.method(HttpMethod.PUT)
									.uri("perfil/{id}", perfilModel.getId_Perfil())
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.body(Mono.just(perfilModel), PerfilModel.class)
									.retrieve()
									.bodyToMono(PerfilModel.class);
		PerfilModel result = perfil.block();
		return result;
	}
	
	
	
}
