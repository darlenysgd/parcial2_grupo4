<#include "Includes/Header.ftl">

<div style="padding-top: 8%" class="container">
    <form class="form-horizontal" role="form" action="/transferirDinero" method="post">
        <fieldset>
            <legend>Transferir</legend>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="card-holder-name">Monto</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" name="monto" id="monto" placeholder="Monto A Transferir">
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


<#include "Includes/Footer.ftl">