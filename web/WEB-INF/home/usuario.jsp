
<%@page import="controllers.Login"%>
<%@page import="java.util.ArrayList"%>
<%@page import="datatype.DataPedido"%>
<%@page import="datatype.DataUsuario"%>
<jsp:include page="/WEB-INF/template/header.jsp"/>
<%
            DataUsuario usr;
            ArrayList<DataPedido> pedidos = null;
            try {
                    usr = Login.getUsuarioLogueado(request);
                    pedidos = usr.getPedidos();
            } catch(Exception ex){
                    usr = null;
            }

            
%>
<div style="clear:both"></div>
	<div class="container bs-docs-container" sytle="margin-top: 60px; ">			
	<div class="col-lg-4" >
            <h4><%= usr.getNickname() %></h4>
			</div>		
            <div class="col-lg-8">
                        <h4>Pedidos de <%= usr.getNickname() %></h4>
                        

			
                        <% 
                            for (DataPedido pedido : pedidos) { %>
                        <div class="panel panel-default">
                          <div class="panel-heading">
                            <h3 class="panel-title">
                                <b>#</b><%= pedido.getNumero()%> a Restaurante:<%= pedido.getNickNameRestaurante()%></br>
                                
                           </h3>
                          </div>  
                          <div class="panel-body">
                            Lista Productos
                            Lista Comentarios
                          </div>
                        </div>
                                <%
                            } 
                        %>   
                        
        </div>
            
			
	</div>

<jsp:include page="/WEB-INF/template/footer.jsp"/>
<script type="text/javascript">

$(document).ready(function() {

});

      
       
</script>

	