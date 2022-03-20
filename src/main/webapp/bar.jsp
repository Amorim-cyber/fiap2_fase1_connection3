<%@   page   language="java"   contentType="text/html; charset=UTF-8"
import="br.com.bar.web.bebidas.ListaBebidas"
import="br.com.bar.web.analista.Analista"
import="br.com.bar.dao.ClienteDAO"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
Object bebidas = new ListaBebidas().findAll();
request.setAttribute("bebidas",bebidas);

Object cliente = request.getAttribute("cliente");
Object celular = request.getAttribute("celular");
Object analista = new Analista((ClienteDAO)cliente);

request.setAttribute("analista",analista);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="http://localhost:8084/BarProject/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="http://localhost:8084/BarProject/resources/css/bootstrap-icons-1.5.0/bootstrap-icons.css">
<title>Bar-Project</title>
</head>
<body>
	
	<div id="main" style="padding:20px;">
		<form action="http://localhost:8084/BarProject/comanda" method="post">
			<div class="input-group mb-3" style="width:550px;">
			  <input name="celular" type="number" class="form-control" placeholder="Digite aqui o celular do cliente (ddd+número)" aria-label="Recipient's username" aria-describedby="button-addon2">
			  <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Pesquisar</button>
			</div>
		</form>
		<br>
		<form action="http://localhost:8084/BarProject/conta" method="post">
		<div class="accordion" id="accordionFlushExample">
			  <div class="accordion-item">
			    <h2 class="accordion-header" id="flush-headingOne">
			    	<button ${cliente == null && celular!=null? "" : "disabled"} id="cadastro" class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
				        	#1 Cadastro (Novo cliente)
				     </button>
			    </h2>
			    <div id="flush-collapseOne" class="accordion-collapse collapse ${cliente == null && celular!=null? 'show' : ''}" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
			      <div style="padding:20px;" class="accordion-body">
			      	<%@ include file="./cadastro/cadastro.jsp" %>
			      </div>
			    		  
			    </div>
			  </div>
			  <div class="accordion-item">
			    <h2 class="accordion-header" id="flush-headingTwo">
			    
			    	<button ${cliente != null? "" : "disabled"} id="dashboard" class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
					        #2 DashBoard
					</button>
			    
			    </h2>
			    
			    <div id="flush-collapseTwo" class="accordion-collapse collapse ${cliente != null? 'show' : ''}" aria-labelledby="flush-headingTwo" data-bs-parent="#accordionFlushExample">
					<div class="accordion-body">
					<%@ include file="./dashboard/dashboard.jsp" %>
					</div>
				</div>
			    
			    
			  </div>
			  <div class="accordion-item">
			    <h2 class="accordion-header" id="flush-headingThree">
			    
			    	<button id="comanda" ${cliente == null? "disabled" : ""}  class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree">
					        #3 Comanda
					</button>
			    
			      
			    </h2>
			    <div id="flush-collapseThree" class="accordion-collapse collapse" aria-labelledby="flush-headingThree" data-bs-parent="#accordionFlushExample">
			      <div style="padding:20px;" class="accordion-body">
			      		<%@ include file="./comanda/comanda.jsp" %>
			      		
			      </div>
			    </div>
			  </div>
			</div>
			</form>
	</div>
	

	<%@ include file="./resources/js/bebidas/scriptBebidas.jsp" %>
	<%@ include file="./resources/js/cliente/scriptCliente.jsp" %>
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>