package br.com.bar.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="bar_cliente")
public class Cliente {

	@Id
	@SequenceGenerator(name="cliente",sequenceName="sq_bar_cliente",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente")
	@Column(name="id_cliente")
	private int id;
	
	@Column(name="nm_cliente",nullable=false,length=80)
	private String nome;
	
	@Column(name="cel_cliente",nullable=false)
	private String celular;
	
	@Column(name="cpf_cliente",nullable=true)
	private String cpf;
	
	@Column(name="e_cliente",nullable=true,length=100)
	private String email;
	
	@Column(name="sex_cliente",nullable=true,length=20)
	private String sexo;
	
	@OneToMany(mappedBy = "cliente")
	private List<Comanda> comandas;
	
	public Cliente() {
	}

	

	public Cliente(int id, String nome, String celular, String cpf, String email, String sexo, List<Comanda> comandas) {
		
		this.id = id;
		this.nome = nome;
		this.celular = celular;
		this.cpf = cpf;
		this.email = email;
		this.sexo = sexo;
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



	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", celular=" + celular + ", cpf=" + cpf + ", email=" + email
				+ ", sexo=" + sexo + "]";
	}
	
	
	
	
	
}
