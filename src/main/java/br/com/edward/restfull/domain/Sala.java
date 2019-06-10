package br.com.edward.restfull.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import br.com.edward.restfull.model.SalaModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter

@Entity
@Table(name = "sala")
public class Sala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sala_gen")
	@SequenceGenerator(name = "sala_gen", sequenceName = "sala_id_seq", allocationSize = -1)
	private Long id;

	private String nome;

	@ManyToOne
    @JoinColumn(name = "tipo_sala_id")
	private TipoSala tipo;

	private Integer capacidade;

	@OneToMany(mappedBy = "sala")
	private List<Sessao> sessoes;
	
	public Sala(SalaModel model, TipoSala tipoSala) {
		
		this.nome = model.getNome();
		this.tipo = tipoSala;
		this.capacidade = model.getCapacidade();
	}
}
