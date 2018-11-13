package com.rafael.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafael.cursomc.domain.Categorias;
import com.rafael.cursomc.domain.Cidades;
import com.rafael.cursomc.domain.Estados;
import com.rafael.cursomc.domain.Produtos;
import com.rafael.cursomc.repositories.CategoriaRepository;
import com.rafael.cursomc.repositories.CidadeRepository;
import com.rafael.cursomc.repositories.EstadoRepository;
import com.rafael.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EstadoRepository estadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categorias c1 = new Categorias(null, "Informática");
		Categorias c2 = new Categorias(null, "Escritório");

		Produtos p1 = new Produtos(null, "Computador", 1000.00);
		Produtos p2 = new Produtos(null, "Impressora", 323.54);
		Produtos p3 = new Produtos(null, "Mouse", 50.5);

		c1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		c2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(c1));
		p2.getCategorias().addAll(Arrays.asList(c1,c2));
		p3.getCategorias().addAll(Arrays.asList(c1));	

		categoriaRepository.saveAll(Arrays.asList(c1, c2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estados e1 = new Estados(null,"Minas Gerais");
		Estados e2 = new Estados(null,"São Paulo");
		
		Cidades ci1 = new Cidades(null, "Uberlândia", e1);
		Cidades ci2 = new Cidades(null, "São Paulo", e2);
		Cidades ci3 = new Cidades(null, "Campinas", e2);
		
		e1.getCidades().addAll(Arrays.asList(ci1));
		e2.getCidades().addAll(Arrays.asList(ci2, ci3));
		
		estadoRepository.saveAll(Arrays.asList(e1, e2));
		cidadeRepository.saveAll(Arrays.asList(ci1, ci2, ci3));
		
	}

}
