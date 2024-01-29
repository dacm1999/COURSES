<?php

    // Array de tipo escalar ------- van subiendo de numero
    $estudiantes =array("Daniel","Luis","Nicole","Adrian","Vallejo");
        // $estudiantes[3]="Miriam";
        // print_r($estudiantes[3]);


    //Array de tipo asociativo ------- van asignados por un nombre
    $tutor=[
        "nombre"=>"Carlos",
        "apellido"=>"Alfaro",
        "edad"=>27
    ];

        // print_r($tutor["nombre"]);
        // print_r($tutor["edad"]);
    
    
    
    //Array de tipo multidimencional ------- van asignados por un nombre
    $tutor2=[
        "nombre"=>"Vanessa",
        "apellido"=>"Perez",
        "edad"=>30,
        "cursos"=>[
           "PHP",
           "CSS",
           "JAVA"
        ]
    ];
    $tutor2["pais"] ="Honduras";
    
    print_r($tutor2["nombre"]. "\n");
    print_r($tutor2["cursos"][0]. "\n");
    print_r($tutor2["pais"]. "\n");

        // echo $tutor2["cursos"][1];

    print_r(count($tutor). "\n"); // Veo la cantidad de elementos que tiene un array
    echo "Cantidad de elementos en \$tutor2: " . count($tutor2, COUNT_RECURSIVE) . "\n";

?>