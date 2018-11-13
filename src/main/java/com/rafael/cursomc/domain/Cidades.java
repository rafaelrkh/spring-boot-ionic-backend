package com.rafael.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Cidades implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cd_cidade;
	private String ds_cidade;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="cd_estado")
	private Estados estado;
	
	public Cidades() {
		
	}

	public Cidades(Integer cd_cidade, String ds_cidade, Estados estado) {
		super();
		this.cd_cidade = cd_cidade;
		this.ds_cidade = ds_cidade;
		this.estado = estado;
	}

	public Integer getCd_cidade() {
		return cd_cidade;
	}

	public void setCd_cidade(Integer cd_cidade) {
		this.cd_cidade = cd_cidade;
	}

	public String getDs_cidade() {
		return ds_cidade;
	}

	public void setDs_cidade(String ds_cidade) {
		this.ds_cidade = ds_cidade;
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
		result = prime * result + ((cd_cidade == null) ? 0 : cd_cidade.hashCode());
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
		if (cd_cidade == null) {
			if (other.cd_cidade != null)
				return false;
		} else if (!cd_cidade.equals(other.cd_cidade))
			return false;
		return true;
	}
	
	
}
