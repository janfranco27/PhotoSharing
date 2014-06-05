package com.unsa.PhotoSharing.persistence.Dao;

import java.util.List;

import org.hibernate.SessionFactory;


import com.unsa.PhotoSharing.persistence.entity.Fotos;

public class FotosDaoImpl implements FotosDao {
	private SessionFactory session;
	@Override
	public void add(Fotos fotos) {
		// TODO Auto-generated method stub
		this.session.getCurrentSession().save(fotos);
	}

	@Override
	public void edit(Fotos fotos) {
		// TODO Auto-generated method stub
		this.session.getCurrentSession().update(fotos);
	}

	@Override
	public void delete(int fotosId) {
		// TODO Auto-generated method stub
		Fotos fotosDell = (Fotos)this.session.getCurrentSession().get(Fotos.class,fotosId);
		if(fotosDell != null)
		{
			this.session.getCurrentSession().delete(fotosDell);
		}
	}

	@Override
	public Fotos getFotos(int fotosId) {
		// TODO Auto-generated method stub
		return (Fotos)this.session.getCurrentSession().get(Fotos.class,fotosId);

	}

	@Override
	public List<Fotos> getAllFotos() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Fotos> listFotos = (List<Fotos>)this.session.getCurrentSession().createQuery("from Fotos").list();
		return listFotos;
	}

}
