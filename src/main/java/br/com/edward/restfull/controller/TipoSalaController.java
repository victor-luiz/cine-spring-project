package br.com.edward.restfull.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.restfull.model.TipoSalaModel;
import br.com.edward.restfull.service.TipoSalaService;

@RestController
@RequestMapping("/tipo-sala")
public class TipoSalaController {
	
	@Autowired
	TipoSalaService service;
	
	@PostMapping("/adicionar")
	public TipoSalaModel adicionar(@RequestBody TipoSalaModel model) {
		return new TipoSalaModel(service.adicionar(model));
	}
	
	@GetMapping("/listar")
	public List<TipoSalaModel> adicionar() {
		return service.listar().stream().map(TipoSalaModel::new).collect(Collectors.toList());
	}
	
}
