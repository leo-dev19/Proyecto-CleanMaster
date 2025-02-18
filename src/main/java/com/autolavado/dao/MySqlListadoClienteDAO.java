package com.autolavado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.autolavado.clases.Cliente;
import com.autolavado.utils.MySqlConexion;

public class MySqlListadoClienteDAO {

    public List<Cliente> findAll() {
        List<Cliente> lista = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            cn = MySqlConexion.getConexion();
            String sql = "SELECT c.*, e.nom_emp, s.nom_tipo " +
                         "FROM tb_cliente c " +
                         "LEFT JOIN tb_empleado e ON c.cod_emp = e.cod_emp " +
                         "LEFT JOIN tb_tipoServicio s on c.cod_tipo = s.cod_tipo";
            pstm = cn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Cliente e = new Cliente();
                e.setCodigo(rs.getInt("cod_cli"));
                e.setDni(rs.getInt("dni_cli"));
                e.setNombre(rs.getString("nom_cli"));
                e.setCorreo(rs.getString("correo_cli"));
                e.setTelefono(rs.getString("tele_cli"));
                e.setFecha(rs.getDate("fecha_cli"));
                e.setCodigoTipo(rs.getInt("cod_tipo"));
                // El nombre del empleado se obtiene directamente del resultado de la consulta
                e.setNombreLimpiador(rs.getString("nom_emp"));
                e.setNombreServicio(rs.getString("nom_tipo"));
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
        return lista;
    }
}