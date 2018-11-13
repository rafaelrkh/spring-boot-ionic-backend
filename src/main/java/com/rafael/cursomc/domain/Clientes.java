package com.rafael.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rafael.cursomc.domain.enums.TipoCliente;

@Entity
public class Clientes implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cd_cliente;
	private String ds_nome;
	private String ds_email;
	private String ds_cpf_cnpj;
	private String ds_senha;

	private Integer tipo;

	@JsonManagedReference
	@OneToMany(mappedBy="cliente")
	private List<Enderecos> enderecos = new ArrayList<>();

	// Conjunto de telefones para o cliente, ao invés de criar uma nova tabela
	@ElementCollection
	@CollectionTable(name="telefone")
	private Set<String> telefones = new HashSet<>(); // Entidade fraca

	public Clientes() {

	}

	public Clientes(Integer cd_cliente, String ds_nome, String ds_email, String ds_cpf_cnpj, String ds_senha,
			TipoCliente tipo) {
		super();
		this.cd_cliente = cd_cliente;
		this.ds_nome = ds_nome;
		this.ds_email = ds_email;
		this.ds_cpf_cnpj = ds_cpf_cnpj;
		this.ds_senha = ds_senha;
		this.tipo = tipo.getCdTipoCliente();
	}

	public Integer getCd_cliente() {
		return cd_cliente;
	}

	public void setCd_cliente(Integer cd_cliente) {
		this.cd_cliente = cd_cliente;
	}

	public String getDs_nome() {
		return ds_nome;
	}

	public void setDs_nome(String ds_nome) {
		this.ds_nome = ds_nome;
	}

	public String getDs_email() {
		return ds_email;
	}

	public void setDs_email(String ds_email) {
		this.ds_email = ds_email;
	}

	public String getDs_cpf_cnpj() {
		return ds_cpf_cnpj;
	}

	public void setDs_cpf_cnpj(String ds_cpf_cnpj) {
		this.ds_cpf_cnpj = ds_cpf_cnpj;
	}

	public String getDs_senha() {
		return ds_senha;
	}

	public void setDs_senha(String ds_senha) {
		this.ds_senha = ds_senha;
	}

	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCdTipoCliente();
	}

	public List<Enderecos> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Enderecos> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cd_cliente == null) ? 0 : cd_cliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clientes other = (Clientes) obj;
		if (cd_cliente == null) {
			if (other.cd_cliente != null)
				return false;
		} else if (!cd_cliente.equals(other.cd_cliente))
			return false;
		return true;
	}
	
	
	
	
}
