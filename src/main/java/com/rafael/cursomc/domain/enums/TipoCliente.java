package com.rafael.cursomc.domain.enums;

public enum TipoCliente {

   PESSOAFISICA(1, "Pessoa Física"), 
   PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	public int cd_tipo_cliente;
	private String ds_tipo_cliente;
	
	private TipoCliente(int cd_tipo_cliente, String ds_tipo_cliente) {
		this.cd_tipo_cliente = cd_tipo_cliente;
		this.ds_tipo_cliente = ds_tipo_cliente;
	}
	
	public int getCdTipoCliente() {
		return cd_tipo_cliente;		
	}
	
	public String getDsTipoCliente() {
		return ds_tipo_cliente;
	}
	
	public static TipoCliente toEnum(Integer cd_tipo_cliente) {
		
		if(cd_tipo_cliente == null) {
			return null;
		}
		
		for(TipoCliente x : TipoCliente.values()) {
			if(cd_tipo_cliente.equals(x.getCdTipoCliente())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido: " + cd_tipo_cliente);
	}
}
