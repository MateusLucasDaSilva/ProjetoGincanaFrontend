package br.edu.ifba.frontend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.edu.ifba.frontend.model.CursoModel;
import reactor.core.publisher.Mono;


@Service
public class CursoService {
	@Autowired
	private WebClient webClient;
	
	public CursoModel getCurso(Integer id) {
		
		Mono<CursoModel> CursoModel = this.webClient
											.method(HttpMethod.GET)
											.uri("curso/{id}", id)
											.retrieve()
											.bodyToMono(CursoModel.class);
		
		CursoModel cm = CursoModel.block();
		return cm;
	}
	
	public List<CursoModel> getCursos() {
		
		Mono<CursoModel[]> CursoModel = this.webClient
											.method(HttpMethod.GET)
											.uri("curso/listall")
											.retrieve()
											.bodyToMono(CursoModel[].class);
		
		List<CursoModel> list = new ArrayList<CursoModel>();
		CursoModel[] cm = CursoModel.block();
		for (CursoModel CursoModel2 : cm) {
			list.add(CursoModel2);
		}
		
		return list;
	}
	
	public Boolean deleteCurso(Integer id) {
		Mono<Boolean> cursoDel = this.webClient
											.method(HttpMethod.DELETE)
											.uri("curso/{id}", id)
											.retrieve()
											.bodyToMono(Boolean.class);
		
		
		Boolean result = cursoDel.block();
		return result;
	}
	
	public Boolean insert(CursoModel cursoModel) {
		Mono<Boolean> curso = this.webClient
									.method(HttpMethod.POST)
									.uri("curso/")
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.body(Mono.just(cursoModel), CursoModel.class)
									.retrieve()
									.bodyToMono(Boolean.class);
		Boolean result = curso.block();
		return result;
	}
	
	public CursoModel update(CursoModel cursoModel) {
		System.out.println("update: " + cursoModel);
		Mono<CursoModel> curso = this.webClient
									.method(HttpMethod.PUT)
									.uri("curso/{id}", cursoModel.getId_Curso())
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.body(Mono.just(cursoModel), CursoModel.class)
									.retrieve()
									.bodyToMono(CursoModel.class);
		CursoModel result = curso.block();
		return result;
	}	
}