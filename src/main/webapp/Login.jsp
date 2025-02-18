<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Intranet</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  	
<style type="text/css">
	:root{
	  --main-bg:#0dcaf0;
	}
	
	.main-bg {
	  background: var(--main-bg) !important;
	}
	
	input:focus, button:focus {
	  border: 1px solid var(--main-bg) !important;
	  box-shadow: none !important;
	}
	
	.form-check-input:checked {
	  background-color: var(--main-bg) !important;
	  border-color: var(--main-bg) !important;
	}
	
	.card, .btn, input{
	  border-radius:0 !important;
	}

	
	.cajalogin{
		margin-top:40px;
		margin-left:auto;
				margin-right:auto;
		
		display:flex;
		flex-direction:row; 
		width: 90%;
    	box-shadow: 0px 0px 10px 2px rgba(0, 0, 0, 0.5);

			
	}	

	.container{
		padding-top:10px;
		margin:auto;
		width: 100%;
	}
	
	#id-login{
		
		width: 50%;
		background:white;
		padding: 40px;
	}
	
	#id-login h2{
		text-align:center;
	}
	
	
	#img-login{
	
		width:50%;
	}
	
	body{
    	background-image: url('img/bcklogin.jpg');
    	background-attachment: fixed;
	}

	#logologin{
		margin-top:90px;
	
		width:100%;
	}
	
	.caja-alerta{
		text-align: center;
	
		margin-top:20px;
		margin-left:auto;
		margin-right:auto;
		margin-bottom:0px;
		
		
		padding:0px;
		width:90%;
	}

			
	button{
			border: 0px;
			margin: auto;
			color: white;
			text-align: center;
			padding: 10px;
			background: linear-gradient(to right, #4472C4, #BD13A9);
			width: 40%;
	}			

</style>
</head>
<body>
  <!-- Login Form -->
  <div class="container">
  
      <div class="caja-alerta" >
      		<c:if test="${sessionScope.TERMINADA!=null}">
		      <div class="alert alert-success" role="alert">
					 ${sessionScope.TERMINADA}
			  </div>
			</c:if>
			
				<c:if test="${sessionScope.ERROR!=null}">
			      <div class="alert alert-danger" role="alert">
					 ${sessionScope.ERROR}
				  </div>
			 	</c:if>
		  		<c:remove var="ERROR" scope="session"/>
		  		<c:remove var="TERMINADA" scope="session"/>
	</div>
		  	
    <div class="cajalogin">
    
	
		  		
		  		
        <div id="id-login">
        
        <img id="logologin" src="img/logo1.jpg">
        	<br><br><br>
          <div>
            <h2>INICIAR SESION</h2>
          </div>
          
          
          <div>
          
            <form method="post" action="ServletLogin?accion=SESION">
            
              <div class="mb-4">
                <label for="username" class="form-label font-weight-bold">Usuario</label>
                <input type="text" class="form-control" name="username" />
              </div>
              
              <div class="mb-4">
                <label for="password" class="form-label font-weight-bold">Contraseña</label>
                <input type="password" class="form-control" name="password" />
              </div>
              
              <div class="d-grid">
                <button type="submit">Ingresar</button>
              </div>
              
            </form>
            
          </div>
          
          
        </div>
        
        
        
            <img id="img-login" src="img/login.jpg">
        
        
        
        
        
    </div>
    
    
    
 
    
    
    
    
    
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  
</body>
</html>
