package br.com.edward.restfull.domain;

import javax.persistence.*;

import br.com.edward.restfull.model.IngressoModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter


@Entity
@Table(name = "ingresso")
public class Ingresso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ingresso_gen")
	@SequenceGenerator(name = "ingresso_gen", sequenceName = "ingresso_id_seq", allocationSize = -1)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "sessao_id")
	private Sessao sessao;

	private Integer lugar;
	
	public Ingresso(IngressoModel model, Sessao sessao) {
		this.sessao = sessao;
		this.lugar = model.getLugar();
	}

}
