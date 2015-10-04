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
                                    <a href="#" class="list-group-item active">Todas las Categorías</a>
                                  <%
                                    List<DataCategoria> categorias = Restaurantes.getCategorias(request);
                                    for(DataCategoria cat : categorias){
                                        %>        
                                        <a href="#" class="list-group-item"><%=cat.getNombre() %></a>
                                        <%
                                    }  
                                    %>
				  
                                    
                                    
				</div>
			</div>
			<div class="col-lg-8">
			<ul class="ulhorizontal">
                            
                            <%
                                    ArrayList<DataRestaurante> restaurantes = Restaurantes.getRestaurantes(request);
                                    for(DataRestaurante res : restaurantes){
                                        %>        
                                        <li>
				  <img src="<%= res.getRutaImagen()%>" alt="..." class="imagenResto">
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
<jsp:include page="/WEB-INF/template/footer.jsp"/>
	