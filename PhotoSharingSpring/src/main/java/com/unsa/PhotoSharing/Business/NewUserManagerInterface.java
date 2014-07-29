package com.unsa.PhotoSharing.Business;

import java.io.File;

import com.unsa.PhotoSharing.persistence.Dao.UsuarioDaoImpl;
import com.unsa.PhotoSharing.persistence.entity.Usuario;

public interface NewUserManagerInterface {
	public void insert(String nombre, String apellidos, String email, String nickname, String password);
	
}
