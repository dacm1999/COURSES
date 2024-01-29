<?php


$texto = "Honduras";

echo $texto. "\n";

$variable1 = $texto. " es hermoso \n";
echo $variable1;
$variable2 = &$texto;


$texto = "Daniel Contreras";

echo $variable2;

?>