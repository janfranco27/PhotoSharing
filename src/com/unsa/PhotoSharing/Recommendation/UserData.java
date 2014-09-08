package com.unsa.PhotoSharing.Recommendation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.unsa.PhotoSharing.persistence.Dao.UsuarioDao;
import com.unsa.PhotoSharing.persistence.Dao.UsuarioDaoImpl;
import com.unsa.PhotoSharing.persistence.entity.Usuario;

public class UserData 
{
	private List<Integer> usersId;
	private List<List<Boolean>> isFriend;
	private UsuarioDao userDao;
	
	public UserData()
	{
		userDao = new UsuarioDaoImpl();
		usersId = new ArrayList<>();
		isFriend = new ArrayList<>();
		getData();
	}
	
	public void getData()
	{
		List<Usuario> users = userDao.getAllUsuario();
		for (Usuario u : users)
		{
			usersId.add(u.getIdUsuario());
		}
		
		Collections.sort(usersId);
		
		for (Integer i : usersId)
		{
			List<Usuario> friends = userDao.getAmigos(userDao.getUsuario(i));
			List<Integer> friendsIDs = new ArrayList<>();
			friendsIDs.add(i);
			for(Usuario f : friends)
			{
				friendsIDs.add(f.getIdUsuario());
			}
			Collections.sort(friendsIDs);
			
			System.out.println("Friends " + i + ": "+ friendsIDs);
			
			List<Boolean> rowMatrix = new ArrayList<>();
			for(int j = 0; j < usersId.size(); j++)
			{
				if(friendsIDs.contains(usersId.get(j)))
					rowMatrix.add(true);
				else
					rowMatrix.add(false);
			}
			isFriend.add(rowMatrix);
		}
		
		System.out.println("USERSID: "+ usersId);
		for(int i = 0; i < isFriend.size(); i++)
		{
			System.out.println();
			for (int j = 0; j < isFriend.get(i).size(); j++)
				System.out.print(isFriend.get(i).get(j)+ " ");
		}
		
	}
	
	public List<Integer> getUsersId() {
		return usersId;
	}

	public void setUsersId(List<Integer> usersId) {
		this.usersId = usersId;
	}

	public List<List<Boolean>> getIsFriend() {
		return isFriend;
	}

	public void setIsFriend(List<List<Boolean>> isFriend) {
		this.isFriend = isFriend;
	}

}
