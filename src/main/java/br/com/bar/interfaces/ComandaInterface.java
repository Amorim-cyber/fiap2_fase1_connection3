package br.com.bar.interfaces;

import java.util.List;

import br.com.bar.dao.ComandaDAO;

public interface ComandaInterface {

public abstract void save(ComandaDAO dao);
	
	public abstract List<ComandaDAO> findAll();
	
	public abstract ComandaDAO find(int id);
	
	public abstract void update(ComandaDAO dao);
	
	public abstract void delete(int id);
	
}
