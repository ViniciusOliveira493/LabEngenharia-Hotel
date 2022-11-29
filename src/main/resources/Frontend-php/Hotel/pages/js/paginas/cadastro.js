function onloadcadastro(){
    carregarTiposDocumento();
}
function carregarTiposDocumento(){
	$.ajax({
		url : 'http://localhost:8080/api/tipodocumento',
		contentType: "application/json",
		type : "GET",
		data : ""
	})
	.done(function(msg){
        let select = document.getElementById('selectTipoDocumento');
        msg.forEach(e => {
            select.append(criarOptionDocumento(e));
        });
		
	})
	.fail(function(jqXHR, textStatus, msg){
		console.log(msg);
	});
}
function criarOptionDocumento(opcao){
    return new Option(opcao.tipo,opcao.id)
}

document.getElementById('frmCadastrarCliente').addEventListener('submit',function submitFormCad(e){
    e.preventDefault();
    if(getValueById('txtSenha') === getValueById('txtCsenha')){
        var cliente = obterCliente();
        $.ajax({
            url : 'http://localhost:8080/api/pessoa',
            contentType: "application/json",
            type : 'POST',
            data : JSON.stringify(cliente)
        })
        .done(function(msg){
            alert(msg)
            voltarParaHome()
        })
        .fail(function(jqXHR, textStatus, msg){
            alert(msg)
        });
    }else{
        alert("senha e confirmar senha precisam ser iguais")
    }
});

function obterCliente(){
    var cliente = new Object();

    var id = new Object();
    id.documento = getValueById('txtDocumento');
    var tipoDoc = new Object();
    tipoDoc.id = document.getElementById('selectTipoDocumento').value;
    id.tipoDocumento = tipoDoc;

    cliente.id = id;
    cliente.nome = getValueById('txtNome');
    cliente.email = getValueById('txtEmail');
    cliente.senha = getValueById('txtSenha');
    cliente.telefone = getValueById('txtTelefone');
    return cliente;
}