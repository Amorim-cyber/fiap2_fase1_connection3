package br.com.bar.interfaces;

import java.util.List;

import br.com.bar.dao.ClienteDAO;

public interface ClienteInterface {

	public abstract void save(ClienteDAO dao);
	
	public abstract List<ClienteDAO> findAll();
	
	public abstract ClienteDAO find(String celular);
	
	public abstract void update(ClienteDAO dao);
	
	public abstract void delete(int id);
	
}
