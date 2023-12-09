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

import br.edu.ifba.frontend.model.GincanaModel;
import br.edu.ifba.frontend.model.StatusModel;
import br.edu.ifba.frontend.service.GincanaService;
import br.edu.ifba.frontend.service.StatusService;
import br.edu.ifba.frontend.tela.GincanaTelaModel;

@Controller
@RequestMapping(value = "/gincana")
public class GincanaController {

	@Autowired
	private GincanaService gincanaService;

	@Autowired
	private StatusService statusService;

	@GetMapping("/")
	public String index(Model model) {
		System.out.println("gincanas_lista - init");
		List<GincanaModel> list = this.gincanaService.getGincanas();
		System.out.println(list);
		model.addAttribute("gincanas", list);
		return "gincana/index";
	}

	@GetMapping("/adicionar_form")
	public String adicionar_form(Model model) {
		StatusService statusService = new StatusService();
		List<StatusModel> list = this.statusService.getListStatus();
		model.addAttribute("list_status", list);
		return "gincana/adicionar_form";
	}

	@PostMapping("/adicionar")
	public String adicionar(@ModelAttribute GincanaTelaModel gincanaTelaModel, Model model) {
		System.out.println("insert: " + gincanaTelaModel);

		StatusModel sm = new StatusModel();
		sm.setId_Status(gincanaTelaModel.getStatus());

		GincanaModel gm = new GincanaModel();

		gm.setNome_Gincana(gincanaTelaModel.getNome_Gincana());
		gm.setDescricao_Gincana(gincanaTelaModel.getDescricao_Gincana());
		gm.setData_inicio_Gincana(gincanaTelaModel.getData_inicio_Gincana());
		gm.setData_fim_Gincana(gincanaTelaModel.getData_fim_Gincana());
		gm.setStatus(sm);
		gincanaService.insert(gm);
		return "redirect:/gincana/";
	}

	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		Boolean boo = this.gincanaService.deleteGincana(id);
		return "redirect:/gincana/";
	}

	@GetMapping("/editar_form/{id}")
	public String editar_form(@PathVariable("id") Integer id, Model model) {

		List<StatusModel> list = this.statusService.getListStatus();
		// System.out.println("editar_form: " + list);

		GincanaModel gm = this.gincanaService.getGincana(id);
		model.addAttribute("id_Gincana", gm.getId_Gincana());
		model.addAttribute("nome_Gincana", gm.getNome_Gincana());
		model.addAttribute("descricao_Gincana", gm.getDescricao_Gincana());
		model.addAttribute("data_inicio_Gincana", gm.getData_inicio_Gincana());
		model.addAttribute("data_fim_Gincana", gm.getData_fim_Gincana());
		model.addAttribute("id_Status", gm.getStatus().getId_Status());
		model.addAttribute("list_status", list);
		model.addAttribute("readonly", true);
		return "gincana/editar_form";
	}

	@PostMapping("/editar")
	public String editar(@ModelAttribute GincanaTelaModel gincanaTelaModel, Model model) {
	
		
		StatusModel sm = this.statusService.getStatus(gincanaTelaModel.getStatus());

		GincanaModel gm = this.gincanaService.getGincana(gincanaTelaModel.getId_Gincana());
		gm.setNome_Gincana(gincanaTelaModel.getNome_Gincana());
		gm.setDescricao_Gincana(gincanaTelaModel.getDescricao_Gincana());
		gm.setData_inicio_Gincana(gincanaTelaModel.getData_inicio_Gincana());
		gm.setData_fim_Gincana(gincanaTelaModel.getData_fim_Gincana());
		gm.setStatus(sm);
		gincanaService.update(gm);
		return "redirect:/gincana/";
	}


}
