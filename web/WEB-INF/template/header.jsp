<%@page import="datatype.DataUsuario"%>
<%@page import="controllers.Login"%>
<%@page import="datatype.DataCliente"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.1 Strict//EN" "http://www.w3.org/TR/xhtml1/Dtd/xhtml1-strict.dtd">
<html xml:lang="es" xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
	
    <link rel="icon" href="favicon.ico">

    <title>Quick Order WEB</title>

    <!-- Bootstrap core CSS -->
    <link href="media/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="media/css/miestilo.css" rel="stylesheet">
    <link href="media/css/star-rating.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="media/js/ie-emulation-modes-warning.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="media/js/star-rating.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body style="background-color:#f6f6f6;">

    <div class="navbar navbar-inverse navbar-fixed-top" style="position:relative;">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/home">QuickOrder</a>
          <a class="navbar-brand" href="/cargarDatos">Cargar</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            
          <ul class="nav navbar-nav" style="float:right">
              <%
		DataUsuario usr;
		try {
			usr = Login.getUsuarioLogueado(request);
		} catch(Exception ex){
			usr = null;
		}
		
		if(usr != null) {
               %>
            <li class="active"><a data-toggle="tooltip" data-placement="bottom" title="Ver Información" href="/usuario" style="cursor:pointer;"><span style="margin-right:5px;" class="glyphicon glyphicon-user" aria-hidden="true"></span><%= usr.getNickname() %></a></li>
            <li><a href="logout">Cerrar Sesion</a></li>
            
            <% }else{ %>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".login">Login</button>
            <span style="color:white" type="button" class="btn" data-toggle="modal" data-target=".registro">Registrarme</span>
            </ul>
            
            
            
            
            
            <% } %>
          
		  
        </div><!--/.nav-collapse -->
		
		<div class="buscarRestaurante">
			<form class="navbar-form navbar-left" role="search">
			  <div class="form-group">
				<input type="text" class="form-control inputRestaurante" placeholder="Ingrese Restaurante o Comida">
			  </div>
			  <button type="submit" class="btn btn-default">Buscar</button>
			</form>
		</div>
		
      </div style="clear:both"></div>
	</div>
            <div class="modal fade login" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
              <div class="modal-dialog modal-sm">
                <div class="modal-content" style="padding:10px">
                  <h4 class="modal-title" id="gridSystemModalLabel">Inicio de Sesión</h4>    
                  <form class="form-signin" action="Login" method="POST">
                    <h2 class="form-signin-heading reliceInicio">Realice inicio de Sesión</h2>
                    <label for="inputEmail" class="sr-only">Nickname</label>
                    <input name="login" type="user" id="inputUser" class="form-control" placeholder="Tu Nickname" required="" autofocus="">
                    <label for="inputPassword" class="sr-only">Password</label>
                    <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
                    <button class="btn btn-lg btn-primary btn-block" type="submit">A pedir!</button>
                  </form>
                </div>
              </div>
            </div>
        
            <div class="modal fade registro" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
              <div class="modal-dialog modal-lg">
                <div class="modal-content" style="padding:10px">
                  <h4 class="modal-title" id="gridSystemModalLabel">Registro de Cliente</h4>    
                  <form class="form-signin" action="Login" method="POST">
                        <div class="row">
                            <div class="col-xs-12 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="text" name="nombre" id="first_name" class="form-control input-lg" placeholder="Nombre" tabindex="1">
                                    </div>
                            </div>
                            <div class="col-xs-12 col-sm-6 col-md-6">
                                    <div class="form-group">
                                            <input type="text" name="apellido" id="last_name" class="form-control input-lg" placeholder="Apellido" tabindex="2">
                                    </div>
                            </div>
			</div>
			<div class="form-group">
				<input type="text" name="nickname" id="display_name" class="form-control input-lg" placeholder="Nickname" tabindex="3">
			</div>
			<div class="form-group">
				<input type="email" name="email" id="email" class="form-control input-lg" placeholder="Email" tabindex="4">
			</div>
			<div class="row">
                            <div class="col-xs-12 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password" tabindex="5">
                                </div>
                            </div>
                            <div class="col-xs-12 col-sm-6 col-md-6">
                                    <div class="form-group">
                                            <input type="password" name="password_confirmation" id="password_confirmation" class="form-control input-lg" placeholder="Re-Password" tabindex="6">
                                    </div>
                            </div>
			</div>
			<hr class="colorgraph">
			<div class="row">
                            <div class="col-xs-12 col-md-6"  style="float:right;"><input type="submit" value="Registrarme" class="btn btn-primary btn-block btn-lg" tabindex="7"></div>	
			</div>
                  </form>
                </div>
              </div>
            </div>
<script type="text/javascript">      
    $(function () {
      $('[data-toggle="tooltip"]').tooltip()
    })
</script>