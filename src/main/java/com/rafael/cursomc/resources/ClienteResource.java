package com.rafael.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.cursomc.domain.Categorias;
import com.rafael.cursomc.domain.Clientes;
import com.rafael.cursomc.domain.enums.TipoCliente;
import com.rafael.cursomc.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;

	@RequestMapping(method=RequestMethod.GET)
	public List<Clientes> listar() {			
		
		Clientes cli1 = new Clientes(1, "Maria Silva", "maria@gmail.com", "07003999684", "******", TipoCliente.PESSOAFISICA);
		
		List<Clientes> list  = new ArrayList<Clientes>();
		list.add(cli1);
		
		return list;
	}
	
	@RequestMapping(value="/{cd_cliente}", method=RequestMethod.GET)
	public ResponseEntity<Clientes> find(@PathVariable Integer cd_cliente) {	
		
		Clientes obj = service.find(cd_cliente);
		
		return ResponseEntity.ok().body(obj);
	}
}
