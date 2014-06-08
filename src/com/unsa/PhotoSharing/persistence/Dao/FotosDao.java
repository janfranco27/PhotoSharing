package com.unsa.PhotoSharing.persistence.Dao;

import java.util.List;

import com.unsa.PhotoSharing.persistence.entity.Foto;

public interface FotosDao {
	public void add(Foto foto);
	public void edit(Foto foto);
	public void delete(int fotoId);
	public Foto getFoto(int fotoId);
	public List<Foto> getAllFotos();
}
