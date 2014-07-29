package com.unsa.PhotoSharing.Business;

import java.io.File;
import java.util.Date;

import org.apache.commons.fileupload.FileItem;

import com.unsa.PhotoSharing.persistence.entity.Foto;
import com.unsa.PhotoSharing.persistence.entity.Usuario;

public interface UploadManagerInterface {
	
	public boolean uploadFile (String uploadFolder, String fileName, int user_id, String description, FileItem item);	
	public boolean uploadProfilePhoto (String uploadFolder, String fileName, Usuario user, FileItem item);
}
