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

import br.com.edward.restfull.model.IngressoModel;
import br.com.edward.restfull.service.IngressoService;
import br.com.edward.restfull.view.IngressoView;

@RestController
@RequestMapping("/ingresso")
public class IngressoController {
	
	@Autowired
	private IngressoService service;
	
	@PostMapping("/comprar-ingresso")
	public IngressoView comprarIngresso(@Valid @RequestBody IngressoModel model, BindingResult bindingResult) {
	
		if (!bindingResult.hasErrors()) {
			return new IngressoView(new IngressoModel(service.comprarIngresso(model)));
		}
		
		throw new RuntimeException("Model invalida");
	}
	
	@GetMapping("/listar")
	public List<IngressoModel> listar() {
		return service.listar().stream().map(IngressoModel::new).collect(Collectors.toList());
	}
	
//	@DeleteMapping("/remover")
//	public SessaoModel remover(@RequestParam Long id) {
//		return new SessaoModel((service.remover(id)));
//	}
	
}
