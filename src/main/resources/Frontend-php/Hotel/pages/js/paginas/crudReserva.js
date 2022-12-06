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

