package com.rafael.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Estados implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdEstado;
	private String dsEstado;
	
	@JsonIgnore
	@OneToMany(mappedBy="estado")
	private List<Cidades> cidades = new ArrayList<>();
	
	public Estados() {
		
	}

	public Estados(Integer cd_estado, String ds_estado) {
		super();
		this.cdEstado = cd_estado;
		this.dsEstado = ds_estado;
	}

	public Integer getCd_estado() {
		return cdEstado;
	}

	public void setCd_estado(Integer cd_estado) {
		this.cdEstado = cd_estado;
	}

	public String getDs_estado() {
		return dsEstado;
	}

	public void setDs_estado(String ds_estado) {
		this.dsEstado = ds_estado;
	}

	public List<Cidades> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidades> cidades) {
		this.cidades = cidades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdEstado == null) ? 0 : cdEstado.hashCode());
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
		Estados other = (Estados) obj;
		if (cdEstado == null) {
			if (other.cdEstado != null)
				return false;
		} else if (!cdEstado.equals(other.cdEstado))
			return false;
		return true;
	}
	
	
}
