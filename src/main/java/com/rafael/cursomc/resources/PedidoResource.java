package com.rafael.cursomc.resources;


import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rafael.cursomc.domain.Pedidos;
import com.rafael.cursomc.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;

	
	@RequestMapping(value="/{cd_pedido}", method=RequestMethod.GET)
	public ResponseEntity<Pedidos> find(@PathVariable Integer cd_pedido) {	
		
		Pedidos obj = service.find(cd_pedido);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Pedidos obj){
		
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{cd_pedido}").buildAndExpand(obj.getCd_pedido()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
