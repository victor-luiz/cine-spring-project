package br.com.edward.restfull.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.edward.restfull.model.TipoSalaModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

@Entity
@Table(name = "tipo_sala")
public class TipoSala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "nome", length = 10)
	private String nome;
	
//@NotNull
	@Column(name = "preco")
	private Double preco;
	
	public TipoSala(TipoSalaModel model) {
		this.nome = model.getNome();
		this.preco = Objects.nonNull(model.getPreco()) ? model.getPreco() : 10;
	}
	
	public Double gerarMeiaEntrada() {
		return this.preco / 2;
	}
}
