package com.example.musicdatabase.rest;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.musicdatabase.dto.ArtistDTO;
import com.example.musicdatabase.dto.ArtistSearchDTO;
import com.example.musicdatabase.entity.ArtistEntity;
import com.examples.music.database.cto.ArtistCTO;

@RestController
public interface ArtistRestService {

	@GetMapping("/getAllArtists")
	public List<ArtistDTO> getAllArtists(Pageable pageable);


	@GetMapping("/getAllArtistsLinks")
	public List <ArtistCTO> getAllArtistsLinks(Pageable pageable);

   @PostMapping("/addNewArtist")
   public ArtistEntity newArtist(@RequestBody ArtistDTO artist);

   @GetMapping("/getArtist/{id}")
   public ArtistDTO getArtistById(@PathVariable Long id);

   @PostMapping("/addArtistandAlbums")
   public ArtistEntity newArtistsAndAlbums(@RequestBody ArtistCTO artist);

   @PutMapping("/alterArtist/{id}")
   public ArtistDTO alterArtist(@PathVariable Long id, @RequestBody ArtistDTO artist);

   @DeleteMapping("/deleteArtist/{id}")
   public Boolean deleteArtist(@PathVariable Long id);


   @PostMapping("/findBy")
   public List<ArtistDTO> findByCriteria(@RequestBody ArtistSearchDTO search);

   @GetMapping("/getAllArtistsMap")
   public List<ArtistDTO> getAllArtistsMap();

//   @GetMapping ("/ArtistsWithGigs")
//   public List<ArtistDTO> getArtistsWithGigs();
}


