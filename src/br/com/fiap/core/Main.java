package br.com.fiap.core;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;

public class Main {

	public static void main(String[] args) {
		Clientes cliente = new Clientes();
		
		cliente.setNome("Everton");
		cliente.setEmail("everton@teste.com");
		
		
		Pedidos pedido1 = new Pedidos();
		pedido1.setIdCliente(cliente);
		pedido1.setDescricao("pedido 1");
		pedido1.setData(new Date(5, 5, 17));
		pedido1.setValor(2187.80);
		
		Pedidos pedido2 = new Pedidos();
		pedido2.setIdCliente(cliente);
		pedido2.setDescricao("pedido 2");
		pedido2.setData(new Date(5, 6, 17));
		pedido2.setValor(9999.00);
		
		
		List<Pedidos> pedidos = new ArrayList<>();
		
		pedidos.add(pedido1);
		pedidos.add(pedido2);
		cliente.setPedidos(pedidos);
		
		GenericDao<Clientes> dao = new GenericDao<>(Clientes.class);
		try{
			dao.adicionar(cliente);
			Clientes clienteRetorno = dao.buscar(11);
			dao.buscar(1).toString();
			System.out.println(clienteRetorno.toString());
			dao.listar().forEach(System.out::println);;
	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("fim");
		
	}

}
