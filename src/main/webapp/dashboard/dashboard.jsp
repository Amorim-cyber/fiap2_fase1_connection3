<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="card" style="padding:20px;">
						  <div class="card-body" >
						  	<div class="container">
						  			<div class="row">
									    <div class="col"style="padding:20px;">
									    	<label  for="nomeCliente" class="col-sm-12 col-form-label"><b>Cliente: ${cliente.getNome()}</b></label>
									    </div>
									    <div class="col" style="padding:20px;">
										       <label  for="nomeCliente" class="col-sm-12 col-form-label"><b>Celular: ${cliente.getCelular()}</b></label>
									    </div>
								    </div>
						  	
								  <div class="row">
								    <div class="col"style="padding:20px;">
								    	<div class="card">
						  					<div class="card-body" >
								      			Última visita ao estabelecimento: <br>
								      			${analista.ObterUltimaVisita()}
								      		</div>
								      	</div>
								    </div>
								    <div class="col" style="padding:20px;">
									      <div class="card">
							  					<div class="card-body" >
									      			Frequência de visitas: <br>
									      			${analista.ObterFrequencia()} visitas
									      		</div>
									      	</div>
								    </div>
								  </div>
								  <div class="row">
								    <div class="col" style="padding:20px;">
								      <div class="card">
						  					<div class="card-body" >
								      			Ticket médio: <br>
								      			<fmt:formatNumber value="${analista.ObterMedia()}" type="currency" /> por pedido
								      		</div>
								      	</div>
								    </div>
								    <div class="col" style="padding:20px;">
								      <div class="card">
						  					<div class="card-body" >
								      			Bebida e o estilo favorito: <br>
								      			${analista.ObterFavorito()}
								      		</div>
								      	</div>
								    </div>
								  </div>
								</div>
								
								
								</div>
						  </div>
					</div>