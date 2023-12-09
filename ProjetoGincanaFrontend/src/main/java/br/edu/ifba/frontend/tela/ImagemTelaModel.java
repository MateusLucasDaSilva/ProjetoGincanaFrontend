package br.edu.ifba.frontend.tela;

import lombok.Data;

@Data
public class ImagemTelaModel {

	private Integer id_Imagem;
	private String URL_Imagem;
	private Integer galeria;

	public ImagemTelaModel() {
		super();
	}

	public ImagemTelaModel(Integer id_Imagem, String uRL_Imagem, Integer galeria) {
		super();
		this.id_Imagem = id_Imagem;
		URL_Imagem = uRL_Imagem;
		this.galeria = galeria;
	}

	public Integer getId_Imagem() {
		return id_Imagem;
	}

	public void setId_Imagem(Integer id_Imagem) {
		this.id_Imagem = id_Imagem;
	}

	public String getURL_Imagem() {
		return URL_Imagem;
	}

	public void setURL_Imagem(String uRL_Imagem) {
		URL_Imagem = uRL_Imagem;
	}

	public Integer getGaleria() {
		return galeria;
	}

	public void setGaleria(Integer galeria) {
		this.galeria = galeria;
	}

	@Override
	public String toString() {
		return "ImagemTelaModel [id_Imagem=" + id_Imagem + ", URL_Imagem=" + URL_Imagem + ", galeria=" + galeria + "]";
	}

}
