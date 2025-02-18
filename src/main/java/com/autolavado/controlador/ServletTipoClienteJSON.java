package com.autolavado.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.autolavado.clases.TipoCliente;
import com.autolavado.dao.MySqlTipoClienteDAO;

import com.google.gson.Gson;

public class ServletTipoClienteJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletTipoClienteJSON() {
        super();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TipoCliente> lista=new MySqlTipoClienteDAO().findAll();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

}
