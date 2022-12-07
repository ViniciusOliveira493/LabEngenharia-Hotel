<!DOCTYPE html>
<html>
    <head>
        <title>Quartos/<title>       
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
        <h5 class="modal-title" id="exampleModalLongTitle">Adicionar Quartos</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
            <div class="form-group">
                <label for="IdQuarto">IdQuarto</label>
                <input type="number" class="form-control" id="txtQuartoModal" placeholder="Digite o código do quarto">
            </div>
            <div class="mt-3">
                <div class="form-group">
                    <label for="numero">Descrição:</label>
                    <input type="number" class="form-control" id="txtNumQuarto" placeholder="Número do quarto">
                </div>
            </div>
            <div class="input-group-append">
                <label for="tipo Do quarto">Tipo de Quarto</label>
                <select class="form-control" id="selectTipoQuartoModal">
                    <option>Selecione um tipo de quarto</option>
                </select>     
            </div>  
            <div class="mt-3">
                <div class="form-group">
                    <label for="andar">Andar</label>
                    <input type="number" class="form-control" id="txtAndar">
            </div>  
            <div class="mt-3">
                <div class="form-group">
                    <label for="predio">Predio</label>
                    <input type="text" class="form-control" id="txtPredio">
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
                            <input type="number" id="txtBuscaQuarto" class="form-control " placeholder="quarto" aria-label="buscar quarto" aria-describedby="button-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-outline-secondary" type="button" id="btnBuscarQuarto">Buscar</button>
                            </div>                      
                        </div>
                        <style>
                            .lista{
                                height:20em;
                                overflow-y: scroll;
                            }
                        </style>
                        <div class="input-group mb-3 overflow-auto lista">
                            <ul class="list-group col-12" id="listaQuartos">
                                
                            </ul>
                        </div>
                    </div>
                    <div class="col-9">
                    <form>                       
                            <div class="form-group mt-1">
                                <div class="form-group">
                                <label for="formGroupExampleInput">Quarto</label>
                                <input type="number" min="0" class="form-control" id="txtIdQuarto" placeholder="Digite o código do quarto">
                            </div>

                            <div class="mt-3">
                                <div class="form-group">
                                    <label for="Nome">Prédio</label>
                                    <input type="text" class="form-control" id="txtPredio" placeholder="Digite o nome do Prédio">
                                </div>
                            </div>
                            <div class="input-group-append">
                                <label for="exampleFormControlSelect1">Tipo de Quarto</label>
                                <select class="form-control" id="selectTipoQuarto">
                                    <option>Selecione um tipo de quarto</option>
                                
                                </select>     
                            </div>  
                            <div class="mt-3">
                                <div class="form-group">
                                    <label for="Número do quarto">Número do quarto</label>
                                    <input type="number" min="0" class="form-control" id="txtNumQuarto" placeholder="Digite o número do quarto">
                                </div>
                            </div>
                
                            <div class="mt-3">
                          <!-- Button trigger modal -->
                                <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#exampleModalCenter">
                                    Adicionar Quartos
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
