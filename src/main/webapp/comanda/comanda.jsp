<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="comanda" ${cliente != null? "" : "style='display:none;'"} >
	<div  class="card" style="padding:10px;" >
						  <div class="card-body" >
						    <select class="form-select" id="listaBebidas" aria-label="Bebidas" onchange="atualizarBebida()">
							  <option selected>-</option>
							  <c:forEach var="bebida" items="${bebidas}">
							  	<option value="${bebida}">${bebida.getNome()}</option>
							  </c:forEach>
							</select>
						  </div>
						  <input style="margin-bottom:5px;" class="form-control" id="nomeBebida" type="text" placeholder="Nome Bebida" aria-label="Nome Bebida" disabled>
						  <input style="margin-bottom:5px;" class="form-control" id="tipoBebida" type="text" placeholder="Tipo de Bebida" aria-label="Tipo de Bebida" disabled>
						  <input style="margin-bottom:5px;" class="form-control" id="descricaoBebida" type="text" placeholder="Descrição da Bebida" aria-label="Descrição da Bebida" disabled>
						  <input style="margin-bottom:5px;" class="form-control" id="precoBebida" type="text" placeholder="Preço da Bebida" aria-label="Preço da Bebida" disabled>
						  
						  
						  <br>
						  <button type="button" onclick="inserirBebida()" style="width:100px; height:50px" class="btn btn-default ml-auto">Adicionar</button>
						  <br>
						  
						  
						  	<div class="card" style="padding:10px;width:50%; height:200px">
						  		<div class="card-body" style="height:100%">
						  			<div class="overflow-auto" style="height:100%">
							  			<table class="table">
										  <thead>
										    <tr>
										      <th scope="col">Bebida</th>
										      <th scope="col">Preço</th>
										      <th scope="col"></th>
										    </tr>
										  </thead>
										  <tbody id="conta">
										    
										  </tbody>
										  <tfoot id="total" style="display:none; ">
										  		<tr>
										  		<th scope="col">TOTAL</th>
										  		<th  scope="col"></th>
										  		<th id="valorTotal" scope="col"></th>
										  		</tr>
										  </tfoot>
										</table>
									</div>
						  		</div>
						  	</div>
						  <br>
						  	
						  		<input value="Fechar conta" type="submit" style="width:150px; height:50px" class="btn btn-danger"/>
						</div>
</div>




