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


    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB187dA62XKshgD-u7O2rfCyESlG1EzXYY&callback=initMap"
            type="text/javascript"></script>



    <!-- =======================================================
          Theme Name: Tempo
          Theme URL: https://bootstrapmade.com/tempo-free-onepage-bootstrap-theme/
          Author: BootstrapMade.com
          Author URL: https://bootstrapmade.com
      ======================================================= -->
</head>
<body onload="geoloc()">
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



<style>

    .imageupload {
        margin: 20px 0;
    }

    #mapdiv {
        margin: 0;
        padding: 0;
        width: 500px;
        height: 500px;
    }
    .panel{
        width: 700px;
        margin: 0 auto;
        margin-top: 100px;
    }
    #comentarioTextArea{
        margin: 15px;
        width: 670px;
        height: 70px;
    }
    .comentario{
        margin-left: 15px;
    }
    textarea {
        resize: none;
    }
</style>


<form action="/publicarGanador" method="post" enctype="multipart/form-data" onload="geoloc()">

    <div class="imageupload panel panel-default" >
        <div class="panel-heading clearfix">
            <h3 class="panel-title pull-left">Compartir partida ganada</h3>
            <div class="btn-group pull-right">
                <button type="button" class="btn btn-default active">Archivo</button>
                <button type="button" class="btn btn-default">URL</button>
            </div>
        </div>
        <div class="file-tab panel-body">
            <h4>Cargar Imagen:</h4>
            <label class="btn btn-default btn-file">
                <span>Buscar</span>
                <!-- The file is stored here. -->
                <input type="file" name="image-file" formenctype="multipart/form-data">
            </label>
            <button type="button" class="btn btn-default">Eliminar</button>
        </div>
        <div class="url-tab panel-body">
            <div class="input-group">
                <input type="text" class="form-control hasclear" placeholder="Image URL">
                <div class="input-group-btn">
                    <button type="button" class="btn btn-default">Cargar</button>
                </div>
            </div>
            <button type="button" class="btn btn-default">Eliminar</button>
            <!-- The URL is stored here. -->
            <input type="hidden" name="image-url">
        </div>

        <hr>

        <input hidden  type="text" id="lugar" name="lugar"/>


        <h4 class="comentario">Comentario:</h4>
        <textarea id="comentarioTextArea" name="comentario"></textarea>

        <p id = 'mapdiv'></p>

        <div class="panel-footer">
            <button class="button-default" type="submit">Guardar</button>
        </div>


    </div>

</form>


<img id="ItemPreview" src="" />



<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="/ImageUpload/dist/js/bootstrap-imageupload.js"></script>

<script>
    var $imageupload = $('.imageupload');
    $imageupload.imageupload();

    $('#imageupload-reset').on('click', function() {
        $imageupload.imageupload('reset');
        $(this).blur();
    });


   var watchId = null;
    function geoloc() {
        if (navigator.geolocation) {
            var optn = {
                enableHighAccuracy : true,
                timeout : Infinity,
                maximumAge : 0
            };
            watchId = navigator.geolocation.watchPosition(showPosition, showError, optn);
        } else {
            alert('Geolocation is not supported in your browser');
        }
    }

    function showPosition(position) {
        var googlePos = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);


        var latlng = String(position.coords.latitude)+","+String(position.coords.longitude);

        var url = "http://maps.googleapis.com/maps/api/geocode/json?latlng=" + latlng + "&sensor=false";
        $.getJSON(url, function (data) {

                    var adress = data.results[1].formatted_address;
                    document.getElementById("lugar").value = adress;
                }
        )

        var mapOptions = {
            zoom : 12,
            center : googlePos,
            mapTypeId : google.maps.MapTypeId.ROADMAP
        };
        var mapObj = document.getElementById('mapdiv');
        var googleMap = new google.maps.Map(mapObj, mapOptions);
        var markerOpt = {
            map : googleMap,
            position : googlePos,
            title : 'Hi , I am here',
            animation : google.maps.Animation.DROP
        };
        var googleMarker = new google.maps.Marker(markerOpt);
        var geocoder = new google.maps.Geocoder();
        geocoder.geocode({
            'latLng' : googlePos
        }, function(results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                if (results[1]) {
                    var popOpts = {
                        content : results[1].formatted_address,
                        position : googlePos
                    };
                    var popup = new google.maps.InfoWindow(popOpts);
                    google.maps.event.addListener(googleMarker, 'click', function() {
                        popup.open(googleMap);
                    });
                } else {
                    alert('No results found');
                }
            } else {
                alert('Geocoder failed due to: ' + status);
            }
        });
    }



    function showError(error) {
        var err = document.getElementById('mapdiv');
        switch(error.code) {
            case error.PERMISSION_DENIED:
                err.innerHTML = "User denied the request for Geolocation."
                break;
            case error.POSITION_UNAVAILABLE:
                err.innerHTML = "Location information is unavailable."
                break;
            case error.TIMEOUT:
                err.innerHTML = "The request to get user location timed out."
                break;
            case error.UNKNOWN_ERROR:
                err.innerHTML = "An unknown error occurred."
                break;
        }
    }














</script>

<#include "Includes/Footer.ftl">