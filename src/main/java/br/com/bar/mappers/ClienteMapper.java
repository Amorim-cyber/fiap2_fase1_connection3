package br.com.bar.mappers;

import java.util.List;
import java.util.stream.Collectors;

import br.com.bar.dao.ClienteDAO;
import br.com.bar.domain.Cliente;

public class ClienteMapper {
	
	public static Cliente toEntity(ClienteDAO dao) {
		Cliente cliente = new Cliente();
			cliente.setId(dao.getId());
			cliente.setNome(dao.getNome());
			cliente.setCelular(dao.getCelular());
			cliente.setCpf(dao.getCpf());
			cliente.setEmail(dao.getEmail());
			cliente.setSexo(dao.getSexo());
			cliente.setComandas(dao.getComandas());
		return cliente;
	}
	
	public static ClienteDAO toDAO(Cliente cliente) {
		
		if(cliente==null) return null;
		
		ClienteDAO dao = new ClienteDAO();
			dao.setId(cliente.getId());
			dao.setNome(cliente.getNome());
			dao.setCelular(cliente.getCelular());
			dao.setCpf(cliente.getCpf());
			dao.setEmail(cliente.getEmail());
			dao.setSexo(cliente.getSexo());
			dao.setComandas(cliente.getComandas());
		return dao;
		
	}
	
	public static List<ClienteDAO> toDAO(List<Cliente> clientes){
		return clientes.stream().map(x->toDAO(x)).collect(Collectors.toList());
	}

}
