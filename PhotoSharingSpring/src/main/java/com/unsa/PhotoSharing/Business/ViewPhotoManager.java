package com.unsa.PhotoSharing.Business;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unsa.PhotoSharing.persistence.Dao.FotosDao;
import com.unsa.PhotoSharing.persistence.Dao.FotosDaoImpl;
import com.unsa.PhotoSharing.persistence.entity.Comentario;
import com.unsa.PhotoSharing.persistence.entity.Foto;
@Service
@Transactional(readOnly = true)
public class ViewPhotoManager {
	@Autowired
	private FotosDao fotodao;
	
	public ViewPhotoManager(){
		fotodao = new FotosDaoImpl();
	}
	
	public Set<Comentario> getComentarios(int fotoId){
		
		
		Foto foto =fotodao.getFoto(fotoId);
		Set<Comentario> comentarios = foto.getComentarios(); 
		return comentarios;
		
	}
	
	public Foto getFoto(int fotoId){		
		Foto foto =fotodao.getFoto(fotoId);
		return foto;		
	}
	
	public List<Comentario> getFotoComentarios(Foto foto ){		
		return fotodao.getFotoComentario(foto);		
		
	}
	

}
