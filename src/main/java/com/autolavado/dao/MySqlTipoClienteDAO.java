package com.autolavado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.autolavado.clases.TipoCliente;
import com.autolavado.interfaces.TipoClienteDAO;
import com.autolavado.utils.MySqlConexion;


public class MySqlTipoClienteDAO implements TipoClienteDAO{
	public List<TipoCliente> findAll() {
		List<TipoCliente> lista = new ArrayList<TipoCliente>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// Paso 1:
			cn=MySqlConexion.getConexion();
			// Paso 2:
			String sql="select *from tb_tipoServicio";
			// Paso 3:
			pstm=cn.prepareStatement(sql);
			// Paso 4: Parámetros (No existe en el select)
			/**No existe en el select**/
			// Paso 5: Ejecutar sentencia sql (usar el metodo executeQuery) y guardar el valor en el objeto "rs"
			rs = pstm.executeQuery();
			// Paso 6: Bucle para realizar recorrido sobre "rs"
			while(rs.next()) {
				// Paso 7: Crear objeto de la clase Cliente
				TipoCliente e = new TipoCliente();
				// Paso 8: Setear los atributos del objeto "e" con los valores actuales de "rs"
				e.setCodigo(rs.getInt(1));
				e.setNombre(rs.getString(2));
				// Paso 9: adicionar objeto "e" dentro del arreglo "lista"
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
