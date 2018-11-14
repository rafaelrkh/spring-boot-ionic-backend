package com.rafael.cursomc.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rafael.cursomc.domain.Categorias;
import com.rafael.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;

	@RequestMapping(method=RequestMethod.GET)
	public List<Categorias> listar() {	
		
		Categorias c1 = new Categorias(1, "Informática");
		Categorias c2 = new Categorias(2, "Escritório");
		
		List<Categorias> list  = new ArrayList<Categorias>();
		list.add(c1);
		list.add(c2);
		
		return list;
	}
	
	@RequestMapping(value="/{cd_categoria}", method=RequestMethod.GET)
	public ResponseEntity<Categorias> find(@PathVariable Integer cd_categoria) {	
		
		Categorias obj = service.find(cd_categoria);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categorias obj){
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{cd_categoria}").buildAndExpand(obj.getCd_categoria()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{cd_categoria}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categorias obj, @PathVariable Integer cd_categoria){
		obj.setCd_categoria(cd_categoria); 
		
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
		 
	}
}
