package br.com.edward.restfull.view;

import br.com.edward.restfull.model.IngressoModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class IngressoView {
	
	private String filme;
	private String audio;
	private String sala;
	private String tipoSala;
	private Double preco;
	
	public IngressoView(IngressoModel model) {
		this.filme = model.getSessao().getFilme();
		this.audio = model.getSessao().getAudio();
		this.sala = model.getSessao().getSala();
		this.tipoSala = model.getSessao().getTipoSala();
		this.preco = model.getPreco();
	}
}
