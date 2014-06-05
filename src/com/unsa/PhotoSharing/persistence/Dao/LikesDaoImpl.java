package com.unsa.PhotoSharing.persistence.Dao;

import java.util.List;

import org.hibernate.SessionFactory;


import com.unsa.PhotoSharing.persistence.entity.Likes;

public class LikesDaoImpl implements LikesDao {
	private SessionFactory session;
	@Override
	public void add(Likes likes) {
		// TODO Auto-generated method stub
		this.session.getCurrentSession().save(likes);
	}

	@Override
	public void edit(Likes likes) {
		// TODO Auto-generated method stub
		this.session.getCurrentSession().update(likes);
	}

	@Override
	public void delete(int likesId) {
		// TODO Auto-generated method stub
		Likes likesDell = (Likes)this.session.getCurrentSession().get(Likes.class,likesId);
		if(likesDell != null)
		{
			this.session.getCurrentSession().delete(likesDell);
		}
	}

	@Override
	public Likes getLikes(int likesId) {
		// TODO Auto-generated method stub
		return (Likes)this.session.getCurrentSession().get(Likes.class,likesId);

	}

	@Override
	public List<Likes> getAllLikes() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Likes> listLikes = (List<Likes>)this.session.getCurrentSession().createQuery("from Likes").list();
		return listLikes;
	}

}
