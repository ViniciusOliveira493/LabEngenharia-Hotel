<!DOCTYPE html>
<html>
    <head>
        <title>Vagas de Estacionamento</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <?php include_once('componentes/nav.php')?>
<!-- modal -->
        <div class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Título do modal</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Texto do corpo do modal, é aqui.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
        <button type="button" class="btn btn-primary">Salvar mudanças</button>
      </div>
    </div>
  </div>
</div>
<!-- modal -->
        <main class="conteudo">
            <div class="container mt-4">
                <div class="row border">
                    <div class="col-3">
                        <div class="input-group mb-3">   
                            <input type="text" id="txtEstacionamentoVagaBusca" class="form-control" placeholder="Estacionamento" aria-label="buscar vaga" aria-describedby="button-addon2">                    
                            <input type="number" id="txtBuscaVaga" class="form-control " placeholder="vaga" aria-label="buscar vaga" aria-describedby="button-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-outline-secondary" type="button" id="btnBuscarVaga">Buscar</button>
                            </div>                      
                        </div>
                        <div class="input-group mb-3">
                            <ul class="list-group col-12" id="listaVagas">
                                
                            </ul>
                        </div>
                    </div>
                    <div class="col-9">
                    <form>                        
                        <div class="form-group mt-1">
                            <div class="form-group">
                                <label for="formGroupExampleInput">Estacionamento</label>
                                <input type="text" class="form-control" id="txtEstacionamentoVaga" placeholder="Digite o numero do estacionamento">
                            </div>

                            <div class="form-group">
                                <label for="formGroupExampleInput">Vaga</label>
                                <input type="text" class="form-control" id="txtNumVaga" placeholder="Digite o numero da vaga">
                            </div>

                            <div class="mt-3">
                                <div class="form-group">
                                    <label for="Nome">Descrição:</label>
                                    <input type="text" class="form-control" id="txtDescricao" aria-describedby="emailHelp" placeholder="Descrição da vaga">
                                </div>
                            </div>
                            <div class="input-group-append">
                                <label for="exampleFormControlSelect1">Tipo de Vaga</label>
                                <select class="form-control" id="selectTipoVaga">
                                    <option>Selecione um tipo de vaga</option>
                                
                                </select>     
                            </div>  
                            <div class="mt-3">
                                <div class="form-group">
                                    <label for="valor diaria">Valor Diária</label>
                                    <input type="number" min="0" step="0.01" class="form-control" id="txtDiaria" placeholder="0.00">
                                </div>
                            </div>
                
                            <div class="mt-3">
                                <button type="button" class="btn btn-success btn-lg btn-block" data-toggle="modal" data-target="#modalExemplo">Adicionar Vagas</button>
                                <button id = "btnSendCad" type="button" class="btn btn-primary btn-lg btn-block">Salvar</button>
                                <button id = "btnEditCad" type="button" class="btn btn-warning btn-lg btn-block">Editar</button>
                                <button id = "btnApagarCad" type="button" class="btn btn-danger btn-lg btn-block">Apagar</button>
                            </div>   
                            <div class="mb-5"></div>  
                        </div>
                    </form>
                    </div>
                </div>
                </div>
            </main>
        <?php include_once('componentes/footer.php')?>

        <script>
            <?php 
                include_once("js/ferramentas/metodosDeApoio.js");
                include_once("js/paginas/nav.js");
                include_once("js/paginas/crudVagas.js");
            ?>
        </script>
    </body>
</html>