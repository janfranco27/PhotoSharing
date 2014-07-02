package com.unsa.PhotoSharing.Controller;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.unsa.PhotoSharing.Business.LoginManager;
import com.unsa.PhotoSharing.persistence.entity.Usuario;

public class LoginBeanController {
	String nickname;
	String password;
	public LoginBeanController(){
		super();
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login(){		
		
		LoginManager manager = new LoginManager();
		if (manager.login (nickname, password))
		{
			System.out.println("Existe el usuario");
			return "login";

        }else
        {
        	System.out.println("NO existe Usuario");
        	return "errorlogin";

        }
		
	}
	 
}
