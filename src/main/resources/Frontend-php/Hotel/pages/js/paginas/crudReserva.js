var cookieName = "usuario";
var user = getCookie(cookieName);
user = JSON.parse(user)

window.onload = init();
function init(){
    if(user.funcao == 3){
        getElementById("pesquisaCliente").setAttribute("class","d-none");
    }else{
        getElementById("pesquisaCliente").removeAttribute("class","d-none");
    }

    var selects = ['selectTipoDocumentoBusca','selectTipoDocumentoForm'];
    carregarTiposDocumento(selects);

    var selectQuarto = ['slTipoQuarto'];
    carregarTiposQuarto(selectQuarto);

    var selectTipoVaga = ['selectTipoVaga'];
    carregarTiposVaga(selectTipoVaga);
}

getElementById("selectTipoDocumentoBusca").addEventListener("change",function(){
    aplicarMascarasDocumentos("selectTipoDocumentoBusca","txtDocumentoClienteBusca")
});

getElementById("selectTipoDocumentoForm").addEventListener("change",function(){
    aplicarMascarasDocumentos("selectTipoDocumentoForm","txtDocumentoClienteForm")
});

getElementById("slTipoQuarto").addEventListener("change",function(){
    var data = getValueById('dataInicioReserva');
    var tipo = getValueById('slTipoQuarto');
    data = data.replace('T',' ');
    
    $.ajax({
		url : urlbase+'quartosdisp/'+data+'/'+tipo,
		contentType: "application/json",
		type : "GET",
		data : ""
	})
	.done(function(msg){
        msg.forEach(f => {
            getElementById('selectQuarto').append(criarOptionQuarto(f));
        });
	})
	.fail(function(jqXHR, textStatus, msg){
		console.log(msg);
	});
});

function criarOptionQuarto(opcao){
    return new Option('Quarto:'+opcao.numero +' Prédio: '+opcao.predio,opcao.id)
}

getElementById("selectTipoVaga").addEventListener("change",function(){
    var data = getValueById('dataInicioReserva');
    var tipo = getValueById('selectTipoVaga');
    data = data.replace('T',' ');
    
    $.ajax({
		url : urlbase+'vagasdisp/'+data+'/'+tipo,
		contentType: "application/json",
		type : "GET",
		data : ""
	})
	.done(function(msg){
        msg.forEach(f => {
            getElementById('selectVaga').append(criarOptionVaga(f));
        });
	})
	.fail(function(jqXHR, textStatus, msg){
		console.log(msg);
	});
});

function criarOptionVaga(opcao){
    return new Option('Estacionamento:'+opcao.estacionamento +' Vaga: '+opcao.numVaga,opcao.numVaga+"|"+opcao.estacionamento);
}