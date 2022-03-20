package br.com.bar.testes;


import br.com.bar.dao.ClienteDAO;
import br.com.bar.service.ClienteService;
import br.com.bar.web.analista.Analista;

public class TesteAnalista {

	public static void main(String[] args) {
		
		ClienteService servico = new ClienteService();
		
		ClienteDAO cliente = servico.find("02199999999");
		
		System.out.println(cliente);
		
		Analista analista = new Analista(cliente);
		
		System.out.println(analista.ObterMedia());
	}

}
