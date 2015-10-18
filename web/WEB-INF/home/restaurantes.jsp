<%@page import="java.util.Arrays"%>
<%@page import="datatype.DataPedido"%>
<%@page import="datatype.DataUsuario"%>
<%@page import="controllers.Login"%>
<%@page import="datatype.DataCliente"%>
<%@page import="datatype.DataProducto"%>
<%@page import="datatype.DataDireccion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="datatype.DataRestaurante"%>
<jsp:include page="/WEB-INF/template/header.jsp"/>
<div style="clear:both"></div>
<div class="container bs-docs-container" sytle="margin-top: 60px; ">			
    <div class="col-lg-8">
        <div class="media">
            <div class="media-left media-middle">
                <a href="#">
                    <% 	DataRestaurante datosRes = (DataRestaurante) request.getAttribute("datosRes");
                    String aca = Arrays.toString(datosRes.getRutaImagen());
                                        aca = aca.substring(1, aca.length()-3);
                                        aca = aca.replace(",", "");
                    %>
                    <img style="with:64px;height:64px;" class="media-object" src=<%out.println(""+aca+"");%> alt="...">
                </a>
            </div>

            
            <div class="media-body">

                <input id="input-22e" value="<%=datosRes.getPuntajePromedio()%>" type="number" class="rating" min=0 max=5 step=0.5 data-size="xs" data-readonly="true">
                <h4 class="media-heading"><%=datosRes.getNombre()%></h4>
            </div>
        </div>


        <ul class="nav nav-tabs nav-justified" style="margin-top:10px;">
            <li id="menu" role="presentation" class="active"><a href="#">Menu</a></li>
            <li id="informacion" role="presentation"><a href="#">Informacion</a></li>
            <li id="comentarios" role="presentation"><a href="#">Comentarios</a></li>
        </ul>
        <div id="contenedorMenu" class="contenedorMenu" style="background-color:white;width:100%;">
            <div id="cmenu" class="soyContenedor">
                <div id="categorias">
                    <h5 style="padding-top:15px;padding-left:10px;" class="media-heading"><b>Categor�a De Ejemplo</b></h3>

                        <% ArrayList<DataProducto> productos = datosRes.getDataProductos();
                        Integer contador = 1;    
                        for (DataProducto producto : productos) {
                        %>
                        <a class="verPedidos" data-toggle="modal" data-target=".<%= contador%>"></a>        
                        <a class="producto <%= producto.getTipoProducto()%>" data-nickname="<%= producto.getNombre()%>" data-imagen="<%= producto.getRutaImagen()%>"  data-precio="<%= producto.getStock().getPrecio()%>" type="button" data-toggle="modal" data-target=".bs-example-modal-sm"><%= producto.getNombre()%>
                            
                            <spam style="color:<% if(producto.getTipoProducto() == "promocion") out.println("#FCD857"); else out.println("#a8ccdf");%>;float:right" class="glyphicon glyphicon-plus-sign"></spam>
                            <spam style="padding-right:10px;float:right"><%= producto.getStock().getPrecio()%></spam>
                            <spam style="padding-right:10px;float:left;font-size: 9px;clear: both;"><%= producto.getDescripcion()%></spam>
                           
                        </a>
                        
                        
                        
                        <div class="modal fade <%= contador%>" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                            <div class="modal-dialog modal-lg">
                              <div class="modal-content" style="padding:15px;">
                                <% ArrayList<DataPedido> pedidos = producto.getPedidos();
                                    
                                    if(pedidos != null){
                                        
                                        %><b>Pedidos del Producto:</b></br>
                                        <ul class="list-group"><%
                                        for (DataPedido pedido : pedidos) { %>
                                        
                                        
                                        <li class="list-group-item">
                                            <% out.println("#"+pedido.getNumero()); %>
                                            <% out.println("</br><b>Fecha: </b>"+pedido.getFechaPedido().getTime().toString()); %>
                                            <% out.println("</br><b>Cliente: </b>"+pedido.getNickNameCliente()); %>
                                            <% out.println("</br><b>Precio Total: </b>"+pedido.getPrecioTotal()); %>
                                        </li>
                                        <% } %></ul><%
                                    }
                                    
                                %>
                              </div>
                            </div>
                          </div>
                        
                        <% contador++;
                                }%>
                </div>

                <div id="miModal" style="padding:100px;" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                    <div class="modal-dialog modal-sm">
                        <div class="modal-content" style="padding:25px;height:150px;width:500px">
                            <div id="laImg"><img style="float:left;position:relative;height:100px;margin:5px;" src="" /></div>
                            
                            <div id="nickname"></div> 
                            <div id="precio"></div> 
                             

                            <%
                                DataUsuario usr2;
                                try {
                                    usr2 = Login.getUsuarioLogueado(request);
                                } catch (Exception ex) {
                                    usr2 = null;
                                }

                                if (usr2 != null) {
                            %>  
                            <select id="cantidad" class="form-control cantidad">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                            <a id="agregarPedido" href="#" class="btn btn-primary derecha" role="button">Agregar a mi Pedido</a>
                            <% } else { %>
                            Inicie Sesi�n para a�adir Producto
                            <% }%>  
                        </div>
                    </div>
                </div>

            </div>  
            <div id="cinformacion" class="soyContenedor">
                <div id="categorias">
                    <h1>Informacion de  Restaurantes</h1>

                    <p>Nombre : <%=datosRes.getNombre()%></p>
                    <p>Nickname: <span id="idRestaurante"><%=datosRes.getNickname()%></span></p>
                    <p>Direccion: <%=datosRes.getDireccion()%></p>
                    <p> Email: <%=datosRes.getMail()%></p>
                </div>
            </div>  
            <div id="ccomentarios" class="soyContenedor">
                <div id="categorias">
                    <h1>Comentarios</h1>

                    <%  ArrayList<DataPedido> datosPedido = (ArrayList<DataPedido>) request.getAttribute("datosPedidoRes");
                        if (datosPedido != null && !datosPedido.isEmpty()) {
                            for (DataPedido dp : datosPedido) {
                                if(dp.getDataComentario() != null){
                    %>             
                    <input id="input-21e" value="<%=dp.getDataComentario().getPuntaje()%>" type="number" class="rating" min=0 max=5 step=0.5 data-size="xs" data-readonly="true">
                        <p><%=dp.getDataComentario().getComentario()%></p>                        
                    <%          }
                            }
                        }%>


                </div>
            </div> 
        </div>



    </div>
    <div class="col-lg-4" >
        <jsp:include page="pedido.jsp"/>
    </div>
