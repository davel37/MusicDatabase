package com.example.musicdatabase.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.musicdatabase.dto.ArtistDTO;
import com.example.musicdatabase.dto.ArtistSearchDTO;
import com.example.musicdatabase.entity.ArtistEntity;
import com.examples.music.database.cto.ArtistCTO;


@Service
public interface ArtistService {

	List<ArtistDTO> findAllArtists(Pageable pageable);

	List<ArtistCTO> findAllArtistsLinks(Pageable pageable);

	ArtistEntity addNewArtist(ArtistDTO artist);

	ArtistDTO getById(Long id);

	ArtistEntity addNewArtistAndLinks(ArtistCTO artist);

	ArtistDTO alterArtist(Long id, ArtistDTO artist);

	Boolean deleteArtist(Long id);

	List<ArtistDTO> findByCriteria(ArtistSearchDTO search);

   List<ArtistDTO> findAllArtistsWithoutPage();

//List<ArtistDTO> getArtistGigs();



}
