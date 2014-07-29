package com.unsa.PhotoSharing.Business;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unsa.PhotoSharing.persistence.Dao.UsuarioDao;
import com.unsa.PhotoSharing.persistence.Dao.UsuarioDaoImpl;
import com.unsa.PhotoSharing.persistence.entity.Foto;
import com.unsa.PhotoSharing.persistence.entity.Usuario;
@Service
@Transactional(readOnly = true)
public class UserHomeManager implements UserHomeManagerInterface 
{
	@Autowired
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
	@Transactional(readOnly = false)
	public void editUsuario(Usuario usuario)
	{
		userDao.edit(usuario);
	}
}
