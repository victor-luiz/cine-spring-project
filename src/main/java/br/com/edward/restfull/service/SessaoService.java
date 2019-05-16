package br.com.edward.restfull.service;

import java.util.List;
import java.util.Optional;

import br.com.edward.restfull.domain.Sessao;
import br.com.edward.restfull.model.SessaoModel;

public interface SessaoService {

	Sessao cadastrar(SessaoModel model);

	List<Sessao> listar();

	Sessao remover(Long id);

	Sessao consultar(Long id);

	Optional<Sessao> findById(Long id);

}
