<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="controllers.Login"%>
<%@page import="java.util.ArrayList"%>
<%@page import="datatype.DataPedido"%>
<%@page import="datatype.DataUsuario"%>
<%@page import="datatype.DataPedidoProduco"%>
<%@page import="datatype.DataComentario"%>


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
         <div class="row">
        
            <div class="card">
                <canvas class="header-bg" width="250" height="70" id="header-blur"></canvas>
                <div class="avatar">
                    <img src="http://keenthemes.com/preview/metronic/theme/assets/admin/pages/media/profile/profile_user.jpg" alt="" />
                </div>
                <div class="content">
                    <p><span  style="padding-right:5px;" class="glyphicon glyphicon-user" aria-hidden="true"></span><%= usr.getNickname() %><br>
                       (<%= usr.getNombre()%>)</p>
                    
                    <p><span style="padding-right:5px;" class="glyphicon glyphicon-envelope" aria-hidden="true"></span><%= usr.getMail()%></p>
                    <p><span style="padding-right:5px;" class="glyphicon glyphicon-home" aria-hidden="true"></span><%= usr.getDireccion()%></p>
                    
                </div>
            </div>
          
         </div>   
            <h4></h4>
            
                
                
               
            
            
			</div>		
            <div class="col-lg-8">
                        <h4>Pedidos de <%= usr.getNickname() %></h4>
                        


			
                        <% for (DataPedido pedido : pedidos) { %>
                            <div class="panel panel-default">
                              <div class="panel-heading">
                                <h3 class="panel-title">
                                    <span class="glyphicon glyphicon-cutlery" style="margin-right:5px;"></span><%= pedido.getNickNameRestaurante()%><span style="float:right;" class="badge"><%= pedido.getFechaPedido().getTime().toString()%></span>
                               </h3>
                              </div>  
                              <div class="panel-body">
                                <%
                                    ArrayList<DataPedidoProduco> productosP = pedido.getDataPedidoProducos();
                                    for (DataPedidoProduco prod : productosP) {  %>                                
                                        <%= prod.getCantidad()+" - " %>
                                        <%= prod.getStockProduco().getNombreProducto() %></br>
                                        
                                <% } %>
                                <!--Precio Total:</b><%= pedido.getPrecioTotal() %></b>-->
                              </div>
                              <div class="panel-footer">
                                   
                                  <% if(pedido.getDataComentario() != null ){
                                      String comentario = pedido.getDataComentario().getComentario();
                                  
                                  %>
                                  <input id="input-21e" value="<%= pedido.getDataComentario().getPuntaje()%>" type="number" class="rating" min=0 max=5 step=0.5 data-size="xs" data-readonly="true">
                                  <div class="media">
                                    <div class="media-body">
                                      <h4 class="media-heading">Tu Comentario:</h4>
                                      <%= pedido.getDataComentario().getComentario()%>
                                    </div>
                                  </div>      
                                  
                                    <%}else{ %>
                               
                                    <button type="button" class="realizarComentario btn btn-primary btn-sh" data-toggle="modal" data-target="#myModal">
                                     <span class="glyphicon glyphicon-comment" aria-hidden="true"></span> Comentar
                                     <span id="idPedido" style="visibility:hidden;"><%= pedido.getNumero() %></span>
                                    </button>

                                  <% 
                                  } %>  
                                  <span style="float:right;" class="label label-success <%= " "+pedido.getEstado()%>"><%= pedido.getEstado()%></span>

                              </div>
                            </div>
                         <% } %>   
                        
        </div>
            
			
	</div>

                         
                         

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Comentar Pedido</h4>
      </div>
      <div class="modal-body">
        <input id="miPuntuacion" value="" type="number" class="rating" min=0 max=5 step=0.5 data-size="xs" data-readonly="false">
    
        <label for="inputdefault">Ingrese el comentario:</label>
        <input class="form-control" id="miComentario" type="text">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
        <button id="confirmarComentario" type="button" class="btn btn-primary">Comentar</button>
      </div>
    </div>
  </div>
</div>                         
                         
                         
                         
                         
<jsp:include page="/WEB-INF/template/footer.jsp"/>
<script type="text/javascript">

$(document).ready(function() {

        $(".realizarComentario").click(function() {
           $("#miComentario").val("");
           $idPedido = ($(this).find("#idPedido").text());
           
	});
        
        $("#confirmarComentario").click(function() {
           $comentario = $("#miComentario").val();
           $puntuacion = $("#miPuntuacion").val();
  
           $.ajax({
                url: 'comentarPedido',
                dataType: 'json',
                data: {comentario: $comentario, puntuacion: $puntuacion, idPedido: $idPedido },
                type: 'get',
                cache: false,
            
            
            complete: function(request, textStatus)
            {
              //PEDIDO AGREGADO CORECTAMENTE.
              alert("Gracias, hemos registrado tu comentario");
              window.location = "/usuario";
            }
          });
	});

});

      
       
</script>

	