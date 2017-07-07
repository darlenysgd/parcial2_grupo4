<#include "Includes/Header.ftl">

<style>
    .imageupload {
        margin: 20px 0;
    }

    .panel{
        width: 700px;
        margin: 0 auto;
        margin-top: 100px;
    }
    #comentarioTextArea{
        margin: 15px;
        width: 670px;
        height: 70px;
    }
    .comentario{
        margin-left: 15px;
    }
    textarea {
        resize: none;
    }
</style>


<form action="/Imagen" method="post" enctype="multipart/form-data">

    <div class="imageupload panel panel-default">
        <div class="panel-heading clearfix">
            <h3 class="panel-title pull-left">Compartir partida ganada</h3>
            <div class="btn-group pull-right">
                <button type="button" class="btn btn-default active">Archivo</button>
                <button type="button" class="btn btn-default">URL</button>
            </div>
        </div>
        <div class="file-tab panel-body">
            <h4>Cargar Imagen:</h4>
            <label class="btn btn-default btn-file">
                <span>Buscar</span>
                <!-- The file is stored here. -->
                <input type="file" name="image-file" formenctype="multipart/form-data">
            </label>
            <button type="button" class="btn btn-default">Eliminar</button>
        </div>
        <div class="url-tab panel-body">
            <div class="input-group">
                <input type="text" class="form-control hasclear" placeholder="Image URL">
                <div class="input-group-btn">
                    <button type="button" class="btn btn-default">Cargar</button>
                </div>
            </div>
            <button type="button" class="btn btn-default">Eliminar</button>
            <!-- The URL is stored here. -->
            <input type="hidden" name="image-url">
        </div>

        <hr>

        <h4 class="comentario">Comentario:</h4>
        <textarea id="comentarioTextArea"></textarea>

        <div class="panel-footer">
            <button type="submit" class="button-default">Guardar</button>
        </div>
    </div>


</form>


<img id="ItemPreview" src="" />



<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="/ImageUpload/dist/js/bootstrap-imageupload.js"></script>

<script>
    var $imageupload = $('.imageupload');
    $imageupload.imageupload();

    $('#imageupload-reset').on('click', function() {
        $imageupload.imageupload('reset');
        $(this).blur();
    });



</script>

<#include "Includes/Footer.ftl">