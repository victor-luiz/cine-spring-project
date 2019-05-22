package br.com.edward.restfull.view;

import br.com.edward.restfull.model.SessaoModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SessaoView {
	
	private String filme;
	private String categoria;
	private String audio;
	private String sala;
	private String tipoSala;
	private Double preco;
	private Double meiaEntrada;	
	
	public SessaoView(SessaoModel model) {
		this.filme = model.getFilme().getNome();
		this.audio = model.getAudio().getNome();
		this.sala = model.getSala().getNome();
		this.tipoSala = model.getSala().getTipo().getNome();
		this.preco = model.getSala().getTipo().getPreco();
		this.categoria = model.getFilme().getCategoria().getNome();
		this.meiaEntrada = model.getSala().getTipo().getMeiaEntrada();
	}
}
