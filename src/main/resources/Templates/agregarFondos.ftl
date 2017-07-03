<#include "Includes/Header.ftl">
<div style="padding-top: 8%" class="container">
    <form class="form-horizontal" role="form">
        <fieldset>
            <legend>Cargar Fondos</legend>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="card-holder-name">Monto</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" name="card-holder-name" id="card-holder-name" placeholder="Monto A Cargar">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="card-number">Numero de Tarjeta</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" name="card-number" id="card-number" placeholder="Numero de Tarjeta de Debito/Credito">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="expiry-month">Fecha de Expiracion</label>
                <div class="col-sm-9">
                    <div class="row">
                        <div class="col-xs-3">
                            <select class="form-control col-sm-2 selectpicker" name="expiry-month" id="expiry-month" >
                                <option>Mes</option>
                                <option value="01">Jan (01)</option>
                                <option value="02">Feb (02)</option>
                                <option value="03">Mar (03)</option>
                                <option value="04">Apr (04)</option>
                                <option value="05">May (05)</option>
                                <option value="06">June (06)</option>
                                <option value="07">July (07)</option>
                                <option value="08">Aug (08)</option>
                                <option value="09">Sep (09)</option>
                                <option value="10">Oct (10)</option>
                                <option value="11">Nov (11)</option>
                                <option value="12">Dec (12)</option>
                            </select>
                        </div>
                        <div class="col-xs-3">
                            <select class="form-control selectpicker" name="expiry-year">
                                <option value="17">2017</option>
                                <option value="18">2018</option>
                                <option value="19">2019</option>
                                <option value="20">2020</option>
                                <option value="21">2021</option>
                                <option value="22">2022</option>
                                <option value="23">2023</option>
                                <option value="24">2024</option>
                                <option value="25">2025</option>
                                <option value="26">2026</option>
                                <option value="27">2027</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="cvv">CVC</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="cvc" id="cvc" placeholder="Codigo de Seguridad">
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