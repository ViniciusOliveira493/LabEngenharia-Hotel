<html>
    <head>
        <title>Não encontrado</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <?php include_once('componentes/nav.php')?>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="error-template">
                        <h1>
                            Oops!</h1>
                        <h2>
                            404 Not Found</h2>
                        <div class="error-details">
                            A página que você buscou não existe
                        </div>
                        <div class="error-actions">
                            <a href="home" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>
                                Voltar para a Home </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <?php include_once('componentes/footer.php')?>
    </body>
</html>