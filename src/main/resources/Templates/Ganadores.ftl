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

<#include "Includes/Footer.ftl">