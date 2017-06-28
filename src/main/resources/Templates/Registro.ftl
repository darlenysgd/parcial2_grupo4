<#include "Includes/Header.ftl">

<div class="panel">
    <div class="panel-heading  panel-lottery">Registro de Usuarios</div>
    <div class="panel-body">
        <form>
            <div class="form-group">
                <label>Nombre Completo:</label>
                <input type="text" class="form-control" name="nombre"/>
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
                <input type="submit" id="btnSubmit" class="form-control" value="Crear">
            </div>


        </form>
    </div>
</div>

<#include "Includes/Footer.ftl">