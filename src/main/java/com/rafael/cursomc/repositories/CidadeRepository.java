package com.rafael.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.cursomc.domain.Cidades;

@Repository
public interface CidadeRepository extends JpaRepository<Cidades, Integer>{

	
}
