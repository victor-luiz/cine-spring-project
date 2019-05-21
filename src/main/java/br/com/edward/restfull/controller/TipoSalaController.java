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

import br.com.edward.restfull.model.TipoSalaModel;
import br.com.edward.restfull.service.TipoSalaService;
import br.com.edward.restfull.view.TipoSalaView;

@RestController
@RequestMapping("/tipo-sala")
public class TipoSalaController {
	
	@Autowired
	TipoSalaService service;
	
	@PostMapping("/adicionar")
	public TipoSalaView adicionar(@Valid @RequestBody TipoSalaModel model, BindingResult bindingResult) {
	
		if(!bindingResult.hasErrors()) {
			return new TipoSalaView(new TipoSalaModel(service.adicionar(model)));
		}
		
		throw new RuntimeException("Model invalida");
	}
	
	@GetMapping("/listar")
	public List<TipoSalaView> adicionar() {
		return service.listar().stream().map(TipoSalaModel::new).map(TipoSalaView::new).collect(Collectors.toList());
	}
	
}
