<script>

function guardarCliente(){
	let nome = document.getElementById("nomeCliente");
	let celular = document.getElementById("celularCliente");
	
	if(nome.value!="" && celular.value!="" ){
		let botaoCadastro = document.getElementById("cadastro");
		let botaoComanda = document.getElementById("comanda");
		botaoCadastro.disabled = true;
		botaoComanda.disabled = false;
		botaoComanda.click();
	}
	
}


</script>