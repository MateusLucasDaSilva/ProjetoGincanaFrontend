package br.edu.ifba.frontend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.edu.ifba.frontend.model.GincanaModel;
import reactor.core.publisher.Mono;

@Service
public class GincanaService {
	
	@Autowired
	private WebClient webClient;
	
	public GincanaModel getGincana(Integer id) {
		
		Mono<GincanaModel> gincanaModel = this.webClient
											.method(HttpMethod.GET)
											.uri("gincana/{id}", id)
											.retrieve()
											.bodyToMono(GincanaModel.class);
		
		GincanaModel gm = gincanaModel.block();
		return gm;
	}
	
	public List<GincanaModel> getGincanas() {
		
		Mono<GincanaModel[]> gincanaModel = this.webClient
											.method(HttpMethod.GET)
											.uri("gincana/listall")
											.retrieve()
											.bodyToMono(GincanaModel[].class);
		
		List<GincanaModel> list = new ArrayList<GincanaModel>();
		GincanaModel[] tm = gincanaModel.block();
		for (GincanaModel gincanaModel2 : tm) {
			list.add(gincanaModel2);
		}
		
		return list;
	}
	
	public Boolean deleteGincana(Integer id) {
		Mono<Boolean> gincanaDel = this.webClient
											.method(HttpMethod.DELETE)
											.uri("gincana/{id}", id)
											.retrieve()
											.bodyToMono(Boolean.class);
		
		
		Boolean result = gincanaDel.block();
		return result;
	}
	
	public Boolean insert(GincanaModel gincanaModel) {
		System.out.println("Objeto --------------------------------> " + gincanaModel);
		Mono<Boolean> gincana = this.webClient
									.method(HttpMethod.POST)
									.uri("gincana/")
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.body(Mono.just(gincanaModel), GincanaModel.class)
									.retrieve()
									.bodyToMono(Boolean.class);
		Boolean result = gincana.block();
		return result;
	}
	
	public GincanaModel update(GincanaModel gincanaModel) {
		
		Mono<GincanaModel> gincana = this.webClient
									.method(HttpMethod.PUT)
									.uri("gincana/{id}", gincanaModel.getId_Gincana())
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.body(Mono.just(gincanaModel), GincanaModel.class)
									.retrieve()
									.bodyToMono(GincanaModel.class);
		
		
		GincanaModel result = gincana.block();
		return result;
	}
	
	

}
