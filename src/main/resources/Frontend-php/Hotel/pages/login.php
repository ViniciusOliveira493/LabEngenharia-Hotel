<!DOCTYPE html>
<html>
    <head>
        <title>Acesso à conta</title>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    </head>
    <body>
        <?php include_once('componentes/nav.php')?>
        <main class="container-fluid">
            <div class="container">
            <section class="vh-100">
                <div class="container-fluid h-custom">
                    <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-md-9 col-lg-6 col-xl-5">
                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                        class="img-fluid" alt="Sample image">
                    </div>
                    <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                        <form>
                            <!-- Email input -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="form3Example3">Endereço de Email</label>
                                <input type="email" id="txtEmail" class="form-control form-control-lg"
                                placeholder="Digite seu email" />                           
                            </div>

                            <!-- Password input -->
                            <div class="form-outline mb-3">
                                <label class="form-label" for="senha">Senha</label>
                                <input type="password" id="txtSenha" class="form-control form-control-lg"
                                placeholder="Digite sua senha" />                            
                            </div>

                            <div class="d-flex justify-content-between align-items-center">
                                <!-- Checkbox 
                                <div class="form-check mb-0">
                                <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3" />
                                <label class="form-check-label" for="form2Example3">
                                    Lembre-me
                                </label>
                                </div>
                                <a href="#!" class="text-body">Esqueceu a senha ?</a>
                                -->
                            </div>

                            <div class="text-center text-lg-start mt-4 pt-2">
                                <button type="button" id="btnLogar" class="btn btn-primary btn-lg" style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
                                <p class="small fw-bold mt-2 pt-1 mb-0">Não tem uma conta ? <a href="cadastrar"
                                    class="link-danger">Cadastrar</a></p>
                            </div>
                        </form>
                    </div>
                    </div>
                </div>
        </main>
        <?php include_once "componentes/footer.php"?>
        <script>
             <?php 
                include_once("js/ferramentas/metodosDeApoio.js");
                include_once("js/paginas/nav.js");
                include_once("js/paginas/login.js");
            ?>
        </script>
    </body>
</html>