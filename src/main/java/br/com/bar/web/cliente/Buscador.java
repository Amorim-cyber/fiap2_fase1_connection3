package br.com.bar.web.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bar.service.ClienteService;


@WebServlet("/comanda")
public class Buscador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteService clienteService = new ClienteService();
	
    public Buscador() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("celular", request.getParameter("celular"));
		
		request.setAttribute("cliente", clienteService.find(request.getParameter("celular")));
		
		request.getRequestDispatcher("bar.jsp").forward(request, response);
	}

}
