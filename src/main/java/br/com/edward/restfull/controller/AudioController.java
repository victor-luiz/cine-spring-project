package br.com.edward.restfull.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.restfull.model.AudioModel;
import br.com.edward.restfull.service.AudioService;

@RestController
@RequestMapping("/audio")
public class AudioController {
	
	@Autowired
	private AudioService service;
	
	@PostMapping("/adicionar")
	public AudioModel adicionar(@Valid @RequestBody AudioModel model, BindingResult bindingResult) {
	
		if(!bindingResult.hasErrors()) {
			return new AudioModel(service.adicionar(model));
		}
		
		throw new RuntimeException("Model invalida");
	}
	
	@GetMapping("/listar")
	public List<AudioModel> listar(){
		return service.listar().stream().map(AudioModel::new).collect(Collectors.toList());
	}
}
