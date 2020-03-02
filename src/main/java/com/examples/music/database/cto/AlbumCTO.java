package com.examples.music.database.cto;

import com.example.musicdatabase.dto.AlbumDTO;
import com.example.musicdatabase.dto.ArtistDTO;

public class AlbumCTO {

	AlbumDTO albumDTO;

	ArtistDTO artistDTO;

	public AlbumDTO getAlbumDTO() {
		return albumDTO;
	}

	public void setAlbumDTO(AlbumDTO albumDTO) {
		this.albumDTO = albumDTO;
	}

	public ArtistDTO getArtistDTO() {
		return artistDTO;
	}

	public void setArtistDTO(ArtistDTO artistDTO) {
		this.artistDTO = artistDTO;
	}

}
