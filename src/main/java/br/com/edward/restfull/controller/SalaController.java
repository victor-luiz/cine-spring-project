package br.com.edward.restfull.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
	public SalaModel adicionar(@RequestBody SalaModel model) {
		return new SalaModel(service.adicionar(model));
	}
	
	@GetMapping("/listar")
	public List<SalaModel> listar() {
		return service.listar().stream().map(SalaModel::new).collect(Collectors.toList());
	}

}
