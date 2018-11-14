package com.rafael.cursomc.dto;

import java.io.Serializable;

import com.rafael.cursomc.domain.Categorias;

public class CategoriaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	//Define os dados que serão trafegados quando for fazer operação
	
	private Integer cdCategoria;
	private String dsCategoria;
	
	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(Categorias obj) {
		cdCategoria = obj.getCd_categoria();
		dsCategoria = obj.getDs_categoria();
	}

	public Integer getCd_categoria() {
		return cdCategoria;
	}

	public void setCd_categoria(Integer cd_categoria) {
		this.cdCategoria = cd_categoria;
	}

	public String getDs_categoria() {
		return dsCategoria;
	}

	public void setDs_categoria(String ds_categoria) {
		this.dsCategoria = ds_categoria;
	}
	
	 
}
