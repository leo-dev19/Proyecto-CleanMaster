package com.autolavado.controlador;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.autolavado.utils.MySqlConexion; // Importa la clase de conexión

public class GenerarReporteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        try (OutputStream out = response.getOutputStream();
             Connection con = MySqlConexion.getConexion()) { // Obtiene la conexión de la clase de conexión
            Document document = new Document();
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(new Paragraph("Reporte de Clientes"));

            try (PreparedStatement ps = con.prepareStatement("SELECT * FROM tb_cliente");
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    document.add(new Paragraph("Código: " + rs.getInt("cod_cli")));
                    document.add(new Paragraph("DNI: " + rs.getString("dni_cli")));
                    document.add(new Paragraph("Nombre: " + rs.getString("nom_cli")));
                    document.add(new Paragraph("Correo: " + rs.getString("correo_cli")));
                    document.add(new Paragraph("Teléfono: " + rs.getString("tele_cli")));
                    document.add(new Paragraph("Fecha: " + rs.getDate("fecha_cli")));
                    document.add(new Paragraph("Tipo: " + rs.getInt("cod_tipo")));
                    document.add(new Paragraph("---------------------------------------------"));
                }
            }
            document.close();
        } catch (DocumentException | SQLException e) {
            throw new ServletException("Error en la generación del reporte", e);
        }
    }
}