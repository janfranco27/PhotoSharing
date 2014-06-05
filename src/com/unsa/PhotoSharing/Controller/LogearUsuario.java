package com.unsa.PhotoSharing.Controller;
import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogearUsuario
 */
@WebServlet("/LogearUsuario")
public class LogearUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogearUsuario() {
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
        ResultSet result = null;
        
    	try {
    	    //inserto la tupla en la BD
    		sentencia = c.getConnection().createStatement();

        	String usuario = request.getParameter("usuario");  
        	String password = request.getParameter("password");   
        	
        	String query = "SELECT * FROM usuario WHERE Nickname = '" + usuario + "' and Password = '" + password + "';";
        	System.out.println(query);
        	result = sentencia.executeQuery(query);
        	
        	if (!result.isBeforeFirst() ) {    
        		 tituloHTML (out, "NO hay resultados",true); 
        	} 
        	else
        	{
	        	while (result.next())
	        	{
	        		out.println(result.getObject (1).toString() + "\t\t\t");
	        		out.println(result.getObject (2).toString() + "\t\t\t");
	        		out.println(result.getObject (3).toString() + "\t\t\t");
	        		out.println(result.getObject (4).toString() + "\t\t\t");
	        		out.println(result.getObject (5).toString() + "\t\t\t");
	        		out.println(result.getObject (6).toString() + "\t\t\t");
	        		
	        	    tituloHTML(out,"Logeado con exito",true);

	        	}
        	}
            
    	} catch (SQLException e2) {
    	    tituloHTML(out,"Error en la busqueda "+e2.getMessage(),true);
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