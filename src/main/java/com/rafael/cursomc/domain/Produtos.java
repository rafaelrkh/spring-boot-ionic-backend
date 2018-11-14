package com.rafael.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Produtos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cd_produto;
	private String ds_produto;
	private Double quantidade_estoque;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA", 
	           joinColumns = @JoinColumn(name = "cd_produto"),
	           inverseJoinColumns = @JoinColumn(name = "cd_categoria")) 
	private List<Categorias> categorias = new ArrayList<>();
	
	//Conjunto de itens
	@OneToMany(mappedBy="id.produto")
    private Set<ItensPedido> itens = new HashSet<>();
    
    //Retorna os pedidos que contenham esse produto
    public List<Pedidos> getPedidos(){
    	List<Pedidos> lista = new ArrayList<>();
    	
    	for(ItensPedido x : itens) {
    		lista.add(x.getPedido());
    	}
    	
    	return lista;
    }

	public Produtos() {

	}

	public Produtos(Integer cd_produto, String ds_produto, Double quantidade_estoque) {
		super();
		this.cd_produto = cd_produto;
		this.ds_produto = ds_produto;
		this.quantidade_estoque = quantidade_estoque;
	}


	public Integer getCd_produto() {
		return cd_produto;
	}

	public void setCd_produto(Integer cd_produto) {
		this.cd_produto = cd_produto;
	}

	public String getDs_produto() {
		return ds_produto;
	}

	public void setDs_produto(String ds_produto) {
		this.ds_produto = ds_produto;
	}

	public Double getQuantidade_estoque() {
		return quantidade_estoque;
	}

	public void setQuantidade_estoque(Double quantidade_estoque) {
		this.quantidade_estoque = quantidade_estoque;
	}

	public List<Categorias> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categorias> categorias) {
		this.categorias = categorias;
	}	
	
	public Set<ItensPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItensPedido> itens) {
		this.itens = itens;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cd_produto == null) ? 0 : cd_produto.hashCode());
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
		Produtos other = (Produtos) obj;
		if (cd_produto == null) {
			if (other.cd_produto != null)
				return false;
		} else if (!cd_produto.equals(other.cd_produto))
			return false;
		return true;
	}

}
