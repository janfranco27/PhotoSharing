package com.unsa.PhotoSharing.Business;

import java.util.ArrayList;
import java.util.List;

import com.unsa.PhotoSharing.persistence.Dao.TagsDaoImpl;
import com.unsa.PhotoSharing.persistence.Dao.UsuarioDaoImpl;
import com.unsa.PhotoSharing.persistence.entity.Tag;
import com.unsa.PhotoSharing.persistence.entity.Usuario;

public interface SearchManagerInterface {	
	public List<String> getSearchResults(String like);
	
}
