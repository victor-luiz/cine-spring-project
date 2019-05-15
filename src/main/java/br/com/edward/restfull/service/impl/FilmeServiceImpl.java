package br.com.edward.restfull.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edward.restfull.domain.Categoria;
import br.com.edward.restfull.domain.Filme;
import br.com.edward.restfull.model.FilmeModel;
import br.com.edward.restfull.repository.FilmeRepository;
import br.com.edward.restfull.service.CategoriaService;
import br.com.edward.restfull.service.FilmeService;

@Transactional
@Service
public class FilmeServiceImpl implements FilmeService{
	
	@Autowired
	private CategoriaService categoriaService; 
	
	@Autowired
	private FilmeRepository repository;

	@Override
	public Filme cadastrar(FilmeModel model) {
		Categoria categoria =  categoriaService.consultar(model.getIdCategoria());
		return repository.save(new Filme(model, categoria));
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
