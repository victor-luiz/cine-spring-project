package br.com.edward.restfull.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edward.restfull.domain.Audio;
import br.com.edward.restfull.domain.Filme;
import br.com.edward.restfull.domain.Sala;
import br.com.edward.restfull.domain.Sessao;
import br.com.edward.restfull.model.SessaoModel;
import br.com.edward.restfull.repository.SessaoRepository;
import br.com.edward.restfull.service.AudioService;
import br.com.edward.restfull.service.FilmeService;
import br.com.edward.restfull.service.SalaService;
import br.com.edward.restfull.service.SessaoService;

@Transactional
@Service
public class SessaoServiceImpl implements SessaoService{
	
	@Autowired
	SessaoRepository repository;
	
	@Autowired
	FilmeService filmeSercice;
	
	@Autowired
	SalaService salaSercice;
	
	@Autowired
	AudioService audioSercice;

	@Override
	public Sessao cadastrar(SessaoModel model) {
		
		Optional<Sala> sala = salaSercice.findById(model.getSala().getId());
		if (sala.isPresent()) {
			Optional<Filme> filme = filmeSercice.findById(model.getFilme().getId());
			if (filme.isPresent()) {
				Optional<Audio> audio = audioSercice.findById(model.getAudio().getId());
				if (audio.isPresent()) {
					return repository.save(new Sessao(model, filme.get(), sala.get(), audio.get()));
				}
			} else {
				throw new RuntimeException("Filme não encontrado");
			}
		} else {
			throw new RuntimeException("Sala não encontrada");
		}
		throw new RuntimeException("Audio não encontrado");
	}

	@Override
	public List<Sessao> listar() {
		return repository.findAll();
	}

	@Override
	public Sessao remover(Long id) {
		
		Sessao sessao = this.consultar(id);
		
		if(Objects.nonNull(sessao)) {
			repository.delete(sessao);
		}
		
		return sessao;		
	}
	
	@Override
	public Optional<Sessao> findById(Long id) {
		return repository.findById(id);
	}
	
	@Override
	public Sessao consultar(Long id) {
		return repository.findById(id).orElse(null);
	}
}
