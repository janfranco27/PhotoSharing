package com.unsa.PhotoSharing.persistence.Dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.unsa.PhotoSharing.persistence.entity.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {
	private SessionFactory session;
	
	public UsuarioDaoImpl ()
	{
		session = SessionFactoryUtil.getInstance();
	}
	
	@Override
	public void add(Usuario usuario) {
		// TODO Auto-generated method stub
		Session s = session.getCurrentSession();
		System.out.println("añadir");
		Transaction trans=s.beginTransaction();
		s.save(usuario);
		trans.commit();
	}

	@Override
	public void edit(Usuario usuario) {
		// TODO Auto-generated method stub
		this.session.getCurrentSession().update(usuario);
	}

	@Override
	public void delete(int usuarioId) {
		// TODO Auto-generated method stub
		Usuario usuarioDell = (Usuario)this.session.getCurrentSession().get(Usuario.class,usuarioId);
		if(usuarioDell != null)
		{
			this.session.getCurrentSession().delete(usuarioDell);
		}
	}

	@Override
	public Usuario getUsuario(int usuarioId) {
		// TODO Auto-generated method stub
		return (Usuario)this.session.getCurrentSession().get(Usuario.class,usuarioId);
	}

	@Override
	public List<Usuario> getAllUsuario() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Usuario> listUsuario = (List<Usuario>)this.session.getCurrentSession().createQuery("from Usuario").list();
		return listUsuario;
	}

	@Override
	public Usuario loginUsuario(String nickname, String password) {
		// TODO Auto-generated method stub
		
		Usuario u = null;
		Session s = session.getCurrentSession();
		System.out.println("añadir");
		Transaction trans=s.beginTransaction();
		Query query= s.createQuery("FROM Usuario U WHERE U.nickname = :nickname and U.password = :password");
		query.setParameter("nickname", nickname);
		query.setParameter("password", password);
		
		List user = query.list();
		Iterator listIterator = user.iterator();
        while(listIterator.hasNext())
        {
            Usuario rd = (Usuario) listIterator.next();
            System.out.println("UserId :" +rd.getNombre());
            System.out.println("Mail Id :" +rd.getEmail());
            u = rd;
        }
		
		trans.commit();
		return u;
	}

}
