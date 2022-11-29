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