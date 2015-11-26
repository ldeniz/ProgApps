<%@page import="org.apache.tomcat.util.codec.binary.Base64"%>
<%@page import="java.util.Arrays"%>
<%@page import="proxy.DataRestaurante"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="proxy.DataCategoria"%>
<%@page import="controllers.Restaurantes"%>
<jsp:include page="/WEB-INF/template/header.jsp"/>
	
	<!-- ACA TERMINA EL HEADER -->
	<div style="clear:both;"></div>
	<div class="container bs-docs-container" sytle="margin-top: 60px; ">
	<div class="buscarRestaurante">
			<form class="navbar-form navbar-left" role="search">
			  <div class="form-group">
				<input name="cat" type="text" class="form-control inputRestaurante" placeholder="Ingrese Restaurante o Comida">
			  </div>
			  <button id="busqueda" type="submit" class="btn btn-default">Buscar</button>
			</form>
		</div>

	
		<div class="row">
			
			<div class="col-lg-4" >
				<div class="list-group" style="padding:5px;">
                                <a id="all" href="/home" class="list-group-item">Todas las Categorías</a>            
                                  <%
                                    String todos = request.getParameter("cat");
                                    
                                    //if(todos==null) todos="all";
                                    List<DataCategoria> categorias = Restaurantes.getCategorias(request).getItem();
                                    for(DataCategoria cat : categorias){
                                        %>        
                                        <a id="<%=cat.getNombre() %>" href="?cat=<%=cat.getNombre() %>" class="list-group-item"><%=cat.getNombre() %></a>
                                        <%
                                    }  
                                    %>
				  
                                    
                                    
				</div>
			</div>
			<div class="col-lg-8">
			<ul class="ulhorizontal">
                            
                                       
                                    <%
                                    List<DataRestaurante> restaurantes = Restaurantes.getRestaurantes(request,todos).getItem();                                    
                                    for(DataRestaurante res : restaurantes){
                                        if (res.getRutaImagen().size() > 0){
                                            String aca = res.getRutaImagen().get(0);
                                            byte[] imagen = Restaurantes.getImagen(request, aca);
                                        %>        
                                        <li>
                                            <img src=data:image/png;base64,<%=Base64.encodeBase64String(imagen)%>
                                   alt="..." class="imagenResto">
				  <div class="infoResto">
                                    <form action="restaurantes" method="POST">
					<div class="nombreResto"><%= res.getNombre()%></div>
					<div class="descripcionResto"><%= res.getNickname()%></p>
					<div class="direccionResto"><%= res.getDireccion().getCalle() + " " + res.getDireccion().getNumeroPuerta() + " " + res.getDireccion().getApto()%></div>
					<div class="categoriasResto">Categorias</div>
					<input style="visibility:hidden;" name="restaurante" value="<%= res.getNickname()%>">
					
					<p style="float:right;"><button type="submit" class="btn btn-primary" role="button">Ver Menú</button></p>
                                        </form>    
                                    </div>
				</li>
                                <% }} %>

			</ul>
			</div>
		</div>
	</div>
<script type="text/javascript">
    function getVarUrl( name ){
	var regexS = "[\\?&]"+name+"=([^&#]*)";
	var regex = new RegExp ( regexS );
	var tmpURL = window.location.href;
	var results = regex.exec( tmpURL );
	if( results == null )
		return"";
	else
		return results[1];
}

$(document).ready(function() {                        // When the HTML DOM is ready loading, then execute the following function...
    //
    var cat = getVarUrl( 'cat' );
    if(cat=="")$("#all").addClass("active");
    $("#"+cat).addClass("active");
    });    
    $(document).on("click", "#busqueda", function () {
        $(location).attr("href",$("#aBuscar").val());
    });
    
</script>
<jsp:include page="/WEB-INF/template/footer.jsp"/>
	