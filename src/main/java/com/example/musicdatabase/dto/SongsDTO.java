package com.example.musicdatabase.dto;

import com.example.musicdatabase.entity.AuditModel;

public class SongsDTO extends AuditModel {

	private Long id;

	private String title;

	private Long albumId;

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

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

}
