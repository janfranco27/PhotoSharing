package com.unsa.PhotoSharing.Business;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.unsa.PhotoSharing.persistence.Dao.UsuarioDao;
import com.unsa.PhotoSharing.persistence.Dao.UsuarioDaoImpl;
import com.unsa.PhotoSharing.persistence.entity.Foto;
import com.unsa.PhotoSharing.persistence.entity.Usuario;

public class UserHomeManager 
{
	private UsuarioDao userDao;
	private Usuario user;
	
	public UserHomeManager ()
	{
		userDao = new UsuarioDaoImpl();
	}

	public Usuario getUsuario (int user_id)
	{
		user = userDao.getUsuario(user_id);
		if (user != null) return user;
		return null;
	}
	
	public List<Foto> getUsuarioFotos(Usuario usuario) 
	{
		return userDao.getUsuarioFotos(usuario);
	}
	
	public List<String> getLastNews(Usuario usuario)
	{
		return userDao.getLastNews(usuario);
	}
	
	public void editUsuario(Usuario usuario)
	{
		userDao.edit(usuario);
	}
}
