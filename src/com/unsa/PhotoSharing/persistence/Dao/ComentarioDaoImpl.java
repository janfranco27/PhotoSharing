package com.unsa.PhotoSharing.persistence.Dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.unsa.PhotoSharing.persistence.entity.Comentarios;

public class ComentarioDaoImpl implements ComentariosDao {
	private SessionFactory session;
	@Override
	public void add(Comentarios comentario) {
		// TODO Auto-generated method stub
		this.session.getCurrentSession().save(comentario);
	}

	@Override
	public void edit(Comentarios comentario) {
		// TODO Auto-generated method stub
		this.session.getCurrentSession().update(comentario);
	}

	@Override
	public void delete(int comentarioId) {
		// TODO Auto-generated method stub
		Comentarios comentarioDell = (Comentarios)this.session.getCurrentSession().get(Comentarios.class,comentarioId);
		if(comentarioDell != null)
		{
			this.session.getCurrentSession().delete(comentarioDell);
		}
	}

	
	@Override
	public Comentarios getComentarios(int comentarioId) {
		// TODO Auto-generated method stub
		return (Comentarios)this.session.getCurrentSession().get(Comentarios.class,comentarioId);

	}

	@Override
	public List<Comentarios> getAllComentarios() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Comentarios> listComentarios = (List<Comentarios>)this.session.getCurrentSession().createQuery("from Comentarios").list();
		return listComentarios;

	}

}
