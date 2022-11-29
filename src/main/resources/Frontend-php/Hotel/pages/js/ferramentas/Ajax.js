function requestAjax(verbo,url,dados){
	$.ajax({
		url : url,
		contentType: "application/json",
		type : verbo,
		data : dados
	})
	.done(function(msg){
		return msg;
	})
	.fail(function(jqXHR, textStatus, msg){
		resposta = msg;
	});
}

