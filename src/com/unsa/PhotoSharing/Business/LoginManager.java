package com.unsa.PhotoSharing.Business;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.unsa.PhotoSharing.persistence.Dao.UsuarioDao;
import com.unsa.PhotoSharing.persistence.Dao.UsuarioDaoImpl;
import com.unsa.PhotoSharing.persistence.entity.Usuario;



public class LoginManager 
{
	private UsuarioDao userDao;
	Usuario user;
	
	public boolean login (String nickname, String password)
	{
		userDao = new UsuarioDaoImpl();
		user = userDao.loginUsuario(nickname, password);
		if(user != null) return true;
		return false;
	}
	
	public void sessionInit(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setMaxInactiveInterval(30*60);
        Cookie userName = new Cookie("user", user.getNombre());
        userName.setMaxAge(30*60);
        response.addCookie(userName);
        try {
			response.sendRedirect("LoginSuccess.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sessionClose(){
		
		
	}
	
	public void register(){
		
	}
	
	
}
