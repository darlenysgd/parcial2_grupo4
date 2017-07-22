<#include "Includes/Header.ftl">

<div style="margin-top: 100px">
<#list ganadores as ganador>

    <div class="row" >

        <h3 style="margin-left: 20px">Usuario Ganador: ${ganador.usuario.usuario}</h3>

        <img class="col-md-2" width="250px" height="100px" src=${ganador.getRutaImagen()}>

        <p class="col-md-10">${ganador.mensaje}</p>

    </div>
    <hr>
</div>


</#list>

<div id="pagg"></div>

<#if mas>
<button onclick="paginar1()" type="submit" class="btn btn-primary">Siguiente</button>
</#if>

<button onclick="paginar2()" class="btn btn-primary" type="submit" >Anterior</button>

<div id="VerArticulos">


</div>

    <script>
        function paginar1(){

            $.get("/HomeNext", function (data) {
                $("#VerArticulos").html(data)

            })
        }

        function paginar2() {

            $.get("/HomeBack", function (data) {
                $("#VerArticulos").html(data)

            })

        }
    </script>
<#include "Includes/Footer.ftl">