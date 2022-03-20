package br.com.bar.web.conta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bar.dao.BebidaDAO;
import br.com.bar.dao.ClienteDAO;
import br.com.bar.dao.ComandaDAO;
import br.com.bar.mappers.BebidaMapper;
import br.com.bar.mappers.ClienteMapper;
import br.com.bar.service.BebidaService;
import br.com.bar.service.ClienteService;
import br.com.bar.service.ComandaService;

@WebServlet("/conta")
public class Conta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BebidaService bebidaService = new BebidaService();
	private ComandaService comandaService = new ComandaService();
	private ClienteService clienteService = new ClienteService();
    public Conta() {
    	
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClienteDAO cliente = new ClienteDAO(
				0,
				request.getParameter("nomeCliente"),
				request.getParameter("celularCliente"),
				request.getParameter("cpfCliente"),
				request.getParameter("emailCliente"),
				request.getParameter("sexoCliente")
				);
		
		ClienteDAO clienteBanco = clienteService.find(cliente.getCelular());
		
		if(clienteBanco==null) {
			clienteService.save(cliente);
		}else {
			cliente.setId(clienteBanco.getId());
		}
		
		
		String[] bebidas = request.getParameterValues("bebidas");
		List<BebidaDAO> listaBebidas = new ArrayList<BebidaDAO>();
		
		if(bebidas!=null) {
			for(String bebida : bebidas) {
				listaBebidas.add(bebidaService.find(Integer.parseInt(bebida)));
			}
		}else {
			listaBebidas.add(bebidaService.find("Não consumiu"));
		}
		
		ComandaDAO comanda = new ComandaDAO(0,ClienteMapper.toEntity(cliente),BebidaMapper.toEntity(listaBebidas));
		comandaService.save(comanda);
		
		request.getRequestDispatcher("sucesso.jsp").forward(request, response);
	}

}
