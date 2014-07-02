package com.unsa.PhotoSharing.Controller;

import java.util.Locale;

import javax.faces.context.FacesContext;

public class IdiomaBean {
	
	private final Locale SPANISH = new Locale("es");
	public String espaniolAction(){
		FacesContext context = FacesContext.getCurrentInstance();
		context.getViewRoot().setLocale(SPANISH);
		return null;
	}
	
	public String inglesAction(){
		FacesContext context = FacesContext.getCurrentInstance();
		context.getViewRoot().setLocale(Locale.US);
		return null;
	}

}
