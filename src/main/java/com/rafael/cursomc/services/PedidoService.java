package com.rafael.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.cursomc.domain.Pedidos;
import com.rafael.cursomc.repositories.PedidoRepository;
import com.rafael.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository rep;
	
	public Pedidos find(Integer cd_pedido){
		  Optional<Pedidos> obj  = rep.findById(cd_pedido);
		  
		  if(obj == null) {
			 throw new ObjectNotFoundException("Objeto não encontrado! Código: " + cd_pedido +
					 ", Tipo: " + Pedidos.class.getName());  
		  }
		  
		  return obj.orElse(null);
	}
}
