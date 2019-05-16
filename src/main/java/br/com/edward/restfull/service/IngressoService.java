package br.com.edward.restfull.service;

import java.util.List;

import br.com.edward.restfull.domain.Ingresso;
import br.com.edward.restfull.model.IngressoModel;

public interface IngressoService {

	Ingresso comprarIngresso(IngressoModel model);
	List<Ingresso> listar();
}
