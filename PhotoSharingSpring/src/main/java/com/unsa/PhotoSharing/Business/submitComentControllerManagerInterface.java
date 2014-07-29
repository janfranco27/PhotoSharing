package com.unsa.PhotoSharing.Business;

import com.unsa.PhotoSharing.persistence.Dao.ComentarioDaoImpl;
import com.unsa.PhotoSharing.persistence.Dao.UsuarioDaoImpl;
import com.unsa.PhotoSharing.persistence.entity.Comentario;
import com.unsa.PhotoSharing.persistence.entity.Usuario;

public interface submitComentControllerManagerInterface {
	public void setComentario(Comentario c);
	public Usuario getUsuario(int id);
}
