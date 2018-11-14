package com.rafael.cursomc.domain;

import javax.persistence.Entity;

import com.rafael.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamentos{
	private static final long serialVersionUID = 1L;

	private String ds_numero_cartao;
	private Integer nr_parcelas;
	
	public PagamentoComCartao() {
		
	}	

	public PagamentoComCartao(Integer cd_pagamento, EstadoPagamento estado_pagamento, Pedidos pedido, String ds_numero_cartao, Integer nr_parcelas) {
		super(cd_pagamento, estado_pagamento, pedido);
		this.ds_numero_cartao = ds_numero_cartao;
		this.nr_parcelas = nr_parcelas;
	}



	public String getDs_numero_cartao() {
		return ds_numero_cartao; 
	}

	public void setDs_numero_cartao(String ds_numero_cartao) {
		this.ds_numero_cartao = ds_numero_cartao;
	}

	public Integer getNr_parcelas() {
		return nr_parcelas;
	}

	public void setNr_parcelas(Integer nr_parcelas) {
		this.nr_parcelas = nr_parcelas;
	}
	
	
	
}
