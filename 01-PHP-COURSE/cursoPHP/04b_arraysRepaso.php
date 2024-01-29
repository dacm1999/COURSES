<?php

    $estudiantes=[
        [
            "nombre" => "Daniel",
            "apellido" => "Contreras",
            "calificaciones" =>[80,90,75,85]
        ],
        [
            "nombre" => "Luis",
            "apellido" => "Gomez",
            "calificaciones" =>[85,85,100,15]
        ],
        [
            "nombre" => "Nicole",
            "apellido" => "Rojas",
            "calificaciones" => [70,100,100,75]
        ]
    ];

// Función para calcular el promedio de un estudiante
function calcularPromedio($calificaciones){
    $total = array_sum($calificaciones);
    $cantidadAsignaturas = count($calificaciones);
    return $total / $cantidadAsignaturas;
}
// Calcular y mostrar el promedio de cada estudiante
foreach ($estudiantes as $estudiante) {
    $promedio = calcularPromedio($estudiante["calificaciones"]);
    echo "Estudiante: {$estudiante['nombre']} {$estudiante['apellido']} - Promedio: $promedio\n";
}

?>