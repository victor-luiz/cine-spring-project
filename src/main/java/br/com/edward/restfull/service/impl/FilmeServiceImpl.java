package br.com.edward.restfull.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edward.restfull.domain.Categoria;
import br.com.edward.restfull.domain.Filme;
import br.com.edward.restfull.model.CategoriaModel;
import br.com.edward.restfull.model.FilmeModel;
import br.com.edward.restfull.repository.FilmeRepository;
import br.com.edward.restfull.service.CategoriaService;
import br.com.edward.restfull.service.FilmeCategoriaService;
import br.com.edward.restfull.service.FilmeService;

@Transactional
@Service
public class FilmeServiceImpl implements FilmeService{
	
	@Autowired
	private CategoriaService categoriaService; 
	
	@Autowired
	private FilmeRepository repository;
	
	@Autowired
	private FilmeCategoriaService  filmeCategoriaService;

	@Override
	public Filme cadastrar(FilmeModel model) {
		List<Categoria> categorias = new ArrayList<>();
		
		for (CategoriaModel categoriaModel : model.getCategorias()) {
			
			Categoria categoria =  categoriaService.consultar(categoriaModel.getId());
			
			if (Objects.nonNull(categoria)) {
				categorias.add(categoria);
			} else {
				new RuntimeException("Categoria não encotrada");
			}
		}
		
		Filme filme = new Filme(model, categorias);
		
		filmeCategoriaService.addFilmeCategorias(filme, categorias);
		return repository.save(filme);
	}

	@Override
	public List<Filme> listar() {
		return repository.findAll();
	}

	@Override
	public Optional<Filme> findById(Long id) {
		return repository.findById(id);
	}

}
