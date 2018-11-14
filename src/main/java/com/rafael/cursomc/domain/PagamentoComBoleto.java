package com.rafael.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.rafael.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamentos{
	private static final long serialVersionUID = 1L;
	
	private Date dt_vencimento;
	private Date dt_pagamento;
	
	public PagamentoComBoleto() {
		
	}

	public PagamentoComBoleto(Integer cd_pagamento, EstadoPagamento estado_pagamento, Pedidos pedido, Date dt_vencimento, Date dt_pagamento) {
		super(cd_pagamento, estado_pagamento, pedido);
		this.dt_vencimento = dt_vencimento;
		this.dt_pagamento = dt_pagamento;
	}

	public Date getDt_vencimento() {
		return dt_vencimento;
	}

	public void setDt_vencimento(Date dt_vencimento) {
		this.dt_vencimento = dt_vencimento;
	}

	public Date getDt_pagamento() {
		return dt_pagamento;
	}

	public void setDt_pagamento(Date dt_pagamento) {
		this.dt_pagamento = dt_pagamento;
	}
	
	
}
