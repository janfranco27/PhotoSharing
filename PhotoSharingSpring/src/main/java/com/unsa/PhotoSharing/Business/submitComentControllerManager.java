package com.unsa.PhotoSharing.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unsa.PhotoSharing.persistence.Dao.ComentarioDaoImpl;
import com.unsa.PhotoSharing.persistence.Dao.ComentariosDao;
import com.unsa.PhotoSharing.persistence.Dao.UsuarioDao;
import com.unsa.PhotoSharing.persistence.Dao.UsuarioDaoImpl;
import com.unsa.PhotoSharing.persistence.entity.Comentario;
import com.unsa.PhotoSharing.persistence.entity.Usuario;
@Service
@Transactional(readOnly = true)
public class submitComentControllerManager implements submitComentControllerManagerInterface{
	@Autowired
	private  ComentariosDao comentariodao;
	@Autowired
	private UsuarioDao usuariodao;
	
	public void setComentario(Comentario c){
		
		comentariodao = new ComentarioDaoImpl();
		comentariodao.add(c);
	
		
	}
	
	public Usuario getUsuario(int id){
	usuariodao = new UsuarioDaoImpl();
	return usuariodao.getUsuario(id);
		
	}
	
}
