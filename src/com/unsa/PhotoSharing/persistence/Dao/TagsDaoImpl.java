package com.unsa.PhotoSharing.persistence.Dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.unsa.PhotoSharing.persistence.entity.Tag;

public class TagsDaoImpl implements TagsDao {
	private SessionFactory session;
	@Override
	public void add(Tag tags) {
		// TODO Auto-generated method stub
		this.session.getCurrentSession().save(tags);
	}

	@Override
	public void edit(Tag tags) {
		// TODO Auto-generated method stub
		this.session.getCurrentSession().update(tags);
	}

	@Override
	public void delete(int tagsId) {
		// TODO Auto-generated method stub
		Tag tagsDell = (Tag)this.session.getCurrentSession().get(Tag.class,tagsId);
		if(tagsDell != null)
		{
			this.session.getCurrentSession().delete(tagsDell);
		}
	}

	@Override
	public Tag getTag(int tagsId) {
		// TODO Auto-generated method stub
		return (Tag)this.session.getCurrentSession().get(Tag.class,tagsId);
	}

	@Override
	public List<Tag> getAllTags() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Tag> listTags = (List<Tag>)this.session.getCurrentSession().createQuery("from Tag").list();
		return listTags;
	}

}
