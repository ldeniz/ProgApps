<div id="categorias">
	<h5 style="padding-top:15px;padding-left:10px;" class="media-heading"><b>Categoría De Ejemplo</b></h3>
	<a class="producto" data-nickname="Este es un producto 1"  data-precio="111.50" type="button" data-toggle="modal" data-target=".bs-example-modal-sm">Este es un producto 1<spam style="color:#a8ccdf;float:right" class="glyphicon glyphicon-plus-sign"></spam><spam style="padding-right:10px;float:right">$111.50</spam></a>
	<a class="producto" data-nickname="Otro producto distindo"  data-precio="222.50" type="button" data-toggle="modal" data-target=".bs-example-modal-sm">Otro producto distindo<spam style="color:#a8ccdf;float:right" class="glyphicon glyphicon-plus-sign"></spam><spam style="padding-right:10px;float:right">$222.50</spam></a>
	<a class="producto" data-nickname="Caramba que rica"  data-precio="333.50" type="button" data-toggle="modal" data-target=".bs-example-modal-sm">Caramba que rica<spam style="color:#a8ccdf;float:right" class="glyphicon glyphicon-plus-sign"></spam><spam style="padding-right:10px;float:right">$333.50</spam></a>
	<a class="producto" data-nickname="Señores la pizza"  data-precio="444.50" type="button" data-toggle="modal" data-target=".bs-example-modal-sm">Señores la pizza<spam style="color:#a8ccdf;float:right" class="glyphicon glyphicon-plus-sign"></spam><spam style="padding-right:10px;float:right">$444.50</spam></a>
</div>
<div id="categorias">
	<h5 style="padding-top:15px;padding-left:10px;" class="media-heading"><b>Categoría De Ejemplo</b></h3>
	<a class="producto" data-nickname="Este es un producto 1"  data-precio="111.50" type="button" data-toggle="modal" data-target=".bs-example-modal-sm">Este es un producto 1<spam style="color:#a8ccdf;float:right" class="glyphicon glyphicon-plus-sign"></spam><spam style="padding-right:10px;float:right">$111.50</spam></a>
	<a class="producto" data-nickname="Otro producto distindo"  data-precio="222.50" type="button" data-toggle="modal" data-target=".bs-example-modal-sm">Otro producto distindo<spam style="color:#a8ccdf;float:right" class="glyphicon glyphicon-plus-sign"></spam><spam style="padding-right:10px;float:right">$222.50</spam></a>
	<a class="producto" data-nickname="Caramba que rica"  data-precio="333.50" type="button" data-toggle="modal" data-target=".bs-example-modal-sm">Caramba que rica<spam style="color:#a8ccdf;float:right" class="glyphicon glyphicon-plus-sign"></spam><spam style="padding-right:10px;float:right">$333.50</spam></a>
	<a class="producto" data-nickname="Señores la pizza"  data-precio="444.50" type="button" data-toggle="modal" data-target=".bs-example-modal-sm">Señores la pizza<spam style="color:#a8ccdf;float:right" class="glyphicon glyphicon-plus-sign"></spam><spam style="padding-right:10px;float:right">$444.50</spam></a>
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
	$(document).on("click", ".producto", function () {
		
		$(".modal-content #nickname").html( $(this).data('nickname') );
		$(".modal-content #precio").html( $(this).data('precio') );
		$('#cantidad option').eq(0).prop('selected', true);
		});
	
	$(document).on("click", "#agregarPedido", function () {
		$('#miModal').modal('hide')
		$("#pedidos ul").append('<li id="1" class="list-group-item"><span class="badge">x'+$("#cantidad option:selected").html()+'</span>'+$("#nickname").text()+'<span id="1" class="glyphicon glyphicon-trash" style="margin-right:5px;cursor:pointer;float:left;" ></span></li>');	
	});	
	
	
		
</script>