<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clean Master</title>
				<link href="css/index.css" rel="stylesheet">
		
		<link href="css/indexV2.css" rel="stylesheet">
		<link href="css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
		<link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css"  rel="stylesheet">
		
</head>

	<style>
	
		h6{padding-left:45px;width:100%;font-size: 40px;text-decoration: underline;}
		
		.nav-link{font-size: 18px; color: black;}
		h3{color:white;font-size: 80px;text-align: center;}
	
		
		.modal-header{
				color:#fff;
				background: #428bca;
				display: flex;
		  		justify-content: center;
		}
		.help-block {
			  	color: red;
		}
		.form-group.has-error .form-control-label {
			    color: red;
		}
		.form-group.has-error .form-control {
			    border: 1px solid red;
			    box-shadow: 0 0 0 0.2rem rgba(250, 16, 0, 0.18);
		}
		.form-group.has-error .form-select {
			    border: 1px solid red;
			    box-shadow: 0 0 0 0.2rem rgba(250, 16, 0, 0.18);
		}
		
			
		body{
			width: 100%;
	    	background-image: url('img/bck2.jpg');
	    	background-attachment: fixed;
		}	
				

				
		
		
		#frmCleanmaster{
			opacity:1;
		}
		
		.modal-content{
			background-color: rgba(0, 0, 0, 0.5);	
		
		}
		
		.modal-header{
				    background: linear-gradient(to right, #4472C4, #BD13A9);
			
		}
		
		#banner{
		align-items: center;		
		display: flex;
		flex-direction: column;
		
		
		
		}
		
		#bannerh1{
			text-align: center;
			text-shadow: 8px 8px 16px rgba(0, 0, 0, 4);		
			font-size:90px;
			color:white;
		}
		
		#btn-reservar{
			border-radius:0px;
			margin: auto;
			color: white;
			text-align: center;
			padding: 10px;
			background: linear-gradient(to right, #4472C4, #BD13A9);
			width: 10%;
		}
		
		
		
		#galeria{
		
			width: 64.5%;
			margin: auto;
			
			
		}
		
		#galeria h1{
				padding:10px;
				width:100%;font-size: 40px;text-decoration: underline;
		
		
		}
		
		.fila{
		
		        display: flex; /* Mostrar las imágenes en una fila */
		
		}
		
		.fila img{
		padding:10px;
			height:350px;
			width:50%;
		}
		
		#footer-links{
		    flex-direction: row; 
			width: 64.5%;
					margin: auto;
										        display: flex; /* Mostrar las imágenes en una fila */
					
		
		}
		
		
		.footer-cont{
		padding:20px;
			width: 25%;
		}
		
		.footer-cont img{
		padding:15px;
				height:65px;
					width: 100%;
		
		}
		
		
		.footer-cont a{
				padding:15px;
		
				color: white;
				text-decoration: none;
		}
		
		.footer-cont p{
				padding:15px;
		
				color: white;
		}
		
		.footer-cont h1{
					font-size:30px;
		    font-weight: bold; /* Establece el peso de la fuente en negrita */
		
				color: #BD13A9;
		}
		
		.footer-cont h6{
			text-decoration: none;
			padding-bottom:0px;
						margin-bottom:0px;
			
			padding-left:15px;
			font-size:20px;
			color: #BD13A9;
		}
		footer{
			padding-top:60px;
						padding-bottom:60px;
			
		}
		
		#nosotros img{
			height:275px;
		}
		
		
	
	</style>
	
