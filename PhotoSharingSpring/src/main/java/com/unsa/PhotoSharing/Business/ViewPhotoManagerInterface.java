package com.unsa.PhotoSharing.Business;

import java.util.List;
import java.util.Set;

import com.unsa.PhotoSharing.persistence.entity.Comentario;
import com.unsa.PhotoSharing.persistence.entity.Foto;

public interface ViewPhotoManagerInterface {
	public Set<Comentario> getComentarios(int fotoId);	
	public Foto getFoto(int fotoId);	
	public List<Comentario> getFotoComentarios(Foto foto );
}
