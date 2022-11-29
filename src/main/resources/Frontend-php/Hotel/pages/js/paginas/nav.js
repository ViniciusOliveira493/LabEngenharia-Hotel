var cookieName = "usuario"
var user = getCookie(cookieName)
var iconeLogin = getElementById("menuIconeLogin")

if(!checkUndefined(user)){
    user = JSON.parse(user)
    console.log(user.nome + " | "+user.funcao);
    setarIconeUsuario();
}else{   
    iconeLogin.innerHTML = '<a class="nav-link" href="login">Login</a>';
}
adicionarMenus();


function setarIconeUsuario(){
    var html = '<li class="nav-item dropdown">'
    +'<a class="nav-link dropdown-toggle" href="#" id="btnUsuarioLogado" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">'
    + user.nome + "- sair" 
    +'</a>'
  +'</li>';

    iconeLogin.innerHTML = html;

    getElementById('btnUsuarioLogado').addEventListener("click",function(){
        deleteCookie(cookieName);
        alert("Você saiu do sistema com sucesso");
        voltarParaHome();
    });
}

function adicionarMenus(){
    var div = getElementById("menuNavItens");
    var html = ' <li class="nav-item">'
        +'<a class="nav-link active" aria-current="page" href="home">Home</a>'
        +'</li>';
    
    if(!checkUndefined(user)){
        if(user.funcao < 3){
            html += '<li class="nav-item">'
            +'<a class="nav-link" href="cliente">Clientes</a>'
        +'</li>'
        +'<li class="nav-item">'
            +'<a class="nav-link" href="servico">Serviços</a>'
        +'</li>'
        }
        if(user.funcao < 2){
            html += 
        '<li class="nav-item">'
            +'<a class="nav-link" href="funcionarios">Funcionarios</a>'
        +'</li>'
        +'<li class="nav-item">'
            +'<a class="nav-link" href="vagas">Vagas</a>'
        +'</li>'
        }
    }

    div.innerHTML = html;
}
