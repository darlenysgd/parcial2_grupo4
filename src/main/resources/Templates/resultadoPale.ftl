<#include "Includes/Header.ftl">

<div style="padding-top:8%" class="col-md-4 col-md-offset-4">
    <legend>Los Números Ganadores Son:</legend>
    <div class="col-md-4">
        <br>
        <label>Primer Numero</label>
        <div id="numeros">
            <ul class="loto-balls ">
                <li class="loto-ball"><span>${ganadores[0]}</span></li>
                <br>
            </ul>
        </div>
    </div>
    <div class="col-md-4">
        <label>Segundo Numero</label>
        <div id="numeros">
            <ul class="loto-balls ">
                <li class="loto-ball"><span>${ganadores[1]}</span></li>
                <br>
            </ul>
        </div>
    </div>
    <div class="col-md-4">
        <br>
        <label>Tercer Numero</label>
        <div id="numeros">
            <ul class="loto-balls ">
                <li class="loto-ball"><span>${ganadores[2]}</span></li>
                <br>
            </ul>
        </div>
    </div>

</div>

<div class="col-md-4 col-md-offset-4">
    <legend>Usted Jugó:</legend>
    <div class="col-md-4">
        <br>
        <label>Primer Numero</label>
        <div id="numeros">
            <ul class="loto-balls ">
                <li class="loto-ball"><span>${jugados[0]}</span></li>
                <br>
            </ul>
        </div>
    </div>
    <div class="col-md-4">
        <label>Segundo Numero</label>
        <div id="numeros">
            <ul class="loto-balls ">
                <li class="loto-ball"><span>${jugados[1]}</span></li>
                <br>
            </ul>
        </div>
    </div>
    <div class="col-md-4">
        <br>
        <label>Tercer Numero</label>
        <div id="numeros">
            <ul class="loto-balls ">
                <li class="loto-ball"><span>${jugados[2]}</span></li>
                <br>
            </ul>
        </div>
    </div>

</div>

<#if ganador>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
    Usted es un Ganador!
</button>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Usted Ha Ganado!</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Presione Siguiente Para Subir Una foto y mostrarlo junto a los demas ganadores!
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" href="/" class="btn btn-primary">Siguiente</button>
            </div>
        </div>
    </div>
</div>
</#if>

<script type="text/javascript">
    $(document).ready(function() {
        $("#MyModal").modal();
    });
</script>
<#include "Includes/Footer.ftl">