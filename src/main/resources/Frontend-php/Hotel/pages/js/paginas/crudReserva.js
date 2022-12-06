var cookieName = "usuario";
var user = getCookie(cookieName);
user = JSON.parse(user)
var quarto = new Object();
var cliente;

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

getElementById("selectQuarto").addEventListener("change",function(){
    findQuarto(getValueById('selectQuarto'));
});
getElementById("slTipoQuarto").addEventListener("change",function(){
    var data = getValueById('dataInicioReserva');
    var tipo = getValueById('slTipoQuarto');
    data = data.replace('T',' ');
    getElementById('selectQuarto').innerHTML = "";
    var opt1 = new Option('Selecione um Quarto disponível:',0);
    getElementById('selectQuarto').append(opt1);

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
    getElementById('selectVaga').innerHTML = "";
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

getElementById("btnCadReserva").addEventListener("click",function(){
    $.ajax({
		url : urlbase+'reserva',
		contentType: "application/json",
		type : "POST",
		data : getReserva()
	})
	.done(function(msg){
        alert(msg)	
	})
	.fail(function(jqXHR, textStatus, msg){
		console.log(msg);
	});
});

getElementById("txtDocumentoClienteForm").addEventListener("focusout",function(){
    var documento = getValueById('txtDocumentoClienteForm');
    var tipoDocumento = getValueById('selectTipoDocumentoForm');
    documento = limparDocumento(documento);
    findCliente(tipoDocumento,documento)
});

getElementById("btnCancelarReserva").addEventListener("click",function(){
    $.ajax({
		url : urlbase+'reserva',
		contentType: "application/json",
		type : "DELETE",
		data : getReserva()
	})
	.done(function(msg){
        alert(msg)	
	})
	.fail(function(jqXHR, textStatus, msg){
		console.log(msg);
	});
});

function criarOptionVaga(opcao){
    return new Option('Estacionamento:'+opcao.estacionamento +' Vaga: '+opcao.numVaga,opcao.numVaga+"|"+opcao.estacionamento);
}

function getReserva(){
    var dataInicio = getValueById('dataInicioReserva')
    dataInicio = dataInicio.replace('T',' ');
    var dataFim = getValueById('dataFimReserva')
    dataFim = dataFim.replace('T',' ');

    var vaga = new Object();

    if(getValueById('selectVaga') != 0){
        var vagaId = getValueById('selectVaga');
        var id = vagaId.split('|');       
        vaga.estacionamento = id[1];
        vaga.numVaga = id[0];
    }

    var reserva = new Object();
    reserva.dataInicio = dataInicio;
    reserva.dataFim = dataFim;
    reserva.documento = cliente;
    reserva.quarto = quarto;
    reserva.vaga = vaga;

    return JSON.stringify(reserva);
}

function findCliente(tipoDocumento,documento){
    $.ajax({
		url : urlbase+'pessoa/'+tipoDocumento+'/'+limparDocumento(documento),
		contentType: "application/json",
		type : "GET",
		data : ''
	})
	.done(function(msg){
        cliente = msg;
	})
	.fail(function(jqXHR, textStatus, msg){
		console.log(msg);
	});
}

function findQuarto(id){
    $.ajax({
		url : urlbase+'quartos/'+id,
		contentType: "application/json",
		type : "GET",
		data : ''
	})
	.done(function(msg){
        quarto = msg;
	})
	.fail(function(jqXHR, textStatus, msg){
		console.log(msg);
	});
}