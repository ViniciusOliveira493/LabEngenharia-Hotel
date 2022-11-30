document.onload = inicio();
var editar = false;
function inicio(){
    carregarSelect();
    limpaDados();
}

function carregarSelect(){
    var url = urlbase+'tipovaga';
    
    $.ajax({
		url : url,
		contentType: "application/json",
		type : 'GET',
		data : null
	})
	.done(function(msg){		
        var select = getElementById('selectTipoVaga')       
        msg.forEach(e => {
            select.append(criarOptionTipoVaga(e))
        });
	})
	.fail(function(jqXHR, textStatus, msg){
		console.log(msg);
	});
}

function criarItemVaga(dados){
    var usr = document.createElement('li');
    usr.setAttribute("class","list-group-item")
    usr.setAttribute("onclick","abrirVaga('"+dados.estacionamento+"',"+dados.numVaga+")")
    usr.append(dados.estacionamento + " - "+dados.numVaga);
    return usr;
}

function criarOptionTipoVaga(opcao){
    return new Option(opcao.tipo,opcao.id)
}

function abrirVaga(estacionamento,numeroVaga){
    console.log(estacionamento + " | "+numeroVaga)
    var url = urlbase + "vagas/"+numeroVaga+"/"+estacionamento;
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
    getElementById('txtEstacionamentoVaga').value = dados.estacionamento;
    getElementById('txtNumVaga').value = dados.numVaga;
    getElementById('txtDescricao').value = dados.descricao;
    getElementById('selectTipoVaga').value = dados.tipo.id;
    getElementById('txtDiaria').value = dados.valorDiaria;

    getElementById('txtEstacionamentoVaga').disabled = true;
    getElementById('txtNumVaga').disabled = true;
    getElementById('txtDescricao').disabled = true;
    getElementById('selectTipoVaga').disabled = true;
    getElementById('txtDiaria').disabled = true;

}

function getDados(dados){
    var vaga = new Object();
    vaga.estacionamento=getElementById('txtEstacionamentoVaga').value;
    vaga.numVaga=getElementById('txtNumVaga').value;
    vaga.descricao=getElementById('txtDescricao').value;
    var tipoVaga = new Object();
    tipoVaga.id = getElementById('selectTipoVaga').value;
    vaga.tipo= tipoVaga;
    vaga.valorDiaria=getElementById('txtDiaria').value;

    return vaga;
}

function alterarVaga(metodo){
    var dados = getDados();
    var endpoint = "vagas";  

    var url = urlbase+endpoint;

    console.log(JSON.stringify(dados));
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

function permitirEdicao(){
    getElementById('txtEstacionamentoVaga').disabled = false;
    getElementById('txtNumVaga').disabled = false;
    getElementById('txtDescricao').disabled = false;
    getElementById('selectTipoVaga').disabled = false;
    getElementById('txtDiaria').disabled = false;   
}

function limpaDados(){
    getElementById('txtEstacionamentoVaga').value = "";
    getElementById('txtNumVaga').value = "";
    getElementById('txtDescricao').value = "";
    getElementById('selectTipoVaga').value = 0
    getElementById('txtDiaria').value = "";
}
document.getElementById('btnEditCad').addEventListener('click',function submitFormCad(e){
    permitirEdicao();
});

document.getElementById('btnBuscarVaga').addEventListener('click',function submitFormCad(e){
    var txtEstacionamento = getValueById('txtEstacionamentoVagaBusca');
    var txtNumVaga = getValueById('txtBuscaVaga');

    console.log(txtEstacionamento + " | "+txtNumVaga)

    var lista = getElementById("listaVagas");
    lista.innerHTML = "";
    
    var url;    
    url = urlbase+"vagas/"+txtNumVaga+"/"+txtEstacionamento
  
    console.log(url)
    $.ajax({
		url : url,
		contentType: "application/json",
		type : "GET",
		data : null
	})
	.done(function(msg){		
        lista.append(criarItemVaga(msg));		
	})
	.fail(function(jqXHR, textStatus, msg){
		console.log(msg);
	});
});

document.getElementById('btnSendCad').addEventListener('click',function submitFormCad(e){
    if(editar){
        alterarVaga('POST');
    }else{
        alterarVaga('POST');
    }
});

document.getElementById('btnApagarCad').addEventListener('click',function submitFormCad(e){   
    alterarVaga('DELETE'); 
});