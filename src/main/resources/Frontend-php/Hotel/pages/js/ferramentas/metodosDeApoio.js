var urlbase = "http://localhost:8080/api/";

function getValueById(id){
    return document.getElementById(id).value;
}

function getElementById(id){
  return document.getElementById(id);
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

function checkUndefined(msg){
  return typeof msg === "undefined"
}
function voltarParaHome(){
  window.location.href = "/Hotel"
}
/* */
function limparDocumento(txt){
  txt = txt.replaceAll(".","");
  txt = txt.replaceAll("-","");
  txt = txt.replaceAll(" ","");
  return txt;
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