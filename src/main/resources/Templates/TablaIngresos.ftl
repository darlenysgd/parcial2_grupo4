<#include "Includes/Header.ftl">
<div style="padding-top: 100px">
    <table id="myTable" class="table table-striped" >
        <thead>
        <tr>
            <th>Monto Agregado</th>
            <th>Fecha</th>
        </tr>
        </thead>
        <tbody align="left">
        <#list fondos as fondo>
            <#if mostrar>
            <tr>
                <td>${fondo.monto}</td>
                <td>${fondo.fecha}</td>
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