package br.edu.ifba.frontend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.edu.ifba.frontend.model.StatusModel;
import reactor.core.publisher.Mono;


@Service
public class StatusService {
	@Autowired
	private WebClient webClient;
	
	public StatusModel getStatus(Integer id) {
		
		Mono<StatusModel> statusModel = this.webClient
											.method(HttpMethod.GET)
											.uri("status/{id}", id)
											.retrieve()
											.bodyToMono(StatusModel.class);
		
		StatusModel sm = statusModel.block();
		return sm;
	}
	
	public List<StatusModel> getListStatus() {
		
		Mono<StatusModel[]> statusModel = this.webClient
											.method(HttpMethod.GET)
											.uri("status/listall")
											.retrieve()
											.bodyToMono(StatusModel[].class);
		
		List<StatusModel> list = new ArrayList<StatusModel>();
		StatusModel[] sm = statusModel.block();
		for (StatusModel statusModel2 : sm) {
			list.add(statusModel2);
		}
		
		return list;
	}
	
	public Boolean deleteStatus(Integer id) {
		Mono<Boolean> statusDel = this.webClient
											.method(HttpMethod.DELETE)
											.uri("status/{id}", id)
											.retrieve()
											.bodyToMono(Boolean.class);
		
		
		Boolean result = statusDel.block();
		return result;
	}
	
	public Boolean insert(StatusModel statusModel) {
		Mono<Boolean> status = this.webClient
									.method(HttpMethod.POST)
									.uri("status/")
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.body(Mono.just(statusModel), StatusModel.class)
									.retrieve()
									.bodyToMono(Boolean.class);
		Boolean result = status.block();
		return result;
	}
	
	public StatusModel update(StatusModel statusModel) {
		System.out.println("update: " + statusModel);
		Mono<StatusModel> status = this.webClient
									.method(HttpMethod.PUT)
									.uri("status/{id}", statusModel.getId_Status())
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.body(Mono.just(statusModel), StatusModel.class)
									.retrieve()
									.bodyToMono(StatusModel.class);
		StatusModel result = status.block();
		return result;
	}
	
	
}
