package com.rafael.cursomc.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;

import com.rafael.cursomc.domain.Categorias;

public class CategoriaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	//Define os dados que serão trafegados quando for fazer operação
	
	private Integer cdCategoria;
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5,max=80,message="O tamanho deve ser maior do que 5 e menor do que 80 caracteres")
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
