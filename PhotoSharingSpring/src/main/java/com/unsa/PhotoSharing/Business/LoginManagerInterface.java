package com.unsa.PhotoSharing.Business;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.unsa.PhotoSharing.persistence.Dao.UsuarioDaoImpl;
import com.unsa.PhotoSharing.persistence.entity.Usuario;

public interface LoginManagerInterface {
	public boolean login (String nickname, String password);	
	public void sessionInit(HttpServletRequest request, HttpServletResponse response);
	public void sessionClose(HttpServletRequest request);
	public Usuario getUser();
	public void register();
}
