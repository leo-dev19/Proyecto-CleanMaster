package com.autolavado.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.autolavado.clases.Cliente;
import com.autolavado.dao.MySqlClienteDAO;
import com.google.gson.Gson;


public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletCliente() {
        super();
    
    }

	
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipo = request.getParameter("accion");
        if (tipo.equals("grabar")) {
            try {
                String codigo = request.getParameter("codigo");
                if (codigo != null && !codigo.isEmpty() && !codigo.equals("0")) {
                    actualizarFechaCliente(request, response);
                } else {
                    insertarCliente(request, response);
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        } else if (tipo.equals("BuscarPorDni")) {
            try {
                buscarEmpleadoPorID(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(tipo.equals("buscarPorId"))
			buscarReservacionPorID(request,response);
        else if (tipo.equals("asignar")) {
        	try {
				asignarLimpiador(request, response);
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
        }
        else if(tipo.equals("eliminar"))
			eliminarReservacion(request,response);
    }
    
    private void eliminarReservacion(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String cod;
		cod = request.getParameter("codigo");
		int estado=new MySqlClienteDAO().DeleteByID(Integer.parseInt(cod));
		if(estado>0){
			request.getSession().setAttribute("MENSAJE", 
						"Reservacion cancelada correctamente");
		}
		else
			request.getSession().setAttribute("MENSAJE", 
					"Error en la cancelacion de la reservacion");
		response.sendRedirect("listadoClientes.jsp");
		
	}


	private void asignarLimpiador(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
    	String cod, nom, dni, cor, tel,fec, codTipo, lim;
		cod = request.getParameter("codigo");
		dni = request.getParameter("dni");
		nom = request.getParameter("nombre");		
		cor = request.getParameter("correo");
		tel = request.getParameter("telefono");
		fec= request.getParameter("fecha");
		codTipo = request.getParameter("tipo");
		lim = request.getParameter("limpiador");

        // Convertir la fecha de String a Date
		Date fecha = null;

		 if (fec != null && !fec.isEmpty()) {
               SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
	            java.util.Date parsedDate = formatoFecha.parse(fec);
	            fecha = new Date(parsedDate.getTime());
	        } else {
	            request.getSession().setAttribute("ERROR_MESSAGE", "La fecha no puede estar vacía.");
	            response.sendRedirect("listadoClientes.jsp");
	            return;
	        }

        // Crear un objeto  con los datos del cliente y el limpiador
        Cliente emp = new Cliente();
        emp.setDni(Integer.parseInt(dni));
		emp.setNombre(nom);
		emp.setCorreo(cor);
		emp.setTelefono(tel);		
        emp.setFecha(fecha);
		emp.setCodigoTipo(Integer.parseInt(codTipo));
		emp.setCod_emp(Integer.parseInt(lim));
		emp.setCodigo(Integer.parseInt(cod));

        // Llamar al método del DAO para asignar el limpiador al cliente
		if(Integer.parseInt(cod)==0) {
			// Invocar al método "save" y enviar el objeto "emp"
			int estado=new MySqlClienteDAO().update(emp);
			if(estado>0){
				request.getSession().setAttribute("MENSAJE", 
							"Reserva del cliente registrado Correctamente");
			}
			else
				request.getSession().setAttribute("MENSAJE", 
						"Error en el registro del cliente");
			//response
			response.sendRedirect("listadoClientes.jsp");
			
		}
		else {
			// Setear atributo codigo
			emp.setCodigo(Integer.parseInt(cod));
			// Invocar al método "update" y enviar el objeto "emp"
			int estado=new MySqlClienteDAO().update(emp);
			if(estado>0){
				request.getSession().setAttribute("MENSAJE", 
							"Empleado actualizado correctamente");
			}
			else
				request.getSession().setAttribute("MENSAJE", 
						"Error en la actualización de Empleado");
			//response
			response.sendRedirect("listadoClientes.jsp");
		}
	}
    


	private void buscarReservacionPorID(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod;
		cod = request.getParameter("codigo");
		Cliente bean=new MySqlClienteDAO().findByID(Integer.parseInt(cod));
		Gson gson=new Gson();
		String json=gson.toJson(bean);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
		
	}


	private void buscarEmpleadoPorID(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String dni;
		dni = request.getParameter("dni");
		Cliente bean=new MySqlClienteDAO().findByDNI(Integer.parseInt(dni));
		Gson gson=new Gson();
		String json=gson.toJson(bean);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}
	
	private void actualizarFechaCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
	    String codigo = request.getParameter("codigo");
	    String fec = request.getParameter("fecha");
	    Date fecha = null;

	    if (fec != null && !fec.isEmpty()) {
	        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date parsedDate = formatoFecha.parse(fec);
	        fecha = new Date(parsedDate.getTime());
	    } else {
	        request.getSession().setAttribute("ERROR_MESSAGE", "La fecha no puede estar vacía.");
	        response.sendRedirect("index.jsp");
	        return;
	    }

	    Cliente emp = new Cliente();
	    emp.setCodigo(Integer.parseInt(codigo));
	    emp.setFecha(fecha);

	    int estado = new MySqlClienteDAO().actualizarFecha(emp);
	    if (estado > 0) {
	        request.getSession().setAttribute("MENSAJE", "Fecha del cliente actualizada correctamente");
	    } else {
	        request.getSession().setAttribute("MENSAJE", "Error al actualizar la fecha del cliente");
	    }
	    response.sendRedirect("index.jsp");
	}
	
	 
	
	private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
		// Leer controles del formularios que se encuntra en la página empleado.jsp
				// Trabajar con el atributo "name"
				String cod, nom, dni, cor, tel,fec, codTipo;
				cod = request.getParameter("codigo");
				dni = request.getParameter("dni");
				nom = request.getParameter("nombre");		
				cor = request.getParameter("correo");
				tel = request.getParameter("telefono");
				fec= request.getParameter("fecha");
				
				codTipo = request.getParameter("tipo");
				Date fecha = null;

				 if (fec != null && !fec.isEmpty()) {
	                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
			            java.util.Date parsedDate = formatoFecha.parse(fec);
			            fecha = new Date(parsedDate.getTime());
			        } else {
			            request.getSession().setAttribute("ERROR_MESSAGE", "La fecha no puede estar vacía.");
			            response.sendRedirect("index.jsp");
			            return;
			        }
				// Crear objeto de la clase Empleado
				Cliente emp = new Cliente();
				// Setear los atributos del objeto "emp" con los valores de las variables
				emp.setDni(Integer.parseInt(dni));
				emp.setNombre(nom);
				emp.setCorreo(cor);
				emp.setTelefono(tel);		
		        emp.setFecha(fecha);
				emp.setCodigoTipo(Integer.parseInt(codTipo));
				// Validar variable codigo
				if(Integer.parseInt(cod)==0) {
					// Invocar al método "save" y enviar el objeto "emp"
					int estado=new MySqlClienteDAO().save(emp);
					if(estado>0){
						request.getSession().setAttribute("MENSAJE", 
									"Reserva del cliente registrado Correctamente");
					}
					else
						request.getSession().setAttribute("MENSAJE", 
								"Error en el registro del cliente");
					//response
					response.sendRedirect("index.jsp");
					
				}
				else {
					// Setear atributo codigo
					emp.setCodigo(Integer.parseInt(cod));
					// Invocar al método "update" y enviar el objeto "emp"
					int estado=new MySqlClienteDAO().update(emp);
					if(estado>0){
						request.getSession().setAttribute("MENSAJE", 
									"Empleado actualizado correctamente");
					}
					else
						request.getSession().setAttribute("MENSAJE", 
								"Error en la actualización de Empleado");
					//response
					response.sendRedirect("index.jsp");
				}
			}
	}

