package com.rafael.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.cursomc.domain.Categorias;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<Categorias> listar() {	
		
		Categorias c1 = new Categorias(1, "Informática");
		Categorias c2 = new Categorias(2, "Escritório");
		
		List<Categorias> list  = new ArrayList<Categorias>();
		list.add(c1);
		list.add(c2);
		
		return list;
	}
}
