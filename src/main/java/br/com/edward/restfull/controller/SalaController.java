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

import br.com.edward.restfull.model.SalaModel;
import br.com.edward.restfull.service.SalaService;

@RestController
@RequestMapping("/sala")
public class SalaController {
	
	@Autowired
	private SalaService service;
	
	@PostMapping("/adicionar")
	public SalaModel adicionar(@Valid @RequestBody SalaModel model, BindingResult bindingResult) {
	
		if(!bindingResult.hasErrors()) {
			return new SalaModel(service.adicionar(model));
		}
		
		throw new RuntimeException("Model invalida");
	}
	
	@GetMapping("/listar")
	public List<SalaModel> listar() {
		return service.listar().stream().map(SalaModel::new).collect(Collectors.toList());
	}

}
