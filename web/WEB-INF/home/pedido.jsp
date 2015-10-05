<%@page import="controllers.Login"%>
<%@page import="datatype.DataUsuario"%>
<div id="pedidos">
    <%
		DataUsuario usr;
		try {
			usr = Login.getUsuarioLogueado(request);
		} catch(Exception ex){
			usr = null;
		}
		
		if(usr != null) {
               %>
    <h4>Mi Pedido</h4>
	<ul class="list-group" >

	</ul>
    <div id="total">
        Total: $<span class="fullprice">0</span>
    </div>
     <button id="realizarPedido" class="btn btn-lg btn-primary btn-block" type="submit">Realizar Pedido</button>
    <% }else{ %>
    Usuario no logueado
    <% } %>
</div>

<script type="text/javascript">

 $(document).on("click", ".list-group-item span", function () {
		
                
                var cantidad = parseInt($(this).closest("li").find("#cantidad").text());
                var precio = parseInt($(this).closest("li").find("#precio").text());
                var total = parseInt($("#total .fullprice").html());

                $(this).closest("li").remove();
                total = total - (cantidad*precio);
                $("#total .fullprice").html(total);
                
                if(total<=0) $("#realizarPedido").hide();
                
                
    });
    
    $(document).on("click", "#realizarPedido", function () {
	
        
        $productos = "[";
        $( "li.list-group-item" ).each(function() {
            if ($productos !== "[") {$productos += ",";}
            $productos += '{"Precio":"'  + parseInt($(this).find("#precio").text()) + '"}';
        });
        $productos +="]";
        alert($productos);
        
         $nickname = "mathi";
         $restaurante = "Mathi";
         
          $.ajax({
            url: 'realizarPedido',
            dataType: 'json',
            data: {cliente: $nickname, restaurante: $restaurante, productos:$productos },
            type: 'get',
            cache: false,
            
            
            complete: function(request, textStatus)
            {
              //PEDIDO AGREGADO CORECTAMENTE.
              alert("PEDIDO REGISTRADO CON ID: " + request.responseText);
             
            }
          });
    });
</script>