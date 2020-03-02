package com.example.musicdatabase.dto;

import java.util.Date;

import com.example.musicdatabase.entity.AuditModel;

public class AlbumDTO extends AuditModel {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private Date year;

	private Long artistId;

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

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public Long getArtistId() {
		return artistId;
	}

	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}



}
