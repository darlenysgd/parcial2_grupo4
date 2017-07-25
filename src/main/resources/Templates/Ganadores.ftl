<!DOCTYPE html>
<html lang="en" class=" js no-touch">
<head>
    <title>Loteria</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300,600|Raleway:600,300|Josefin+Slab:400,700,600italic,600,400italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="/css/slick-team-slider.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link href="/ImageUpload/dist/css/bootstrap-imageupload.css" rel="stylesheet">
    <!-- Latest compiled and minified JavaScript -->
    <script href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/js/bootstrap-select.min.js"></script>
    <script href="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
    <script type="text/javascript" href="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>

    <link href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <!-- <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">-->
    <link href="/datatables/css/dataTables.bootstrap.css" rel="stylesheet">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css">


    <!-- =======================================================
          Theme Name: Tempo
          Theme URL: https://bootstrapmade.com/tempo-free-onepage-bootstrap-theme/
          Author: BootstrapMade.com
          Author URL: https://bootstrapmade.com
      ======================================================= -->
</head>
<body >
<!--HEADER START-->
<div class="main-navigation navbar-fixed-top">
    <nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/Inicio">Loteria</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="/Inicio">Inicio</a></li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown">Juegos
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-text" href="/Pale">Palé</a></li>
                            <li><a class="dropdown-text" href="/Loto">Loto</a></li>
                        </ul>
                    </li>
                <#if loggeado>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown">Fondos
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-text" href="/AgregarFondos">Agregar</a></li>
                            <li><a class="dropdown-text" href="/transferirFondos">Transferir</a></li>
                            <li><a class="dropdown-text" href="/Transacciones">Transacciones 3ros.</a></li>
                            <li><a class="dropdown-text" href="/HistorialIngresos">Ingresos</a></li>
                        </ul>
                    </li>
                </#if>
                <#if !loggeado>
                    <li><a href="/NuevoUsuario">Registro</a></li>
                </#if>

                <#if loggeado>
                    <li><a href="/Usuarios">Usuarios</a> </li>
                    <li><a href="/Ganadores">Ganadores</a> </li>


                    <li><a href="/cerrarSesion">Cerrar Sesión</a></li>
                </#if>
                <#if !loggeado>
                    <li><a href="/InicioSesion">Iniciar Sesión</a></li>
                </#if>
                </ul>
            </div>
        </div>
    </nav>
</div>
<!--HEADER END-->



<div style="margin-top: 100px">
<#list ganadores as ganador>

<div class="row" >

    <h3 style="margin-left: 20px">Usuario Ganador: ${ganador.usuario.usuario}</h3>

    <img class="col-md-2" width="250px" height="100px" src=${ganador.getRutaImagen()}>

    <p>Mensaje:</p>
    <p class="col-md-10">${ganador.mensaje}</p>

    <p>Ubicacion</p>
    <p>${ganador.direccion}</p>


</div>
<hr>
</div>
</#list>


<#include "Includes/Footer.ftl">