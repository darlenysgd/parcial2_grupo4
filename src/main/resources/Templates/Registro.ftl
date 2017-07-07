<#include "Includes/Header.ftl">

<div class="panel panelRegistro">
<br>
<div class="panel">
    <div class="panel-heading  panel-lottery">Registro de Usuarios</div>
    <div class="panel-body">
        <form action="/CrearUsuario" method="post" id="form" data-toggle="validator">
            <div class="form-group">
                <label>Nombre Completo:</label>
                <input type="text" class="form-control" name="nombre" data-error="Por Favor, Inserte Su Nombre Completo" required />
                <div class="help-block with-errors"></div>
             </div>
            <div class="form-group">
                <label>Cedula:</label>
                <input type="text" id="cedula" minlength="11" class="form-control" name="cedula" data-error="Por Favor, Inserte Su Cedula" required/>
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <label>Nombre de usuario:</label>
                <input type="text" id="username" class="form-control" name="usuario" data-error="Por Favor, Inserte Su Nombre De Usuario" required/>
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <label>Constraseña:</label>
                <input type="password" id="pass" class="form-control" name="clave" data-error="Por Favor, Inserte Su Clave" required/>
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <label>Fecha de Nacimiento:</label>
                <input type="date" id="date" class="form-control" name="fechanac" data-error="Por Favor, Inserte Su Fecha de Nacimiento" required/>
                <div class="help-block with-errors"></div>
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.js"></script>

<script type="text/javascript">
    $(document).ready(function ($) {
        $('#cedula').mask("999-9999999-9", {placeholder: ""});

    });
</script>
<#include "Includes/Footer.ftl">