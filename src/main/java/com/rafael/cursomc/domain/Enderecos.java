package com.rafael.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Enderecos implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdEndereco;
	private String dsLogradouro;
	private String dsNumero;
	private String dsBairro;
	private String dsComplemento;
	private String dsCep;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cd_cliente")
	private Clientes cliente;
	
	@ManyToOne
	@JoinColumn(name="cd_cidade")
	private Cidades cidade;
	
	public Enderecos() {
		
	}

	public Enderecos(Integer cd_endereco, String ds_logradouro, String ds_numero, String ds_bairro,
			String ds_complemento, String ds_cep, Clientes cliente, Cidades cidade) {
		super();
		this.cdEndereco = cd_endereco;
		this.dsLogradouro = ds_logradouro;
		this.dsNumero = ds_numero;
		this.dsBairro = ds_bairro;
		this.dsComplemento = ds_complemento;
		this.dsCep = ds_cep;
		this.cliente = cliente;
		this.cidade = cidade;
	}

	public Integer getCd_endereco() {
		return cdEndereco;
	}

	public void setCd_endereco(Integer cd_endereco) {
		this.cdEndereco = cd_endereco;
	}

	public String getDs_logradouro() {
		return dsLogradouro;
	}

	public void setDs_logradouro(String ds_logradouro) {
		this.dsLogradouro = ds_logradouro;
	}

	public String getDs_numero() {
		return dsNumero;
	}

	public void setDs_numero(String ds_numero) {
		this.dsNumero = ds_numero;
	}

	public String getDs_bairro() {
		return dsBairro;
	}

	public void setDs_bairro(String ds_bairro) {
		this.dsBairro = ds_bairro;
	}

	public String getDs_complemento() {
		return dsComplemento;
	}

	public void setDs_complemento(String ds_complemento) {
		this.dsComplemento = ds_complemento;
	}

	public String getDs_cep() {
		return dsCep;
	}

	public void setDs_cep(String ds_cep) {
		this.dsCep = ds_cep;
	}
	
	

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	
	public Cidades getCidade() {
		return cidade;
	}

	public void setCidade(Cidades cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdEndereco == null) ? 0 : cdEndereco.hashCode());
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
		Enderecos other = (Enderecos) obj;
		if (cdEndereco == null) {
			if (other.cdEndereco != null)
				return false;
		} else if (!cdEndereco.equals(other.cdEndereco))
			return false;
		return true;
	}
	
	
}
