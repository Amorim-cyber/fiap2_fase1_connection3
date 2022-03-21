
<div id="cadastro" ${cliente == null && celular!=null? "" : "style='display:none;'"}>
	<div class="row content-pane">
                    <div class="col-sm-1">                      </div>
                    <div class="col-sm-8">
                        <img src="./resources/img/alert.png"/> <span>atenção: cliente sem cadastro</span> 
                    </div>                                                                         
                </div>
                <div class="row">
                    <div class="col-sm-1">                      </div>
                    <div class="col-sm-8">
                        <br>
                        <h2>Novo cadastro</h2>
                    </div>                                                                         
                </div>
                <div class="row">
                    <div class="col-sm-1">                      </div>
                    <div class="col-sm-8">
                        <div class="form__group field">
                            <input type="input" class="form__field" placeholder="Nome completo" name="name" id='name' value="${cliente.getNome()}" required />
                            <label for="name" class="form__label">Nome completo</label>
                        </div>
                    </div>                                                                         
                </div>
                <div class="row">
                    <div class="col-sm-1">                      </div>
                    <div class="col-sm-4">
                        <div class="form__group field">
                            <input type="input" class="form__field" placeholder="Email" name="email" id='email' value="${cliente.getEmail()}"/>
                            <label for="email" class="form__label">Email</label>
                        </div>
                    </div>  
                    <div class="col-sm-4">
                        <div class="form__group field">
                            <input type="input" class="form__field" placeholder="CPF" name="cpf" id='cpf' value="${cliente.getCpf()}" />
                            <label for="cpf" class="form__label">CPF</label>
                        </div>
                    </div>                                                                          
                </div>
                <div class="row">
                    <div class="col-sm-1">                      </div>
                    <div class="col-sm-4">
                        <div class="form__group field">
                            <select name="genero" id="genero" placeholder="Gênero" class="form__field">
                                <option value="">Gênero</option>
                                <option ${cliente.getSexo()=="Masculino"?"selected":""} value="Masculino">Masculino</option>
								  <option ${cliente.getSexo()=="Feminino"?"selected":""} value="Feminino">Feminino</option>
								  <option ${cliente.getSexo()=="Outro"?"selected":""} value="Outro">Outro</option>
                            </select>                                                    
                        </div>
                    </div>  
                    <div class="col-sm-4">
                        <div class="form__group field">
                            <input type="input" class="form__field" placeholder="celular" name="celular" id='celular' value="${celular}" required />
                            <label for="celular" class="form__label">Celular</label>
                        </div>
                    </div>                                                                          
                </div>
                <div class="row">
                    <div class="col-sm-7">                      </div>
                    <div class="col-sm-2">
                        <br>
                        <button type="button" onclick="guardarCliente()" class="btn btn-default ml-auto">
                            CADASTRAR
                        </button>
                    </div>                                                                                           
                </div>
</div>


