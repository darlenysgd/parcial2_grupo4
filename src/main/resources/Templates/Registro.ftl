<#include "Includes/Header.ftl">

<div class="panel">
    <div class="panel-heading  panel-lottery">Registro de Usuarios</div>
    <div class="panel-body">
        <form action="/CrearUsuario" method="post">
            <div class="form-group">
                <label>Nombre Completo:</label>
                <input type="text" class="form-control" name="nombre"/>
            </div>
            <div class="form-group">
                <label>Cédula:</label>
                <input type="text" class="form-control" name="cedula"/>
            </div>
            <div class="form-group">
                <label>Fecha de nacimiento:</label>
                <input type="text" class="form-control" id="fechanac"/>
                <p id="demo"></p>
            </div>
            <div class="form-group">
                <label>Nombre de usuario:</label>
                <input type="text" class="form-control" name="usuario"/>
            </div>
            <div class="form-group">
                <label>Constraseña:</label>
                <input type="password" class="form-control" name="clave"/>
            </div>


            <div class="form-group">
                <input type="submit" id="btnSubmit" class="form-control" onclick="myFunction()" value="Crear">
            </div>


        </form>
    </div>
</div>

<#include "Includes/Footer.ftl">