package br.com.edward.restfull.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edward.restfull.domain.Ingresso;
import br.com.edward.restfull.domain.Sessao;
import br.com.edward.restfull.model.IngressoModel;
import br.com.edward.restfull.repository.IngressoRepository;
import br.com.edward.restfull.service.IngressoService;
import br.com.edward.restfull.service.SessaoService;

@Transactional
@Service
public class IngressoServiceImpl implements IngressoService {

	@Autowired
	IngressoRepository repository;
	
	@Autowired
	SessaoService sessaoService;
	
	@Override
	public Ingresso comprarIngresso(IngressoModel model) {

		Optional<Sessao> sessao = sessaoService.findById(model.getSessao().getId());
		
		if(sessao.isPresent()) {
			return repository.save(new Ingresso(model, sessao.get()));
		}
		
		throw new RuntimeException("Sessao não existe");
	}

	@Override
	public List<Ingresso> listar() {
		return repository.findAll();
	}
	
}
