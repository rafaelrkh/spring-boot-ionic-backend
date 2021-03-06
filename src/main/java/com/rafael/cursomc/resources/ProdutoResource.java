package com.rafael.cursomc.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.cursomc.domain.Produtos;
import com.rafael.cursomc.dto.ProdutoDTO;
import com.rafael.cursomc.resources.utils.URL;
import com.rafael.cursomc.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;

	
	@RequestMapping(value="/{cd_produto}", method=RequestMethod.GET)
	public ResponseEntity<Produtos> find(@PathVariable Integer cd_produto) {	
		
		Produtos obj = service.find(cd_produto);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDTO>> findPage(
			@RequestParam(value="dsProduto", defaultValue="") String dsProduto, 
			@RequestParam(value="categorias", defaultValue="") String categorias,
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="dsProduto") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {			
		
		String dsProdutoDecode = URL.decodeParam(dsProduto);
		List<Integer> ids = URL.decodeIntList(categorias);
		
		Page<Produtos> list = service.search(dsProdutoDecode,ids, page, linesPerPage, orderBy, direction);
		Page<ProdutoDTO> listDto = list.map(obj -> new ProdutoDTO(obj));
		
		return ResponseEntity.ok().body(listDto);
		
	}

}
