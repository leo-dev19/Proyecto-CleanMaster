package com.autolavado.interfaces;

import java.util.List;

import com.autolavado.clases.Empleado;
import com.autolavado.clases.Enlace;

public interface UsuarioDAO {

	Empleado findByLoginInClave(String login,String clave);
	List<Enlace> findByEnlacesInRol(int codRol);
	
	
}
