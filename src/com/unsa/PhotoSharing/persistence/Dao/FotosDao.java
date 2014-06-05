package com.unsa.PhotoSharing.persistence.Dao;

import java.util.List;

import com.unsa.PhotoSharing.persistence.entity.Fotos;

public interface FotosDao {
	public void add(Fotos fotos);
	public void edit(Fotos fotos);
	public void delete(int fotosId);
	public Fotos getFotos(int fotosId);
	public List<Fotos> getAllFotos();
}
