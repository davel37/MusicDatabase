package com.examples.music.database.cto;

import java.util.List;

import com.example.musicdatabase.dto.AlbumDTO;
import com.example.musicdatabase.dto.ArtistDTO;
import com.example.musicdatabase.dto.GigsDTO;

public class ArtistCTO {


	private ArtistDTO artistDTO;

	private List<AlbumDTO> allAlbums;

	private List <GigsDTO> allGigs;

	public ArtistDTO getArtistDTO() {
		return artistDTO;
	}

	public void setArtistDTO(ArtistDTO artistDTO) {
		this.artistDTO = artistDTO;
	}

	public List<AlbumDTO> getAllAlbums() {
		return allAlbums;
	}

	public void setAllAlbums(List<AlbumDTO> allAlbums) {
		this.allAlbums = allAlbums;
	}

	public List<GigsDTO> getAllGigs() {
		return allGigs;
	}

	public void setAllGigs(List<GigsDTO> allGigs) {
		this.allGigs = allGigs;
	}


}
