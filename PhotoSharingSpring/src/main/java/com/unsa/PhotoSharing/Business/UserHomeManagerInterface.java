package com.unsa.PhotoSharing.Business;

import java.util.List;

import com.unsa.PhotoSharing.persistence.entity.Foto;
import com.unsa.PhotoSharing.persistence.entity.Usuario;

public interface UserHomeManagerInterface {
	public Usuario getUsuario (int user_id);
	public List<Foto> getUsuarioFotos(Usuario usuario);
	public List<String> getLastNews(Usuario usuario);
	public void editUsuario(Usuario usuario);
}
