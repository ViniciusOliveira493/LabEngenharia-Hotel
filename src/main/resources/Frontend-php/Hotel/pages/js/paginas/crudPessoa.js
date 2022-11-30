window.onload = onloadA();
var editar = false;
function onloadA(){
    limpaDados();
    carregarTiposDocumento();
    carregarFuncoes();
}

function criarOption(opcao){
    return new Option(opcao.tipo,opcao.id)
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
        let select2 = document.getElementById('selectTipoDocumentoBusca');
        msg.forEach(e => {
            select.append(criarOption(e));
            select2.append(criarOption(e));
        });
		
	})
	.fail(function(jqXHR, textStatus, msg){
		console.log(msg);
	});
}

function carregarFuncoes(){
    let select = document.getElementById('selectFuncao');
    if(user.funcao < 2){
        let opcao = new Object();
        opcao.id = 2
        opcao.tipo = "Atendente"
        select.append(criarOption(opcao));
        opcao.id = 1
        opcao.tipo = "Gerente"
        select.append(criarOption(opcao));
    }
}
document.getElementById('btnEditCad').addEventListener('click',function submitFormCad(e){
    permitirEdicao();
});

document.getElementById('btnBuscarUser').addEventListener('click',function submitFormCad(e){
    var documento = getValueById('txtDocumentoBusca');
    var tipoDoc = getValueById('selectTipoDocumentoBusca');

    var lista = getElementById("listaClientes");
    lista.innerHTML = "";
    
    var url;

    if(!getElementById('cbFuncionario').checked){
        url = urlbase+"pessoa/"+tipoDoc+"/"+documento
    }else{
        url = urlbase+"funcionario/"+tipoDoc+"/"+documento
    }

    $.ajax({
		url : url,
		contentType: "application/json",
		type : "GET",
		data : null
	})
	.done(function(msg){		
        lista.append(criarItemCliente(msg));		
	})
	.fail(function(jqXHR, textStatus, msg){
		console.log(msg);
	});
});

function criarItemCliente(dados){
    var usr = document.createElement('li');
    usr.setAttribute("class","list-group-item")
    usr.setAttribute("onclick","abrirUsuario("+dados.id.documento+","+dados.id.tipoDocumento.id+")")
    usr.append(dados.nome)
    return usr;
}

function abrirUsuario(doc,tipo){
    var url = urlbase+"pessoa/"+tipo+"/"+doc

    $.ajax({
		url : url,
		contentType: "application/json",
		type : "GET",
		data : null
	})
	.done(function(msg){		
        setDados(msg);		
	})
	.fail(function(jqXHR, textStatus, msg){
		console.log(msg);
	});
}

function setDados(dados){
    getElementById('txtDocumentoUser').value = dados.id.documento
    getElementById('txtDocumentoUser').disabled = true;

    getElementById('selectTipoDocumento').value = dados.id.tipoDocumento.id
    getElementById('selectTipoDocumento').disabled = true;

    getElementById('txtNome').value = dados.nome;
    getElementById('txtNome').disabled = true;

    getElementById('txtEmail').value = dados.email;
    getElementById('txtEmail').disabled = true;

    getElementById('txtTelefone').value = dados.telefone;
    getElementById('txtTelefone').disabled = true;

    getElementById('selectFuncao').value = dados.funcao;
    getElementById('selectFuncao').disabled = true;
   
}

function permitirEdicao(){
    editar = true;
    getElementById('txtDocumentoUser').disabled = false;
    getElementById('selectTipoDocumento').disabled = false;
    getElementById('txtNome').disabled = false;
    getElementById('txtEmail').disabled = false;
    getElementById('txtTelefone').disabled = false;
    getElementById('selectFuncao').disabled = false;
}

function limpaDados(){
    editar = false;
    getElementById('txtDocumentoUser').value = ""
    getElementById('selectTipoDocumento').value = 0
    getElementById('txtNome').value = "";
    getElementById('txtEmail').value = "";
    getElementById('txtTelefone').value = "";
}

function getDados(){
    var cliente = new Object();

    var id = new Object();
    id.documento = getValueById('txtDocumentoUser');
    var tipoDoc = new Object();
    tipoDoc.id = document.getElementById('selectTipoDocumento').value;
    id.tipoDocumento = tipoDoc;

    cliente.id = id;
    cliente.nome = getValueById('txtNome');
    cliente.email = getValueById('txtEmail');
    cliente.telefone = getValueById('txtTelefone');
    cliente.funcao = getValueById('selectFuncao');

    return cliente;
}

document.getElementById('btnSendCad').addEventListener('click',function submitFormCad(e){
    var metodo ="";
    if(editar){
        metodo="POST";
    }else{
        metodo="POST";
    }
    alterarUsuario(metodo);
});

document.getElementById('btnApagarCad').addEventListener('click',function submitFormCad(e){
    var metodo ="DELETE";
    alterarUsuario(metodo);
});

function alterarUsuario(metodo){
    var dados = getDados();
    var endpoint = "";
    if(dados.funcao != 3){
        endpoint = "funcionario"
    }else{
        endpoint = "pessoa"
    }

    var url = urlbase+endpoint;

    console.log(metodo)
    $.ajax({
		url : url,
		contentType: "application/json",
		type : metodo,
		data : JSON.stringify(dados)
	})
	.done(function(msg){		
       alert(msg);	
       limpaDados();	
	})
	.fail(function(jqXHR, textStatus, msg){
		console.log(msg);
	});
}