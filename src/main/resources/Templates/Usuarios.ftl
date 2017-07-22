<#include "Includes/Header.ftl">

<div class="panel panelUsuarios">
    <div class="panel-heading panel-lottery">Usuarios</div>
    <div class="panel-body">
        <table id="demo-dt-basic" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>Nombre</th>
        <th>Usuario</th>
        <th>Permimsos</th>
        <th>Cambio Permisos</th>
        <th>Eliminar</th>
    </tr>
    </thead>
    <tbody class="tablaUsuarios">

        <#if first>

            <#list usuarios as usuario>
            <tr>
                <td>${usuario.nombre}</td>
                <td>${usuario.usuario}</td>
                <#assign usr = usuario.usuario>
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

    </tbody>
</table>
    </div>
</div>

<div class="modal fade" id="ModalEliminar" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header alert-danger">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Eliminar Usuario</h4>
            </div>
            <div class="modal-body">
                <p>¿Está seguro que desea eliminar este usuario?</p>
            </div>
            <div class="modal-footer">
                <button type="button" onclick="actualizarTabla('${usr}')" class="btn btn-default" data-dismiss="modal">Si</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="ModalPermisos" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header alert-danger">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Cambios de permisos de usuario</h4>
            </div>
            <div class="modal-body">
                <p>¿Está seguro que desea cambiar el permiso de este usuario?</p>
            </div>
            <div class="modal-footer">
                <button type="button" onclick="permisos('${usr}')" class="btn btn-default" data-dismiss="modal">Si</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
            </div>
        </div>
    </div>
</div>


<script>
    function actualizarTabla(usuario){

    $.get("/EliminarUsuario/"+usuario, function (data) {
        $(".tablaUsuarios").html(data)

    })
    }

    function permisos(usuario) {
        $.get("/CambiarPermisos/"+usuario, function (data) {
            $(".tablaUsuarios").html(data)

        })
    }



    $('#demo-dt-basic').dataTable({
        "sInfo" : false
    });
</script>
<#include "Includes/Footer.ftl">