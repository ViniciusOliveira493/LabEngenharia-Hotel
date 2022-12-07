document.onload = inicio();
var editar = false;
function inicio(){
    carregarSelect();
    limpaDados();
}

function carregarSelect(){
    var url = urlbase+'tipoquarto';
    
    $.ajax({
		url : url,
		contentType: "application/json",
		type : 'GET',
		data : null
	})
	.done(function(msg){		
        var select = getElementById('selectTipoQuarto');
        var select2 = getElementById('selectTipoQuartoModal');
        msg.forEach(e => {
            select.append(criarOptionTipoQuarto(e))
            select2.append(criarOptionTipoQuarto(e))
        });
	})
	.fail(function(jqXHR, textStatus, msg){
		console.log(msg);
	});
}

function criarItemQuarto(dados){
    var usr = document.createElement('li');
    usr.setAttribute("class","list-group-item")
    usr.setAttribute("onclick","abrirQuarto('"+dados.id+"')");
    usr.append("Andar: "+dados.andar+"| Número: "+dados.numero);
    return usr;
}

function criarOptionTipoQuarto(opcao){
    return new Option(opcao.tipo,opcao.id)
}

function abrirQuarto(IdQuarto){
    var url = urlbase + "quartos/"+IdQuarto;
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
    console.log(dados)
    getElementById('txtIdQuarto').value = dados.id;
    getElementById('txtPredio').value = dados.predio;
    getElementById('txtAndar').value = dados.andar;
    getElementById('txtNumQuarto').value = dados.numero;
    getElementById('selectTipoQuarto').value = dados.tipo.id;

    getElementById('txtIdQuarto').disabled  = true;
    getElementById('txtPredio').disabled  = true;
    getElementById('txtAndar').disabled  = true;
    getElementById('txtNumQuarto').disabled  = true
    getElementById('selectTipoQuarto').disabled  = true

}

function getDados(){
    var quarto = new Object();
    quarto.IdQuarto =getElementById('txtIdQuarto').value;
    quarto.Predio = getElementById('txtPredio').value;
    quarto.Andar = getElementById('txtAndar').value;
    var tipoQuarto = new Object();
    tipoQuarto.id = getElementById('selectTipoQuarto').value;
    quarto.tipo = tipoQuarto;

    return quarto;
}

function alterarQuarto(metodo,dados,enviarMensagem){
    var endpoint = "quartos";  

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
    getElementById('txtIdQuarto').disabled  = false;
    getElementById('txtPredio').disabled  = false;
    getElementById('txtAndar').disabled  = false;
    getElementById('txtnumQuarto').disabled  = false;
    getElementById('selectTipoQuarto').disabled  = 0
}

function limpaDados(){
    editar = false;
    getElementById('txtIdQuarto').disabled  = "";
    getElementById('txtPredio').disabled  = "";
    getElementById('txtAndar').disabled  = "";
    getElementById('txtNumQuarto').disabled  = "";
    getElementById('selectTipoQuarto').disabled  = 0
}
document.getElementById('btnEditCad').addEventListener('click',function submitFormCad(e){
    permitirEdicao();
});

document.getElementById('btnBuscarQuarto').addEventListener('click',function submitFormCad(e){
    var txtIdQuarto= getValueById('txtBuscaQuarto');

    var lista = getElementById("listaQuartos");
    lista.innerHTML = "";
    console.log(txtIdQuarto)
    var url;  
    if(txtIdQuarto===null || txtIdQuarto.length===0){  
        url = urlbase+"quartos/";
    }else{
        url = urlbase+"quartos/"+txtIdQuarto+"/";
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
                lista.append(criarItemQuarto(e));	
            }); 
        }
        if(!Array.isArray(msg)){
            lista.append(criarItemQuarto(msg));	
        }     	
	})
	.fail(function(jqXHR, textStatus, msg){
		console.log(msg);
	});
});

document.getElementById('btnSendCad').addEventListener('click',function submitFormCad(e){
    var dados = getDados();
    if(!editar){
        alterarQuarto('POST',dados,true);
    }else{
        alterarQuarto('PUT',dados,true);
    }
});

document.getElementById('btnApagarCad').addEventListener('click',function submitFormCad(e){  
    var dados = getDados(); 
    alterarQuarto('DELETE',dados,true); 
});

//=========================== MODAL ================================
document.getElementById('btnSubmitModal').addEventListener('click',function submitFormCad(e){   
    var quartos = getDadosModal();
    for(let i=quartos.inicio;i<=(quartos.fim);i++){
        var quartos = new Object();
        quarto.IdQuarto = i;
        quarto.Predio = quartos.Predio;
        quarto.tipoQuarto = quartos.tipoQuarto;

        alterarQuarto('POST',quarto,false);       
    }
    alert("Quartos cadastrados com sucesso");
    limparDadosModal();
});

function getDadosModal(){
    var quarto = new Object();
    quarto.IdQuarto =getElementById('txtIdQuarto').value;
    quarto.Predio = getElementById('txtPredio').value;
    quarto.Andar = getElementById('txtAndar').value = dados.Andar;;

    var tipoQuarto = new Object();
    tipoQuarto.id = getElementById('selectTipoQuarto').value;
    quarto.tipo = tipoQuarto;

    return quarto;
}

function limparDadosModal(){
    getElementById('txtIdQuarto').value = "0";
    getElementById('txtPredio').value = "";
    getElementById('txtAndar').value = "0";
    getElementById('txtnumQuarto').value = "0";
    getElementById('selectTipoQuarto').value = "0";  
}