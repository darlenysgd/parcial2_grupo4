<#include "Includes/Header.ftl">

<div style="padding-top:8%" class="col-md-4 col-md-offset-4">

    <form class="form-horizontal" role="form" action="/Pale" method="post">
        <div class="form-group">
            <label class="col-md-4 control-label" for="card-holder-name">Monto</label>
            <div class="col-md-8">
                <input type="text" class="form-control" name="card-holder-name" id="card-holder-name" placeholder="Monto A Apostar">
            </div>
        </div>

           <div class="col-md-4">
               <br>
               <label>Primer Numero</label>
            <select class="form-control selectpicker" name="primerNumero" id="primerNumero" >
                <option>Primero</option>
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
            <label>Segundo Numero</label>
            <select class="form-control selectpicker" name="segundoNumero" id="segundoNumero" >
                <option>Segundo</option>
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
            <label>Tercer Numero</label>
            <select class="form-control selectpicker" name="tercerNumero" id="tercerNumero" >
                <option>Tercero</option>
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
                <input type="submit" class="btn btn-success" value="Realizar Apuesta"></input>
            </div>
        </div>

    </form>

</div>

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