
<div class="card" style="padding:20px;">
						  <div class="card-body" >
						  	<div class="mb-3 row">
							    <label style="text-align:end" for="nome" class="col-sm-1 col-form-label">Nome:</label>
							    <div class="col-sm-11">
							      <input name="nomeCliente" type="text"  class="form-control" id="nomeCliente" value="${cliente.getNome()}">
							    </div>
							 </div>
							 <div class="mb-3 row">
							    <label style="text-align:end" for="celular" class="col-sm-1 col-form-label">Celular:</label>
							    <div class="col-sm-11">
							    	<input name="celularCliente" type="number"  class="form-control" id="celularCliente" value="${celular}">      
							    </div>
							 </div>
							 <div class="mb-3 row">
							    <label style="text-align:end" for="cpf" class="col-sm-1 col-form-label">CPF:</label>
							    <div class="col-sm-11">
							      <input name="cpfCliente" type="number" class="form-control" id="cpfCliente" value="${cliente.getCpf()}">
							    </div>
							 </div>
							 <div class="mb-3 row">
							    <label style="text-align:end" for="email" class="col-sm-1 col-form-label">E-mail:</label>
							    <div class="col-sm-11">
							      <input name="emailCliente" type="email"  class="form-control" id="emailCliente" value="${cliente.getEmail()}">
							    </div>
							 </div>
							 <div class="mb-3 row">
							 	<label style="text-align:end" for="sexo" class="col-sm-1 col-form-label">sexo:</label>
							    <div class="col-sm-3">
							      <select name="sexoCliente" class="form-select" id="sexoCliente" aria-label="sexo">
								  <option ${cliente==null?"selected":""}>-</option>
								  <option ${cliente.getSexo()=="Masculino"?"selected":""} value="Masculino">Masculino</option>
								  <option ${cliente.getSexo()=="Feminino"?"selected":""} value="Feminino">Feminino</option>
								  <option ${cliente.getSexo()=="Outro"?"selected":""} value="Outro">Outro</option>
								</select>
							    </div>
							 </div>
							 <br>
							 <div class="mb-3 row">
							 	<button onclick="guardarCliente()" type="button" style="width:100px; height:50px" class="btn btn-primary">Cadastrar</button>
							 </div>
						  </div>
					</div>