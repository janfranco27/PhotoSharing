package com.unsa.PhotoSharing.Controller;

import java.io.PrintWriter;

import com.unsa.PhotoSharing.Business.NewUserManager;

public class NewUserBeanController {
	String nombre;
	String apellidos;
	String email; 
	String nickname;
	String password;
	public NewUserBeanController(){
		super();
		
	}
	
	public String getNombre() {
		return nombre;
		
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	public String registrar(){
		
		
		NewUserManager manager = new NewUserManager();
		manager.insert(nombre, apellidos, email, nickname, password);
		
		return "registro";
		
		
		
		
	}

}
