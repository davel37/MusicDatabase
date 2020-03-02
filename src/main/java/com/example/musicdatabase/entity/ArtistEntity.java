package com.example.musicdatabase.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "artist")
public class ArtistEntity extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artist_generator")
	@SequenceGenerator(name = "artist_generator", sequenceName = "artist_sequence", initialValue = 1000)
	private Long id;

	private String name;

	private String country;

	 @JsonManagedReference
	@OneToMany(mappedBy = "artist", fetch = FetchType.LAZY)
	// @Fetch(value = FetchMode.SUBSELECT)
	private List<AlbumEntity> allAlbums;
	 @JsonManagedReference
	@OneToMany(mappedBy = "artist", fetch = FetchType.LAZY)
	// @Fetch(value = FetchMode.SUBSELECT)
	private List<GigsEntity> allGigs;

	public List<GigsEntity> getAllGigs() {
		return allGigs;
	}

	public void setAllGigs(List<GigsEntity> allGigs) {
		this.allGigs = allGigs;
	}

	public List<AlbumEntity> getAllAlbums() {
		return allAlbums;
	}

	public void setAllAlbums(List<AlbumEntity> allAlbums) {
		this.allAlbums = allAlbums;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}



}
