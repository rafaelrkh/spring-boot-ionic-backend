package com.rafael.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.rafael.cursomc.domain.Categorias;
import com.rafael.cursomc.repositories.CategoriaRepository;
import com.rafael.cursomc.services.exceptions.DataIntegrityException;
import com.rafael.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository rep;
	
	public Categorias find(Integer cd_categoria){
		  Optional<Categorias> obj  = rep.findById(cd_categoria);
		  
		  if(obj == null) {
			 throw new ObjectNotFoundException("Objeto não encontrado! Código: " + cd_categoria +
					 ", Tipo: " + Categorias.class.getName());  
		  }
		  
		  return obj.orElse(null);
	}
	
	public Categorias insert(Categorias obj) {
		obj.setCd_categoria(null); // O Codigo deve ser nulo, pois o método "save" entende que é uma inserção e não alteração
		return rep.save(obj);
	}
	
	public Categorias update(Categorias obj) {
		
		//Verificando existência de código da categoria
		find(obj.getCd_categoria());
		
		return rep.save(obj);
	}
	
	public void delete(Integer cd_categoria) {
		
		//Verificando existência de código da categoria
		find(cd_categoria);
		
		try {
		
			rep.deleteById(cd_categoria);
			
		} catch(DataIntegrityViolationException e) { //Se houver alguma integridade de categoria e produto, esta excessão aborta a exclusão
			
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos!");
		}
	}
}
