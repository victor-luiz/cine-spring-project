package br.com.edward.restfull.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edward.restfull.domain.Categoria;
import br.com.edward.restfull.domain.Filme;
import br.com.edward.restfull.domain.FilmeCategoria;
import br.com.edward.restfull.repository.FilmeCategoriaRepository;
import br.com.edward.restfull.service.FilmeCategoriaService;

@Service
public class FilmeCategoriaServiceImpl implements FilmeCategoriaService{

	@Autowired
	FilmeCategoriaRepository repository;
	
	@Override
	public void addFilmeCategorias(Filme filme, List<Categoria> categorias) {
		
		for (Categoria categoria : categorias) {
			repository.save(new FilmeCategoria(filme, categoria));
		}
		
	}
	
	
}
