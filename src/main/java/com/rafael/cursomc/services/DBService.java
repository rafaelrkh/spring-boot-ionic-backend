package com.rafael.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.cursomc.domain.Categorias;
import com.rafael.cursomc.domain.Cidades;
import com.rafael.cursomc.domain.Clientes;
import com.rafael.cursomc.domain.Enderecos;
import com.rafael.cursomc.domain.Estados;
import com.rafael.cursomc.domain.ItensPedido;
import com.rafael.cursomc.domain.PagamentoComBoleto;
import com.rafael.cursomc.domain.PagamentoComCartao;
import com.rafael.cursomc.domain.Pagamentos;
import com.rafael.cursomc.domain.Pedidos;
import com.rafael.cursomc.domain.Produtos;
import com.rafael.cursomc.domain.enums.EstadoPagamento;
import com.rafael.cursomc.domain.enums.TipoCliente;
import com.rafael.cursomc.repositories.CategoriaRepository;
import com.rafael.cursomc.repositories.CidadeRepository;
import com.rafael.cursomc.repositories.ClienteRepository;
import com.rafael.cursomc.repositories.EnderecoRepository;
import com.rafael.cursomc.repositories.EstadoRepository;
import com.rafael.cursomc.repositories.ItensPedidoRepository;
import com.rafael.cursomc.repositories.PagamentoRepository;
import com.rafael.cursomc.repositories.PedidoRepository;
import com.rafael.cursomc.repositories.ProdutoRepository;

@Service
public class DBService {
	
	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	CidadeRepository cidadeRepository;

	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	@Autowired
	ItensPedidoRepository itensPedidoRepository;

	public void instantiateTestDatabase() throws ParseException {
		
		Categorias c1 = new Categorias(null, "Informática");
		Categorias c2 = new Categorias(null, "Escritório");
		Categorias c3 = new Categorias(null, "Cama, mesa e banho");
		Categorias c4 = new Categorias(null, "Eletrônicos");
		Categorias c5 = new Categorias(null, "Jardinagem");
		Categorias c6 = new Categorias(null, "Decoração");
		Categorias c7 = new Categorias(null, "Pefumaria");
		//Categorias c8 = new Categorias(null, "Teste");

		Produtos p1 = new Produtos(null, "Computador", 1000.00,34.2);
		Produtos p2 = new Produtos(null, "Impressora", 323.54,434.2);
		Produtos p3 = new Produtos(null, "Mouse", 50.5,32.1);
		Produtos p4 = new Produtos(null, "Mesa de escritório", 43.5,43.6);
		Produtos p5 = new Produtos(null, "Toalha", 55.00,65.3);
		Produtos p6 = new Produtos(null, "Colcha", 76.78,98.2);
		Produtos p7 = new Produtos(null, "TV true color", 23.5,24.00);
		Produtos p8 = new Produtos(null, "Roçadeira", 1000.00,553.00);
		Produtos p9 = new Produtos(null, "Abajour", 44.25,234.43);
		Produtos p10 = new Produtos(null, "Pendente", 127.5,43.2);
		Produtos p11 = new Produtos(null, "Shampoo", 100.00,982.3);

		c1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		c2.getProdutos().addAll(Arrays.asList(p2));
		c3.getProdutos().addAll(Arrays.asList(p5,p6));
		c4.getProdutos().addAll(Arrays.asList(p1,p2,p3,p7));
		c5.getProdutos().addAll(Arrays.asList(p8));
		c6.getProdutos().addAll(Arrays.asList(p9,p10));
		c7.getProdutos().addAll(Arrays.asList(p11));

		p1.getCategorias().addAll(Arrays.asList(c1,c4));
		p2.getCategorias().addAll(Arrays.asList(c1, c2,c4));
		p3.getCategorias().addAll(Arrays.asList(c1,c4));
		p4.getCategorias().addAll(Arrays.asList(c2));
		p5.getCategorias().addAll(Arrays.asList(c3));
		p6.getCategorias().addAll(Arrays.asList(c3));
		p7.getCategorias().addAll(Arrays.asList(c4));
		p8.getCategorias().addAll(Arrays.asList(c5));
		p9.getCategorias().addAll(Arrays.asList(c6));
		p10.getCategorias().addAll(Arrays.asList(c6));
		p11.getCategorias().addAll(Arrays.asList(c7));

		categoriaRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3,p4,p5,p6,p7,p8,p9,p10,p11));

		Estados e1 = new Estados(null, "Minas Gerais");
		Estados e2 = new Estados(null, "São Paulo");

		Cidades ci1 = new Cidades(null, "Uberlândia", e1);
		Cidades ci2 = new Cidades(null, "São Paulo", e2);
		Cidades ci3 = new Cidades(null, "Campinas", e2);

		e1.getCidades().addAll(Arrays.asList(ci1));
		e2.getCidades().addAll(Arrays.asList(ci2, ci3));

		estadoRepository.saveAll(Arrays.asList(e1, e2));
		cidadeRepository.saveAll(Arrays.asList(ci1, ci2, ci3));

		Clientes cli1 = new Clientes(null, "Maria Silva", "maria@gmail.com", "07003999684", "******", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("(34)3831-2278","(34)9984-2006"));
		
		Enderecos end1 = new Enderecos(null,"Rua Artur Botelho", "356", "Centro", "CASA", "38740512", cli1, ci1);
		Enderecos end2 = new Enderecos(null, "Rua Inácio de Oliveira Campos", "134", "São Vicente", "AP 02", "3874512", cli1, ci2);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedidos ped1 = new Pedidos(null, sdf.parse("15/11/2018 10:32"), cli1, end1);
		Pedidos ped2 = new Pedidos(null, sdf.parse("30/11/2018 22:45"), cli1, end2);
		
		Pagamentos pgt1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, "432423532666234", 6);
		ped1.setPagamento(pgt1);
		
		Pagamentos pgt2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pgt2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pgt1, pgt2));
		
		ItensPedido i1 = new ItensPedido(ped1, p1, 99, 65.35);
		ItensPedido i2 = new ItensPedido(ped1, p3, 105, 25.63);
		ItensPedido i3 = new ItensPedido(ped2, p2, 4, 2.65);
		
		ped1.getItens().addAll(Arrays.asList(i1, i2));
		ped2.getItens().addAll(Arrays.asList(i3));
		
		p1.getItens().addAll(Arrays.asList(i1));
		p2.getItens().addAll(Arrays.asList(i3));
		p3.getItens().addAll(Arrays.asList(i2));
		
		itensPedidoRepository.saveAll(Arrays.asList(i1, i2, i3));
	}
}
