package com.example.musicdatabase.dto;

import java.util.Date;

import com.example.musicdatabase.entity.AuditModel;

public class GigsDTO extends AuditModel {

	private Long id;

	private String venue;

	private String country;

	private Boolean isSoldOut;

	private Date dateOfGig;

	private Long artistId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Boolean getIsSoldOut() {
		return isSoldOut;
	}

	public void setIsSoldOut(Boolean isSoldOut) {
		this.isSoldOut = isSoldOut;
	}

	public Date getDateOfGig() {
		return dateOfGig;
	}

	public void setDateOfGig(Date dateOfGig) {
		this.dateOfGig = dateOfGig;
	}

	public Long getArtistId() {
		return artistId;
	}

	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}

}
