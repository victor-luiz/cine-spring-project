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

import br.com.edward.restfull.model.FilmeModel;
import br.com.edward.restfull.service.FilmeService;

@RestController
@RequestMapping("/filme")
public class FilmeController {

	@Autowired
	private FilmeService service;
	
	@PostMapping("/cadastrar")
	public FilmeModel cadastrar(@Valid @RequestBody FilmeModel model, BindingResult bindingResult) {
	
		if(!bindingResult.hasErrors()) {
			return new FilmeModel(service.cadastrar(model));
		}
		
		throw new RuntimeException("Model invalida");
	}
	
	@GetMapping("/listar")
	public List<FilmeModel> listar(){
		return service.listar().stream().map(FilmeModel::new).collect(Collectors.toList());
	}
	
}
