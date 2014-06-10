package com.unsa.PhotoSharing.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unsa.PhotoSharing.Business.LoginManager;
import com.unsa.PhotoSharing.Business.NewUserManager;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		
		LoginManager manager = new LoginManager();
		if (manager.login (nickname, password))
		{
			manager.sessionInit(request, response);
			
        }else
        {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Nombre de usuario o contrase�a inv�lidos.</font>");
            rd.include(request, response);
        }
	}

}
