package br.com.edward.restfull.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edward.restfull.domain.Categoria;
import br.com.edward.restfull.model.CategoriaModel;
import br.com.edward.restfull.repository.CategoriaRepository;
import br.com.edward.restfull.service.CategoriaService;

@Transactional
@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;

	@Override
	public Categoria cadastrar(CategoriaModel model) {
	
		System.out.println("---------> Nome: " + model.getNome());
		
		return repository.save(new Categoria(model));
	}

	@Override
	public List<Categoria> listar() {
		return repository.findAll();
	}

	@Override
	public Categoria remover(Long id) {
		Categoria categoria = consultar(id);
		
		if (Objects.nonNull(categoria)) {
			repository.delete(categoria);
		}
		
		return categoria;		
	}

	@Override
	public Categoria consultar(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	
	
	
}
