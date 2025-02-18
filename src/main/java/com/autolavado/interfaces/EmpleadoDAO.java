package com.autolavado.interfaces;

import java.util.List;

import com.autolavado.clases.Empleado;

public interface EmpleadoDAO {
	List<Empleado>findAll();

	List<Empleado> findByTipoEmpleado(int cod_tipoemp);

}