</div>

<jsp:include page="/WEB-INF/template/footer.jsp"/>
<script type="text/javascript">
$(document).ready(function() {
    
    $("#realizarPedido").hide();
    $("#pedidos ul").empty();
    total= 0;
    for (x=0; x<=localStorage.length-1; x++)  { 
        clave = localStorage.key(x); 
        var object2 = JSON.parse(localStorage.getItem(clave));
        var cantidad = object2.cantidad;
        var precio = object2.precio;
        total = total + (cantidad*precio);
        $("#pedidos ul").append('<li id="1" class="list-group-item enCarrito"><span class="badge"><span id="precio">'+precio+'</span> x <span id="cantidad">'+cantidad+'</span></span><span id="nickname">'+clave+'</span><span id="1" class="glyphicon glyphicon-trash" style="margin-right:5px;cursor:pointer;float:left;" ></span></li>');	

    }
    $("#total .fullprice").html(total);    
     if(parseInt($("#total .fullprice").html()) > 0 ) $("#realizarPedido").fadeIn();
               
    
	
    $("ul.nav-tabs li:first").addClass("active").show(); //Activar primera pestaña
    $(".contenedorMenu:first").show(); //Mostrar contenido primera pestaña

    $(cinformacion).hide();
    $(ccomentarios).hide();
	
	// Sucesos al hacer click en una pestaña
    $("ul.nav-tabs li").click(function() {
        $("ul.nav-tabs li").removeClass("active"); //Borrar todas las clases "active"
        $(this).addClass("active"); //Añadir clase "active" a la pestaña seleccionada

        $(".soyContenedor").hide();
        var activatab = "c"+$(this).attr('id'); //Leer el valor de href para identificar la pestaña active 
       // $("#"+activatab).show();
        $("#"+activatab).fadeIn(); //Visibilidad con efecto fade del contenido activo
        return false;
    });
});

      
    $(".producto").click(function () {


            $(".modal-content #nickname").html( $(this).data('nickname') );
            $(".modal-content #precio").html( $(this).data('precio') );
            $('#cantidad option').eq(0).prop('selected', true);
            $('#laImg img').prop('src', $(this).data('imagen'));

    });
	
        $("#agregarPedido").click(function () {
            
            $('#miModal').modal('hide');
            var cantidad = parseInt($("#cantidad option:selected").html());
            var precio = parseInt($(".modal-content #precio").html());
            

            // Creamos un objeto
            var object = { 'precio' : precio, 'cantidad' : cantidad };
            // Lo guardamos en localStorage pasandolo a cadena con JSON
            localStorage.setItem($("#nickname").text(), JSON.stringify(object));
            
            $("#pedidos ul").empty();
            total= 0;
            for (x=0; x<=localStorage.length-1; x++)  { 
                clave = localStorage.key(x); 
                var object2 = JSON.parse(localStorage.getItem(clave));
                var cantidad = object2.cantidad;
                var precio = object2.precio;
                $("#pedidos ul").append('<li id="1" class="list-group-item enCarrito"><span class="badge"><span id="precio">'+precio+'</span> x <span id="cantidad">'+cantidad+'</span></span><span id="nickname">'+clave+'</span><span id="1" class="glyphicon glyphicon-trash" style="margin-right:5px;cursor:pointer;float:left;" ></span></li>');	
                total = total + (cantidad*precio);
            
            }
            $("#total .fullprice").html(total);    
            if(parseInt($("#total .fullprice").html()) > 0 ) $("#realizarPedido").fadeIn();  

                

        });
    
        	
	
		
</script>

	