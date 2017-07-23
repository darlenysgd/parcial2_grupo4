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
                <p><strong>¡Felicidades, Usted ha ganado!</strong></p>
                <button type="button" onclick="location.href = '/CompartirGanador';" class="btn" data-toggle="modal" data-target="#myModal" style="margin: 0 auto; margin-top: 25px;background: #088DA5; color: white">
                    Compatir con los demás
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


<script type="text/javascript">
    $(document).ready(function() {
        $("#MyModal").modal();
    });
</script>
<#include "Includes/Footer.ftl">