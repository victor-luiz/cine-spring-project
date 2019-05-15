package br.com.edward.restfull.service;

import java.util.List;

import br.com.edward.restfull.domain.Audio;
import br.com.edward.restfull.model.AudioModel;

public interface AudioService {

	Audio adicionar(AudioModel model);

	List<Audio> listar();

}
