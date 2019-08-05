package com.practicacrud2.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
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

/**
 * Servlet implementation class TransaccionesServlet
 */
@WebServlet("/TransaccionesServlet")
public class TransaccionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransaccionesServlet() {
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
		String sentenciaSQL = props.getProperty("sentenciaSQLReadIndividualProductos");
		String insert1="INSERT INTO productos VALUES(90,'Chorizo',70.0, 70)";
		String insert2="INSERT INTO productos VALUES(91,'Queso',52.5, 71)";
		String insert3="INSERT INTO productos VALUES(92,'Jamon',15, 72)";
		String insert4="INSERT INTO productos VALUES(93,'Carne',90.0, 73)";
		String insert5="INSERT INTO productos VALUES(94,'Pollo',95, 74)";

		// objetos conexion
		Connection conn = null;
		PreparedStatement pstmnt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(miDriver).getDeclaredConstructor().newInstance();
			conn = DriverManager.getConnection(urlServidor, user, pass);
			conn.setAutoCommit(false);
			
			pstmnt = conn.prepareStatement(insert1);
			pstmnt.executeUpdate();
			
			pstmnt = conn.prepareStatement(insert2);
			pstmnt.executeUpdate();
			
			pstmnt = conn.prepareStatement(insert3);
			pstmnt.executeUpdate();
			
			pstmnt = conn.prepareStatement(insert4);
			pstmnt.executeUpdate();
			
			pstmnt = conn.prepareStatement(insert5);
			pstmnt.executeUpdate();
			
			conn.commit();
			pstmnt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				pstmnt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
