package br.com.edward.restfull.view;

import br.com.edward.restfull.model.SalaModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SalaView {
	
	private Long id;
	private String nome;
	private String tipo;
	
	public SalaView(SalaModel model) {
		
		this.id = model.getId();
		this.nome = model.getNome();
		this.tipo = model.getTipo().getNome();
	}
}
