package com.unsa.PhotoSharing.persistence.Dao;

import java.util.List;

import com.unsa.PhotoSharing.persistence.entity.Comentarios;

public interface ComentariosDao {
	public void add(Comentarios comentario);
	public void edit(Comentarios comentario);
	public void delete(int comentarioId);
	public Comentarios getComentarios(int comentarioId);
	public List<Comentarios> getAllComentarios();

}
