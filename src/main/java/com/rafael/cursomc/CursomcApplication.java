package com.rafael.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafael.cursomc.domain.Categorias;
import com.rafael.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categorias c1 = new Categorias(null,"Informática");
		Categorias c2 = new Categorias(null, "Escritório");
		
		categoriaRepository.saveAll(Arrays.asList(c1,c2));
		
	}
	
	
}
