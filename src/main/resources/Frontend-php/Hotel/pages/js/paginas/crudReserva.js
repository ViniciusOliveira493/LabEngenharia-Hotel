window.onload = init();

function init(){
    var selects = ['selectTipoDocumentoBusca','selectTipoDocumentoForm'];
    carregarTiposDocumento(selects);
}

getElementById("selectTipoDocumentoBusca").addEventListener("change",function(){
    aplicarMascarasDocumentos("selectTipoDocumentoBusca","txtDocumentoClienteBusca")
});

getElementById("selectTipoDocumentoForm").addEventListener("change",function(){
    aplicarMascarasDocumentos("selectTipoDocumentoForm","txtDocumentoClienteForm")
});

