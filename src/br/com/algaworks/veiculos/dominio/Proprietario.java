package br.com.algaworks.veiculos.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "proprietario")
public class Proprietario {
	private Long codigo;
	private String nome;
	private List<Telefone> telefones = new ArrayList<>();

	@Id
	@GeneratedValue
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Column(name = "nome", length = 60, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ElementCollection
	@CollectionTable(name = "proprietario_telefones",
	joinColumns = @JoinColumn(name = "cod_proprietario"))
	@AttributeOverrides({ @AttributeOverride(name = "numero",
	column = @Column(name = "num_telefone", length = 20, nullable = false)) })
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

}
