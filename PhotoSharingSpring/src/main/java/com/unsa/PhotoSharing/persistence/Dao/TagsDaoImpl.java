package com.unsa.PhotoSharing.persistence.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unsa.PhotoSharing.persistence.entity.Tag;
@Repository("tagsDao")
public class TagsDaoImpl implements TagsDao {
	@Autowired
	private SessionFactory session;
	
	public TagsDaoImpl()
	{
		session = SessionFactoryUtil.getInstance();
	}
	
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

		Session s = session.getCurrentSession();
		Transaction trans=s.beginTransaction();
		
		List<Tag> listTags = (List<Tag>)s.createQuery("from Tag").list();
		trans.commit();
		return listTags;
	}

}
