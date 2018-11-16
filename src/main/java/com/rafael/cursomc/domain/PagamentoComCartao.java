package com.rafael.cursomc.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.rafael.cursomc.domain.enums.EstadoPagamento;

@Entity
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamentos{
	private static final long serialVersionUID = 1L;

	private String dsNumeroCartao;
	private Integer nrParcelas;
	
	public PagamentoComCartao() {
		
	}	

	public PagamentoComCartao(Integer cd_pagamento, EstadoPagamento estado_pagamento, Pedidos pedido, String ds_numero_cartao, Integer nr_parcelas) {
		super(cd_pagamento, estado_pagamento, pedido);
		this.dsNumeroCartao = ds_numero_cartao;
		this.nrParcelas = nr_parcelas;
	}



	public String getDs_numero_cartao() {
		return dsNumeroCartao; 
	}

	public void setDs_numero_cartao(String ds_numero_cartao) {
		this.dsNumeroCartao = ds_numero_cartao;
	}

	public Integer getNr_parcelas() {
		return nrParcelas;
	}

	public void setNr_parcelas(Integer nr_parcelas) {
		this.nrParcelas = nr_parcelas;
	}
	
	
	
}
