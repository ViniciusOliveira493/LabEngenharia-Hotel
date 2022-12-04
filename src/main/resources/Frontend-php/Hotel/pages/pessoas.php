<!DOCTYPE html>
<html>
    <head>
        <title>Pessoas</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <?php include_once('componentes/nav.php')?>
        <main class="conteudo bg">
            <div class="container bg-white">
                <div class="row border">
                    <div class="col-3">
                        <!--
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="cbFuncionario">
                            <label class="form-check-label" for="flexCheckDefault">
                               Buscar apenas funcionários
                            </label>
                        </div>
                        -->
                        
                        <div class="input-group mb-3">  
                            <div class="input-group-append">
                                <label for="exampleFormControlSelect1">Tipo de Documento:</label>
                                <select class="form-control" id="selectTipoDocumentoBusca">
                                    <option>Selecione um tipo de documento</option>
                                
                                </select>     
                            </div>  
                            <div class="input-group mt-2">
                                <input type="text" id="txtDocumentoBusca" class="form-control " placeholder="buscar usuário" aria-label="buscar usuário" aria-describedby="button-addon2">
                                <div class="input-group-append">
                                    <button class="btn btn-outline-secondary" type="button" id="btnBuscarUser">Buscar</button>
                                </div>  
                            </div>                                           
                        </div>
                        <div class="input-group mb-3">
                            <ul class="list-group col-12" id="listaClientes">
                               
                            </ul>
                        </div>
                    </div>
                    <div class="col-9">
                    <form>
                       
                        <div class="form-group mt-1">
                            <label for="exampleFormControlSelect1">Tipo de Documento</label>
                            <select class="form-control" id="selectTipoDocumento">
                                <option>Selecione um tipo de documento</option>
                               
                            </select>

                            <div class="form-group">
                                <label for="formGroupExampleInput">Documento</label>
                                <input type="text" class="form-control" id="txtDocumentoUser" placeholder="Digite o numero do documento">
                            </div>

                            <div class="mt-3">
                                <div class="form-group">
                                    <label for="Nome">Nome:</label>
                                    <input type="text" class="form-control" id="txtNome" aria-describedby="emailHelp" placeholder="Nome do usuário">
                                </div>
                            </div>
                            <div class="mt-3">
                                <div class="form-group">
                                    <label for="email">Endereço de email</label>
                                    <input type="email" class="form-control" id="txtEmail" aria-describedby="emailHelp" placeholder="Email do usuário">
                                </div>
                            </div>
                            <div class="mt-3">
                                <div class="form-group">
                                    <label for="telefone">Número de telefone</label>
                                    <input type="text" class="form-control" id="txtTelefone" placeholder="Telefone: (11) 91111-1111">
                                </div>
                            </div>
                            <div>
                                <label for="exampleFormControlSelect1">Função</label>
                                <select class="form-control" id="selectFuncao">
                                    <option value="3">Cliente</option>

                                </select>
                            </div>
                            <div class="mt-3">
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
                include_once("js/paginas/crudPessoa.js");
            ?>
        </script>
    </body>
</html>