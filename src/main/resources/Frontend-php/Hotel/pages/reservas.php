<!DOCTYPE html>
<html>
    <head>
        <title>Reservas</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <?php include_once('componentes/nav.php')?>
        <main class="bg">
            <div class="container bg-white">
                <div class="row border">
                    <div class="col-3">
                        <div class="input-group mb-3">   
                            <div class="input-group mb-3"> 
                                <div id="pesquisaCliente" class="d-none">
                                    <div class="input-group-append">
                                        <label for="slTipoDocumento">Tipo de Documento:</label>
                                        <select class="form-control" id="selectTipoDocumentoBusca">
                                            <option>Selecione um tipo de documento</option>                                    
                                        </select>     
                                    </div>  
                                    <div class="form-group">
                                        <label for="txtDocumentoCliente">Documento:</label>
                                        <input type="text" class="form-control" id="txtDocumentoClienteBusca" placeholder="Digite o numero do estacionamento">
                                    </div>
                                </div> 
                                    <div class="input-group mt-2">
                                        <input type="date" id="txtDataReserva" class="form-control " placeholder="buscar usuário" aria-label="buscar usuário" aria-describedby="button-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-outline-secondary" type="button" id="btnBuscarReservaUser">Buscar</button>
                                        </div>  
                                    </div> 
                                    <p class="text-center col-12">OU</p>
                                
                               
                                <div class="input-group">
                                    <input type="number" id="txtCodigoReserva" class="form-control " placeholder="Código da reserva" aria-label="buscar usuário" aria-describedby="button-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-outline-secondary" type="button" id="btnBuscarReservaCod">Buscar</button>
                                    </div>  
                                </div> 
                            </div>
                            <div class="input-group mb-3">
                                <ul class="list-group col-12" id="listaReservas">
                                
                                </ul>
                            </div>                    
                        </div>
                        <style>
                            .lista{
                                height:20em;
                                overflow-y: scroll;
                            }
                        </style>
                        <div class="input-group mb-3 overflow-auto lista">
                            <ul class="list-group col-12" id="listaReservas">
                                
                            </ul>
                        </div>
                    </div>
                    <div class="col-9">
                        <form>                        
                            <div class="input-group-append">
                                <label for="slTipoDocumento">Tipo de Documento:</label>
                                <select class="form-control" id="selectTipoDocumentoForm">
                                    <option>Selecione um tipo de documento</option>                                    
                                </select>     
                            </div>  
                            <div class="form-group">
                                <label for="txtDocumentoCliente">Documento:</label>
                                <input type="text" class="form-control" id="txtDocumentoClienteForm" placeholder="Digite o numero do estacionamento">
                            </div>
                            <div class="form-group">
                                <label for="txtDocumentoCliente">Data Início:</label>
                                <input type="datetime-local" class="form-control" id="dataInicioReserva">
                            </div>
                            <div class="form-group">
                                <label for="txtDocumentoCliente">Data Fim:</label>
                                <input type="datetime-local" class="form-control" id="dataFimReserva">
                            </div>
                            <div class="input-group-append">
                                <label for="select Tipo do Quarto">Tipo de Quarto:</label>
                                <select class="form-control" id="slTipoQuarto">
                                    <option>Selecione um tipo de quarto</option>                                    
                                </select>     
                            </div>  
                            <div class="input-group-append">
                                <label for="select Quarto">Quarto:</label>
                                <select class="form-control" id="selectQuarto">
                                    <option value="0">Selecione um Quarto disponível:</option>                                    
                                </select>     
                            </div>
                            <div class="input-group-append">
                                <label for="select Vaga">Vaga:</label>
                                <select class="form-control" id="selectTipoVaga">
                                    <option value="0">Selecione um tipo de vaga</option>                                    
                                </select>  
                            </div>
                            <div class="input-group-append mt-2">
                                <select class="form-control" id="selectVaga">
                                    <option value="0">Selecione uma vaga disponível:</option>                                   
                                </select>     
                            </div>
                            <div class="input-group-append mt-4">
                                <button id = "btnCadReserva" type="button" class="btn btn-success btn-lg btn-block">Realizar Reserva </button>
                                <button id = "btnCancelarReserva" type="button" class="btn btn-danger btn-lg btn-block">Cancelar Reserva</button>
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
                include_once("js/paginas/crudReserva.js");
            ?>
        </script>
    </body>
</html>