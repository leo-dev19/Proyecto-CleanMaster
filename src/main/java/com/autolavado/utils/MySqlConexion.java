package com.autolavado.utils;

// Paquete del API JDBC
import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConexion {
	
	// Método estático que retorna la conexión con la base de datos colegio_2024_grupo1
	public static Connection getConexion() {
		Connection cn = null;
		// Bloque para controlar exception
		try {
			// Acceder a la clase "Driver" que se encuentra en el jar
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Variables
			String url,user,pass;
			user="root";
			pass="mysql";
			url="jdbc:mysql://localhost:3306/cleanmaster?serverTimezone=UTC";
			// Crear "cn"
			cn = DriverManager.getConnection(url,user,pass);
		} catch (Exception e) {
			e.printStackTrace(); // Lanzar traza de error en la consola
		}
		return cn;
	}
}