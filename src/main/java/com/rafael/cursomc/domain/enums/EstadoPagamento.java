package com.rafael.cursomc.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int cd_estado_pagamento;
	private String ds_estado_pagamento;
	
	private EstadoPagamento(int cd_estado_pagamento, String ds_estado_pagamento) {
		this.cd_estado_pagamento = cd_estado_pagamento;
		this.ds_estado_pagamento = ds_estado_pagamento;
	}
	
	public int getCdEstadoPagamento() {
		return cd_estado_pagamento;
	}
	
	public String getDsEstadoPagamento() {
		return ds_estado_pagamento;
	}
	
public static EstadoPagamento toEnum(Integer cd_estado_pagamento) {
	
		if(cd_estado_pagamento == null) {
			return null;
		}
		
		for(EstadoPagamento x : EstadoPagamento.values()) {
			if(cd_estado_pagamento.equals(x.getCdEstadoPagamento())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido: " + cd_estado_pagamento);
	}
}
