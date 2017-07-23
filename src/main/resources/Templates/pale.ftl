<#include "Includes/Header.ftl">

<div style="padding-top:8%" class="col-md-4 col-md-offset-4">

    <form class="form-horizontal" role="form" action="/Pale" method="post" data-toggle="validator">


        <div class="form-group">
            <label class="col-md-4 control-label" for="card-holder-name">Monto</label>
            <div class="col-md-8">
                <input type="number" max="${balance}" min="1" class="form-control" name="monto" id="monto" placeholder="Monto A Apostar">
            </div>
        </div>

           <div class="col-md-4">
               <br>
               <label>1er. Numero</label>
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
               <div id="numeros">
                   <ul class="loto-balls ">
                       <li class="loto-ball"><span id="primeraBola"></span></li>
                       <br>
                   </ul>
               </div>
        </div>
        <div class="col-md-4">
            <label>2do. Numero</label>
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
            <div id="numeros">
                <ul class="loto-balls ">
                    <li class="loto-ball"><span id="segundaBola"></span></li>
                    <br>
                </ul>
            </div>
        </div>
        <div class="col-md-4">
            <br>
            <label>3er. Numero</label>
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
            <div id="numeros">
                <ul class="loto-balls ">
                    <li class="loto-ball"><span id="terceraBola"></span></li>
                    <br>
                </ul>
            </div>
        </div>
        <div style="padding-top: 50%" class="form-group">
               <div class="col-sm-offset-4 col-sm-4">
                <input type="submit" class="btn btn-success" style="background: #088DA5; color: white" value="Realizar Apuesta"/>
            </div>
        </div>
        <div class="form-group">
            <div class="checkbox">
            <label><input type="checkbox" name="ganar" value="0">Ganar</label>
        </div>
        </div>

    </form>

</div>



    <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.js"></script>
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

</script>

<#include "Includes/Footer.ftl">