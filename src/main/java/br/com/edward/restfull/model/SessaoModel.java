package br.com.edward.restfull.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import br.com.edward.restfull.domain.Sessao;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SessaoModel {
	
	private Long id;
	
	private LocalDate dia;
	
	@NotNull
	private LocalTime horario;
	
	@NotNull
	private FilmeModel filme;
	
	@NotNull
	private SalaModel sala;
	
	@NotNull
	private AudioModel audio;

	
	public SessaoModel(Sessao domain) {
		
		this.id = domain.getId();
		this.dia = domain.getDia();
		this.horario = domain.getHorario();
		this.filme = new FilmeModel(domain.getFilme());
		this.sala = new SalaModel(domain.getSala());
		this.audio = new AudioModel(domain.getAudio());
	}
}
