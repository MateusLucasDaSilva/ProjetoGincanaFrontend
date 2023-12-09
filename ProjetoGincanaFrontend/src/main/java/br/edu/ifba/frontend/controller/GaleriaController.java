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

import br.edu.ifba.frontend.model.GaleriaModel;
import br.edu.ifba.frontend.model.GincanaModel;
import br.edu.ifba.frontend.service.GaleriaService;
import br.edu.ifba.frontend.service.GincanaService;
import br.edu.ifba.frontend.service.StatusService;
import br.edu.ifba.frontend.tela.GaleriaTelaModel;


@Controller
@RequestMapping("/galeria")
public class GaleriaController {
	@Autowired
	private GaleriaService galeriaService;
	
	@Autowired
	private GincanaService gincanaService;
	
	
	
	
	@GetMapping("/")
	public String index(Model model) {
		System.out.println("tarefa_lista - init");
		List<GaleriaModel> list = this.galeriaService.getGalerias();
		model.addAttribute("galeria", list);
		return "galeria/index";
	}

	@GetMapping("/adicionar_form")
	public String adicionar_form(Model model) {
		GincanaService gincanaService = new GincanaService();
		List<GincanaModel> list = this.gincanaService.getGincanas();
		model.addAttribute("list_gincana", list);
		return "galeria/adicionar_form";
	}
	
	@PostMapping("/adicionar")
	public String adicionar(@ModelAttribute GaleriaTelaModel galeriaTelaModel, Model model) {
		GincanaModel gm = new GincanaModel();
		gm.setId_Gincana(galeriaTelaModel.getGincana());
		
		GaleriaModel gam = new GaleriaModel();
		gam.setNome_Galeria(galeriaTelaModel.getNome_Galeria());
		gam.setDescricao_Galeria(galeriaTelaModel.getDescricao_Galeria());
		gam.setGincana(gm);
		galeriaService.insert(gam);
		return "redirect:/galeria/";
	}
	
	@RequestMapping(value="/deletar/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		Boolean boo = this.galeriaService.deleteGaleria(id);
		return "redirect:/galeria/";
	}
	
	
	
	@GetMapping("/editar_form/{id}")
	public String editar_form(@PathVariable("id") Integer id, Model model) {
		
		List<GincanaModel> list = this.gincanaService.getGincanas();
		
		GaleriaModel gm = this.galeriaService.getGaleria(id);
		System.out.println("------------------------->"+ gm);
		model.addAttribute("id_Galeria", gm.getId_Galeria());
		model.addAttribute("nome_Galeria", gm.getNome_Galeria());
		model.addAttribute("descricao_Galeria", gm.getDescricao_Galeria());
		model.addAttribute("id_Gincana", gm.getGincana().getId_Gincana());
		model.addAttribute("gincanas", list);
		model.addAttribute("readonly", true);
		return "galeria/editar_form";
	}
	
	@PostMapping("/editar")
	public String editar(@ModelAttribute GaleriaTelaModel galeriaTelaModel, Model model) {
		GincanaModel gm = this.gincanaService.getGincana(galeriaTelaModel.getGincana());
		
		
		GaleriaModel tm = this.galeriaService.getGaleria(galeriaTelaModel.getId_Galeria());
		tm.setNome_Galeria(galeriaTelaModel.getNome_Galeria());
		tm.setDescricao_Galeria(galeriaTelaModel.getDescricao_Galeria());
		tm.setGincana(gm);
		galeriaService.update(tm);
		return "redirect:/galeria/";
	}
	
	@GetMapping("/indexdashboard")
	public String desenvolvedores(Model model) {
		List<GaleriaModel> list = this.galeriaService.getGalerias();
		
		model.addAttribute("galerias", list);
		model.addAttribute("readonly", true);
		return "galeria/dashboard_galeria";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
