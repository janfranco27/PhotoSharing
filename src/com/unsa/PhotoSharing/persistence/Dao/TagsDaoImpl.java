package com.unsa.PhotoSharing.persistence.Dao;

import java.util.List;

import org.hibernate.SessionFactory;


import com.unsa.PhotoSharing.persistence.entity.Tags;

public class TagsDaoImpl implements TagsDao {
	private SessionFactory session;
	@Override
	public void add(Tags tags) {
		// TODO Auto-generated method stub
		this.session.getCurrentSession().save(tags);
	}

	@Override
	public void edit(Tags tags) {
		// TODO Auto-generated method stub
		this.session.getCurrentSession().update(tags);
	}

	@Override
	public void delete(int tagsId) {
		// TODO Auto-generated method stub
		Tags tagsDell = (Tags)this.session.getCurrentSession().get(Tags.class,tagsId);
		if(tagsDell != null)
		{
			this.session.getCurrentSession().delete(tagsDell);
		}
	}

	@Override
	public Tags getTags(int tagsId) {
		// TODO Auto-generated method stub
		return (Tags)this.session.getCurrentSession().get(Tags.class,tagsId);
	}

	@Override
	public List<Tags> getAllTags() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Tags> listTags = (List<Tags>)this.session.getCurrentSession().createQuery("from Tags").list();
		return listTags;
	}

}
