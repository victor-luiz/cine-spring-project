package br.com.edward.restfull.model;

import br.com.edward.restfull.domain.Categoria;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CategoriaModel {
	
	private Long id;
	private String nome;
	
	public CategoriaModel(Categoria domain) {
		this.id = domain.getId();
		this.nome = domain.getNome();
	}
	
}
