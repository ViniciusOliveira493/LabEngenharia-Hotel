<!DOCTYPE html>
<html>
    <head>
        <title>Cliente</title>

        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body onload="onloadcadastro()">
        <?php include_once('componentes/nav.php')?>
        <main>
        <form id = "frmCadastrarCliente">
            <div class="row">
                <div class="col-12">
                    <div class="row d-flex justify-content-center">
                        <div class="col-md-7 col-sm-10 col-10">
                            <div class="mt-3">
                                <label for="Documento">Documento:</label>
                                <input type="text" class="form-control" id="txtDocumento">
                            </div>
                            <div class="mt-3">
                            <select class="form-select" aria-label="Default select example" id="selectTipoDocumento">
                                <option selected>Selecione o tipo do Documento</option>                                
                            </select>
                            </div>
                            <div class="mt-3">
                                <div class="form-group">
                                    <label for="Nome">Nome:</label>
                                    <input type="text" class="form-control" id="txtNome" aria-describedby="emailHelp" placeholder="Seu nome">
                                </div>
                            </div>
                            <div class="mt-3">
                                <div class="form-group">
                                    <label for="email">Endereço de email</label>
                                    <input type="email" class="form-control" id="txtEmail" aria-describedby="emailHelp" placeholder="Seu email">
                                </div>
                            </div>
                            <div class="mt-3">
                                <div class="form-group">
                                    <label for="senha">Senha</label>
                                    <input type="password" class="form-control" id="txtSenha" placeholder="Senha">
                                </div>
                            </div>
                            <div class="mt-3">
                                <div class="form-group">
                                    <label for="confirmar senha">Confirmar senha</label>
                                    <input type="password" class="form-control" id="txtCsenha" placeholder="Senha">
                                </div>
                            </div>
                            <div class="mt-3">
                                <div class="form-group">
                                    <label for="telefone">Número de telefone</label>
                                    <input type="text" class="form-control" id="txtTelefone" placeholder="Telefone: (11) 91111-1111">
                                </div>
                            </div>
                            <div class="mt-3">
                                <button id = "btnSendCad" type="submit" class="btn btn-primary btn-lg btn-block">Cadastrar</button>
                            </div>   
                            <div class="mb-5"></div>                         
                        </div>
                    </div>
                </div>
            </div>           
        </form>
        
        </main>
        <?php include_once('componentes/footer.php')?>
        <script>
            <?php 
                include_once("js/ferramentas/metodosDeApoio.js");
                include_once("js/paginas/nav.js");
                include_once("js/paginas/cadastro.js");
            ?>
        </script>

    </body>
</html>