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
import com.autolavado.dao.MySqlListadoClienteDAO;
import com.google.gson.Gson;

public class ServletListadoClienteJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletListadoClienteJSON() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cliente> lista=new MySqlListadoClienteDAO().findAll();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

}