<body>

	<div id="contenedor1">

		<!-- NAV  -->
		<ul class="nav justify-content-center" id="nav">
		
		  <li class="nav-item" id="logo">
		  	<a href="index.jsp">
		  		<img id="logo-img" src="img/logo1.jpg" >   
		  	</a>
		  </li>
		  
		  <li class="nav-item">
		    <a class="nav-link" href="#">INICIO</a>
		  </li>
		  
		  <li class="nav-item">
		    <a class="nav-link" href="#">SERVICIOS</a>
		  </li>
		  
		  <li class="nav-item">
		    <a class="nav-link" href="#">PRODUCTOS</a>
		  </li>
		  
		  <li class="nav-item">
		    <a class="nav-link" href="#">NOSOTROS</a>
		  </li>
		  
		</ul>
		
		
		<!-- FORMULARIO  -->
		
		<div id="banner">
		<br><br><br><br>
		<h1 id="bannerh1" >¡No esperes más! <br> Lava tu auto con nostros</h1>
		
		
		<button type="button" id="btn-reservar" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalReserva">Reserva ya</button>
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		
		
		</div>
		
			<div class="modal fade" id="modalReserva" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
			  <div class="modal-dialog modal-dialog-centered">
			    <div class="modal-content">
			    
			      <div class="modal-header">
			        <h1 class="modal-title fs-5" id="staticBackdropLabel">Reserva</h1>
			      </div>
			      
			      <div class="modal-body">
			      
			      
			        <form id="frmCleanmaster" method="post" action="ServletCliente?accion=grabar">
			        <div class="form-group">
					    <label for="exampleInputEmail1" class="form-label">Código</label>
					    <input type="text" class="form-control" 
					    name="codigo" id="id-codigo" value="0" readonly>
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleInputEmail1" class="form-label">DNI</label>
					    <button type="button" class="buscar" id="buscar">Buscar DNI</button>
					    <input type="text" class="form-control" name="dni" id="id-dni">
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleInputEmail1" class="form-label">Nombre Completo</label>
					    <input type="text" class="form-control" name="nombre" id="id-nombre">
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleInputEmail1" class="form-label">Correo</label>
					    <input type="text" class="form-control" name="correo" id="id-correo">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputEmail1" class="form-label">Telefono</label>
					    <input type="text" class="form-control" name="telefono" id="id-telefono">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputEmail1" class="form-label">Fecha</label>
					    <input type="date" class="form-control" name="fecha" id="id-fecha">
					  </div>

					  <div class="form-group">
					    <label for="exampleInputEmail1" class="form-label">Servicios</label>
					    <select class="form-select" name="tipo" id="id-tipo">
						<!--
								  <option value="" selected>Seleccione Tipo Empleado</option>
								  <option value="1">Secretaria</option>
								  <option value="2">Contador</option>
								  <option value="3">Supervisor</option>
								  <option value="4">Cajero</option>
						 -->
								  
						</select>
					</div>

					  <div class="modal-footer">
				        <button type="submit" id="enviar" class="btn btn-primary">Enviar</button>
				        <button type="button" id="cerrar" class="btn btn-secondary" data-bs-dismiss="modal" id="btn-cerrar">Cerrar</button> 
				      </div>
				      
					</form>
					
					
			      </div>
			    </div>
			  </div>
			</div>

		<br>



		<div class="cajas">
		    
			<div class="servicio-img">
			<img src="img/servicio5.png">
				<h4>SERVICIO 1</h4>	
				<a href=""><button class="btn-servicio">Ver más</button></a>
			</div>
			
			<div class="servicio-img">
				<img src="img/servicio2.png">
				<h4>SERVICIO 2</h4>	
				<a href=""><button class="btn-servicio">Ver más</button></a>
			</div>
			
			<div class="servicio-img">
				<img src="img/servicio3.png">
				<h4>SERVICIO 3</h4>	
				<a href=""><button class="btn-servicio">Ver más</button></a>
			</div>
		
			<div class="servicio-img">
				<img src="img/servicio4.png">
				<h4>SERVICIO 4</h4>	
				<a href=""><button class="btn-servicio">Ver más</button></a>
			</div>
			
		</div>
		
			
		
		
	
		<div class="cajas">
		
			<div id="nosotros" >
			
				<img src="img/nosotros.png">
				
				<div id="info" >
				<br>
					<h6>Nosotros</h6>
					<p>Somos un centro especializado en la limpieza y detallado de vehículos con 1 año de experiencia en el mercado local.
					Nuestro equipo está conformado por jóvenes profesionales y especialistas de 1er nivel en el cuidado integral de vehículos.
					</p>
					<div id="boton1"><button id="boton2">Saber más</button></div>
					
					
				</div>
			
			</div>
			
		</div>
		
		
		<div class="caja2">
			<h3>Reserva tu cita ya!</h3>	
		</div>
	
		
		
		<div class="cajas">
		
			<div id="galeria">
			
				<h1>Galeria</h1>
				<div class="fila">
				   <img src="img/galeria1.png">
				   <img src="img/galeria2.png">
				</div>
				<div class="fila">
				   <img src="img/galeria3.png">
				   <img src="img/galeria4.png">
				</div>
				<div class="fila">
				   <img src="img/galeria5.png">
				   <img src="img/galeria6.png">
				</div>

				
			</div>
		
		</div>
		
		<br><br>
		
		
		
		<footer>
		
			<div id="footer-links">
				
				
				<div class="footer-cont">
					<img src="img/logo1.jpg">
					<p>Somos un centro especializado en la limpieza y detallado de vehículos con 1 año de experiencia en el mercado local.
					Nuestro equipo está conformado por jóvenes profesionales y especialistas de 1er nivel en el cuidado integral de vehículos.</p>
				</div>
				
				
				
				<div class="footer-cont">
					<h1>Servicios</h1>
					<br>
					<a href="">Servicio 1</a><br>
			      	<a href="">Servicio 2</a><br>
			      	<a href="">Servicio 3</a><br>
			      	<a href="">Servicio 4</a>
				</div>
				
				
				
				<div class="footer-cont">
					<h1>Menú</h1>
					<br>
					<a href="">Inicio</a><br>
			      	<a href="">Servicios</a><br>
			      	<a href="">Productos</a><br>
			      	<a href="">Nosotros</a>
				</div>
				
				
				
				<div class="footer-cont">
					<h1>Contacto</h1>
					<br>
					<h6>Direccion</h6>
					<p>Av. Ayacucho cuadra 4 S/N (Esq. Calle Doña Virginia). Surco, Lima - Perú.</p>
					
					<h6>Horarios de Atencion</h6>
					<p>Lun. - Sáb. 9.00 - 18.00 <br>
					Dom: Cerrado hasta nuevo aviso</p>
					
					<h6>Telefono</h6>
					<p>51 (1) 260 3634 <br> (51) 956 770 355</p>
					
				</div>
				
				
				
				
			</div>
		
		</footer>
		
		<div class="footer2">	
			© 2024 CLEAN MASTER Todos los Derechos Reservados.
		</div>












	</div>
	
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.0/js/bootstrapValidator.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
		
		
		<c:if test="${not empty sessionScope.MENSAJE}">
    <script>
        $(document).ready(function() {
            toastr.success('${sessionScope.MENSAJE}', 'SISTEMA', {timeOut: 5000});
        });
    </script>
