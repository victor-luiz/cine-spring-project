package br.com.edward.restfull.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edward.restfull.domain.Sala;
import br.com.edward.restfull.domain.TipoSala;
import br.com.edward.restfull.model.SalaModel;
import br.com.edward.restfull.repository.SalaRepository;
import br.com.edward.restfull.service.SalaService;

@Transactional
@Service
public class SalaServiceImpl implements SalaService{
	
	@Autowired
	SalaRepository repository;
	
	@Autowired
	TipoSalaServiceImpl tipoSalaService;

	@Override
	public Sala adicionar(SalaModel model) {
		
		Optional<TipoSala> tipo = tipoSalaService.findById(model.getTipoSalaModel().getId()); 
		if(tipo.isPresent()) {
			return repository.save(new Sala(model, tipo.get()));
		}
		
		throw new RuntimeException("Tipo sala não encontrado");
	}

	@Override
	public List<Sala> listar() {
		return repository.findAll();
	}

	@Override
	public Optional<Sala> findById(Long id) {
		return repository.findById(id);
	}

}
