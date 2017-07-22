<#include "Includes/Header.ftl">
<div style="padding-top: 100px">
<table id="myTable" class="table table-striped" >
    <thead>
    <tr>
        <th>Usuario Origen</th>
        <th>Usuario Destino</th>
        <th>Monto</th>
        <th>Fecha</th>
    </tr>
    </thead>
    <tbody align="left">
    <#list transacciones as transaccion>
    <#if mostrar>
    <tr>
        <td>${transaccion.usuarioOrigen.usuario}</td>
        <td>${transaccion.usuarioDestino.usuario}</td>
        <td>${transaccion.montoTransferido}</td>
        <td>${transaccion.fecha}</td>
    </tr>

    </#if>
    </#list>
      </tbody>
</table>
</div>
<script type="text/javascript">
    $(document).ready(function(){
        $('#myTable').dataTable();
    });
</script>
<#include "Includes/Footer.ftl">