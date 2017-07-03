<#include "Includes/Header.ftl">

<br>
<div class="panel">
    <div class="panel-heading  panel-lottery">Registro de Usuarios</div>
    <div class="panel-body">
        <form action="/CrearUsuario" method="post" id="form">
            <div class="form-group">
                <label>Nombre Completo:</label>
                <input type="text" id="field" class="form-control" name="nombre"/>
            </div>
            <div class="form-group">

                <label>Nombre de usuario:</label>
                <input type="text" id="username" class="form-control" name="usuario"/>
            </div>
            <div class="form-group">
                <label>Constraseña:</label>
                <input type="password" id="pass" class="form-control" name="clave"/>
            </div>
            <div class="form-group">
                <label>Fecha de Nacimiento:</label>
                <input type="date" id="date" class="form-control" name="fechanac"/>
            </div>
            <div class="form-group">
                <label>Cedula:</label>
                <input type="text" id="cedula" class="form-control" name="cedula"/>
            </div>

            <div class="form-group">
                <input type="submit" id="btnSubmit" class="form-control" onclick="myFunction()" value="Crear">
            </div>


        </form>

    </div>
</div>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>

<script type="text/javascript">
    // just for the demos, avoids form submit
    jQuery.validator.setDefaults({
        debug: true,
        success: "valid"
    });
    $( "#form" ).validate({
        rules: {
            nombre: {
                required: true
            }
            usuario: {
                required: true
            }
            clave: {
                required: true
            }
            fecha: {
                required: true,
                date: true
            }
            cedula: {
                required: true,
            }
        }
    });
</script>

<#include "Includes/Footer.ftl">