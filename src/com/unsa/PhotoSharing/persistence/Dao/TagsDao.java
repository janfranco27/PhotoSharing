package com.unsa.PhotoSharing.persistence.Dao;

import java.util.List;

import com.unsa.PhotoSharing.persistence.entity.Tags;



public interface TagsDao {
	public void add(Tags tags);
	public void edit(Tags tags);
	public void delete(int tagsId);
	public Tags getTags(int tagsId);
	public List<Tags> getAllTags();
}
