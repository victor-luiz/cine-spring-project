package br.com.edward.restfull.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import br.com.edward.restfull.model.SessaoModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter

@Entity
@Table(name = "sessao")
public class Sessao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sessao_gen")
	@SequenceGenerator(name = "sessao_gen", sequenceName = "sessao_id_seq", allocationSize = -1)
	private Long id;

	@ManyToOne
    @JoinColumn(name = "filme_id")
	private Filme filme;

	@ManyToOne
    @JoinColumn(name = "sala_id")
	private Sala sala;

	@ManyToOne
    @JoinColumn(name = "audio_id")
	private Audio audio;

	private LocalDate dia;

	private LocalTime horario;

	@OneToMany(mappedBy = "sessao")
	private List<Ingresso> ingressos;
	
	public Sessao(SessaoModel model, Filme filme, Sala sala, Audio audio, LocalDate dia) {
		this.horario = model.getHorario();
		this.dia = dia;
		this.filme = filme;
		this.sala = sala;
		this.audio = audio;
	}
	
}

