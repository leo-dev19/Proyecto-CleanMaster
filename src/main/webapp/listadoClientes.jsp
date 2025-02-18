<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Clientes</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap5.min.css" rel="stylesheet">
</head>
<body>
<style>
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
		</style>
<div class="container">

    <h3 class="text-center mt-5">Lista de Clientes</h3>
        <form action="GenerarReporteServlet" method="get">
        <input type="submit" value="Generar Reporte">
    </form>
    <table id="tableClientes" class="table table-striped" style="width:100%">
        <thead>
        <tr>
            <th>CÓDIGO</th>
            <th>DNI</th>
            <th>NOMBRE</th>
            <th>CORREO</th>
            <th>TELÉFONO</th>
            <th>FECHA</th>
            <th>CÓDIGO TIPO</th>
            <th>LIMPIADOR</th>
            <th>OPCIONES</th>
        </tr>
        </thead>
        <tbody>
       		
        </tbody>
    </table>
    
    <div class="modal fade" id="modalLimpiador" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
			  <div class="modal-dialog modal-dialog-centered">
			    <div class="modal-content">
			    
			      <div class="modal-header">
			        <h1 class="modal-title fs-5" id="staticBackdropLabel">Reserva</h1>
			      </div>
			      
			      <div class="modal-body">
			      
			      
			        <form id="frmCleanmaster" method="post" action="ServletCliente?accion=asignar">
			        
			        <div class="form-group">
					    <label for="exampleInputEmail1" class="form-label">Código</label>
					    <input type="text" class="form-control" 
					    		name="codigo" id="id-codigo" value="0" readonly>
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleInputEmail1" class="form-label">DNI</label>					   
					    <input type="text" class="form-control" name="dni" id="id-dni" readonly>
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleInputEmail1" class="form-label">Nombre Completo</label>
					    <input type="text" class="form-control" name="nombre" id="id-nombre" readonly>
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleInputEmail1" class="form-label">Correo</label>
					    <input type="text" class="form-control" name="correo" id="id-correo" readonly>
					  </div>
					  <div class="form-group">
					    <label for="exampleInputEmail1" class="form-label">Telefono</label>
					    <input type="text" class="form-control" name="telefono" id="id-telefono" readonly>
					  </div>
					  <div class="form-group">
					    <label for="exampleInputEmail1" class="form-label">Fecha</label>
					    <input type="date" class="form-control" name="fecha" id="id-fecha">
					  </div>

					  <div class="form-group">
					    <label for="exampleInputEmail1" class="form-label">Servicios</label>
					    <select class="form-select" name="tipo" id="id-tipo">
						</select>
					</div>
					
					 <div class="form-group">
					    <label for="exampleInputEmail1" class="form-label">Limpiador</label>
					    <select class="form-select" name="limpiador" id="id-limpiador">
					    <option value="">Seleccione un Limpiador</option>				  
						</select>
					</div>
					
					  
					  <div class="modal-footer">
				        <button type="submit" id="enviar" class="btn btn-primary">Grabar</button>
				        <button type="button" id="enviar" class="btn btn-secondary" data-bs-dismiss="modal" id="btn-cerrar">Cerrar</button> 
				      </div>
				      
					</form>
					
					
			      </div>
			    </div>
			  </div>
			  
			</div>
    	<form id="form-eliminar" method="post" 
				action="ServletCliente?accion=eliminar">
			<input type="hidden" name="codigo" id="codigo-empleado">
		</form>	
</div>
<script src=https://code.jquery.com/jquery-3.7.1.js></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/2.0.3/js/dataTables.js"></script>
        <script src="https://cdn.datatables.net/2.0.3/js/dataTables.bootstrap5.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.0/js/bootstrapValidator.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
<script>




    leerClientes();
    llenarCombo();
    llenarCombo2();
	function leerClientes(){
		$.get("ServletClienteJSON",function(response){
	
			$.each(response, function(index,item){
				$("#tableClientes tbody").append(`
						<tr>
                        <td>\${item.codigo}</td>
                        <td>\${item.dni}</td>
                        <td>\${item.nombre}</td>
                        <td>\${item.correo}</td>
                        <td>\${item.telefono}</td>
                        <td>\${item.fecha}</td>
                        <td>\${item.nombreServicio}</td>
                        <td>\${item.nombreLimpiador != null ? item.nombreLimpiador : 'no asignado'}</td>   
                        <td>
                		<button type="button" class="btn btn-success btn-asignar" data-bs-toggle="modal" data-bs-target="#modalLimpiador">Asignar</button>
                		<button type="button" class="btn btn-danger btn-eliminar">Cancelar</button>
                		</td>
						</tr>
						`)
			})
			new DataTable("#tableClientes");
		})
	}
    
	

	function llenarCombo(){
		$.get("ServletLimpiadorJSON",function(data){
			$.each(data,function(index,item){
				$("#id-limpiador").append(`
						<option value="\${item.codigo}">\${item.nombre}</option>
						
				
				
				`);
			})
			
		})
	}
	
	function llenarCombo2(){
		$.get("ServletTipoClienteJSON",function(data){
			$.each(data,function(index,item){
				$("#id-tipo").append(`
						<option value="\${item.codigo}">\${item.nombre}</option>
				
				
				`);
			})
			
		})
	}
	
	$(document).on("click",".btn-asignar",function(){
		let cod;
		cod=$(this).parents("tr").find("td")[0].innerHTML;
		//leer JSON
		$.get("ServletCliente?accion=buscarPorId&codigo="+cod,
								function(response){
			//mostrar los valores que guarda response dentro las
			//cajas y los combos
			$("#id-codigo").val(response.codigo);
			$("#id-dni").val(response.dni);
			$("#id-nombre").val(response.nombre);
			$("#id-correo").val(response.correo);
			$("#id-telefono").val(response.telefono);
			$("#id-fecha").val(response.fecha);
			$("#id-tipo").val(response.codigoTipo);
			if(response.cod_emp !=null && response.cod_emp > 0){
				$("#id-limpiador").val(response.cod_emp);

			}
			
			console.log(response);
		})		
	})
	
	$(document).on("click",".btn-eliminar",function(){
				let cod;
				cod=$(this).parents("tr").find("td")[0].innerHTML;
				$("#codigo-empleado").val(cod);
				
				Swal.fire({
					  title: "Seguro de Cancelar?",
					  text: "Deseas cancela la cita?",
					  icon: "warning",
					  showCancelButton: true,
					  confirmButtonColor: "#3085d6",
					  cancelButtonColor: "#d33",
					  confirmButtonText: "SI",
					  cancelButtonText: "NO"
					}).then((result) => {
					  if (result.isConfirmed) {
					    $("#form-eliminar").submit();
					  }
					});
				
			})
</script>
</body>
</html>


























