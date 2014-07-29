package com.unsa.PhotoSharing.persistence.Dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unsa.PhotoSharing.persistence.entity.Comentario;
import com.unsa.PhotoSharing.persistence.entity.Foto;
@Repository("fotosDao")
public class FotosDaoImpl implements FotosDao {
	@Autowired
	private SessionFactory session;
	
	public FotosDaoImpl()
	{
		session = SessionFactoryUtil.getInstance();
	}
	
	@Override
	public void add(Foto fotos) {
		// TODO Auto-generated method stub
		Session s = session.getCurrentSession();
		System.out.println("añadir foto");
		Transaction trans=s.beginTransaction();
		s.save(fotos);
		trans.commit();
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

	@Override
	public int getLastInsertedId()
	{
		Session s = session.getCurrentSession();
		System.out.println("last id");
		Transaction trans=s.beginTransaction();
		Query query= s.createSQLQuery("SELECT COUNT(idFoto) AS id FROM foto").addScalar("id");
		List<BigInteger> result = query.list();
		int lastInserted = result.get(0).intValue();
		trans.commit();
		return lastInserted;
	}

	@Override
	public List<Comentario> getFotoComentario(Foto foto) {
		Session s = session.getCurrentSession();
		List<Comentario> result = new ArrayList<Comentario>();
		Set <Comentario> setResult;
		
		setResult = foto.getComentarios();
		Transaction t = s.beginTransaction();
		t.commit();
		for (Comentario c : setResult)
		{
			result.add(c);
		}
		
	    s.close();
		System.out.println(result);

		return result;
	}
}
