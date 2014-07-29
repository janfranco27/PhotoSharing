package com.unsa.PhotoSharing.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unsa.PhotoSharing.Business.LoginManager;
import com.unsa.PhotoSharing.persistence.entity.Usuario;

@Controller
public class LoginController {
	
    @RequestMapping(value="/login")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		
		LoginManager manager = new LoginManager();
		if (manager.login (nickname, password))
		{
			manager.sessionInit(request, response);
			HttpSession c = request.getSession();
			Usuario u = (Usuario)c.getAttribute("user");
			System.out.println ("Mi nombre es " + u.getNombre());
        }else
        {
            /*RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Nombre de usuario o contrasenha invalidos.</font>");
            rd.include(request, response);*/
        }

        return new ModelAndView("hello.jsp");
    }

}
