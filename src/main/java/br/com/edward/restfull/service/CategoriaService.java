package br.com.edward.restfull.service;

import java.util.List;

import br.com.edward.restfull.domain.Categoria;
import br.com.edward.restfull.model.CategoriaModel;

public interface CategoriaService {

	Categoria cadastrar(CategoriaModel model);

	List<Categoria> listar();

	Categoria remover(Long id);
	
	Categoria consultar(Long id);

}
