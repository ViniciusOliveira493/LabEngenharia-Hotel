window.onload = onloadA();
var editar = false;

getElementById('btnSendCad').addEventListener('click',function submitFormCad(e){
    var metodo ="";
    if(!editar){
        metodo="POST";
    }else{
        metodo="PUT";
    }
    alterarUsuario(metodo);
});

getElementById('btnApagarCad').addEventListener('click',function submitFormCad(e){
    var metodo ="DELETE";
    alterarUsuario(metodo);
});

getElementById("selectTipoDocumento").addEventListener("change",function(){
    aplicarMascarasDocumentos("selectTipoDocumento","txtDocumentoUser")
});

getElementById("selectTipoDocumentoBusca").addEventListener("change",function(){
    aplicarMascarasDocumentos("selectTipoDocumentoBusca","txtDocumentoBusca")
});

getElementById('btnEditCad').addEventListener('click',function submitFormCad(e){
    permitirEdicao();
});

getElementById('btnBuscarUser').addEventListener('click',function submitFormCad(e){
    var documento = limparDocumento(getValueById('txtDocumentoBusca'));
    var tipoDoc = getValueById('selectTipoDocumentoBusca');

    var lista = getElementById("listaClientes");
    lista.innerHTML = "";
    
    var url;

    url = urlbase+"pessoa/"+tipoDoc+"/"+documento

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

function onloadA(){
    limpaDados();
    var selects = ['selectTipoDocumento','selectTipoDocumentoBusca'];
    carregarTiposDocumento(selects);
    carregarFuncoes();
}

function criarOptionFuncao(opcao){
    return new Option(opcao.tipo,opcao.id)
}
function carregarFuncoes(){
    let select = document.getElementById('selectFuncao');
    if(user.funcao < 2){
        let opcao = new Object();
        opcao.id = 2
        opcao.tipo = "Atendente"
        select.append(criarOptionFuncao(opcao));
        opcao.id = 1
        opcao.tipo = "Gerente"
        select.append(criarOptionFuncao(opcao));
    }
}

function criarItemCliente(dados){
    var usr = document.createElement('li');
    usr.setAttribute("class","list-group-item")
    usr.setAttribute("onclick","abrirUsuario('"+dados.id.documento+"','"+dados.id.tipoDocumento.id+"')")
    usr.append(dados.nome)
    return usr;
}

function abrirUsuario(doc,tipo){
    console.log(doc);
    var url = urlbase+"pessoa/"+tipo+"/"+doc;   
    $.ajax({
		url : url,
		contentType: "application/json",
		type : "GET",
		data : null
	})
	.done(function(msg){        
        console.log(JSON.stringify(msg))		
        setDados(msg);		
	})
	.fail(function(jqXHR, textStatus, msg){
		console.log(msg);
	});
}

function setDados(dados){
    getElementById('selectTipoDocumento').value = dados.id.tipoDocumento.id
    getElementById('selectTipoDocumento').disabled = true;

    getElementById('txtDocumentoUser').value = dados.id.documento
    getElementById('txtDocumentoUser').disabled = true;

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
    id.documento = limparDocumento(getValueById('txtDocumentoUser'));
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

function alterarUsuario(metodo){
    var dados = getDados();
    var endpoint = "";
    if(dados.funcao != 3){
        endpoint = "funcionario"
    }else{
        endpoint = "pessoa"
    }

    var url = urlbase+endpoint;

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