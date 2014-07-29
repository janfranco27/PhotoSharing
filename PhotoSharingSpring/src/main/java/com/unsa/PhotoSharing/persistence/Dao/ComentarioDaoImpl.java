package com.unsa.PhotoSharing.persistence.Dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unsa.PhotoSharing.persistence.entity.Comentario;

@Repository("comentariosDao")
public class ComentarioDaoImpl implements ComentariosDao {
	@Autowired
	private SessionFactory session;
	@Override
	public void add(Comentario comentario) {
		// TODO Auto-generated method stub
		this.session.getCurrentSession().save(comentario);
	}

	@Override
	public void edit(Comentario comentario) {
		// TODO Auto-generated method stub
		this.session.getCurrentSession().update(comentario);
	}

	@Override
	public void delete(int comentarioId) {
		// TODO Auto-generated method stub
		Comentario comentarioDell = (Comentario)this.session.getCurrentSession().get(Comentario.class,comentarioId);
		if(comentarioDell != null)
		{
			this.session.getCurrentSession().delete(comentarioDell);
		}
	}

	
	@Override
	public Comentario getComentario(int comentarioId) {
		// TODO Auto-generated method stub
		return (Comentario)this.session.getCurrentSession().get(Comentario.class,comentarioId);

	}

	@Override
	public List<Comentario> getAllComentarios() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Comentario> listComentario = (List<Comentario>)this.session.getCurrentSession().createQuery("from Comentario").list();
		return listComentario;

	}

}
