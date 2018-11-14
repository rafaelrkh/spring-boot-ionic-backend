package com.rafael.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.cursomc.domain.Pedidos;

@Repository
public interface PedidoRepository extends JpaRepository<Pedidos, Integer>{

	
}
