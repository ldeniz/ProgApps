<%@page import="datatype.DataRestaurante"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="datatype.DataCategoria"%>
<%@page import="controllers.Restaurantes"%>
<jsp:include page="/WEB-INF/template/header.jsp"/>
	
	<!-- ACA TERMINA EL HEADER -->
	
	

	<div style="clear:both"></div>
	<div class="container bs-docs-container" sytle="margin-top: 60px; ">
		<div class="row">
			
			<div class="col-lg-4" >
				<div class="list-group" style="padding:5px;">
                                <a id="all" href="/home" class="list-group-item">Todas las Categorías</a>            
                                  <%
                                    String todos = request.getParameter("cat");
                                    
                                    //if(todos==null) todos="all";
                                    List<DataCategoria> categorias = Restaurantes.getCategorias(request);
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
                                    ArrayList<DataRestaurante> restaurantes = Restaurantes.getRestaurantes(request,todos);
                                    for(DataRestaurante res : restaurantes){
                                        %>        
                                        <li>
                                            <!--<%= res.getRutaImagen()%>-->
				  <img src="http://www.reservarestaurantes.com/media/cache/th_680_420/bundles/rrweb/images/restaurant-default-image.jpg" alt="..." class="imagenResto">
				  <div class="infoResto">
                                    <form action="restaurantes" method="POST">
					<div class="nombreResto"><%= res.getNombre()%></div>
					<div class="descripcionResto"><%= res.getNickname()%></p>
					<div class="direccionResto"><%= res.getDireccion()%></div>
					<div class="categoriasResto">Categorias</div>
					<input style="visibility:hidden;" name="restaurante" value="<%= res.getNickname()%>">
					
					<p style="float:right;"><button type="submit" class="btn btn-primary" role="button">Ver Menú</button></p>
                                        </form>    
                                    </div>
				</li>
                                <% } %>

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
</script>
<jsp:include page="/WEB-INF/template/footer.jsp"/>
	