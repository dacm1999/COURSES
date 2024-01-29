<?php

    define("nombre","Daniel"); //Vieja forma
    const nombre2 = "Daniel";
    // define("nombre",10); No se puede cambiar el valor de la constante
    echo nombre2;

    define("alumnos", array("Carlos", "Alba","Luis"));
    
    print_r(alumnos); // para imprimir un array necesito la funcion "print_r" o "var_dump"



?>