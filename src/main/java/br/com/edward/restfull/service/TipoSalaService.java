package br.com.edward.restfull.service;

import java.util.List;

import br.com.edward.restfull.domain.TipoSala;
import br.com.edward.restfull.model.TipoSalaModel;

public interface TipoSalaService {

	TipoSala adicionar(TipoSalaModel model);

	List<TipoSala> listar();

}
