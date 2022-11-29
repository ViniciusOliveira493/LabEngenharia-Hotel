var btnLogar = document.getElementById("btnLogar");
btnLogar.addEventListener("click",function(){
    var email = getValueById('txtEmail');
    var senha = getValueById('txtSenha');
    console.log(email + " | "+senha)
    var pessoa = new Object();
    pessoa.email = email;
    pessoa.senha = senha;

    var url = urlbase+"login"
    $.ajax({
		url : url,
		contentType: "application/json",
		type : "POST",
		data : JSON.stringify(pessoa)
	})
	.done(function(msg){
		if(checkUndefined(msg.nome)){
			alert("Dados de login inválidos");
		}else{
			setCookie("usuario",JSON.stringify(msg),172800);
			voltarParaHome();
		}
	})
	.fail(function(jqXHR, textStatus, msg){
		resposta = msg;
	});
});