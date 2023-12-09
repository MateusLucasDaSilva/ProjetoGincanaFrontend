package br.edu.ifba.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifba.frontend.model.CriterioModel;
import br.edu.ifba.frontend.model.EventoModel;
import br.edu.ifba.frontend.service.CriterioService;
import br.edu.ifba.frontend.service.EventoService;
import br.edu.ifba.frontend.tela.CriterioTelaModel;

@Controller
@RequestMapping("/criterio")
public class CriterioController {

	@Autowired
	private CriterioService criterioService;

	@Autowired
	private EventoService eventoService;

	@GetMapping("/")
	public String index(Model model) {
		System.out.println("tarefas_lista - init");
		List<CriterioModel> list = this.criterioService.getCriterios();
		model.addAttribute("criterios", list);
		return "criterio/index";
	}

	@GetMapping("/adicionar_form")
	public String adicionar_form(Model model) {
		List<EventoModel> list = this.eventoService.getEventos();
		model.addAttribute("eventos", list);
		return "criterio/adicionar_form";
	}

	@PostMapping("/adicionar")
	public String adicionar(@ModelAttribute CriterioTelaModel criterioTelaModel, Model model) {
		EventoModel em = new EventoModel();
		em.setId_Evento(criterioTelaModel.getEvento());

		CriterioModel cm = new CriterioModel();
		cm.setNome_Criterio(criterioTelaModel.getNome_Criterio());
		cm.setPontuacao_min_Criterio(criterioTelaModel.getPontuacao_min_Criterio());
		cm.setPontuacao_max_Criterio(criterioTelaModel.getPontuacao_max_Criterio());
		cm.setEvento(em);
		criterioService.insert(cm);
		return "redirect:/criterio/";
	}

	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		Boolean boo = this.criterioService.deleteCriterio(id);
		return "redirect:/criterio/";
	}

	@GetMapping("/editar_form/{id}")
	public String editar_form(@PathVariable("id") Integer id, Model model) {
		List<EventoModel> list = this.eventoService.getEventos();

		CriterioModel cm = this.criterioService.getCriterio(id);
		model.addAttribute("id_Criterio", cm.getId_Criterio());
		model.addAttribute("nome_Criterio", cm.getNome_Criterio());
		model.addAttribute("pontuacao_min_Criterio", cm.getPontuacao_min_Criterio());
		model.addAttribute("pontuacao_max_Criterio", cm.getPontuacao_max_Criterio());
		model.addAttribute("id_Evento", cm.getEvento().getId_Evento());
		model.addAttribute("eventos", list);
		model.addAttribute("readonly", true);
		return "criterio/editar_form";
	}

	@PostMapping("/editar")
	public String editar(@ModelAttribute CriterioTelaModel criterioTelaModel, Model model) {
		EventoModel em = new EventoModel();
		em.setId_Evento(criterioTelaModel.getEvento());

		CriterioModel cm = this.criterioService.getCriterio(criterioTelaModel.getId_Criterio());
		cm.setNome_Criterio(criterioTelaModel.getNome_Criterio());
		cm.setPontuacao_min_Criterio(criterioTelaModel.getPontuacao_min_Criterio());
		cm.setPontuacao_max_Criterio(criterioTelaModel.getPontuacao_max_Criterio());
		cm.setEvento(em);
		criterioService.update(cm);
		return "redirect:/criterio/";
	}

}
