package br.com.edward.restfull.view;

import br.com.edward.restfull.model.IngressoModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
public class IngressoView {
	
	private String filme;
	private String audio;
	private String sala;
	private String tipoSala;
	private BigDecimal preco;
	
	public IngressoView(IngressoModel model) {
		this.filme = model.getSessao().getFilme().getNome();
		this.audio = model.getSessao().getAudio().getNome();
		this.sala = model.getSessao().getSala().getNome();
		this.tipoSala = model.getSessao().getSala().getTipo().getNome();
		this.preco = model.getPreco();
	}
}
