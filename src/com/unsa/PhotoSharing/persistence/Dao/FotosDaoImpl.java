package com.unsa.PhotoSharing.persistence.Dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.unsa.PhotoSharing.persistence.entity.Foto;

public class FotosDaoImpl implements FotosDao {
	private SessionFactory session;
	@Override
	public void add(Foto fotos) {
		// TODO Auto-generated method stub
		this.session.getCurrentSession().save(fotos);
	}

	@Override
	public void edit(Foto fotos) {
		// TODO Auto-generated method stub
		this.session.getCurrentSession().update(fotos);
	}

	@Override
	public void delete(int fotosId) {
		// TODO Auto-generated method stub
		Foto fotosDell = (Foto)this.session.getCurrentSession().get(Foto.class,fotosId);
		if(fotosDell != null)
		{
			this.session.getCurrentSession().delete(fotosDell);
		}
	}

	@Override
	public Foto getFoto(int fotosId) {
		// TODO Auto-generated method stub
		return (Foto)this.session.getCurrentSession().get(Foto.class,fotosId);

	}

	@Override
	public List<Foto> getAllFotos() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Foto> listFotos = (List<Foto>)this.session.getCurrentSession().createQuery("from Foto").list();
		return listFotos;
	}

}
