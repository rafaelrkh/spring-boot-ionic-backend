package com.rafael.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rafael.cursomc.domain.enums.EstadoPagamento;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Pagamentos  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer cd_pagamento;
	
	private Integer estado_pagamento;
	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name="cd_pedido")
	@MapsId
	private Pedidos pedido;

	public Pagamentos() {
		
	}

	public Pagamentos(Integer cd_pagamento, EstadoPagamento estado_pagamento, Pedidos pedido) {
		this.cd_pagamento = cd_pagamento;
		this.estado_pagamento = estado_pagamento.getCdEstadoPagamento();
		this.pedido = pedido;
	}

	public Integer getCd_pagamento() {
		return cd_pagamento;
	}

	public void setCd_pagamento(Integer cd_pagamento) {
		this.cd_pagamento = cd_pagamento;
	}

	public EstadoPagamento getEstado_pagamento() {
		return EstadoPagamento.toEnum(estado_pagamento);
	}

	public void setEstado_pagamento(EstadoPagamento estado_pagamento) {
		this.estado_pagamento = estado_pagamento.getCdEstadoPagamento();
	}

	public Pedidos getPedido() {
		return pedido;
	}

	public void setPedido(Pedidos pedido) {
		this.pedido = pedido;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cd_pagamento;
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
		Pagamentos other = (Pagamentos) obj;
		if (cd_pagamento != other.cd_pagamento)
			return false;
		return true;
	}
	
	
}
