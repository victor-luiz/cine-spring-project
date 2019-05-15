package br.com.edward.restfull.service;

import java.util.List;
import java.util.Optional;

import br.com.edward.restfull.domain.Sala;
import br.com.edward.restfull.model.SalaModel;

public interface SalaService {

	Sala adicionar(SalaModel model);

	List<Sala> listar();
	
	Optional<Sala> findById(Long id); 

}
