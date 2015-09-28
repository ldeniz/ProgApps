<%@page import="datatype.DataProducto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="datatype.DataRestaurante"%>
<div id="categorias">
    
    
    <% 	DataRestaurante datosRes = (DataRestaurante) request.getAttribute("datosRes"); %>	
			
    
    
	<h5 style="padding-top:15px;padding-left:10px;" class="media-heading"><b>Categoría De Ejemplo</b></h3>
	
        <% ArrayList<DataProducto> productos = datosRes.getDataProductos(); 
        for(DataProducto producto: productos){
        %>
        
        <a class="producto" data-nickname="<%= producto.getNombre()%>"  data-precio="<%= producto.getStock().getPrecio()%>" type="button" data-toggle="modal" data-target=".bs-example-modal-sm"><%= producto.getNombre()%><spam style="color:#a8ccdf;float:right" class="glyphicon glyphicon-plus-sign"></spam><spam style="padding-right:10px;float:right"><%= producto.getStock().getPrecio()%></spam></a>
	<%}%>
</div>
	
	<div id="miModal" style="padding:100px;" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
	  <div class="modal-dialog modal-sm">
		<div class="modal-content" style="padding:25px;height:135px;">
		  <div id="nickname"></div> 
		  <div id="precio"></div> 
		  <select id="cantidad" class="form-control cantidad">
			 <option>1</option>
			 <option>2</option>
			 <option>3</option>
			 <option>4</option>
			 <option>5</option>
			</select>
                  <a id="agregarPedido" href="#" class="btn btn-primary derecha" role="button">Agregar a mi Pedido</a>
		</div>
	  </div>
	</div>
	
	
<script type="text/javascript">
      
        $(".producto").click(function () {	
		$(".modal-content #nickname").html( $(this).data('nickname') );
		$(".modal-content #precio").html( $(this).data('precio') );
		$('#cantidad option').eq(0).prop('selected', true);
	});
	
	/*$(document).on("click", "#agregarPedido", function () {
		$('#miModal').modal('hide');
		$("#pedidos ul").append('<li id="1" class="list-group-item"><span class="badge">x'+$("#cantidad option:selected").html()+'</span>'+$("#nickname").text()+'<span id="1" class="glyphicon glyphicon-trash" style="margin-right:5px;cursor:pointer;float:left;" ></span></li>');	
	});*/
    
        $("#agregarPedido").click(function () {
		$('#miModal').modal('hide');
		$("#pedidos ul").append('<li id="1" class="list-group-item"><span class="badge">x'+$("#cantidad option:selected").html()+'</span>'+$("#nickname").text()+'<span id="1" class="glyphicon glyphicon-trash" style="margin-right:5px;cursor:pointer;float:left;" ></span></li>');	
	});
    
        	
	
		
</script>