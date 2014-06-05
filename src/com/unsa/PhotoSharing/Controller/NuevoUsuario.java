package com.unsa.PhotoSharing.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NuevoUsuario
 */
@WebServlet("/NuevoUsuario")
public class NuevoUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	
    	DBConnection c = DBConnection.getInstance();
        Statement sentencia = null; //Objeto para la ejecutar una sentencia
        PrintWriter out = response.getWriter();
        
    	try {
    	    //inserto la tupla en la BD
    		sentencia = c.getConnection().createStatement();

        	String nombre = request.getParameter("nombre");
        	String apellidos = request.getParameter("apellidos");   
        	String email = request.getParameter("email");   
        	String usuario = request.getParameter("usuario");   
        	String password = request.getParameter("password");   
        	
        	String query = "INSERT INTO usuario (`Nombre`, `Apellidos`, `Nickname`, `Email`, `Password`)" +
	    			"VALUES('"+nombre+"', '"+apellidos+"', '"+usuario+"', '"+email+"', '"+password+"' )";
        	
        	System.out.println(query);
    	    sentencia.executeUpdate(query);
    	    tituloHTML(out,"Insertado correctamente!",true);

    	} catch (SQLException e2) {
    	    tituloHTML(out,"No se ha podido insertar el registro:"+e2.getMessage(),true);
    	} 
    }
    	
    public void tituloHTML(PrintWriter out, String mensaje, boolean volver)
    {
    	out.println("<!-------------------------------------------------------------------->"+
    		    "<!-- TITULO                                                         -->"+
    		    "<!-------------------------------------------------------------------->"+
    		    "<h1><br/>"+mensaje+"<br/>&nbsp;</h1>");
    	
    	if (volver) out.println("<h4><br/><font size=\"+1\" <a href=\"index.html\" onClick=\"history.go(-1); return false;\">VOLVER</a><br/>&nbsp;</h4><br/>");
        }        	
}