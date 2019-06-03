package br.com.edward.restfull.view;

import java.util.List;
import java.util.stream.Collectors;

import br.com.edward.restfull.model.CategoriaModel;
import br.com.edward.restfull.model.FilmeModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FilmeView {
	
	private Long id;
	private String nome;
	private List<String> categorias;
	
	public FilmeView(FilmeModel model) {
		
		this.id = model.getId();
		this.nome = model.getNome();
		this.categorias = model.getCategorias().stream().map(CategoriaModel::getNome).collect(Collectors.toList());
	}
}
