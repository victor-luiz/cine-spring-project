package br.com.edward.restfull.view;

import br.com.edward.restfull.model.FilmeModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FilmeView {
	
	private Long id;
	private String nome;
	private String categoria;
	
	public FilmeView(FilmeModel model) {
		
		this.id = model.getId();
		this.nome = model.getNome();
		this.categoria = model.getCategoria().getNome();
	}
}
