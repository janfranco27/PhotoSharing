package com.unsa.PhotoSharing.Business;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unsa.PhotoSharing.persistence.Dao.UsuarioDao;
import com.unsa.PhotoSharing.persistence.Dao.UsuarioDaoImpl;
import com.unsa.PhotoSharing.persistence.entity.Usuario;
@Service
@Transactional(readOnly = true)
public class NewUserManager  implements NewUserManagerInterface
{
	@Autowired
	private UsuarioDao userDao;
	@Transactional(readOnly = false)
	public void insert(String nombre, String apellidos, String email, String nickname, String password)
	{
		Usuario user = new Usuario();
		user.setNombre(nombre);
		user.setApellidos(apellidos);
		user.setEmail(email);
		user.setNickname(nickname);
		user.setPassword(password);
		user.setProfilePhoto("images" + File.separator + "no_user_image.png");
		userDao = new UsuarioDaoImpl();
		userDao.add(user);
		
	}
}
