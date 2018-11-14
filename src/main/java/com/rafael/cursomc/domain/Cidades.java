package com.rafael.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cidades implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdCidade;
	private String dsCidade;
	
	@ManyToOne
	@JoinColumn(name="cd_estado")
	private Estados estado;
	
	public Cidades() {
		
	}

	public Cidades(Integer cd_cidade, String ds_cidade, Estados estado) {
		super();
		this.cdCidade = cd_cidade;
		this.dsCidade = ds_cidade;
		this.estado = estado;
	}

	public Integer getCd_cidade() {
		return cdCidade;
	}

	public void setCd_cidade(Integer cd_cidade) {
		this.cdCidade = cd_cidade;
	}

	public String getDs_cidade() {
		return dsCidade;
	}

	public void setDs_cidade(String ds_cidade) {
		this.dsCidade = ds_cidade;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdCidade == null) ? 0 : cdCidade.hashCode());
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
		Cidades other = (Cidades) obj;
		if (cdCidade == null) {
			if (other.cdCidade != null)
				return false;
		} else if (!cdCidade.equals(other.cdCidade))
			return false;
		return true;
	}
	
	
}
