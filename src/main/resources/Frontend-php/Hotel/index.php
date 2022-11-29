<?php
    $rota = explode('/',$_GET['url'] ?? 'home');   
    if(file_exists("pages/{$rota[0]}.php")){
        include "pages/{$rota[0]}.php";
    }else{
        include "pages/notFound.php";
    }   
?>