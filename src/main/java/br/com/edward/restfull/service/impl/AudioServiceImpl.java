package br.com.edward.restfull.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edward.restfull.domain.Audio;
import br.com.edward.restfull.model.AudioModel;
import br.com.edward.restfull.repository.AudioRepository;
import br.com.edward.restfull.service.AudioService;

@Transactional
@Service
public class AudioServiceImpl implements AudioService {

	@Autowired
	AudioRepository repository;
	
	@Override
	public Audio adicionar(AudioModel model) {
		return repository.save(new Audio(model));
	}

	@Override
	public List<Audio> listar() {
		return repository.findAll();
	}
	
}
