package br.edu.ifba.frontend.controller;

import java.sql.Date;
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

import br.edu.ifba.frontend.model.EventoModel;
import br.edu.ifba.frontend.model.GincanaModel;
import br.edu.ifba.frontend.model.StatusModel;
import br.edu.ifba.frontend.service.EventoService;
import br.edu.ifba.frontend.service.GincanaService;
import br.edu.ifba.frontend.service.StatusService;
import br.edu.ifba.frontend.tela.EventoTelaModel;

@Controller
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired
	private EventoService eventoService;
	
	@Autowired
	private GincanaService gincanaService;
	
	@Autowired
	private StatusService statusService;
	
	@GetMapping("/")
	public String index(Model model) {
		System.out.println("eventos_lista - init");
		List<EventoModel> list = this.eventoService.getEventos();
		model.addAttribute("eventos", list);
		return "evento/index";
	}

	@GetMapping("/adicionar_form")
	public String adicionar_form(Model model, Model model2) {
		GincanaService gincanaService = new GincanaService();
		List<GincanaModel> list = this.gincanaService.getGincanas();
		model.addAttribute("list_gincana", list);
		StatusService statusService = new StatusService();
		List<StatusModel> list2 = this.statusService.getListStatus();
		model2.addAttribute("list_status",list2);
		return "evento/adicionar_form";
	}
	
	@PostMapping("/adicionar")
	public String adicionar(@ModelAttribute EventoTelaModel eventoTelaModel, Model model, Model model2) {
		System.out.println("insert: " + eventoTelaModel.getNome_Evento());
		
		GincanaModel gm = new GincanaModel();
		gm.setId_Gincana(eventoTelaModel.getGincana());
		
		StatusModel sm = new StatusModel();
		sm.setId_Status(eventoTelaModel.getStatus());
		
	
		EventoModel em = new EventoModel();
		em.setNome_Evento(eventoTelaModel.getNome_Evento());
		em.setDescricao_Evento(eventoTelaModel.getDescricao_Evento());
		em.setTipo_Evento(eventoTelaModel.getTipo_Evento());
		em.setData_Evento(eventoTelaModel.getData_Evento());
		em.setHorario_Evento(eventoTelaModel.getHorario_Evento());
		em.setLocal_Evento(eventoTelaModel.getLocal_Evento());
		em.setGincana(gm);
		em.setStatus(sm);
		eventoService.insert(em);
		return "redirect:/evento/";
	}
	
	@RequestMapping(value="/deletar/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		Boolean boo = this.eventoService.deleteEvento(id);
		return "redirect:/evento/";
	}
	
	@GetMapping("/editar_form/{id}")
	public String editar_form(@PathVariable("id") Integer id, Model model) {
		List<GincanaModel> list = this.gincanaService.getGincanas();
		List<StatusModel> list2 = this.statusService.getListStatus();
		
		
		
		EventoModel em = this.eventoService.getEvento(id);
		model.addAttribute("id_Evento", em.getId_Evento());
		model.addAttribute("nome_Evento", em.getNome_Evento());
		model.addAttribute("descricao_Evento", em.getDescricao_Evento());
		model.addAttribute("tipo_Evento", em.getTipo_Evento());
		model.addAttribute("data_Evento", em.getData_Evento());
		model.addAttribute("horario_Evento", em.getHorario_Evento());
		model.addAttribute("local_Evento", em.getLocal_Evento());
		model.addAttribute("id_Gincana", em.getGincana().getId_Gincana());
		model.addAttribute("id_Status", em.getStatus().getId_Status());
		model.addAttribute("gincanas", list);
		model.addAttribute("list_status", list2);
	
		model.addAttribute("readonly", true);
		return "evento/editar_form";
	}
	
	@PostMapping("/editar")
	public String editar(@ModelAttribute EventoTelaModel eventoTelaModel, Model model) {
		GincanaModel gm = this.gincanaService.getGincana(eventoTelaModel.getGincana());
		StatusModel sm = this.statusService.getStatus(eventoTelaModel.getStatus());
		
		
		EventoModel em = this.eventoService.getEvento(eventoTelaModel.getId_Evento());
		em.setNome_Evento( eventoTelaModel.getNome_Evento());
		em.setDescricao_Evento( eventoTelaModel.getDescricao_Evento());
		em.setTipo_Evento( eventoTelaModel.getTipo_Evento());
		em.setData_Evento( eventoTelaModel.getData_Evento());
		em.setHorario_Evento( eventoTelaModel.getHorario_Evento());
		em.setLocal_Evento( eventoTelaModel.getLocal_Evento());
		em.setGincana(gm);
		em.setStatus(sm);
		eventoService.update(em);
		return "redirect:/evento/";
	}
	
	
	
	@GetMapping("/dashboard_evento")
	public String desenvolvedores() {
		return "/evento/dashboard_evento";
	}
}
