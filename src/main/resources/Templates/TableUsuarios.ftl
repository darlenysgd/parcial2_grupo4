<#if existe>
    <#list usuarios as usuario>
    <tr>

        <td>${usuario.nombre}</td>
        <td>${usuario.usuario}</td>
        <#if usuario.adminsitrador>
            <td>Administrador</td>

        <#else>
            <td>Regular</td>
        </#if>
        <td>
            <button  class="btn btn-icon" data-toggle="modal" data-target="#ModalEliminar">Eliminar</button>
        </td>
    </tr>
    </#list>
</#if>