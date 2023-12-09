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

import br.edu.ifba.frontend.model.StatusModel;
import br.edu.ifba.frontend.service.StatusService;

@Controller
@RequestMapping("/status")
public class StatusController {
	@Autowired
	private StatusService statusService;
	
	@GetMapping("/")
	public String index(Model model) {
		System.out.println("status_lista - init");
		List<StatusModel> list = this.statusService.getListStatus();
		model.addAttribute("status", list);
		return "status/index";
	}

	@GetMapping("/adicionar_form")
	public String adicionar_form() {
		return "status/adicionar_form";
	}
	
	@PostMapping("/adicionar")
	public String adicionar(@ModelAttribute StatusModel statusModel, Model model) {
		System.out.println("insert: " + statusModel.getSituacao_Status());
		StatusModel sm = new StatusModel();
		sm.setSituacao_Status(statusModel.getSituacao_Status());
		statusService.insert(sm);
		return "redirect:/status/";
	}
	
	@RequestMapping(value="/deletar/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		Boolean boo = this.statusService.deleteStatus(id);
		return "redirect:/status/";
	}
	
	@GetMapping("/editar_form/{id}")
	public String editar_form(@PathVariable("id") Integer id, Model model) {
		StatusModel sm = this.statusService.getStatus(id);
		model.addAttribute("id_Status", sm.getId_Status());
		model.addAttribute("situacao", sm.getSituacao_Status());
		model.addAttribute("readonly", true);
		return "status/editar_form";
	}
	
	@PostMapping("/editar")
	public String editar(@ModelAttribute StatusModel statusModel, Model model) {
		StatusModel sm = this.statusService.getStatus(statusModel.getId_Status());
		sm.setSituacao_Status( statusModel.getSituacao_Status());
		statusService.update(sm);
		return "redirect:/status/";
	}
	
	/*
	@GetMapping("/modificar_status/{id}")
	public String modificar_status(@PathVariable("id") long id) {
		StatusModel sm = this.statusService.getStatus(id);
		if (!sm.getStatus()) {
			sm.setData_conclusao( new Date(System.currentTimeMillis()) );
		}
		else {
			sm.setData_conclusao( null );
		}
		sm.setStatus( !tm.getStatus() );
		statusService.update(sm);
		return "redirect:/status/";
	}
	*/
}
	
