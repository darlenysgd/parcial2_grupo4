<#include "Includes/Header.ftl">

<div style="padding-top: 8%" class="container">
    <form class="form-horizontal" role="form">
        <fieldset>
            <legend>Transferir</legend>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="card-holder-name">Monto</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" name="card-holder-name" id="card-holder-name" placeholder="Monto A Transferir">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label" for="card-holder-name">Usuario A Transferir</label>
                <div class="col-sm-9">
                    <select class="form-control selectpicker " live name="monto" id="monto" data-live-search="true" >
                        <option value="1">ok</option>
                        <option value="1">ok</option>
                        <option value="1">ok</option>


                    </select>

                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-9">
                    <button type="button" class="btn btn-success">Aceptar</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>


<#include "Includes/Footer.ftl">