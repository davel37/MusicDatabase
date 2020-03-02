package com.example.musicdatabase.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "gigs")
public class GigsEntity extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gigs_generator")
    @SequenceGenerator(
            name = "gigs_generator",
            sequenceName = "gigs_sequence",
            initialValue = 1000
    )
	private Long id;

	private String venue;

	private String country;

	@Column(name = "issoldout")
	private Boolean isSoldOut;


	@Column(name = "dateofgig")
	private Date dateOfGig;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artist_id")
	 @JsonBackReference
	private ArtistEntity artist;


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


	public ArtistEntity getArtist() {
		return artist;
	}


	public void setArtist(ArtistEntity artist) {
		this.artist = artist;
	}

	public Long getArtistId() {

		if(this.artist == null) {
			return null;
		}

		else {
			return this.artist.getId();
		}
	}
	public void setArtistId(Long artistId) {

	if (artistId == null) {
		this.artist = null;

	}
	else {
		ArtistEntity artistEntity = new ArtistEntity();
		artistEntity.setId(artistId);
		this.artist = artistEntity;
	}
	}

}
