package br.com.edward.restfull.service;

import java.util.List;

import br.com.edward.restfull.domain.Categoria;
import br.com.edward.restfull.domain.Filme;

public interface FilmeCategoriaService {

	void addFilmeCategorias(Filme filme, List<Categoria> categorias);
	
}
