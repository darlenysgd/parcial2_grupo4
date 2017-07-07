<#include "Includes/Header.ftl">

<div>
    <div style="padding-top:8%" class="col-md-10 col-md-offset-2">
        <legend>Los Números Ganadores Son:</legend>
            <div class="col-md-2">
                <br>
                <label>Primer Numero</label>
                         <br>
                <div style="padding-top: 10%" id="numeros">
                    <ul class="loto-ballgk">
                        <li class="loto-ball-g"><span>${ganadores[0]}</span></li>
                        <br>
                    </ul>
                </div>
            </div>
            <div class="col-md-2">
                <br>
                <label>Segundo Numero</label>

                <div style="padding-top: 10%" id="numeros">
                    <ul class="loto-ballgk">
                        <li class="loto-ball-g"><span>${ganadores[1]}</span></li>
                        <br>
                    </ul>
                </div>
            </div>
            <div class="col-md-2">
                <br>
                <label>Tercer Numero</label>

                <div style="padding-top: 10%" id="numeros">
                    <ul class="loto-ballgk">
                        <li class="loto-ball-g"><span>${ganadores[2]}</span></li>
                        <br>
                    </ul>
                </div>
            </div>
            <div class="col-md-2">
                <br>
                <label>Cuarto Numero</label>

                <div style="padding-top: 10%" id="numeros">
                    <ul class="loto-ballgk">
                        <li class="loto-ball-g"><span>${ganadores[3]}</span></li>
                        <br>
                    </ul>
                </div>
            </div>
            <div class="col-md-2">
                <br>
                <label>Quinto Numero</label>

                <div style="padding-top: 10%" id="numeros">
                    <ul class="loto-ballgk">
                        <li class="loto-ball-g"><span>${ganadores[4]}</span></li>
                        <br>
                    </ul>
                </div>
            </div>


    </div>
    <div style="padding-top:8%" class="col-md-10 col-md-offset-2">
        <legend>Usted Jugó:</legend>
        <div class="col-md-2">
            <br>
            <label>Primer Numero</label>
            <br>
            <div style="padding-top: 10%" id="numeros">
                <ul class="loto-ballgk">
                    <li class="loto-ball-g"><span>${jugados[0]}</span></li>
                    <br>
                </ul>
            </div>
        </div>
        <div class="col-md-2">
            <br>
            <label>Segundo Numero</label>

            <div style="padding-top: 10%" id="numeros">
                <ul class="loto-ballgk">
                    <li class="loto-ball-g"><span>${jugados[1]}</span></li>
                    <br>
                </ul>
            </div>
        </div>
        <div class="col-md-2">
            <br>
            <label>Tercer Numero</label>

            <div style="padding-top: 10%" id="numeros">
                <ul class="loto-ballgk">
                    <li class="loto-ball-g"><span>${jugados[2]}</span></li>
                    <br>
                </ul>
            </div>


        <#if ganador>
            <div class="row">
                <h1>¡Felicidades, Usted ha ganado: !</h1>
                <button type="button" class="btn" data-toggle="modal" data-target="#myModal" style="margin: 0 auto; margin-top: 25px;background: #088DA5; color: white">
                    Usted es un Ganador!
                </button>
            </div>
        </#if>

        </div>
        <div class="col-md-2">
            <br>
            <label>Cuarto Numero</label>

            <div style="padding-top: 10%" id="numeros">
                <ul class="loto-ballgk">
                    <li class="loto-ball-g"><span>${jugados[3]}</span></li>
                    <br>
                </ul>
            </div>
        </div>
        <div class="col-md-2">
            <br>
            <label>Quinto Numero</label>

            <div style="padding-top: 10%" id="numeros">
                <ul class="loto-ballgk">
                    <li class="loto-ball-g"><span>${jugados[4]}</span></li>
                    <br>
                </ul>
            </div>
        </div>


    </div>
</div>

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

<script type="text/javascript">
    $(document).ready(function() {
        $("#MyModal").modal();
    });
</script>
<#include "Includes/Footer.ftl">