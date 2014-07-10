package com.unsa.PhotoSharing.Controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.unsa.PhotoSharing.Business.LoginManager;
import com.unsa.PhotoSharing.persistence.entity.Usuario;

public class LoginAction extends ActionSupport implements SessionAware  {
	
	private String nickname;
	private String password;
	private  Map<String, Object> session;
	private Usuario user;
	private LoginManager manager;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String validateLogin() {

		System.out.println("salida" + nickname +"-" +password);
		
		manager = new LoginManager();
		
		if(manager.login(nickname, password))
		{
			System.out.println("validate STRUTS");
			user = manager.getUser();
			session.put("user", user);
			HttpSession session = ServletActionContext.getRequest().getSession();
            session.setAttribute("logined","true");
			return SUCCESS;
			
		}
		else
		{
			return ERROR;
		}	
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String dni) {
		this.nickname = dni;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Map<String, Object> getSession() {
		return session;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

}
