package com.unsa.PhotoSharing.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.unsa.PhotoSharing.Business.UserHomeManager;
import com.unsa.PhotoSharing.persistence.entity.Usuario;

@Controller
public class UserHomeController {
@Autowired
private UserHomeManager manager;
	
    public UserHomeController() {
        super();
        // TODO Auto-generated constructor stub
        manager = new UserHomeManager();
    }
    
    public Usuario getUser (int user_id)
	{
		return manager.getUsuario(user_id);
	}
}
