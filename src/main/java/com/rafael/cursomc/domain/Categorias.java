package com.rafael.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Categorias implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cd_categoria;
	private String ds_categoria;
	
	@JsonManagedReference
	@ManyToMany(mappedBy="categorias") 
	private List<Produtos> produtos = new ArrayList<>();

	public Categorias() {

	}

	public Categorias(Integer cd_categoria, String ds_categeoria) {
		super();
		this.cd_categoria = cd_categoria;
		this.ds_categoria = ds_categeoria;
	}

	public Integer getCd_categoria() {
		return cd_categoria;
	}

	public void setCd_categoria(Integer cd_categoria) {
		this.cd_categoria = cd_categoria;
	}

	public String getDs_categoria() {
		return ds_categoria;
	}

	public void setDs_categoria(String ds_categeoria) {
		this.ds_categoria = ds_categeoria;
	}
	
	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cd_categoria == null) ? 0 : cd_categoria.hashCode());
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
		Categorias other = (Categorias) obj;
		if (cd_categoria == null) {
			if (other.cd_categoria != null)
				return false;
		} else if (!cd_categoria.equals(other.cd_categoria))
			return false;
		return true;
	}

		
}
