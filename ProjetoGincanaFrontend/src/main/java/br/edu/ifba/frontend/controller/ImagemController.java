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
import br.edu.ifba.frontend.model.ImagemModel;
import br.edu.ifba.frontend.service.GaleriaService;
import br.edu.ifba.frontend.service.ImagemService;
import br.edu.ifba.frontend.tela.ImagemTelaModel;

@Controller
@RequestMapping("/imagem")
public class ImagemController {

	@Autowired
	private ImagemService imagemService;

	@Autowired
	private GaleriaService galeriaService;

	@GetMapping("/")
	public String index(Model model) {
		List<ImagemModel> list = this.imagemService.getListImagem();
		model.addAttribute("imagens", list);
		System.out.println("00000000000000000000000000000" + model);
		return "imagem/index";
	}

	@GetMapping("/adicionar_form")
	public String adicionar_form(Model model) {
		List<GaleriaModel> list = this.galeriaService.getGalerias();
		model.addAttribute("galerias", list);
		return "imagem/adicionar_form";
	}

	@PostMapping("/adicionar")
	public String adicionar(@ModelAttribute ImagemTelaModel imagemTelaModel, Model model) {
		GaleriaModel gm = new GaleriaModel();
		gm.setId_Galeria(imagemTelaModel.getGaleria());

		ImagemModel sm = new ImagemModel();
		sm.setURL_Imagem(imagemTelaModel.getURL_Imagem());
		sm.setGaleria(gm);
		imagemService.insert(sm);
		return "redirect:/imagem/";
	}

	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		Boolean boo = this.imagemService.deleteTarefa(id);
		return "redirect:/imagem/";
	}

	@GetMapping("/editar_form/{id}")
	public String editar_form(@PathVariable("id") Integer id, Model model) {
		
		List<GaleriaModel> list = this.galeriaService.getGalerias();
		System.out.println("------------------------------>"+ id);
		ImagemModel im = this.imagemService.getImagem(id);
		System.out.println("------------------------->"+ im);
		model.addAttribute("id_Imagem",im.getId_Imagem());
		model.addAttribute("URL_Imagem", im.getURL_Imagem());
		model.addAttribute("id_Galeria", im.getGaleria().getId_Galeria());
		model.addAttribute("galerias", list);
		model.addAttribute("readonly", true);
		return "imagem/editar_form";
	}
	

	@PostMapping("/editar")
	public String editar(@ModelAttribute ImagemTelaModel imagemTelaModel, Model model) {
		GaleriaModel gm = this.galeriaService.getGaleria(imagemTelaModel.getGaleria());

		ImagemModel sm = this.imagemService.getImagem(imagemTelaModel.getId_Imagem());
		sm.setURL_Imagem(imagemTelaModel.getURL_Imagem());
		sm.setGaleria(gm);
		imagemService.update(sm);
		return "redirect:/imagem/";
	}
	
	@GetMapping("/indexdashboard")
	public String indexdashboard(Model model){
		List<ImagemModel> list = this.imagemService.getListImagem();
		model.addAttribute("imagens", list);
		model.addAttribute("readonly", true);
		return"imagem/indexdashboard";
		
	}
	
	
	

}
