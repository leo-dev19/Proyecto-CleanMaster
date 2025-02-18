package com.autolavado.interfaces;


import java.util.List;

import com.autolavado.clases.Cliente;

public interface ClienteDAO {
	int save(Cliente bean);
	Cliente findByDNI(int dni);
    int actualizarFecha(Cliente cli);
    Cliente findByID(int codigo);
    int update(Cliente bean);
    int DeleteByID (int cod);
	
}
