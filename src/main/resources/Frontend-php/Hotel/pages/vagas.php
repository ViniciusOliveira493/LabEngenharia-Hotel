<!DOCTYPE html>
<html>
    <head>
        <title>Vagas de Estacionamento</title>       
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <?php include_once('componentes/nav.php')?>
<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-lg bg-white" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Adicionar Vagas</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
            <div class="form-group">
                <label for="estacionamento">Estacionamento</label>
                <input type="text" class="form-control" id="txtEstacionamentoVagaModal" placeholder="Digite o número do estacionamento">
            </div>
            <div class="form-group">
                <label for="Primeira Vaga">Primeira Vaga</label>
                <input type="number" min="0" class="form-control" id="txtNumPrimeiraVaga" placeholder="Digite o numero da primeira vaga">
            </div>
            <div class="form-group">
                <label for="Primeira Vaga">Última Vaga</label>
                <input type="number" min="0" class="form-control" id="txtNumUltimaVaga" placeholder="Digite o numero da última vaga">
            </div>
            <div class="mt-3">
                <div class="form-group">
                    <label for="Descrição">Descrição:</label>
                    <input type="text" class="form-control" id="txtDescricaoModal" placeholder="Descrição da vaga">
                </div>
            </div>
            <div class="input-group-append">
                <label for="tipo Da Vaga">Tipo de Vaga</label>
                <select class="form-control" id="selectTipoVagaModal">
                    <option>Selecione um tipo de vaga</option>
                
                </select>     
            </div>  
            <div class="mt-3">
                <div class="form-group">
                    <label for="valor diaria">Valor Diária</label>
                    <input type="number" min="0" step="0.01" class="form-control" id="txtDiariaModal" placeholder="0.00">
                </div>
            </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
        <button type="button" id="btnSubmitModal" class="btn btn-success">Salvar</button>
      </div>
    </div>
  </div>
</div>
<!-- Modal -->
        <main class="conteudo bg">
            <div class="container bg-white">
                <div class="row border">
                    <div class="col-3">
                        <div class="input-group mb-3">   
                            <input type="text" id="txtEstacionamentoVagaBusca" class="form-control" placeholder="Estacionamento" aria-label="buscar vaga" aria-describedby="button-addon2">                    
                            <input type="number" id="txtBuscaVaga" class="form-control " placeholder="vaga" aria-label="buscar vaga" aria-describedby="button-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-outline-secondary" type="button" id="btnBuscarVaga">Buscar</button>
                            </div>                      
                        </div>
                        <style>
                            .lista{
                                height:20em;
                                overflow-y: scroll;
                            }
                        </style>
                        <div class="input-group mb-3 overflow-auto lista">
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
                                <input type="number" min="0" class="form-control" id="txtNumVaga" placeholder="Digite o numero da vaga">
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
                          <!-- Button trigger modal -->
                                <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#exampleModalCenter">
                                    Adicionar Vagas
                                </button>
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

        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script>            
            <?php 
                include_once("js/ferramentas/metodosDeApoio.js");
                include_once("js/paginas/nav.js");
                include_once("js/paginas/crudVagas.js");
            ?>
        </script>
    </body>
</html>