package com.example.musicdatabase.restimpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.musicdatabase.dto.ArtistDTO;
import com.example.musicdatabase.dto.ArtistSearchDTO;
import com.example.musicdatabase.entity.ArtistEntity;
import com.example.musicdatabase.repository.ArtistRepository;
import com.example.musicdatabase.rest.ArtistRestService;
import com.example.musicdatabase.service.ArtistService;
import com.example.musicdatabase.service.KafkaService;
import com.examples.music.database.cto.ArtistCTO;


@RestController
public class ArtistRestServiceImpl implements ArtistRestService {


	@Autowired
	ArtistRepository artistRepo;

	@Autowired
	ArtistService artistManagement;
//
//	@Autowired
//	KafkaService kafkaService;

   @Override
	public List<ArtistDTO> getAllArtists(Pageable pageable) {
		return artistManagement.findAllArtists(pageable);
	}

@Override
public List<ArtistCTO> getAllArtistsLinks(Pageable pageable) {

	return artistManagement.findAllArtistsLinks(pageable);

}

@Override
public ArtistEntity newArtist(ArtistDTO artist) {
return this.artistManagement.addNewArtist(artist);
}

@Override
public ArtistDTO getArtistById(Long id) {
	 return this.artistManagement.getById(id);
}

@Override
public ArtistEntity newArtistsAndAlbums(ArtistCTO artist) {
	return this.artistManagement.addNewArtistAndLinks(artist);
}

@GetMapping("/getAllEntity")

public List<ArtistEntity> getArtist() {

	return this.artistRepo.findAll();
}

@Override
public ArtistDTO alterArtist(Long id, ArtistDTO artist) {
	return this.artistManagement.alterArtist(id, artist);
}

@Override
public Boolean deleteArtist(Long id) {
	return this.artistManagement.deleteArtist(id);
}

@Override
public List<ArtistDTO> findByCriteria(ArtistSearchDTO search) {
	return this.artistManagement.findByCriteria(search);
}

@Override
public List<ArtistDTO> getAllArtistsMap() {
	return this.artistManagement.findAllArtistsWithoutPage();
}

//@Override
//public List<ArtistDTO> getArtistsWithGigs() {
//	 return this.artistManagement.getArtistGigs();
//}

//@Override
//public void PostToKafka() {
//	this.kafkaService.postToKafka();
//
//}


}
