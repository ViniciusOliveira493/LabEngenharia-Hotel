var urlbase = "http://localhost:8080/api/";

function getValueById(id){
    return document.getElementById(id).value;
}

function getElementById(id){
  return document.getElementById(id);
}

function checkUndefined(msg){
  return typeof msg === "undefined"
}
function voltarParaHome(){
  window.location.href = "/Hotel"
}
/* Operações com documentos*/
function limparDocumento(txt){
  txt = txt.replaceAll(".","");
  txt = txt.replaceAll("-","");
  txt = txt.replaceAll(" ","");
  return txt;
}

function carregarTiposDocumento(selectIds){
	$.ajax({
		url : urlbase+'tipodocumento',
		contentType: "application/json",
		type : "GET",
		data : ""
	})
	.done(function(msg){
        selectIds.forEach(e =>{
          let select = document.getElementById(e);
          msg.forEach(f => {
            getElementById(e).append(criarOptionDocumento(f));
          });
        });		
	})
	.fail(function(jqXHR, textStatus, msg){
		console.log(msg);
	});
}

function aplicarMascarasDocumentos(select,field){
  getElementById(field).value = "";
  //CPF
  if(getValueById(select)==1){
     var cleave = new Cleave('#'+field, {
         delimiters: ['.', '.','-'],
         blocks: [3, 3, 3, 2],
         uppercase: false
     });
 }
 //ITIN
 if(getValueById(select)==2){
     var cleave = new Cleave('#'+field, {
         blocks: [3, 2, 4],
         uppercase: false
     });
 }
}

function criarOptionDocumento(opcao){
  return new Option(opcao.tipo,opcao.id)
}
/* Seleção do tipo de quarto */
function carregarTiposQuarto(selectIds){
	$.ajax({
		url : urlbase+'tipoquarto',
		contentType: "application/json",
		type : "GET",
		data : ""
	})
	.done(function(msg){
        selectIds.forEach(e =>{
          let select = document.getElementById(e);
          msg.forEach(f => {
            getElementById(e).append(criarOptionTipoQuarto(f));
          });
        });		
	})
	.fail(function(jqXHR, textStatus, msg){
		console.log(msg);
	});
}

function criarOptionTipoQuarto(opcao){
  return new Option(opcao.tipo,opcao.id)
}
/* Seleção do tipo de vaga*/
function carregarTiposVaga(selectIds){
	$.ajax({
		url : urlbase+'tipovaga',
		contentType: "application/json",
		type : "GET",
		data : ""
	})
	.done(function(msg){
        selectIds.forEach(e =>{
          let select = document.getElementById(e);
          msg.forEach(f => {
            getElementById(e).append(criarOptionTipoVaga(f));
          });
        });		
	})
	.fail(function(jqXHR, textStatus, msg){
		console.log(msg);
	});
}

function criarOptionTipoVaga(opcao){
  return new Option(opcao.tipo,opcao.id)
}
/*  ============== COOKIES ==================    */
function setCookie(name,value,maxAgeSeconds){
	document.cookie = name+ "=" + value + ";SameSite=None; Secure; max-age="+maxAgeSeconds;
}

function deleteCookie(name){
  setCookie(name,"",-700)
}

//W3Schools
function getCookie(name) {
  let cookie = {};
  document.cookie.split(';').forEach(function(el) {
    let [key,value] = el.split('=');
    cookie[key.trim()] = value;
  })
  return cookie[name];
}
/*  ============== COOKIES ==================  */