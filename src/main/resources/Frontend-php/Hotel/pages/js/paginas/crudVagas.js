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
        var select = getElementById('selectTipoVaga');
        var select2 = getElementById('selectTipoVagaModal');
        msg.forEach(e => {
            select.append(criarOptionTipoVaga(e))
            select2.append(criarOptionTipoVaga(e))
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

function getDados(){
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

function alterarVaga(metodo,dados,enviarMensagem){
    var endpoint = "vagas";  

    var url = urlbase+endpoint;

    $.ajax({
		url : url,
		contentType: "application/json",
		type : metodo,
		data : JSON.stringify(dados)
	})
	.done(function(msg){
        if(enviarMensagem){
            alert(msg);	
        }
       limpaDados();	
	})
	.fail(function(jqXHR, textStatus, msg){
		console.log(msg);
	});
}

function permitirEdicao(){
    editar = true;
    getElementById('txtEstacionamentoVaga').disabled = false;
    getElementById('txtNumVaga').disabled = false;
    getElementById('txtDescricao').disabled = false;
    getElementById('selectTipoVaga').disabled = false;
    getElementById('txtDiaria').disabled = false;   
}

function limpaDados(){
    editar = false;
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

    var lista = getElementById("listaVagas");
    lista.innerHTML = "";
    console.log(txtNumVaga)
    var url;  
    if((txtEstacionamento!=null || txtEstacionamento.length!==0) && (txtNumVaga===null || txtNumVaga.length===0)){  
        url = urlbase+"vagas/"+txtEstacionamento;
    }else{
        url = urlbase+"vagas/"+txtNumVaga+"/"+txtEstacionamento;
    }
    console.log(url)
    $.ajax({
		url : url,
		contentType: "application/json",
		type : "GET",
		data : null
	})
	.done(function(msg){	
        if(Array.isArray(msg)){
            msg.forEach(e => {
                lista.append(criarItemVaga(e));	
            }); 
        }
        if(!Array.isArray(msg)){
            lista.append(criarItemVaga(msg));	
        }     	
	})
	.fail(function(jqXHR, textStatus, msg){
		console.log(msg);
	});
});

document.getElementById('btnSendCad').addEventListener('click',function submitFormCad(e){
    var dados = getDados();
    if(!editar){
        alterarVaga('POST',dados,true);
    }else{
        alterarVaga('PUT',dados,true);
    }
});

document.getElementById('btnApagarCad').addEventListener('click',function submitFormCad(e){  
    var dados = getDados(); 
    alterarVaga('DELETE',dados,true); 
});

//=========================== MODAL ================================
document.getElementById('btnSubmitModal').addEventListener('click',function submitFormCad(e){   
    var vagas = getDadosModal();
    for(let i=vagas.inicio;i<=(vagas.fim);i++){
        var vaga = new Object();
        vaga.estacionamento = vagas.estacionamento;
        vaga.numVaga = i;
        vaga.descricao = vagas.descricao;
        vaga.tipo = vagas.tipo;
        vaga.valorDiaria = vagas.valorDiaria;

        alterarVaga('POST',vaga,false);       
    }
    alert("Vagas cadastradas com sucesso");
    limparDadosModal();
});

function getDadosModal(){
    var vaga = new Object();
    vaga.estacionamento=getElementById('txtEstacionamentoVagaModal').value;
    vaga.inicio=parseInt(getElementById('txtNumPrimeiraVaga').value);
    vaga.fim=parseInt(getElementById('txtNumUltimaVaga').value);
    vaga.descricao=getElementById('txtDescricaoModal').value;
    var tipoVaga = new Object();
    tipoVaga.id = getElementById('selectTipoVagaModal').value;

    vaga.tipo= tipoVaga;
    vaga.valorDiaria=getElementById('txtDiariaModal').value;

    return vaga;
}

function limparDadosModal(){
    getElementById('txtEstacionamentoVagaModal').value ="";
    getElementById('txtNumPrimeiraVaga').value="0";
    getElementById('txtNumUltimaVaga').value="0";
    getElementById('txtDescricaoModal').value="";
    getElementById('selectTipoVagaModal').value="0";
    getElementById('txtDiariaModal').value="0.00";
}