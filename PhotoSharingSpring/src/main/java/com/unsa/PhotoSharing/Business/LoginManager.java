package com.unsa.PhotoSharing.Business;

import java.io.IOException;

import javax.security.auth.spi.LoginModule;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unsa.PhotoSharing.persistence.Dao.UsuarioDao;
import com.unsa.PhotoSharing.persistence.Dao.UsuarioDaoImpl;
import com.unsa.PhotoSharing.persistence.entity.Usuario;

@Service
@Transactional(readOnly = true)
public class LoginManager implements LoginManagerInterface
{
	@Autowired
	private UsuarioDao userDao;
	Usuario user;
	
	@Transactional(readOnly = false)
	public boolean login (String nickname, String password)
	{
		System.out.println("ssss");
		userDao = new UsuarioDaoImpl();
		user = userDao.loginUsuario(nickname, password);
		if(user != null) return true;
		return false;
	}
	@Transactional(readOnly = false)
	public void sessionInit(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setMaxInactiveInterval(30*60);
        Cookie userName = new Cookie("user", user.getNombre());
        userName.setMaxAge(30*60);
        response.addCookie(userName);
        try {
			response.sendRedirect("home.jsp?user_id=" + user.getIdUsuario());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sessionClose(HttpServletRequest request)
	{
		request.getSession().invalidate();
		
	}
	
	public Usuario getUser()
	{
		return user;
	}
	public void register(){
		
	}
	
	
}
