package br.com.bar.mappers;

import java.util.List;
import java.util.stream.Collectors;

import br.com.bar.dao.ComandaDAO;
import br.com.bar.domain.Comanda;

public class ComandaMapper {
	
	public static Comanda toEntity(ComandaDAO dao) {
		Comanda comanda = new Comanda();
			comanda.setId(dao.getId());
			comanda.setCliente(dao.getCliente());
			comanda.setBebidas(dao.getBebidas());
			comanda.setDataEntrada(dao.getDataEntrada());
			comanda.setDataSaida(dao.getDataSaida());
		return comanda;
	}
	
	public static List<Comanda> toEntity(List<ComandaDAO> dao){
		return dao.stream().map(x->toEntity(x)).collect(Collectors.toList());
	}
	
	public static ComandaDAO toDAO(Comanda comanda) {
		ComandaDAO dao = new ComandaDAO();
			dao.setId(comanda.getId());
			dao.setCliente(comanda.getCliente());
			dao.setBebidas(comanda.getBebidas());
			dao.setDataEntrada(comanda.getDataEntrada());
			dao.setDataSaida(comanda.getDataSaida());
		return dao;
		
	}
	
	public static List<ComandaDAO> toDAO(List<Comanda> comandas){
		return comandas.stream().map(x->toDAO(x)).collect(Collectors.toList());
	}

}
