<!DOCTYPE html>
<html>
    <head>
        <title>Reservas</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <?php include_once('componentes/nav.php')?>
        <main class="conteudo">
            <div class="container mt-4">
                <div class="row border">
                    <div class="col-3">
                        <div class="input-group mb-3">   
                            <div class="input-group mb-3">  
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
                            <ul class="list-group col-12" id="listaVagas">
                                
                            </ul>
                        </div>
                    </div>
                    <div class="col-9">
                        <form>                        
                            
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