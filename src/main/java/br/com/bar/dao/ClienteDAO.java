package br.com.bar.dao;

import java.util.List;

import br.com.bar.domain.Comanda;

public class ClienteDAO {

	private int id;
	private String nome;
	private String celular;
	private String cpf;
	private String email;
	private String sexo;
	private List<Comanda> comandas;
	
	public ClienteDAO() {
	}
	
	public ClienteDAO(int id, String nome, String celular, String cpf, String email, String sexo) {
		
		this.id = id;
		this.nome = nome;
		this.celular = celular;
		this.cpf = cpf;
		this.email = email;
		this.sexo = sexo;
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
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public List<Comanda> getComandas() {
		return comandas;
	}
	public void setComandas(List<Comanda> comandas) {
		this.comandas = comandas;
	}
	
	
	
	
}
