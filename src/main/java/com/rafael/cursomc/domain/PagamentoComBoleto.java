package com.rafael.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rafael.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamentos{
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dtVencimento;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dtPagamento;
	
	public PagamentoComBoleto() {
		
	}

	public PagamentoComBoleto(Integer cd_pagamento, EstadoPagamento estado_pagamento, Pedidos pedido, Date dt_vencimento, Date dt_pagamento) {
		super(cd_pagamento, estado_pagamento, pedido);
		this.dtVencimento = dt_vencimento;
		this.dtPagamento = dt_pagamento;
	}

	public Date getDt_vencimento() {
		return dtVencimento;
	}

	public void setDt_vencimento(Date dt_vencimento) {
		this.dtVencimento = dt_vencimento;
	}

	public Date getDt_pagamento() {
		return dtPagamento;
	}

	public void setDt_pagamento(Date dt_pagamento) {
		this.dtPagamento = dt_pagamento;
	}
	
	
}
