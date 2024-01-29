<?php

use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', 
function () {
    return view('welcome');
});

Route::get('/ruta1', 
function () {
    return "hola mundo";
});

Route::get('/areaRectangulo', 
function () {
    $base = 4;
    $altura = 10;
    $area = $base * $altura;

    return $area;
});

Route::get('/areaRectangulo2', 
function () {
    $base = 4;
    $altura = 10;
    $area = $base * $altura;

    return "El area del rectangulo es: $area con base $base y altura $altura";
});

Route::get('/areaRectangulo3/{base}/{altura}', 
function ($base, $altura) {
    $area = $base * $altura;

    return "El area del rectangulo es: $area con base $base y altura $altura";
});

Route::get('/nomina/{diasT}/{pagoDiario?}', 
function ($diasT, $pagoDiario=null) {

    if($pagoDiario ==null){
        $pagoDiario = 100;
        $nomina = $diasT * $pagoDiario;
    }else{
        $nomina = $diasT * $pagoDiario;
    }

    echo "Dias trabajados $diasT";
    echo "<br> Pago Nomina". $pagoDiario;
    echo"\n Total Pago $nomina";
});

Route::get('/nomina/{diasT}/{pagoDiario?}', 
function ($diasT, $pagoDiario=null) { //si los parametros no son obligatorios se inicializan e
    //en la funcion

    if($pagoDiario == null){
        $pagoDiario = 100;
        $nomina = $diasT * $pagoDiario;
    }else{
        $nomina = $diasT * $pagoDiario;
    }

    echo "Dias trabajados $diasT";
    echo "<br> Pago Nomina ". $pagoDiario;
    echo "<br> Total Pago $nomina";
});

Route::get('/redireccionamiento', //Me manda a otra pagina 
function () {
    return redirect("ruta1");
});

Route::redirect('redireccionamiento2','ruta1');

Route::redirect('redireccionamiento3','areaRectangulo3/4/7');

Route::get('/redireccionamiento4/{base}/{altura}', 
function ($base,$altura) {
    return redirect("/areaRectangulo3/$base/$altura");
});

Route::redirect('redireccionamiento5','http://www.google.es');
