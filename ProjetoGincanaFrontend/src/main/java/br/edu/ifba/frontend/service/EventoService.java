package br.edu.ifba.frontend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.edu.ifba.frontend.model.EventoModel;
import reactor.core.publisher.Mono;


@Service
public class EventoService {
	@Autowired
	private WebClient webClient;
	
	public EventoModel getEvento(Integer id) {
		
		Mono<EventoModel> eventoModel = this.webClient
											.method(HttpMethod.GET)
											.uri("evento/{id}", id)
											.retrieve()
											.bodyToMono(EventoModel.class);
		
		EventoModel em = eventoModel.block();
		return em;
	}
	
	public List<EventoModel> getEventos() {
		
		Mono<EventoModel[]> eventoModel = this.webClient
											.method(HttpMethod.GET)
											.uri("evento/listall")
											.retrieve()
											.bodyToMono(EventoModel[].class);
		
		List<EventoModel> list = new ArrayList<EventoModel>();
		EventoModel[] em = eventoModel.block();
		for (EventoModel eventoModel2 : em) {
			list.add(eventoModel2);
		}
		
		return list;
	}
	
	public Boolean deleteEvento(Integer id) {
		Mono<Boolean> eventoDel = this.webClient
											.method(HttpMethod.DELETE)
											.uri("evento/{id}", id)
											.retrieve()
											.bodyToMono(Boolean.class);
		
		
		Boolean result = eventoDel.block();
		return result;
	}
	
	public Boolean insert(EventoModel eventoModel) {
		Mono<Boolean> evento = this.webClient
									.method(HttpMethod.POST)
									.uri("evento/")
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.body(Mono.just(eventoModel), EventoModel.class)
									.retrieve()
									.bodyToMono(Boolean.class);
		Boolean result = evento.block();
		return result;
	}
	
	public EventoModel update(EventoModel eventoModel) {
		System.out.println("update: " + eventoModel);
		Mono<EventoModel> evento = this.webClient
									.method(HttpMethod.PUT)
									.uri("evento/{id}", eventoModel.getId_Evento())
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.body(Mono.just(eventoModel), EventoModel.class)
									.retrieve()
									.bodyToMono(EventoModel.class);
		EventoModel result = evento.block();
		return result;
	}
	
	
	
}
