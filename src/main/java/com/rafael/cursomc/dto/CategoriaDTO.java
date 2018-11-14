package com.rafael.cursomc.dto;

import java.io.Serializable;

import com.rafael.cursomc.domain.Categorias;

public class CategoriaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	//Define os dados que serão trafegados quando for fazer operação
	
	private Integer cd_categoria;
	private String ds_categoria;
	
	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(Categorias obj) {
		cd_categoria = obj.getCd_categoria();
		ds_categoria = obj.getDs_categoria();
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

	public void setDs_categoria(String ds_categoria) {
		this.ds_categoria = ds_categoria;
	}
	
	 
}
