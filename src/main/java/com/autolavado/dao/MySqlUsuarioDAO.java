package com.autolavado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.autolavado.clases.Empleado;
import com.autolavado.clases.Enlace;
import com.autolavado.interfaces.UsuarioDAO;
import com.autolavado.utils.MySqlConexion;

public class MySqlUsuarioDAO implements UsuarioDAO{

	@Override
	public Empleado findByLoginInClave(String login, String clave) {
		Empleado emp=null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn=MySqlConexion.getConexion();
			String sql="select e.cod_emp,e.nom_emp,\r\n"
					+ "		u.idrol from tb_empleado e join tb_usuario u \r\n"
					+ "        on u.cod_emp=e.cod_emp where u.login=? \r\n"
					+ "        and u.password=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, login);
			pstm.setString(2, clave);
			rs = pstm.executeQuery();
			if(rs.next()) {
				emp = new Empleado();
				emp.setCodigo(rs.getInt(1));
				emp.setNombre(rs.getString(2));
				emp.setIdRol(rs.getInt(3));
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
		return emp;		
		
		
	}

	@Override
	public List<Enlace> findByEnlacesInRol(int codRol) {
	
		List<Enlace> lista = new ArrayList<Enlace>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn=MySqlConexion.getConexion();
			String sql="select e.idenlace,e.descripcion,e.ruta,e.tipo \r\n"
					+ "from tb_rol_enlace re join tb_enlace e on\r\n"
					+ "re.idenlace=e.idenlace where re.idrol=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, codRol);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Enlace e = new Enlace();
				e.setCodigo(rs.getInt(1));
				e.setDescripcion(rs.getString(2));
				e.setRuta(rs.getString(3));
				e.setTipo(rs.getString(4).charAt(0));
				lista.add(e);
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
		return lista;
	}
		
		
		
		
		
	}


