<script>

function guardarCliente(){
	let nome = document.getElementById("name");
	let celular = document.getElementById("celular");
	
	if(nome.value!="" && celular.value!="" ){
		let cadastro = document.getElementById("cadastro");
		let comanda = document.getElementById("comanda");
		cadastro.setAttribute("style","display:none;")
		comanda.setAttribute("style","display:block;")
	}
	
}


</script>