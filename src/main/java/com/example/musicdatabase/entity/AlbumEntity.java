package com.example.musicdatabase.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "album")
public class AlbumEntity extends AuditModel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "album_generator")
    @SequenceGenerator(
            name = "album_generator",
            sequenceName = "album_sequence",
            initialValue = 1000
    )
	private Long id;

	private String name;

	private Date year;


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artist_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	 @JsonBackReference
	private ArtistEntity artist;


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


	public ArtistEntity getArtist() {
		return artist;
	}


	public void setArtist(ArtistEntity artist) {
		this.artist = artist;
	}


	  @Transient
	  public Long getArtistId() {

	    if (this.artist == null) {
	      return null;
	    }
	    return this.artist.getId();
	  }


	  public void setArtistId(Long artistId) {

	    if (artistId == null) {
	      this.artist = null;
	    } else {
	      ArtistEntity artistEntity = new ArtistEntity();
	      artistEntity.setId(artistId);
	      this.artist = artistEntity;
	    }
	  }


}
