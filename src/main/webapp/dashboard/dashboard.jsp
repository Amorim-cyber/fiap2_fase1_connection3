<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div ${cliente != null? "" : "style='display:none;'"} class="row client-pane">
	                    <div class="col-lg-11">
	                        <h4>${cliente.getNome()}</h4>  
	                        <div class="container">
						  	
								  <div class="row">
								    <div class="col"style="padding:20px;">
								    	<div class="card">
						  					<div class="card-body" >
								      			<b>Última visita ao estabelecimento:</b> <br>
								      			${analista.ObterUltimaVisita()}
								      		</div>
								      	</div>
								    </div>
								    <div class="col" style="padding:20px;">
									      <div class="card">
							  					<div class="card-body" >
									      			<b>Frequência de visitas:</b> <br>
									      			${analista.ObterFrequencia()} visitas
									      		</div>
									      	</div>
								    </div>
								  </div>
								  <div class="row">
								    <div class="col" style="padding:20px;">
								      <div class="card">
						  					<div class="card-body" >
								      			<b>Ticket médio:</b> <br>
								      			<fmt:formatNumber value="${analista.ObterMedia()}" type="currency" /> por pedido
								      		</div>
								      	</div>
								    </div>
								    <div class="col" style="padding:20px;">
								      <div class="card">
						  					<div class="card-body" >
								      			<b>Bebida e o estilo favorito:</b> <br>
								      			${analista.ObterFavorito()}
								      		</div>
								      	</div>
								    </div>
								  </div>
								</div>      
	                    </div>
	                </div>


