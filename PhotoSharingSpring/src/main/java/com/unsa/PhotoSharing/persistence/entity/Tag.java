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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Tag generated by hbm2java
 */
@Entity
@Table(name = "tag", catalog = "photosharing")
public class Tag implements java.io.Serializable {

	private Integer idTag;
	private String nombreTag;
	private Set<Foto> fotos = new HashSet<Foto>(0);

	public Tag() {
	}

	public Tag(String nombreTag, Set<Foto> fotos) {
		this.nombreTag = nombreTag;
		this.fotos = fotos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idTag", unique = true, nullable = false)
	public Integer getIdTag() {
		return this.idTag;
	}

	public void setIdTag(Integer idTag) {
		this.idTag = idTag;
	}

	@Column(name = "NombreTag", length = 45)
	public String getNombreTag() {
		return this.nombreTag;
	}

	public void setNombreTag(String nombreTag) {
		this.nombreTag = nombreTag;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
	public Set<Foto> getFotos() {
		return this.fotos;
	}

	public void setFotos(Set<Foto> fotos) {
		this.fotos = fotos;
	}

}