</c:if>
		<!-- eliminar atributo de tipo sesión MENSAJE -->
		<c:remove var="MENSAJE" scope="session"/>
		
		
<script >
llenarCombo();

function llenarCombo(){
	$.get("ServletTipoClienteJSON",function(data){
		$.each(data,function(index,item){
			$("#id-tipo").append(`
					<option value="\${item.codigo}">\${item.nombre}</option>
			
			
			`);
		})
		
	})
}

</script>
  <script type="text/javascript">
  
  $(document).on("click", ".buscar", function() {
	    // Obtener el DNI del elemento de entrada correspondiente
	    let dni = $("#id-dni").val();

	    // Realizar la solicitud al servidor para obtener los detalles del cliente por DNI
	    $.get("ServletCliente?accion=BuscarPorDni&dni=" + dni, function(response) {
	        // Mostrar los valores que devuelve la respuesta en los elementos correspondientes
	        $("#id-codigo").val(response.codigo);
	        $("#id-dni").val(response.dni);
	        $("#id-nombre").val(response.nombre);
	        $("#id-correo").val(response.correo);
	        $("#id-telefono").val(response.telefono);
	        $("#id-fecha").val(response.fecha);
	        $("#id-tipo").val(response.codigoTipo);
	    });
	});
  </script>
		<script>    
		    $(document).ready(function(){     
		        $('#frmCleanmaster').bootstrapValidator({      
		        	 fields:{
		        		 
		        		 dni:{
		        			 validators:{
		        				 notEmpty:{
		        					 message:'Ingresar DNI'
		        				 },
		        				 regexp:{
					        			regexp:/^[0-9]{8}$/,
					        			message:'Ingresar DNI correcto'
		        				 }
		        			 }
		        		 },
		        
		        		 nombre:{
		        			 validators:{
		        				 notEmpty:{
		        					 message:'Ingresar nombre completo'
		        				 }
		        			 }
		        		 },
		        		 
		        		 correo:{
		        			 validators:{
		        				 notEmpty:{
		        					 message:'Ingresar correo'
		        				 }
		        			 }
		        		 },
		        		 
		        		 telefono:{
		        			 validators:{
		        				 notEmpty:{
		        					 message:'Ingresar número de telefono/celular'
		        				 }
		        			 }
		        		 },
		        		 
		        		 fechahora:{
		        			 validators:{
		        				 notEmpty:{
		        					 message:'Seleccione una fecha'
		        				 }
		        			 }
		        		 },
		        		 
		        		 servicio:{
		        			 validators:{
		        				 notEmpty:{
		        					 message:'Seleccione un servicio'
		        				 }
		        			 }
		        		 },
		        
		        
		        
		        
		        
		        
		        	 }
		        });   
					
		    });    
		</script> 




















</body>
</html>