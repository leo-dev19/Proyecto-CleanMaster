package com.autolavado.clases;

import java.sql.Date;
import java.sql.Timestamp; 

public class Cliente {
    private int codigo, codigoTipo, dni;
    private String nombre, correo, telefono;
    private Date fecha; 
    private int cod_emp; //empleado limpiador
    private String nombreLimpiador, nombreServicio;
    public int getCodigo() {
        return codigo;
    }

	public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoTipo() {
        return codigoTipo;
    }

    public void setCodigoTipo(int codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

	public int getCod_emp() {
		return cod_emp;
	}

	public void setCod_emp(int cod_emp) {
		this.cod_emp = cod_emp;
	}

	public String getNombreLimpiador() {
		return nombreLimpiador;
	}

	public void setNombreLimpiador(String nombreLimpiador) {
		this.nombreLimpiador = nombreLimpiador;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
    
    

}