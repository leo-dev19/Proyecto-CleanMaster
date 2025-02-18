package com.autolavado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.autolavado.clases.Cliente;
import com.autolavado.interfaces.ClienteDAO;
import com.autolavado.utils.MySqlConexion;


public class MySqlClienteDAO implements ClienteDAO {

	
	@Override
	public int save(Cliente bean) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn=MySqlConexion.getConexion();
			String sql="insert into tb_cliente values(null,?,?,?,?,?,?,null)"; // ? --> Parámetros
			pstm = cn.prepareStatement(sql);
			
			pstm.setInt(1, bean.getDni());
			pstm.setString(2, bean.getNombre());
			pstm.setString(3, bean.getCorreo());
			pstm.setString(4, bean.getTelefono());
            java.sql.Date fecha = new java.sql.Date(bean.getFecha().getTime());
            pstm.setDate(5, fecha); // Usa setDate para DATE
			pstm.setInt(6, bean.getCodigoTipo());
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm!= null) pstm.close();
				if(cn!= null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}
	@Override
	public int update(Cliente bean) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn=MySqlConexion.getConexion();
			String sql="update tb_cliente set dni_cli = ?, nom_cli=?, correo_cli=?, tele_cli=?,  fecha_cli=?, cod_tipo=?, cod_emp=?  where cod_cli=?"; // ? --> Parámetros
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, bean.getDni());
			pstm.setString(2, bean.getNombre());
			pstm.setString(3, bean.getCorreo());
			pstm.setString(4, bean.getTelefono());
            java.sql.Date fecha = new java.sql.Date(bean.getFecha().getTime());
            pstm.setDate(5, fecha); // Usa setDate para DATE
			pstm.setInt(6, bean.getCodigoTipo());
			pstm.setInt(7, bean.getCod_emp());
			pstm.setInt(8, bean.getCodigo());
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm!= null) pstm.close();
				if(cn!= null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public Cliente findByDNI(int dni) {
		Cliente cli=null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// Paso 1:
			cn=MySqlConexion.getConexion();
			// Paso 2:
			String sql="select *from tb_cliente where dni_cli=?";
			// Paso 3:
			pstm=cn.prepareStatement(sql);
			// Paso 4: Parámetros (No existe en el select)
			/**No existe en el select**/
			pstm.setInt(1, dni);
			// Paso 5: Ejecutar sentencia sql (usar el metodo executeQuery) y guardar el valor en el objeto "rs"
			rs = pstm.executeQuery();
			// Paso 6: Bucle para realizar recorrido sobre "rs"
			if(rs.next()) {
				// Paso 7: Crear objeto cli
				cli = new Cliente();
				// Paso 8: Setear los atributos del objeto "e" con los valores actuales de "rs"
				cli.setCodigo(rs.getInt(1));
				cli.setDni(rs.getInt(2));
				cli.setNombre(rs.getString(3));
				cli.setCorreo(rs.getString(4));
				cli.setTelefono(rs.getString(5));
				cli.setFecha(rs.getDate(6));
				cli.setCodigoTipo(rs.getInt(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cli;
	}
		
	public int actualizarFecha(Cliente cli) {
	    int salida = -1;
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    try {
	        // Paso 1: Obtener la conexión con la base de datos y guardala en "cn"
	        cn = MySqlConexion.getConexion();
	        // Paso 2: Crear la sentencia SQL "update"
	        String sql = "UPDATE tb_cliente SET fecha_cli = ? WHERE cod_cli = ?";
	        // Paso 3: Crear el objeto pstm
	        pstm = cn.prepareStatement(sql);
	        // Paso 4: Asignar valor a los parámetros
	        java.sql.Date fecha = new java.sql.Date(cli.getFecha().getTime());
	        pstm.setDate(1, fecha);
	        pstm.setInt(2, cli.getCodigo());
	        // Paso 5: Ejecutar pstm y guardar su valor de retorno en la variable salida
	        salida = pstm.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            // Validar si los objetos pstm y cn estan creados
	            if (pstm != null) pstm.close();
	            if (cn != null) cn.close();
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }
	    return salida;
	}

	
public Cliente findByID(int dni) {
	Cliente cli=null;
	Connection cn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	try {	
		cn=MySqlConexion.getConexion();
		String sql="select *from tb_cliente where cod_cli=?";
		pstm=cn.prepareStatement(sql);
		pstm.setInt(1, dni);
		rs = pstm.executeQuery();
		if(rs.next()) {
			cli = new Cliente();
			cli.setCodigo(rs.getInt(1));
			cli.setDni(rs.getInt(2));
			cli.setNombre(rs.getString(3));
			cli.setCorreo(rs.getString(4));
			cli.setTelefono(rs.getString(5));
			cli.setFecha(rs.getDate(6));
			cli.setCodigoTipo(rs.getInt(7));
			cli.setCod_emp(rs.getInt(8));
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(rs!=null) rs.close();
			if(pstm!=null) pstm.close();
			if(cn!=null) cn.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	return cli;
}
@Override
public int DeleteByID(int cod) {
	int salida = -1;
	Connection cn = null;
	PreparedStatement pstm = null;
	try {
		cn=MySqlConexion.getConexion();
		String sql="delete from tb_cliente where cod_cli=?";
		pstm = cn.prepareStatement(sql);
		pstm.setInt(1, cod);
		salida = pstm.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(pstm!= null) pstm.close();
			if(cn!= null) cn.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	return salida;
}
	

}
