package br.com.edward.restfull.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edward.restfull.domain.TipoSala;
import br.com.edward.restfull.model.TipoSalaModel;
import br.com.edward.restfull.repository.TipoSalaRepository;
import br.com.edward.restfull.service.TipoSalaService;

@Transactional
@Service
public class TipoSalaServiceImpl implements TipoSalaService{

	@Autowired
	TipoSalaRepository repository; 
	
	@Override
	public TipoSala adicionar(TipoSalaModel model) {
		return repository.save(new TipoSala(model));
	}

	@Override
	public List<TipoSala> listar() {
		return repository.findAll();
	}
	
	
}
