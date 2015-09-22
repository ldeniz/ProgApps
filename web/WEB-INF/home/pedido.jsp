<div id="pedidos">
	<ul class="list-group" >
	 <!-- <li id="1" class="list-group-item"><span class="badge">x1</span>Me duermo<span id="1" class="glyphicon glyphicon-trash" style="margin-right:5px;cursor:pointer;float:left;" ></span></li>
	  <li id="2" class="list-group-item"><span class="badge">x2</span>Caramba<span id="2" class="glyphicon glyphicon-trash" style="margin-right:5px;cursor:pointer;float:left;" ></span></li>
	  <li id="3" class="list-group-item"><span class="badge">x1</span>Producto<span id="3" class="glyphicon glyphicon-trash" style="margin-right:5px;cursor:pointer;float:left;" ></span></li>
	  <li id="4" class="list-group-item"><span class="badge">x3</span>No me borres<span id="4" class="glyphicon glyphicon-trash" style="margin-right:5px;cursor:pointer;float:left;" ></span></li>
-->
	</ul>
</div>

<script type="text/javascript">

 $(document).on("click", ".list-group-item span", function () {
		$(this).closest("li").remove();
    });
</script>