<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Iniciar Sesion</title>

    <!-- Bootstrap -->
    <link href="/CSS/style.css" rel="stylesheet">


    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body id="login-bg">

<a href="/Inicio" class="home-login">Inicio</a>
<div class="col-md-4 col-md-offset-4 login-form">
    <h2 class="login-headers">Iniciar Sesion</h2>
    <form method='post' action='/LoginForm' style="padding-bottom:20px">
        <div class="form-group">
            <label class="login-headers">Usuario</label>
            <input type="text" name="usuario" class="form-control">
        </div>
        <div class="form-group">
            <label class="login-headers">Contraseña</label>
            <input type="password"  name="clave" class="form-control">
        </div>
        <div class="form-group">
            <input type="submit" id="btnSubmit" class="form-control" value="Iniciar Sesion">
        </div>
        <div class="form-group">
            <a href="/NuevoUsuario"><input type="Button" class="form-control" value="Registrarse"  ></a>
        </div>
    </form>
</div>
</body>
</html>