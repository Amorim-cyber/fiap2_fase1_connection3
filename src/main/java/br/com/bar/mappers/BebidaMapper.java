package br.com.bar.mappers;

import java.util.List;
import java.util.stream.Collectors;

import br.com.bar.dao.BebidaDAO;
import br.com.bar.domain.Bebida;

public class BebidaMapper {

	public static Bebida toEntity(BebidaDAO dao) {
		Bebida bebida = new Bebida();
			bebida.setId(dao.getId());
			bebida.setNome(dao.getNome());
			bebida.setTipo(dao.getTipo());
			bebida.setDescricao(dao.getDescricao());
			bebida.setPrice(dao.getPrice());
			bebida.setComandas(dao.getComandas());
		return bebida;
	}
	
	public static List<Bebida> toEntity(List<BebidaDAO> dao){
		return dao.stream().map(x->toEntity(x)).collect(Collectors.toList());
	}
	
	public static BebidaDAO toDAO(Bebida bebida) {
		BebidaDAO dao = new BebidaDAO();
			dao.setId(bebida.getId());
			dao.setNome(bebida.getNome());
			dao.setTipo(bebida.getTipo());
			dao.setDescricao(bebida.getDescricao());
			dao.setPrice(bebida.getPrice());
			dao.setComandas(bebida.getComandas());
		return dao;
		
	}
	
	public static List<BebidaDAO> toDAO(List<Bebida> bebidas){
		return bebidas.stream().map(x->toDAO(x)).collect(Collectors.toList());
	}
}
