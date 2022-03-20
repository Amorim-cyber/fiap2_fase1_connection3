package br.com.bar.interfaces;

import java.util.List;

import br.com.bar.dao.BebidaDAO;

public interface BebidaInterface {
	
	public abstract void save(BebidaDAO dao);
	
	public abstract List<BebidaDAO> findAll();
	
	public abstract BebidaDAO find(int id);
	
	public abstract BebidaDAO find(String nome);
	
	public abstract void update(BebidaDAO dao);
	
	public abstract void delete(int id);

}
