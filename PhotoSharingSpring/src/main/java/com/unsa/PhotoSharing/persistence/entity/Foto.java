package com.unsa.PhotoSharing.persistence.entity;
// default package
// Generated 08/06/2014 12:26:52 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Foto generated by hbm2java
 */
@Entity
@Table(name = "foto", catalog = "photosharing")
public class Foto implements java.io.Serializable {

	private Integer idFoto;
	private Usuario usuario;
	private String photoUrl;
	private Date uploadDate;
	private String descripcion;
	private Set<Comentario> comentarios = new HashSet<Comentario>(0);
	private Set<Tag> tags = new HashSet<Tag>(0);
	private Set<Like> likes = new HashSet<Like>(0);

	public Foto() {
	}

	public Foto(Usuario usuario) {
		this.usuario = usuario;
	}

	public Foto(Usuario usuario, String photoUrl, Date uploadDate,
			String descripcion, Set<Comentario> comentarios, Set<Tag> tags, Set<Like> likes) {
		this.usuario = usuario;
		this.photoUrl = photoUrl;
		this.uploadDate = uploadDate;
		this.descripcion = descripcion;
		this.comentarios = comentarios;
		this.tags = tags;
		this.likes = likes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idFoto", unique = true, nullable = false)
	public Integer getIdFoto() {
		return this.idFoto;
	}

	public void setIdFoto(Integer idFoto) {
		this.idFoto = idFoto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "PhotoURL", length = 65535)
	public String getPhotoUrl() {
		return this.photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UploadDate", length = 19)
	public Date getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Column(name = "Descripcion", length = 65535)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "foto")
	public Set<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "foto_tag", catalog = "photosharing", joinColumns = { @JoinColumn(name = "idFoto", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "idTag", nullable = false, updatable = false) })
	public Set<Tag> getTags() {
		return this.tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "foto")
	public Set<Like> getLikes() {
		return this.likes;
	}

	public void setLikes(Set<Like> likes) {
		this.likes = likes;
	}

}
