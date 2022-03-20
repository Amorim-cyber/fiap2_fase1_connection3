package br.com.bar.dao;

import java.sql.Timestamp;
import java.util.List;

import br.com.bar.domain.Bebida;
import br.com.bar.domain.Cliente;

public class ComandaDAO {

	private int id;
	private Cliente cliente;
	private List<Bebida> bebidas;
	private Timestamp dataEntrada;
	private Timestamp dataSaida;
	
	public ComandaDAO() {
	}
	
	public ComandaDAO(int id, Cliente cliente, List<Bebida> bebidas) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.bebidas = bebidas;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Bebida> getBebidas() {
		return bebidas;
	}

	public void setBebidas(List<Bebida> bebidas) {
		this.bebidas = bebidas;
	}

	public Timestamp getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Timestamp dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Timestamp getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Timestamp dataSaida) {
		this.dataSaida = dataSaida;
	}

	@Override
	public String toString() {
		return "ComandaDAO [id=" + id + ", cliente=" + cliente + ", bebidas=" + bebidas + ", dataEntrada=" + dataEntrada
				+ ", dataSaida=" + dataSaida + "]";
	}

	

	
	
	
	
	
}
