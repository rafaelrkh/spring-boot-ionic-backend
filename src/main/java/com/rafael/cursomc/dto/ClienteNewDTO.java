package com.rafael.cursomc.dto;

import java.io.Serializable;

public class ClienteNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String dsNome;
	private String dsEmail;
	private String dsCpfCnpj;
	private String dsSenha;
	
	private Integer tipo;
	
	private String dsTelefone1;
	private String dsTelefone2;
	private String dsTelefone3;
	
	private String dsLogradouro;
	private String dsNumero;
	private String dsBairro;
	private String dsComplemento;
	private String dsCep;	

	private Integer cdCidade;
	
	public String getDsLogradouro() {
		return dsLogradouro;
	}

	public void setDsLogradouro(String dsLogradouro) {
		this.dsLogradouro = dsLogradouro;
	}

	public String getDsNumero() {
		return dsNumero;
	}

	public void setDsNumero(String dsNumero) {
		this.dsNumero = dsNumero;
	}

	public String getDsBairro() {
		return dsBairro;
	}

	public void setDsBairro(String dsBairro) {
		this.dsBairro = dsBairro;
	}

	public String getDsComplemento() {
		return dsComplemento;
	}

	public void setDsComplemento(String dsComplemento) {
		this.dsComplemento = dsComplemento;
	}

	public String getDsCep() {
		return dsCep;
	}

	public void setDsCep(String dsCep) {
		this.dsCep = dsCep;
	}

	
	public ClienteNewDTO() {
		
	}

	public String getDsNome() {
		return dsNome;
	}

	public void setDsNome(String dsNome) {
		this.dsNome = dsNome;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getDsCpfCnpj() {
		return dsCpfCnpj;
	}

	public void setDsCpfCnpj(String dsCpfCnpj) {
		this.dsCpfCnpj = dsCpfCnpj;
	}

	public String getDsSenha() {
		return dsSenha;
	}

	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}
	

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getDsTelefone1() {
		return dsTelefone1;
	}

	public void setDsTelefone1(String dsTelefone1) {
		this.dsTelefone1 = dsTelefone1;
	}

	public String getDsTelefone2() {
		return dsTelefone2;
	}

	public void setDsTelefone2(String dsTelefone2) {
		this.dsTelefone2 = dsTelefone2;
	}

	public String getDsTelefone3() {
		return dsTelefone3;
	}

	public void setDsTelefone3(String dsTelefone3) {
		this.dsTelefone3 = dsTelefone3;
	}

	public Integer getCdCidade() {
		return cdCidade;
	}

	public void setCdCidade(Integer cdCidade) {
		this.cdCidade = cdCidade;
	}
	
	
}
