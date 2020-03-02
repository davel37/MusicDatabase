package com.example.musicdatabase.dto;

import com.example.musicdatabase.entity.AuditModel;

public class ArtistDTO extends AuditModel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	private Long id;

	private String name;

	private String country;

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
