package br.edu.ifba.frontend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.edu.ifba.frontend.model.EquipeModel;
import reactor.core.publisher.Mono;

@Service
public class EquipeService {
	
	@Autowired
	private WebClient webClient;

	public EquipeModel getEquipe(Integer id) {

		Mono<EquipeModel> equipeModel = this.webClient.method(HttpMethod.GET)
													  .uri("equipe/{id}", id)
													  .retrieve()
													  .bodyToMono(EquipeModel.class);

		EquipeModel em = equipeModel.block();
		return em;
	}

	public List<EquipeModel> getEquipes() {

		Mono<EquipeModel[]> equipeModel = this.webClient.method(HttpMethod.GET).uri("equipe/listall").retrieve()
				.bodyToMono(EquipeModel[].class);

		List<EquipeModel> list = new ArrayList<EquipeModel>();
		EquipeModel[] em = equipeModel.block();
		for (EquipeModel equipeModel2 : em) {
			list.add(equipeModel2);
		}

		return list;
	}

	public Boolean deleteEquipe(Integer id) {
		Mono<Boolean> equipeDel = this.webClient.method(HttpMethod.DELETE).uri("equipe/{id}", id).retrieve()
				.bodyToMono(Boolean.class);

		Boolean result = equipeDel.block();
		return result;
	}

	public Boolean insert(EquipeModel equipeModel) {
		Mono<Boolean> equipes = this.webClient.method(HttpMethod.POST).uri("equipe/")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(equipeModel), EquipeModel.class).retrieve().bodyToMono(Boolean.class);
		Boolean result = equipes.block();
		return result;
	}

	public EquipeModel update(EquipeModel equipeModel) {
		System.out.println("update: " + equipeModel);
		Mono<EquipeModel> equipe = this.webClient.method(HttpMethod.PUT).uri("equipe/{id}", equipeModel.getId_Equipe())
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(equipeModel), EquipeModel.class).retrieve().bodyToMono(EquipeModel.class);
		EquipeModel result = equipe.block();
		return result;
	}

}
