<jsp:include page="/WEB-INF/template/header.jsp"/>
<div style="clear:both"></div>
	<div class="container bs-docs-container" sytle="margin-top: 60px; ">			
			<div class="col-lg-8">
			<div class="media">
			  <div class="media-left media-middle">
				<a href="#">
				  <img class="media-object" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIHZpZXdCb3g9IjAgMCA2NCA2NCIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+PCEtLQpTb3VyY2UgVVJMOiBob2xkZXIuanMvNjR4NjQKQ3JlYXRlZCB3aXRoIEhvbGRlci5qcyAyLjYuMC4KTGVhcm4gbW9yZSBhdCBodHRwOi8vaG9sZGVyanMuY29tCihjKSAyMDEyLTIwMTUgSXZhbiBNYWxvcGluc2t5IC0gaHR0cDovL2ltc2t5LmNvCi0tPjxkZWZzPjxzdHlsZSB0eXBlPSJ0ZXh0L2NzcyI+PCFbQ0RBVEFbI2hvbGRlcl8xNGZlNmE4MzA2NyB0ZXh0IHsgZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQgfSBdXT48L3N0eWxlPjwvZGVmcz48ZyBpZD0iaG9sZGVyXzE0ZmU2YTgzMDY3Ij48cmVjdCB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSIxNC41IiB5PSIzNi41Ij42NHg2NDwvdGV4dD48L2c+PC9nPjwvc3ZnPg==" alt="...">
				</a>
			  </div>
			  <div class="media-body">
				<h4 class="media-heading">Nombre del Restaurante</h4>
				Las estrellitas de los puntos
			  </div>
			</div>
			
			
			<ul class="nav nav-tabs nav-justified" style="margin-top:10px;">
                                <li id="menu" role="presentation" class="active"><a href="#">Menu</a></li>
				<li id="informacion" role="presentation"><a href="#">Informacion</a></li>
				<li id="comentarios" role="presentation"><a href="#">Comentarios</a></li>
			</ul>
			<div id="contenedorMenu" class="contenedorMenu" style="background-color:white; height:400px;width:100%;">
                            <div id="contenido"></div>    
			</div>
			

			
			</div>
			<div class="col-lg-4" >
                            ACA EL PEDIDO
				<jsp:include page="pedido.jsp"/>
			</div>
	</div>

<jsp:include page="/WEB-INF/template/footer.jsp"/>
<script type="text/javascript">

$(document).ready(function() {
	$(contenedorMenu).hide(); //Ocultar capas
	$("ul.nav-tabs li:first").addClass("active").show(); //Activar primera pestaña
	$(".contenedorMenu:first").show(); //Mostrar contenido primera pestaña

	$(contenedorMenu).load("/menu");
	$(contenedorMenu).fadeIn();
	
	// Sucesos al hacer click en una pestaña
	$("ul.nav-tabs li").click(function() {
        
	$("ul.nav-tabs li").removeClass("active"); //Borrar todas las clases "active"
	$(this).addClass("active"); //Añadir clase "active" a la pestaña seleccionada
	//$(".contenedorMenu").hide(); //Ocultar todo el contenido de la pestaña
	$(contenedorMenu).empty();
	var activatab = "/"+$(this).attr('id'); //Leer el valor de href para identificar la pestaña active 
	$(contenedorMenu).load(activatab);
	$(contenedorMenu).fadeIn(); //Visibilidad con efecto fade del contenido activo
	return false;
	});
});

</script>

	