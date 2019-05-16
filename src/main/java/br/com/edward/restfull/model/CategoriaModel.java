package br.com.edward.restfull.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.edward.restfull.domain.Categoria;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CategoriaModel {
	
	private Long id;
	
	@NotNull
	@Length(min = 3, max = 20)
	private String nome;
	
	public CategoriaModel(Categoria domain) {
		this.id = domain.getId();
		this.nome = domain.getNome();
	}
	
}
