package com.autolavado.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.autolavado.clases.Cliente;
import com.autolavado.clases.Empleado;
import com.autolavado.dao.MySqlEmpleadoDAO;
import com.autolavado.dao.MySqlListadoClienteDAO;
import com.google.gson.Gson;

/**
 * Servlet implementation class ServletLimpiadorJSON
 */
public class ServletLimpiadorJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLimpiadorJSON() {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Empleado> lista=new MySqlEmpleadoDAO().findByTipoEmpleado(2); //2 es el limpiador
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

}
