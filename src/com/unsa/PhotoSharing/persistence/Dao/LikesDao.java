package com.unsa.PhotoSharing.persistence.Dao;

import java.util.List;

import com.unsa.PhotoSharing.persistence.entity.Likes;

public interface LikesDao {
	public void add(Likes likes);
	public void edit(Likes likes);
	public void delete(int likesId);
	public Likes getLikes(int likesId);
	public List<Likes> getAllLikes();
}
