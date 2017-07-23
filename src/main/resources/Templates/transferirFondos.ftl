<#include "Includes/Header.ftl">

<div style="padding-top: 8%" class="container">
    <form class="form-horizontal" role="form" action="/transferirDinero" method="post" data-toggle="validator">
        <fieldset>
            <legend>Transferir</legend>

            <div class="form-group">
                <label class="col-sm-3 control-label" for="card-holder-name">Monto Actual</label>
                <div class="col-sm-9">
                    <input value="${balance}">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label" for="card-holder-name">Monto a Transferir</label>
                <div class="col-sm-9">
                    <input type="number" max="${maxTransferencia}" min="1" class="form-control" name="monto" placeholder="Monto A Transferir">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label" for="card-holder-name">Usuario A Transferir</label>
                <div class="col-sm-9">
                    <select id="basic" class="selectpicker show-tick form-control" name="usuario" data-live-search="true">
                        <#list usuarios as usuario>
                            <#if Usrorigen.usuario != usuario.usuario>
                                <option value="${usuario.usuario}">${usuario.usuario}</option>
                            </#if>
                        </#list>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-9">
                    <button type="submit" class="btn" style="background: #088DA5; color: white" >Transferir</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.js"></script>

<#include "Includes/Footer.ftl">