package br.com.edward.restfull.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import br.com.edward.restfull.domain.Sessao;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SessaoModel {
	
	private Long id;
	
	@NotNull
	private FilmeModel filme;
	
	@NotNull
	private SalaModel sala;
	
	@NotNull
	private AudioModel audio;
	
<<<<<<< HEAD
	private Boolean[] lugares;
=======
	
	private List<LugaresModel> lugares;
>>>>>>> d2ed9d5602b3a7b6e0b3e77de6f9ee83f5dacf7f
	
	public SessaoModel(Sessao domain) {
		
		this.id = domain.getId();
		this.filme = new FilmeModel(domain.getFilme());
		this.sala = new SalaModel(domain.getSala());
		this.audio = new AudioModel(domain.getAudio());
		this.lugares = domain.getLugares().stream().map(LugaresModel::new).collect(Collectors.toList());
	}
}
