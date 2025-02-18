package com.autolavado.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.autolavado.clases.Empleado;
import com.autolavado.clases.Enlace;
import com.autolavado.dao.MySqlUsuarioDAO;


public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletLogin() {
        super();
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo=request.getParameter("accion");
		if(tipo.equals("SESION"))
			iniciarSesionDelUsuario(request,response);
		else if (tipo.equals("CERRAR"))
			cerrarSesionDelUsuario(request,response);
		
	
	}

	private void cerrarSesionDelUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//obtener la sesion actual
		HttpSession sesionActual=request.getSession();
		//eliminar los atributos de tipo sesion
		sesionActual.invalidate();
		//crear atributo de tipo sesion que guarde el mensaje sesion terminada
		request.getSession().setAttribute("TERMINADA", "Sesion terminada");
		//direccionar al login
		response.sendRedirect("Login.jsp");
		
		
	}

	private void iniciarSesionDelUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//recuperar cajas de la página login.jsp
		String vLogin=request.getParameter("username");
		String vClave=request.getParameter("password");
		//invocar al método findByLoginInClave
		Empleado obj=new MySqlUsuarioDAO().findByLoginInClave(vLogin, vClave);
		//validar obj
		if(obj==null) {//error credenciales incorrectas
			//crear un atributo de tipo sesión que guarde el error del login
			request.getSession().setAttribute("ERROR", "Credenciales incorrectas");
			//direccionar a la página login
			response.sendRedirect("Login.jsp");
		}
		else {//sesión correcta
			
			//invocar al metodo y enviar como parametro el rol del usuario que inicio sesion trabajar con obj
			List<Enlace> datos=new MySqlUsuarioDAO().findByEnlacesInRol(obj.getIdRol()); 
			
			
			//crear atributo de tipo sesion que guarde los nombres y apellidos del usuario que inicio sesion
			//"trabajar con el obj
			request.getSession().setAttribute("USUARIO", obj.getNombre()+" ");
			
			//crear atributo de tipo sesion que guarde 
			request.getSession().setAttribute("ENLACES", datos);
			response.sendRedirect("Intranet.jsp");
			
		}
		
		
		
	}
		
		
}


