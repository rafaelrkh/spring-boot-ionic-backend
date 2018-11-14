package com.rafael.cursomc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedidos implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdPedido;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dtPedido;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="pedido")
	private Pagamentos pagamento;
	
	@ManyToOne
	@JoinColumn(name="cd_cliente")
	private Clientes cliente;
	
	@ManyToOne
	@JoinColumn(name="cd_endereco_entrega")
	private Enderecos enderecoEntrega;
	
	//Conjunto de itens
	@OneToMany(mappedBy="id.pedido")
	private Set<ItensPedido> itens = new HashSet<>();
	
	public Pedidos() {
		
	}

	public Pedidos(Integer cd_pedido, Date dt_pedido,  Clientes cliente, Enderecos endereco_entrega) {
		super();
		this.cdPedido = cd_pedido;
		this.dtPedido = dt_pedido;
		//this.pagamento = pagamento;
		this.cliente = cliente;
		this.enderecoEntrega = endereco_entrega;
	}

	public Integer getCd_pedido() {
		return cdPedido;
	}

	public void setCd_pedido(Integer cd_pedido) {
		this.cdPedido = cd_pedido;
	}

	public Date getDt_pedido() {
		return dtPedido;
	}

	public void setDt_pedido(Date dt_pedido) {
		this.dtPedido = dt_pedido;
	}

	public Pagamentos getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamentos pagamento) {
		this.pagamento = pagamento;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public Enderecos getEndereco_entrega() {
		return enderecoEntrega;
	}

	public void setEndereco_entrega(Enderecos endereco_entrega) {
		this.enderecoEntrega = endereco_entrega;
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
		result = prime * result + ((cdPedido == null) ? 0 : cdPedido.hashCode());
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
		Pedidos other = (Pedidos) obj;
		if (cdPedido == null) {
			if (other.cdPedido != null)
				return false;
		} else if (!cdPedido.equals(other.cdPedido))
			return false;
		return true;
	}

	
}
