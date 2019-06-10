package br.com.edward.restfull.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import br.com.edward.restfull.model.TipoSalaModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter

@Entity
@Table(name = "tipo_sala")
public class TipoSala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "tipo_sala_gen")
	@SequenceGenerator(name = "tipo_sala_gen", sequenceName = "tipo_sala_id_seq", allocationSize = -1)
	private Long id;
	
	@NotNull
	@Column(name = "nome", length = 10)
	private String nome;

	private BigDecimal preco;

	@OneToMany(mappedBy = "tipo")
	private List<Sala> salas;
	
	public TipoSala(TipoSalaModel model) {
		this.nome = model.getNome();
		this.preco = Objects.nonNull(model.getPreco()) ? model.getPreco() : BigDecimal.valueOf(10);
	}
	
	public BigDecimal gerarMeiaEntrada() {
		return  this.preco.divide(BigDecimal.valueOf(2));
	}
}
