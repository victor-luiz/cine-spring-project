package br.com.edward.restfull.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.restfull.model.SessaoModel;
import br.com.edward.restfull.service.SessaoService;

@RestController
@RequestMapping("/sessao")
public class SessaoController {
	
	@Autowired
	private SessaoService service;
	
	@PostMapping("/cadastrar")
	public SessaoModel cadastrar(@RequestBody SessaoModel model) {
		return new SessaoModel(service.cadastrar(model));
	}
	
	@GetMapping("/listar")
	public List<SessaoModel> listar() {
		return service.listar().stream().map(SessaoModel::new).collect(Collectors.toList());
	}
	
	@DeleteMapping("/remover")
	public SessaoModel remover(@RequestParam Long id) {
		return new SessaoModel((service.remover(id)));
	}
	
}
