package com.rafael.cursomc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItensPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();
	
	private Integer quantidade;
	private Double vlr_unitario;	
	
	public ItensPedido() {
		
	}

	public ItensPedido(Pedidos pedido, Produtos produto, Integer quantidade, Double vlr_unitario) {
		super();
		//this.id = id;
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.vlr_unitario = vlr_unitario;
	}
	
	public double getSubTotal() {
		return (vlr_unitario* quantidade);
	}

	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getVlr_unitario() {
		return vlr_unitario;
	}

	public void setVlr_unitario(Double vlr_unitario) {
		this.vlr_unitario = vlr_unitario;
	}
	
	@JsonIgnore
	public Pedidos getPedido() {
		return id.getPedido();
	}
	
	
	public Produtos getProduto() {
		return id.getProduto();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ItensPedido other = (ItensPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
