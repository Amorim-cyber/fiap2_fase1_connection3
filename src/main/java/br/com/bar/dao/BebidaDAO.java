package br.com.bar.dao;

import java.util.List;

import br.com.bar.domain.Comanda;

public class BebidaDAO {

	private int id;
	private String nome;
	private String tipo;
	private String descricao;
	private double price;
	private List<Comanda> comandas;
	
	public BebidaDAO() {
		
	}
	
	public BebidaDAO(int id, String nome, String tipo, String descricao, double price, List<Comanda> comandas) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.descricao = descricao;
		this.price = price;
		this.comandas = comandas;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Comanda> getComandas() {
		return comandas;
	}

	public void setComandas(List<Comanda> comandas) {
		this.comandas = comandas;
	}

	@Override
	public String toString() {
		return "BebidaDAO [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", descricao=" + descricao + ", price="
				+ price +"]";
	}
	
	
}
