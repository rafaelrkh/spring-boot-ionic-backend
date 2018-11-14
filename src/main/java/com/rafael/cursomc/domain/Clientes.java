package com.rafael.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rafael.cursomc.domain.enums.TipoCliente;

@Entity
public class Clientes implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdCliente;
	private String dsNome;
	private String dsEmail;
	private String dsCpfCnpj;
	private String dsSenha;

	private Integer tipo;

	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL)
	private List<Enderecos> enderecos = new ArrayList<>();

	// Conjunto de telefones para o cliente, ao invés de criar uma nova tabela
	@ElementCollection
	@CollectionTable(name="telefone")
	private Set<String> telefones = new HashSet<>(); // Entidade fraca
	
	@JsonIgnore
	@OneToMany(mappedBy="cliente")
	private List<Pedidos> pedidos = new ArrayList<Pedidos>();

	public Clientes() {

	}

	public Clientes(Integer cd_cliente, String ds_nome, String ds_email, String ds_cpf_cnpj, String ds_senha,
			TipoCliente tipo) {
		super();
		this.cdCliente = cd_cliente;
		this.dsNome = ds_nome;
		this.dsEmail = ds_email;
		this.dsCpfCnpj = ds_cpf_cnpj;
		this.dsSenha = ds_senha;
		this.tipo = (tipo ==null) ? null : tipo.getCdTipoCliente();
	}

	public Integer getCd_cliente() {
		return cdCliente;
	}

	public void setCd_cliente(Integer cd_cliente) {
		this.cdCliente = cd_cliente;
	}

	public String getDs_nome() {
		return dsNome;
	}

	public void setDs_nome(String ds_nome) {
		this.dsNome = ds_nome;
	}

	public String getDs_email() {
		return dsEmail;
	}

	public void setDs_email(String ds_email) {
		this.dsEmail = ds_email;
	}

	public String getDs_cpf_cnpj() {
		return dsCpfCnpj;
	}

	public void setDs_cpf_cnpj(String ds_cpf_cnpj) {
		this.dsCpfCnpj = ds_cpf_cnpj;
	}

	public String getDs_senha() {
		return dsSenha;
	}

	public void setDs_senha(String ds_senha) {
		this.dsSenha = ds_senha;
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

	public List<Pedidos> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdCliente == null) ? 0 : cdCliente.hashCode());
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
		if (cdCliente == null) {
			if (other.cdCliente != null)
				return false;
		} else if (!cdCliente.equals(other.cdCliente))
			return false;
		return true;
	}
	
	
	
	
}
