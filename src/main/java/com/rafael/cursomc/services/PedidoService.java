package com.rafael.cursomc.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.cursomc.domain.ItensPedido;
import com.rafael.cursomc.domain.PagamentoComBoleto;
import com.rafael.cursomc.domain.Pedidos;
import com.rafael.cursomc.domain.enums.EstadoPagamento;
import com.rafael.cursomc.repositories.ClienteRepository;
import com.rafael.cursomc.repositories.ItensPedidoRepository;
import com.rafael.cursomc.repositories.PagamentoRepository;
import com.rafael.cursomc.repositories.PedidoRepository;
import com.rafael.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository rep;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ItensPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Pedidos find(Integer cd_pedido){
		  Optional<Pedidos> obj  = rep.findById(cd_pedido);
		  
		  if(obj == null) {
			 throw new ObjectNotFoundException("Objeto não encontrado! Código: " + cd_pedido +
					 ", Tipo: " + Pedidos.class.getName());  
		  }
		  
		  return obj.orElse(null);
	}
	
	public Pedidos insert(Pedidos obj) {
		
		obj.setCd_pedido(null);
		obj.setDt_pedido(new Date());
		obj.setCliente(clienteService.find(obj.getCliente().getCd_cliente()));
		obj.getPagamento().setEstado_pagamento(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		
		//Data de vencimento apenas para o Pagamento com Boleto
		if(obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto,obj.getDt_pedido());
		}
		
		obj = rep.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		
		for(ItensPedido ip : obj.getItens()) {
			//seta desconto (não coloquei nesse projeto)
			ip.setVlr_unitario(produtoService.find(ip.getProduto().getCd_produto()).getPreco());		
			ip.setProduto(produtoService.find(ip.getProduto().getCd_produto()));
			ip.setPedido(obj);
		}
		
		itemPedidoRepository.saveAll(obj.getItens());
		
		System.out.println(obj);
		
		return obj;
	}
}
