
package br.com.edward.restfull.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.restfull.model.CategoriaModel;
import br.com.edward.restfull.service.CategoriaService;
import br.com.edward.restfull.view.CategoriaView;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@PostMapping("/cadastrar")
	public CategoriaView cadastrar(@Valid @RequestBody CategoriaModel model, BindingResult bindingResult) {
	
		if(!bindingResult.hasErrors()) {
			return new CategoriaView(new CategoriaModel(service.cadastrar(model)));
		}
		
		throw new RuntimeException("Model invalida");
		
		//return model;
	}
	
	@GetMapping("/listar")
	public List<CategoriaView> listar() {
		return service.listar().stream().map(CategoriaModel::new).map(CategoriaView::new).collect(Collectors.toList());
	}
	
	@DeleteMapping("/remover")
	public CategoriaModel remover(@RequestParam Long id) {
		return new CategoriaModel((service.remover(id)));
	}
}
