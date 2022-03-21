



<script>

function calcularTotal(){
	var pedidos = document.getElementById("conta").getElementsByTagName("tr");
	var totalRow = document.getElementById("total");
	var total = 0;
	
	
	if(pedidos.length > 0){
		for(let i=0; i< pedidos.length; i++){
			 total += parseFloat(pedidos[i].getElementsByTagName("td")[1].innerHTML
					.replace("R$ ","").replace(",","."));
		}
		
		document.getElementById("valorTotal").innerHTML =
		total.toLocaleString('pt-BR', {style: 'currency', currency: 'BRL'});
		
	}else{
		totalRow.setAttribute("style","display:none;");
	}
}

</script>

<script>
function inserirBebida(){
	
	if(document.getElementById("listaBebidas").value == "-") return;
	
	var conta = document.getElementById("conta");
	
	var row = document.createElement('tr');
	
	var nome = document.createElement('td');
	nome.innerHTML = document.getElementById("nomeBebida").getAttribute("placeholder");
	
	var input = document.createElement('input');
	input.setAttribute('name','bebidas');
	input.setAttribute('value',
	document.getElementById("listaBebidas").value.split(',')[0].replace("BebidaDAO [id=",""));
	input.setAttribute('style','display:none;');
	
	var preco = document.createElement('td');
	preco.innerHTML = document.getElementById("precoBebida").getAttribute("placeholder");
	
	var botao = document.createElement('button');
	botao.setAttribute('type','button');
	botao.setAttribute('style','width:100px; height:40px');
	botao.setAttribute('class','btn btn-warning');
	var index = document.getElementById("conta").getElementsByTagName("tr").length;
	botao.setAttribute('onclick',
	'remover('+index+')');
	botao.innerHTML = "Remover";
	
	var del = document.createElement('td');
	del.appendChild(botao);
	
	row.appendChild(input);
	row.appendChild(nome);
	row.appendChild(preco);
	row.appendChild(del);
	
	conta.appendChild(row);
	
	document.getElementById("listaBebidas").options[0].selected = 'selected';
	
	document.getElementById("nomeBebida").
	setAttribute("placeholder","Nome Bebida");
	
	document.getElementById("tipoBebida").
	setAttribute("placeholder","Tipo de Bebida");
	
	document.getElementById("descricaoBebida").
	setAttribute("placeholder","Descrição da Bebida");
	
	document.getElementById("precoBebida").
	setAttribute("placeholder","Preço da Bebida");
	
	document.getElementById("total").setAttribute("style","display:block;");
	
	calcularTotal();
	 
}
</script>


<script>
function remover(value){
	var row = document.getElementById("conta").getElementsByTagName("tr");
	
	row[value].parentNode.removeChild(row[value]);
	
	
	for(let i=0; i< row.length; i++){
		row[i].getElementsByTagName('button')[0].setAttribute('onclick',
	'remover('+i+')');
	}
	
	calcularTotal();
	
}
</script>

<script>

function atualizarBebida(){
	if(document.getElementById("listaBebidas").value != "-") {
		document.getElementById("nomeBebida").
	setAttribute("placeholder",document.getElementById("listaBebidas").value.split(',')[1].replace("nome=",""));
	
	document.getElementById("tipoBebida").
	setAttribute("placeholder",document.getElementById("listaBebidas").value.split(',')[2].replace("tipo=",""));
	
	document.getElementById("descricaoBebida").
	setAttribute("placeholder",document.getElementById("listaBebidas").value.split(',')[3].replace("descricao=",""));
	
	document.getElementById("precoBebida").
	setAttribute("placeholder","R$ "+document.getElementById("listaBebidas").value.split(',')[4].replace("price=","").replace("]","").replace(".",",")+"0");
	}else{
		document.getElementById("nomeBebida").
		setAttribute("placeholder","Nome Bebida");
		
		document.getElementById("tipoBebida").
		setAttribute("placeholder","Tipo de Bebida");
		
		document.getElementById("descricaoBebida").
		setAttribute("placeholder","Descrição da Bebida");
		
		document.getElementById("precoBebida").
		setAttribute("placeholder","Preço da Bebida");
	}
		
}
		


</script>