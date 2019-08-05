package com.practicacrud2.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practicacrud2.model.Productos;

/**
 * Servlet implementation class CrearPrepareServlet
 */
@WebServlet("/CrearPrepareServlet")
public class CrearPrepareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearPrepareServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		int idProducto = Integer.parseInt(request.getParameter("txtIdProducto"));
		String nombreProducto = request.getParameter("txtNombreProducto");
		Double precioProducto = Double.parseDouble(request.getParameter("txtPrecioProducto"));
		int existenciaProducto = Integer.parseInt(request.getParameter("txtExistenciaProducto"));
		
		Productos miProducto=new Productos(idProducto,nombreProducto,precioProducto,existenciaProducto);
		
		String user="root";
		String pass="root";
		String urlServidor="jdbc:mysql://localhost:3306/norris?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		int nRegistros;
		
		Connection conn=null;
		PreparedStatement pstmnt=null;
		String sentenciaSQL="INSERT INTO productos (idProducto, nombreProducto, precioProducto,existencias) VALUES(?,?,?,?)";
		
		//Paso 3. Inicializar el driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			//Paso 4. Abrir la conexión
			conn = DriverManager.getConnection(urlServidor, user, pass);
			
			//Paso 5. Preparar el comando SQL a ejecutar
			pstmnt = conn.prepareStatement(sentenciaSQL);
			//Paso 6. Ejecutar el comando SQL en la BD
			pstmnt.setInt(1, miProducto.getIdProducto());
			pstmnt.setString(2, miProducto.getNombreProducto());
			pstmnt.setDouble(3, miProducto.getPrecioProducto());
			pstmnt.setInt(4, miProducto.getExistenciasProducto());
			//Paso 7. Ejecutar el pstmnt
			nRegistros = pstmnt.executeUpdate();
			if(nRegistros>0)
				response.getWriter().append("<h1>El regisro fue creado con exito en CrearPS.</h1>");
		}
		
		catch (Exception e) {
			
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
