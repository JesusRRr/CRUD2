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
 * Servlet implementation class DeletePrepareServlet
 */
@WebServlet("/DeletePrepareServlet")
public class DeletePrepareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePrepareServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
		
	
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
	String sentenciaSQL = props.getProperty("sentenciaSQLDeleteProductos");

	// objetos conexion
	Connection conn = null;
	PreparedStatement pstmnt = null;
	ResultSet rs = null;
	
	int nRegistros=0;
	Productos miProducto=new Productos();
	
	int idProducto = Integer.parseInt(request.getParameter("txtIdProducto"));
	
	try 
	{
		//Paso 3. Inicializar el driver
		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		//Paso 4. Abrir la conexión
		conn = DriverManager.getConnection(urlServidor, user, pass);
		
		pstmnt = conn.prepareStatement(sentenciaSQL);
		//Paso 5. Preparar el comando SQL a ejecutar
		
		pstmnt.setInt(1, miProducto.getIdProducto());
		
		nRegistros = pstmnt.executeUpdate(sentenciaSQL);
		if(nRegistros>0)
			response.getWriter().print("Sí se borro el registro");
	} catch (Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		try {
			//Paso 7. Cerrar las conexiones.
			pstmnt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

response.getWriter().append("miTesto1");
}	

}
