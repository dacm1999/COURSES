<?php

    $valor1 = 10;
    $valor2 = 2;


    //SINTAXIS CUANDO SOLO SE UTILIZA PHP
    if($valor1 > 2){
        echo "Valor1 $valor1 es mayor \n";
    }else{
        echo "Valor2 $valor1 es mayor";
    }

    echo "\n";

    // SINTAXIS CUANDO SE UTILIZA CODIGO HTML
    if($valor1 > 2):
        echo "Valor1 $valor1 es mayor";
    else:
        echo "Valor1 $valor2 es mayor";
    endif;

?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php if(9>=8): ?>
        <h1>Expresion verdadera</h1>
    <?php endif; ?>
</body>
</html>