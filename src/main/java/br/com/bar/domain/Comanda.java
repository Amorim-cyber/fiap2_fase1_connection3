package br.com.bar.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="bar_comanda")
public class Comanda {
	
	@Id
	@SequenceGenerator(name="comanda",sequenceName="sq_bar_comanda",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="comanda")
	@Column(name="id_comanda")
	private int id;

	@CreationTimestamp
	@Column(name="dt_entrada")
	private Timestamp dataEntrada;
	
	@UpdateTimestamp
	@Column(name="dt_saida")
	private Timestamp dataSaida;
	
	@JoinColumn(name = "id_cliente")
	@ManyToOne()
	private Cliente cliente;
	
	@ManyToMany()
	@JoinTable(joinColumns = @JoinColumn(name="id_comanda"), 
	inverseJoinColumns = @JoinColumn(name="id_bebida"), name = "bar_pedido")
	private List<Bebida> bebidas;
	
	public Comanda() {
	}

	

	public Comanda(int id, Cliente cliente, List<Bebida> bebidas) {
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



	@Override
	public String toString() {
		return "Comanda [id=" + id + ", dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida + ", cliente="
				+ cliente + ", bebidas=" + bebidas + "]";
	}



	
	
	
	
	
}
