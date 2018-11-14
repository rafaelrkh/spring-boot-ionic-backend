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
	private Integer cd_estado;
	private String ds_estado;
	
	@JsonIgnore
	@OneToMany(mappedBy="estado")
	private List<Cidades> cidades = new ArrayList<>();
	
	public Estados() {
		
	}

	public Estados(Integer cd_estado, String ds_estado) {
		super();
		this.cd_estado = cd_estado;
		this.ds_estado = ds_estado;
	}

	public Integer getCd_estado() {
		return cd_estado;
	}

	public void setCd_estado(Integer cd_estado) {
		this.cd_estado = cd_estado;
	}

	public String getDs_estado() {
		return ds_estado;
	}

	public void setDs_estado(String ds_estado) {
		this.ds_estado = ds_estado;
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
		result = prime * result + ((cd_estado == null) ? 0 : cd_estado.hashCode());
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
		if (cd_estado == null) {
			if (other.cd_estado != null)
				return false;
		} else if (!cd_estado.equals(other.cd_estado))
			return false;
		return true;
	}
	
	
}
