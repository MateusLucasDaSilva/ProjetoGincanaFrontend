package br.edu.ifba.frontend.controller;

import java.util.Iterator;
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

import br.edu.ifba.frontend.model.PerfilModel;
import br.edu.ifba.frontend.service.PerfilService;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
	@Autowired
	private PerfilService perfilService;
	
	@GetMapping("/")
	public String index(Model model) {
		System.out.println("perfis_lista - init");
		List<PerfilModel> list = this.perfilService.getPerfis();
		model.addAttribute("perfis", list);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			PerfilModel perfilModel = (PerfilModel) iterator.next();
			System.out.println(perfilModel);
			
		}
		System.out.println(list);
		return "perfil/index";
	}

	@GetMapping("/adicionar_form")
	public String adicionar_form() {
		return "perfil/adicionar_form";
	}
	
	@PostMapping("/adicionar")
	public String adicionar(@ModelAttribute PerfilModel perfilModel, Model model) {
		System.out.println("insert: " + perfilModel.getCargo_Perfil());
		PerfilModel tm = new PerfilModel();
		tm.setCargo_Perfil( perfilModel.getCargo_Perfil() );
		perfilService.insert(tm);
		return "redirect:/perfil/";
	}
	
	@RequestMapping(value="/deletar/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		Boolean boo = this.perfilService.deletePerfil(id);
		return "redirect:/perfil/";
	}
	
	@GetMapping("/editar_form/{id}")
	public String editar_form(@PathVariable("id") Integer id, Model model) {
		PerfilModel tm = this.perfilService.getPerfil(id);
		model.addAttribute("id_Perfil", tm.getId_Perfil());
		model.addAttribute("cargo_Perfil", tm.getCargo_Perfil());
		model.addAttribute("readonly", true);
		return "perfil/editar_form";
	}
	
	@PostMapping("/editar")
	public String editar(@ModelAttribute PerfilModel perfilModel, Model model) {
		PerfilModel tm = this.perfilService.getPerfil(perfilModel.getId_Perfil());
		tm.setCargo_Perfil( perfilModel.getCargo_Perfil() );
		perfilService.update(tm);
		return "redirect:/perfil/";
	}
	

}
