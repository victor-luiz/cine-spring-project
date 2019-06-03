package br.com.edward.restfull.model;

import java.util.List;
import java.util.stream.Collectors;

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
	
	private List<FilmeModel> filmes;
	
	public CategoriaModel(Categoria domain) {
		this.id = domain.getId();
		this.nome = domain.getNome();
		this.filmes = domain.getFilmes().stream().map(FilmeModel::new).collect(Collectors.toList()); 
	}
	
}
