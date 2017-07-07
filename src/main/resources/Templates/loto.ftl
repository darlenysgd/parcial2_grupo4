<#include "Includes/Header.ftl">

<div style="padding-top:8%" class="col-md-10 col-md-offset-2">

    <form class="form-horizontal" role="form" method="post" action="Loto" data-toggle="validator">

        <div class="col-md-2">
            <br>
            <label>Primer Numero</label>
            <select class="form-control selectpicker" name="primerNumero" id="primerNumero" required>
                <option value="">Primero</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
            </select>
            <br>
            <div style="padding-top: 10%" id="numeros">
                <ul class="loto-ballgk">
                    <li class="loto-ball-g"><span id="primeraBola"></span></li>
                    <br>
                </ul>
            </div>
        </div>
        <div class="col-md-2">
            <br>
            <label>Segundo Numero</label>
            <select class="form-control selectpicker" name="segundoNumero" id="segundoNumero" required>
                <option value="">Segundo</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
            </select>
            <div style="padding-top: 10%" id="numeros">
                <ul class="loto-ballgk">
                    <li class="loto-ball-g"><span id="segundaBola"></span></li>
                    <br>
                </ul>
            </div>

        </div>
        <div class="col-md-2">
            <br>
            <label>Tercer Numero</label>
            <select class="form-control selectpicker" name="tercerNumero" id="tercerNumero" required>
                <option value="">Tercero</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
            </select>
            <div style="padding-top: 10%" id="numeros">
                <ul class="loto-ballgk">
                    <li class="loto-ball-g"><span id="terceraBola"></span></li>
                    <br>
                </ul>
            </div>

        </div>
        <div class="col-md-2">
            <br>
            <label>Cuarto Numero</label>
            <select class="form-control selectpicker" name="cuartoNumero" id="cuartoNumero" required>
                <option value="">Cuarto</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
            </select>
            <div style="padding-top: 10%" id="numeros">
                <ul class="loto-ballgk">
                    <li class="loto-ball-g"><span id="cuartaBola"></span></li>
                    <br>
                </ul>
            </div>
        </div>
        <div class="col-md-2">
            <br>
            <label>Quinto Numero</label>
            <select class="form-control selectpicker" name="quintoNumero" id="quintoNumero" required>
                <option value="">Quinto</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
            </select>
            <div style="padding-top: 10%" id="numeros">
                <ul class="loto-ballgk">
                    <li class="loto-ball-g"><span id="quintaBola"></span></li>
                    <br>
                </ul>
            </div>
        </div>
        <div style="padding-top: 15%" class="form-group">
            <div class="col-sm-offset-4 col-sm-4">
                <input type="submit" class="btn btn-success" value="Realizar Apuesta"></input>
            </div>
        </div>

    </form>


</div>

<div class="col-md-4 col-md-offset-4">
<form method="get" action="/ganarLoto">
    <div class="form-group">
        <input type="submit" value="Ganar Ahora" class="form-control">
    </div>
</form>
</div>
<br>

<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js"></script>


<script type="text/javascript">
    $('#primerNumero').change(function(event) {
        $('#primeraBola').html($('#primerNumero').val());
    });

    $('#segundoNumero').change(function(event) {
        $('#segundaBola').html($('#segundoNumero').val());
    });

    $('#tercerNumero').change(function(event) {
        $('#terceraBola').html($('#tercerNumero').val());
    });

    $('#cuartoNumero').change(function(event) {
        $('#cuartaBola').html($('#cuartoNumero').val());
    });

    $('#quintoNumero').change(function(event) {
        $('#quintaBola').html($('#quintoNumero').val());
    });
</script>

<#include "Includes/Footer.ftl">