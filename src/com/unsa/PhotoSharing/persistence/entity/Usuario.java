package com.unsa.PhotoSharing.persistence.entity;
// default package
// Generated 08/06/2014 12:26:52 AM by Hibernate Tools 3.4.0.CR1

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", catalog = "photosharing", uniqueConstraints = {
		@UniqueConstraint(columnNames = "Nickname"),
		@UniqueConstraint(columnNames = "Email") })
public class Usuario implements java.io.Serializable {

	private Integer idUsuario;
	private String nombre;
	private String apellidos;
	private String nickname;
	private String email;
	private String password;
	private String profilePhoto;
	private Set<Comentario> comentarios = new HashSet<Comentario>(0);
	private Set<Usuario> usuariosForIdUsuario1 = new HashSet<Usuario>(0);
	private Set<Usuario> usuariosForIdUsuario2 = new HashSet<Usuario>(0);
	private Set<Like> likes = new HashSet<Like>(0);
	private Set<Foto> fotos = new HashSet<Foto>(0);

	public Usuario() {
	}

	public Usuario(String nickname, String email, String password) {
		this.nickname = nickname;
		this.email = email;
		this.password = password;
	}

	public Usuario(String nombre, String apellidos, String nickname,
			String email, String password, String profilePhoto,
			Set<Comentario> comentarios, Set<Usuario> usuariosForIdUsuario1,
			Set<Usuario> usuariosForIdUsuario2, Set<Like> likes, Set<Foto> fotos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.profilePhoto = profilePhoto;
		this.comentarios = comentarios;
		this.usuariosForIdUsuario1 = usuariosForIdUsuario1;
		this.usuariosForIdUsuario2 = usuariosForIdUsuario2;
		this.likes = likes;
		this.fotos = fotos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idUsuario", unique = true, nullable = false)
	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Column(name = "Nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "Apellidos", length = 45)
	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Column(name = "Nickname", unique = true, nullable = false, length = 30)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "Email", unique = true, nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Password", nullable = false, length = 30)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "ProfilePhoto", length = 65535)
	public String getProfilePhoto() {
		return this.profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "amigo", catalog = "photosharing", joinColumns = { @JoinColumn(name = "idUsuario2", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "idUsuario1", nullable = false, updatable = false) })
	public Set<Usuario> getUsuariosForIdUsuario1() {
		return this.usuariosForIdUsuario1;
	}

	public void setUsuariosForIdUsuario1(Set<Usuario> usuariosForIdUsuario1) {
		this.usuariosForIdUsuario1 = usuariosForIdUsuario1;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "amigo", catalog = "photosharing", joinColumns = { @JoinColumn(name = "idUsuario1", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "idUsuario2", nullable = false, updatable = false) })
	public Set<Usuario> getUsuariosForIdUsuario2() {
		return this.usuariosForIdUsuario2;
	}

	public void setUsuariosForIdUsuario2(Set<Usuario> usuariosForIdUsuario2) {
		this.usuariosForIdUsuario2 = usuariosForIdUsuario2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Like> getLikes() {
		return this.likes;
	}

	public void setLikes(Set<Like> likes) {
		this.likes = likes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Foto> getFotos() {
		return this.fotos;
	}

	public void setFotos(Set<Foto> fotos) {
		this.fotos = fotos;
	}

}
