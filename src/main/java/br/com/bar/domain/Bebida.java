package br.com.bar.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="bar_bebidas")
public class Bebida {
	
	@Id
	@SequenceGenerator(name="bebida",sequenceName="sq_bar_bebida",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bebida")
	@Column(name="id_bebida")
	private int id;
	
	@Column(name="nm_bebida",nullable=false,length=80)
	private String nome;

	@Column(name="tp_bebida",nullable=false,length=50)
	private String tipo;
	
	@Column(name="ds_bebida",nullable=true,length=50)
	private String descricao;
	
	@Column(name="pr_bebida",nullable=false)
	private double price;
	
	@ManyToMany(mappedBy="bebidas")
	private List<Comanda> comandas;


	public Bebida() {
		
	}

	public Bebida(int id, String nome, String tipo, String descricao, double price, List<Comanda> comandas) {
		
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
		return "Bebida [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", descricao=" + descricao + ", price="
				+ price + "]";
	}
	
	
	
	
}
