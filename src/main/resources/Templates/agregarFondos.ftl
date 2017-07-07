<#include "Includes/Header.ftl">
<div style="padding-top: 8%" class="container">
    <form class="form-horizontal"  action="/agregarFondos" method="post" data-toggle="validator">
        <fieldset>
            <legend>Cargar Fondos</legend>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="card-holder-name">Monto</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" name="monto" id="monto" placeholder="Monto A Cargar" data-error="Por Favor, Inserte el Monto A Cargar" required>
                </div>
                <div class="help-block with-errors"></div>
            </div>


            <div class="form-group ">

                <div id="myRadioGroup">



                    <label style="margin-left: 200px;">Tarjeta Existente  </label>
                    <input type="radio" name="entradaT" checked="checked" value="3"  />

                    <label>Nueva Tarjeta  </label>
                    <input type="radio" name="entradaT" value="2" />

                    <br>
                    <br>

                    <div id="T3" class="desc" >
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="expiry-month">Tarjeta</label>
                            <div class="row">
                                <div class="col-xs-3">
                                    <select class="form-control col-sm-2 " name="tarjeta" id="tarjeta">
                                        <#list tarjetas as tarjeta>
                                            <option value="${tarjeta_index}">${tarjeta.numero}</option>
                                        </#list>
                                    </select>
                                </div>

                            </div>
                        </div>
                    </div>

                    <div id="T2" class="desc" style="display: none;">
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="card-number">Numero de Tarjeta</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" name="card-number" id="card-number" placeholder="Numero de Tarjeta de Debito/Credito" data-minlength="16" data-error="Por Favor, Inserte su Numero de Tarjeta" required>
                            </div>
                            <div class="help-block with-errors"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="expiry-month">Fecha de Expiracion</label>
                            <div class="row">
                                <div class="col-xs-3">
                                    <select class="form-control col-sm-2 " name="expiry-month" id="expiry-month">
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
                                    <select class="form-control" name="expiry-year">
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
                        <div class="form-group">
                            <label class="col-sm-3 control-label" data-minlength="3" for="cvv">CVC</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" name="cvc" id="cvc" placeholder="Codigo de Seguridad">
                            </div>
                        </div>
                    </div>

                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-9">
                    <input type="submit" class="btn" style="background: #088DA5; color: white" data-toggle="modal" data-target="#confirmacion" value="Completar">
                </div>
            </div>
        </fieldset>
    </form>
</div>


<div class="modal fade" id="confirmacion" role="dialog">
    <div class="modal-dialog modal-lg">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header " style="background: #088DA5; color: white">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Confirmación</h4>
            </div>
            <div class="modal-body">
                <p>¡Ha añadido fondos correctamente!</p>
            </div>
            <div class="modal-footer">
                <button class="btn" style="background: #088DA5; color: white">OK</button>
            </div>
        </div>
    </div>
</div>


<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.js"></script>

<script type="text/javascript">
    $(document).ready(function ($) {
        $('#card-number').mask("9999-9999-9999-9999", {placeholder: ""});
        $('#cvc').mask("999", {placeholder: ""});

    });

    $(document).ready(function() {
        $("input[name$='entradaT']").click(function() {
            var test = $(this).val();

            $("div.desc").hide();
            $("#T" + test).show();
        });
    });
</script>

<#include "Includes/Footer.ftl">