package br.com.edward.restfull.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edward.restfull.domain.Filme;
import br.com.edward.restfull.model.FilmeModel;
import br.com.edward.restfull.repository.FilmeRepository;
import br.com.edward.restfull.service.FilmeService;

@Transactional
@Service
public class FilmeServiceImpl implements FilmeService{
	
	@Autowired
	private FilmeRepository repository;

	@Override
	public Filme cadastrar(FilmeModel model) {
		return repository.save(new Filme(model));
	}

	@Override
	public List<Filme> listar() {
		return repository.findAll();
	}

}
