<#include "Includes/Header.ftl">

<div style="padding-top:8%" class="col-md-4 col-md-offset-4">
    <legend>Los Números Ganadores Son:</legend>
    <div class="col-md-4">
        <br>
        <label>1er. Numero</label>
        <div id="numeros">
            <ul class="loto-balls ">
                <li class="loto-ball"><span>${ganadores[0]}</span></li>
                <br>
            </ul>
        </div>
    </div>
    <div class="col-md-4">
        <label>2do. Numero</label>
        <div id="numeros">
            <ul class="loto-balls ">
                <li class="loto-ball"><span>${ganadores[1]}</span></li>
                <br>
            </ul>
        </div>
    </div>
    <div class="col-md-4">
        <br>
        <label>3er. Numero</label>
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
        <label>1er. Numero</label>
        <div id="numeros">
            <ul class="loto-balls ">
                <li class="loto-ball"><span>${jugados[0]}</span></li>
                <br>
            </ul>
        </div>
    </div>
    <div class="col-md-4">
        <label>2do. Numero</label>
        <div id="numeros">
            <ul class="loto-balls ">
                <li class="loto-ball"><span>${jugados[1]}</span></li>
                <br>
            </ul>
        </div>

    <#if ganador>
        <div class="row">
            <p><strong>¡Felicidades, Usted ha ganado!</strong></p>
            <button type="button" onclick="location.href = '/CompartirGanador';" class="btn" data-toggle="modal" data-target="#myModal" style="margin: 0 auto; margin-top: 25px;background: #088DA5; color: white">
                Compatir con los demás
            </button>
        </div>
    </#if>
    </div>
    <div class="col-md-4">
        <br>
        <label>3er. Numero</label>
        <div id="numeros">
            <ul class="loto-balls ">
                <li class="loto-ball"><span>${jugados[2]}</span></li>
                <br>
            </ul>
        </div>

    </div>

</div>


<script type="text/javascript">
    $(document).ready(function() {
        $("#MyModal").modal();
    });
</script>
<#include "Includes/Footer.ftl">