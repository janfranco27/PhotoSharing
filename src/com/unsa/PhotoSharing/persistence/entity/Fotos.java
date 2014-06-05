// default package
// Generated 03-jun-2014 9:20:39 by Hibernate Tools 3.4.0.CR1
package com.unsa.PhotoSharing.persistence.entity;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Fotos generated by hbm2java
 */
public class Fotos implements java.io.Serializable {

	private Integer idFoto;
	private Usuario usuario;
	private String photoUrl;
	private Date uploadDate;
	private String descripcion;
	private Set<Comentarios> comentarioses = new HashSet<Comentarios>(0);
	private Set<Tags> tagses = new HashSet<Tags>(0);
	private Set<Likes> likeses = new HashSet<Likes>(0);

	public Fotos() {
	}

	public Fotos(Usuario usuario) {
		this.usuario = usuario;
	}

	public Fotos(Usuario usuario, String photoUrl, Date uploadDate,
			String descripcion, Set<Comentarios> comentarioses,
			Set<Tags> tagses, Set<Likes> likeses) {
		this.usuario = usuario;
		this.photoUrl = photoUrl;
		this.uploadDate = uploadDate;
		this.descripcion = descripcion;
		this.comentarioses = comentarioses;
		this.tagses = tagses;
		this.likeses = likeses;
	}

	public Integer getIdFoto() {
		return this.idFoto;
	}

	public void setIdFoto(Integer idFoto) {
		this.idFoto = idFoto;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getPhotoUrl() {
		return this.photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Date getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Comentarios> getComentarioses() {
		return this.comentarioses;
	}

	public void setComentarioses(Set<Comentarios> comentarioses) {
		this.comentarioses = comentarioses;
	}

	public Set<Tags> getTagses() {
		return this.tagses;
	}

	public void setTagses(Set<Tags> tagses) {
		this.tagses = tagses;
	}

	public Set<Likes> getLikeses() {
		return this.likeses;
	}

	public void setLikeses(Set<Likes> likeses) {
		this.likeses = likeses;
	}

}
