package com.practicacrud2.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practicacrud2.model.Productos;

/**
 * Servlet implementation class ReadGeneralPrepareServlet
 */
@WebServlet("/ReadGeneralPrepareServlet")
public class ReadGeneralPrepareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadGeneralPrepareServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Properties props = new Properties();
		InputStream miStream = null;
		String miArchivoProps = "config.properties";

		miStream = getClass().getClassLoader().getResourceAsStream(miArchivoProps);

		if (miStream != null) {
			props.load(miStream);
		} else {
			throw new FileNotFoundException("Archivo de Propiedades: " + miArchivoProps + " no se encuentra");
		}

		// declarar variables
		String user = props.getProperty("user");
		String pass = props.getProperty("pass");
		String urlServidor = props.getProperty("urlServidor");
		String miDriver = props.getProperty("driver");
		String sentenciaSQL = props.getProperty("sentenciaSQLReadGeneralProductos");

		// objetos conexion
		Connection conn = null;
		PreparedStatement pstmnt = null;
		ResultSet rs = null;

		//int idProducto = Integer.parseInt(request.getParameter("txtIdProducto"));

		//Productos miProducto = new Productos(idProducto, null, 0, 0);
		// cantidad minima de filas a ser modificadas update
	//	final int MIN_ROWS = 0;
	//	int nRows = MIN_ROWS;

		try {
			Class.forName(miDriver).getDeclaredConstructor().newInstance();

			conn = DriverManager.getConnection(urlServidor, user, pass);
			pstmnt = conn.prepareStatement(sentenciaSQL);

			//pstmnt.setInt(1, miProducto.getIdProducto());
			rs = pstmnt.executeQuery();
			
			while (rs.next()) {
				response.getWriter().append("<table>");
				response.getWriter().append("<th>");
				response.getWriter().append("<td>");
				response.getWriter().append("idProducto");
				response.getWriter().append("</td>");
				response.getWriter().append("<td>");
				response.getWriter().append("nombreProducto");
				response.getWriter().append("</td>");
				response.getWriter().append("<td>");
				response.getWriter().append("precioProducto");
				response.getWriter().append("</td>");
				response.getWriter().append("<td>");
				response.getWriter().append("existencias");
				response.getWriter().append("<br>");
				response.getWriter().append("</th>");

				response.getWriter().append("<tr>");
				response.getWriter().append("<td>");
				response.getWriter().append("</td>");
				response.getWriter().append("<td>");
				response.getWriter().append(rs.getString(1));
				response.getWriter().append("</td>");
				response.getWriter().append("<td>");
				response.getWriter().append(rs.getString(2));
				response.getWriter().append("</td>");
				response.getWriter().append("<td>");
				response.getWriter().append("" + rs.getDouble(3));
				response.getWriter().append("</td>");
				response.getWriter().append("<td>");
				response.getWriter().append(rs.getString(4));
				response.getWriter().append("</td>");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmnt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}