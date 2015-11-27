<%@page import="controllers.Login"%>
<%@page import="proxy.DataUsuario"%>
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
		
        var total = parseInt($("#total .fullprice").html());    

        var object2 = JSON.parse(localStorage.getItem($(this).closest("li").find("#nickname").text()));
        var cantidad = object2.cantidad;
        var precio = object2.precio;
        $(this).closest("li").remove();
        total = total - (cantidad*precio);
        $("#total .fullprice").html(total);

        if(total<=0) $("#realizarPedido").hide();
        localStorage.removeItem($(this).closest("li").find("#nickname").text());
    });
    
    $(document).on("click", "#realizarPedido", function () {
	
        
        $productos = "[";
        $( "li.enCarrito" ).each(function() {
            if ($productos !== "[") {$productos += ",";}
            $productos += '{"prod":"' + $(this).find("#nickname").text()+'","cantidad":"'  + parseInt($(this).find("#cantidad").text()) + '"}';
        });
        $productos +="]";
        
        
   
         $restaurante = $(document).find("#idRestaurante").html();
         
          $.ajax({
            url: 'realizarPedido',
            dataType: 'json',
            data: {restaurante: $restaurante, productos:$productos },
            type: 'get',
            cache: false,
            
            
            complete: function(request, textStatus)
            {
              //PEDIDO AGREGADO CORECTAMENTE.
              localStorage.clear();
              alert("Bien hecho!, tu pedido se está preparando");
              window.location = "/qoweb/usuario";
            }
          });
    });
</script>