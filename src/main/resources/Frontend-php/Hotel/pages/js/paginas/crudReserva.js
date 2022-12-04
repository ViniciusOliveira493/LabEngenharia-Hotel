window.onload = init();

function init(){
    var selects = ['selectTipoDocumentoBusca'];
    carregarTiposDocumento(selects);
}

getElementById("selectTipoDocumentoBusca").addEventListener("change",function(){
    aplicarMascarasDocumentos("selectTipoDocumentoBusca","txtDocumentoClienteBusca")
});

