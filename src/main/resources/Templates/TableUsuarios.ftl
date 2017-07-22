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
            <#if usuario.adminsitrador>
                <button  class="btn btn-icon" data-toggle="modal" data-target="#ModalPermisos">Regular</button>
            <#else>
                <button  class="btn btn-icon" data-toggle="modal" data-target="#ModalPermisos">Administrador</button>
            </#if>


        </td>
        <td>
            <button  class="btn btn-icon" data-toggle="modal" data-target="#ModalEliminar">Eliminar</button>
        </td>
    </tr>
    </#list>
</#if>