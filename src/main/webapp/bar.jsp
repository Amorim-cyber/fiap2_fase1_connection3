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
<link rel="stylesheet" href="./style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="./resources/js/jquery-3.6.0.min.js"></script>
<script src="./resources/js/jquery.mask.min.js"></script>
<title>DRINK.IT</title>
</head>
<body>

	<nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid justify-content-center">
            <span class="navbar-brand mb-0 h1"><img src="./resources/img/logo.png" /></span>
        </div>
    </nav>

    <div class="container-fluid panel">
        <div class="panel row">
        	<form class="col-lg-5 col-sm-12 bg-gray" action="comanda" method="post">
                <div class="row content-pane">
                    <div class="col-lg-6 col-sm-12 img-pane">
                        
                    </div>
                    
                    <div class="col-lg-5 col-sm-12 tel-pane">
                        <div class="frm-telefone">
                            <div class="form__group field">
                                <input ${cliente != null? "readonly" : ""} value="${cliente != null?celular:''}" type="input" class="form__field" placeholder="Digite o telefone" name="tel" id='tel' required />
                                <label for="tel" class="form__label">Digite o telefone</label>
                            </div>
                            
                        </div>  
                                         
                    </div>
                    
                    <div style="${cliente != null? 'display:none;' : 'display:flex;'} flex-direction: row; justify-content: flex-end; margin-top: 20px; margin-right: 20px;">
                    	<button type="submit" class="btn btn-default ml-auto" style=" margin-top: 10px; margin-right: 30px;">
		                            BUSCAR
		                </button> 
                    
                    </div>
                    
                    
                    <%@ include file="./dashboard/dashboard.jsp" %>
                    
                    
                </div>
            </form>
            
            <form action="conta" method="post" class="col-lg-7 col-sm-12">
            
            <%@ include file="./cadastro/cadastro.jsp" %>
            <%@ include file="./comanda/comanda.jsp" %>
            
            </form>
            
        </div>
    </div>
	
	
	<script>
        $(function() {
            $('#tel').mask('(00)00000-0000');
            $('#celular').mask('(00)00000-0000');
            $('#cpf').mask('000.000.000-00');
        });
    </script>

	<%@ include file="./resources/js/bebidas/scriptBebidas.jsp" %>
	<%@ include file="./resources/js/cliente/scriptCliente.jsp" %>
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
    
</body>
</html>