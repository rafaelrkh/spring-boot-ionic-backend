package com.rafael.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Enderecos implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cd_endereco;
	private String ds_logradouro;
	private String ds_numero;
	private String ds_bairro;
	private String ds_complemento;
	private String ds_cep;
	
	@JsonBackReference
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
		this.cd_endereco = cd_endereco;
		this.ds_logradouro = ds_logradouro;
		this.ds_numero = ds_numero;
		this.ds_bairro = ds_bairro;
		this.ds_complemento = ds_complemento;
		this.ds_cep = ds_cep;
		this.cliente = cliente;
		this.cidade = cidade;
	}

	public Integer getCd_endereco() {
		return cd_endereco;
	}

	public void setCd_endereco(Integer cd_endereco) {
		this.cd_endereco = cd_endereco;
	}

	public String getDs_logradouro() {
		return ds_logradouro;
	}

	public void setDs_logradouro(String ds_logradouro) {
		this.ds_logradouro = ds_logradouro;
	}

	public String getDs_numero() {
		return ds_numero;
	}

	public void setDs_numero(String ds_numero) {
		this.ds_numero = ds_numero;
	}

	public String getDs_bairro() {
		return ds_bairro;
	}

	public void setDs_bairro(String ds_bairro) {
		this.ds_bairro = ds_bairro;
	}

	public String getDs_complemento() {
		return ds_complemento;
	}

	public void setDs_complemento(String ds_complemento) {
		this.ds_complemento = ds_complemento;
	}

	public String getDs_cep() {
		return ds_cep;
	}

	public void setDs_cep(String ds_cep) {
		this.ds_cep = ds_cep;
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
		result = prime * result + ((cd_endereco == null) ? 0 : cd_endereco.hashCode());
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
		if (cd_endereco == null) {
			if (other.cd_endereco != null)
				return false;
		} else if (!cd_endereco.equals(other.cd_endereco))
			return false;
		return true;
	}
	
	
}
