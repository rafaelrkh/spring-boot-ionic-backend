package com.rafael.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.cursomc.domain.Clientes;
import com.rafael.cursomc.repositories.ClienteRepository;
import com.rafael.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository rep;
	
	public Clientes find(Integer cd_cliente){
		  Optional<Clientes> obj  = rep.findById(cd_cliente);
		  
		  if(obj == null) {
			 throw new ObjectNotFoundException("Objeto não encontrado! Código: " + cd_cliente +
					 ", Tipo: " + Clientes.class.getName());  
		  }
		  
		  return obj.orElse(null);
	}
}
