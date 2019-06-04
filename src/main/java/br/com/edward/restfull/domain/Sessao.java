package br.com.edward.restfull.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.edward.restfull.model.SessaoModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

@Entity
@Table(name = "sessao")
public class Sessao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "filme_id")
	private Filme filme;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "sala_id")
	private Sala sala;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "audio_id")
	private Audio audio;
	
	@NotNull
	@Column(name = "dia")
	private LocalDate dia;
	
	@NotNull
	@Column(name = "horario")
	private LocalTime horario;
	
	public Sessao(SessaoModel model, Filme filme, Sala sala, Audio audio, LocalDate dia) {
		this.horario = model.getHorario();
		this.dia = dia;
		this.filme = filme;
		this.sala = sala;
		this.audio = audio;
	}
	
}

