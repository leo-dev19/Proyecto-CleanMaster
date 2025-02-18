package com.autolavado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.autolavado.clases.Cliente;
import com.autolavado.clases.Empleado;
import com.autolavado.interfaces.EmpleadoDAO;
import com.autolavado.utils.MySqlConexion;

public class MySqlEmpleadoDAO implements EmpleadoDAO {

	@Override
	public List<Empleado> findAll() {
		 List<Empleado> lista = new ArrayList<>();
	        Connection cn = null;
	        PreparedStatement pstm = null;
	        ResultSet rs = null;
	        try {
	            cn = MySqlConexion.getConexion();
	            String sql = "select * from tb_empleado";
	            pstm = cn.prepareStatement(sql);
	            rs = pstm.executeQuery();
	            while (rs.next()) {
	                Empleado e = new Empleado();
	                e.setCodigo(rs.getInt("cod_emp"));
	                e.setNombre(rs.getString("nom_emp"));
	                lista.add(e);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (pstm != null) pstm.close();
	                if (cn != null) cn.close();
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	        }
	        return lista;	}
	
	
	@Override
	public List<Empleado> findByTipoEmpleado(int cod_tipoemp) {
		 List<Empleado> lista = new ArrayList<>();
	        Connection cn = null;
	        PreparedStatement pstm = null;
	        ResultSet rs = null;
	        try {
	            cn = MySqlConexion.getConexion();
	            String sql = "select * from tb_empleado where cod_tipoemp = ?";
	            pstm = cn.prepareStatement(sql);
	            pstm.setInt(1, cod_tipoemp);
	            rs = pstm.executeQuery();
	            while (rs.next()) {
	                Empleado e = new Empleado();
	                e.setCodigo(rs.getInt("cod_emp"));
	                e.setNombre(rs.getString("nom_emp"));
	                lista.add(e);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (pstm != null) pstm.close();
	                if (cn != null) cn.close();
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	        }
	        return lista;	}
	

}
