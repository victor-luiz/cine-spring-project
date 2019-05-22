package br.com.edward.restfull.view;

import br.com.edward.restfull.model.CategoriaModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CategoriaView {
	
	private Long id;
	private String nome;
	
	public CategoriaView(CategoriaModel model) {
		
		this.id = model.getId();
		this.nome = model.getNome();
	}

}
