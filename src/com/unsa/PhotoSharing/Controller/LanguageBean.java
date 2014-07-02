package com.unsa.PhotoSharing.Controller;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
 
@ManagedBean
@SessionScoped
public class LanguageBean implements Serializable{
 
	private static final long serialVersionUID = 1L;
 	private String localeCode;
	//private final static Locale SPANISH = new Locale("es");
 	public static  Map<String,Object> countries;
	
	public String getLocaleCode() {
		return localeCode;
	}
 
	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}
 	
	public Map<String, Object> getCountries() {
		return countries;
	}


	public void setCountries(Map<String, Object> countries) {
		LanguageBean.countries = countries;
	}

	static{
		countries = new LinkedHashMap<String,Object>();
		countries.put("English", Locale.ENGLISH); //label, value
		Locale espanol = new Locale("ES");
		countries.put("Spanish", espanol);
	}
 
	//value change event listener
	public void countryLocaleCodeChanged(ValueChangeEvent e){
 
	System.out.println(e.getNewValue().toString());
	String newLocaleValue = e.getNewValue().toString();
	System.out.println("LOCALIDAD "+newLocaleValue );
	  for (Map.Entry<String, Object> entry : countries.entrySet()) {
         	   if(entry.getValue().toString().equals(newLocaleValue)){
         		FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale)entry.getValue());
 
        	  }
       }
	}
 
}