package com.example.musicdatabase.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "songs")
public class SongsEntity extends AuditModel{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(generator = "songs_generator")
    @SequenceGenerator(
            name = "songs_generator",
            sequenceName = "songs_sequence",
            initialValue = 1000
    )
private Long id;

private String title;


@ManyToOne(fetch =FetchType.LAZY)
@JoinColumn(name = "album_id")
private AlbumEntity album;


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public AlbumEntity getAlbum() {
	return album;
}


public void setAlbum(AlbumEntity album) {
	this.album = album;
}

public Long getAlbumId() {

	if(this.album == null) {
		return null;
	}	else {
		return this.album.getId();
}
}
public void setAlbumId(Long albumId) {

	if (albumId == null) {

		this.album = null;
	}
	else {

		AlbumEntity albumEntity = new AlbumEntity();
		albumEntity.setId(albumId);

		this.album = albumEntity;
	}


}
}