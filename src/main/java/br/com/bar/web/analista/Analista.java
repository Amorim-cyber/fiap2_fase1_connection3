package br.com.bar.web.analista;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.bar.dao.ClienteDAO;
import br.com.bar.domain.Comanda;
import br.com.bar.interfaces.AnalistaInterface;
import br.com.bar.mappers.ComandaMapper;
import br.com.bar.service.ComandaService;

public class Analista implements AnalistaInterface{
	
	private ClienteDAO cliente;
	private ComandaService comandaService = new ComandaService();
	List<Comanda> listaComanda;
	
	public Analista(ClienteDAO cliente) {
		this.cliente = cliente;
		
		listaComanda =  ComandaMapper.toEntity(comandaService.findAll());
		
	}

	@Override
	public String ObterUltimaVisita() throws ParseException {
		
		if(cliente==null) return "UltimaVisita";
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		Date novaData = format
				.parse(
				listaComanda
				.stream()
				.filter(x->x.getCliente().getId()==cliente.getId())
				.map(x->x.getDataEntrada())
				.map(x->x.toString())
				.max(Comparator.comparing(String::valueOf))
				.get());
				
		format = new SimpleDateFormat("dd/MM/YY, HH:mm");
		
		return format.format(novaData);
	}
	
	
	@Override
	public int ObterFrequencia() {
		
		if(cliente==null) return 0;
		
		int frequencia = (int) listaComanda
				.stream()
				.filter(x->x.getCliente().getId()==cliente.getId())
				.count();
		
		return frequencia;
	}

	@Override
	public double ObterMedia() {
		
		if(cliente==null) return 0d;
		
		double soma = 0;
		
		List<Double> listaSoma = listaComanda
				.stream()
				.filter(x->x.getCliente().getId()==cliente.getId())
				.map(x->x.getBebidas())
				.collect(Collectors.toList())
				.stream()
				.flatMap(List::stream)
				.collect(Collectors.toList())
				.stream()
				.map(b->b.getPrice())
				.collect(Collectors.toList());
		
		for(double item : listaSoma) soma+=item;
		
		int totalPedidos = (int) listaComanda
				.stream()
				.filter(x->x.getCliente().getId()==cliente.getId())
				.map(x->x.getBebidas())
				.collect(Collectors.toList())
				.stream()
				.flatMap(List::stream)
				.count();
				
		return soma/totalPedidos;
	}

	@Override
	public String ObterFavorito() {
		
		if(cliente==null) return "Favorito";
		
		List<String> bebidas = listaComanda
							.stream()
							.filter(x->x.getCliente().getId()==cliente.getId())
							.map(x->x.getBebidas())
							.collect(Collectors.toList())
							.stream()
							.flatMap(List::stream)
							.collect(Collectors.toList())
							.stream()
							.map(b->b.getNome()+" ("+b.getDescricao()+")")
							.collect(Collectors.toList())
							;
		
		
		 
		 return mostFrequentStream(bebidas);
	}
	
	
	private String mostFrequentStream(List<String> elements) {
	    Map<String, Long> temp = elements.stream()
	            .collect(Collectors.groupingBy(a -> a, Collectors.counting()));

	    return temp.entrySet()
	                     .stream()
	                     .max(Map.Entry.comparingByValue())
	                     .map(Map.Entry::getKey).get();

	}
	

}
