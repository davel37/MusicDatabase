package com.example.musicdatabase.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.musicdatabase.dto.AlbumDTO;
import com.example.musicdatabase.dto.ArtistDTO;
import com.example.musicdatabase.dto.ArtistSearchDTO;
import com.example.musicdatabase.dto.GigsDTO;
import com.example.musicdatabase.entity.AlbumEntity;
import com.example.musicdatabase.entity.ArtistEntity;
import com.example.musicdatabase.entity.GigsEntity;
import com.example.musicdatabase.repository.AlbumsRepository;
import com.example.musicdatabase.repository.ArtistRepository;
import com.example.musicdatabase.repository.GigsRepository;
import com.example.musicdatabase.service.ArtistService;
import com.example.musicdatabase.specifications.ArtistSpecification;
import com.examples.music.database.cto.ArtistCTO;

@Service
public class ArtistServiceImpl implements ArtistService {

	@Autowired
	ArtistRepository artistRepo;

	@Autowired
	AlbumsRepository albumRepo;

	@Autowired
	GigsRepository gigsRepo;

	public ArtistServiceImpl(ArtistRepository artistRepo) {
		super();
		this.artistRepo = artistRepo;
	}
	@Override
	public List<ArtistDTO> findAllArtists(Pageable pageable) {

		List<ArtistEntity> entities = artistRepo.findAll(pageable).getContent();

		List<ArtistDTO> dtos = new ArrayList<>();
		entities.stream().forEach(e -> dtos.add(convertToDto(e)));

		return dtos;

	}
	@Override
	public List<ArtistDTO> findAllArtistsWithoutPage() {
			  return artistRepo.findAll().stream().map( a ->convertToDto(a) ).collect(Collectors.toCollection(LinkedList::new));
			 }


//		final List<ArtistEntity> entities = this.artistRepo.findAll();
//
//		final List<ArtistDTO> dtos = new ArrayList<>();
//		  if (entities != null && !entities.isEmpty()) {
//		entities.stream().forEach(e -> dtos.add(convertToDto(e)));
//		  }
//		return dtos;



	public ArtistDTO convertToDto(ArtistEntity e) {

		ArtistDTO dto = new ArtistDTO();

		dto.setId(e.getId());
		dto.setCountry(e.getCountry());
		dto.setName(e.getName());
		dto.setCreatedAt(e.getCreatedAt());
		dto.setUpdatedAt(e.getUpdatedAt());

		return dto;
	}

	@Override
	public List<ArtistCTO> findAllArtistsLinks(Pageable pageable) {

		List<ArtistEntity> entities = this.artistRepo.findAll(pageable).getContent();

		List<ArtistCTO> ctos = new ArrayList<>();

		entities.stream().forEach(e -> {

			ArtistCTO cto = new ArtistCTO();

			cto.setArtistDTO(convertToDto(e));
			cto.setAllAlbums(convertAlbumstoDto(e));
			cto.setAllGigs(convertGigsToDTO(e));

			ctos.add(cto);
		});
		return ctos;
	}

	private List<GigsDTO> convertGigsToDTO(ArtistEntity e) {
		List<GigsEntity> allGigs = e.getAllGigs();

		List<GigsDTO> dtos = new ArrayList<>();

		allGigs.stream().forEach(g -> {

			GigsDTO dto = new GigsDTO();
			dto.setArtistId(g.getArtistId());
			dto.setId(g.getId());
			dto.setVenue(g.getVenue());
			dto.setCountry(g.getCountry());
			dto.setDateOfGig(g.getDateOfGig());
			dto.setIsSoldOut(g.getIsSoldOut());
			dto.setCreatedAt(g.getCreatedAt());
			dto.setUpdatedAt(g.getUpdatedAt());

			if(!dto.getIsSoldOut()) {
			dtos.add(dto);
			}
		});
		return dtos;
	}

	private List<AlbumDTO> convertAlbumstoDto(ArtistEntity e) {

		List<AlbumEntity> allAlbums = e.getAllAlbums();

		List<AlbumDTO> dtos = new ArrayList<>();

		allAlbums.stream().forEach(a -> {

			AlbumDTO dto = new AlbumDTO();
			dto.setArtistId(a.getArtistId());
			dto.setCreatedAt(a.getCreatedAt());
			dto.setUpdatedAt(a.getUpdatedAt());
			dto.setName(a.getName());
			dto.setYear(a.getYear());
			dto.setId(a.getId());

			dtos.add(dto);

		});
		return dtos;
	}

	@Override
	public ArtistEntity addNewArtist(ArtistDTO artist) {
		ArtistEntity entity = new ArtistEntity();

		entity.setName(artist.getName());
		entity.setCountry(artist.getCountry());

		return this.artistRepo.save(entity);

	}

	@Override
	public ArtistDTO getById(Long id) {

		ArtistEntity entity = this.artistRepo.findById(id).orElseThrow(() ->new MusicException("No artist found with ID" + id));

		ArtistDTO dto = new ArtistDTO();
		dto.setCountry(entity.getCountry());
		dto.setName(entity.getName());
		dto.setId(entity.getId());

		return dto;
	}

	@Override
	public ArtistEntity addNewArtistAndLinks(ArtistCTO artist) {
		ArtistEntity entity = new ArtistEntity();

		entity.setCountry(artist.getArtistDTO().getCountry());
		entity.setName(artist.getArtistDTO().getName());
	   this.artistRepo.save(entity);
		entity.setAllAlbums(saveAlbums(artist.getAllAlbums()));
		entity.setAllGigs(saveGigs(artist.getAllGigs()));

	return entity;
	}

	private List<GigsEntity> saveGigs(List<GigsDTO> allGigs) {
		List<GigsEntity> gigs = new ArrayList<>();

		allGigs.stream().forEach(g -> {

			GigsEntity gig = new GigsEntity();
			gig.setArtistId(g.getArtistId());
			gig.setCountry(g.getCountry());
			gig.setIsSoldOut(g.getIsSoldOut());
			gig.setVenue(g.getVenue());
			gig.setDateOfGig(g.getDateOfGig());

			gigs.add(gig);

		});
		return this.gigsRepo.saveAll(gigs);

	}

	private List<AlbumEntity> saveAlbums(List<AlbumDTO> allAlbums) {


		List<AlbumEntity>albums = new ArrayList<>();

		allAlbums.stream().forEach( a->{
			AlbumEntity album = new AlbumEntity();

			album.setArtistId(a.getArtistId());
			album.setName(a.getName());
			album.setYear(a.getYear());

			albums.add(album);
		});
		return this.albumRepo.saveAll(albums);

	}

	@Override
	public ArtistDTO alterArtist(Long id, ArtistDTO artist) {
		ArtistEntity entity = this.artistRepo.findById(id).orElseThrow(() -> new MusicException("No artist found with that Id, Motherfuckcer"));
		ArtistDTO dto = convertToDto(entity);

        dto.setId(entity
        		.getId());
		dto.setCountry(artist.getCountry());
		dto.setName(artist.getName());


		ArtistEntity savedEntity = new ArtistEntity();
        savedEntity.setId(dto.getId());
		savedEntity.setCountry(dto.getCountry());
		savedEntity.setName(dto.getName());

		this.artistRepo.save(savedEntity);
		return dto;
	}

	@Override
	public Boolean deleteArtist(Long id) {
		ArtistEntity entity = this.artistRepo.findById(id).orElseThrow(() -> new MusicException("No artist found with that id, CuntyJaws"));

		this.artistRepo.delete(entity);
		return true;
	}

	@Override
	public List<ArtistDTO> findByCriteria(ArtistSearchDTO search) {

		ArtistEntity entity = new ArtistEntity();
		entity.setCountry(search.getCountry());
		entity.setName(search.getName());

		Specification<ArtistEntity>  filter = new ArtistSpecification(entity);

		List<ArtistEntity> result = this.artistRepo.findAll(filter);

		List<ArtistDTO> dtos = new ArrayList<>();

		result.stream().forEach( r -> dtos.add(convertToDto(r)));

		return dtos;
	}
//	@Override
//	public List<ArtistDTO> getArtistGigs() {
//	return this.artistRepo.findAll().stream().filter(e ->getAvailableGigs(e.getAllGigs())).map(e ->convertToDTO(e)).collect(Collectors.toList());
//	}

	private Boolean getAvailableGigs(List<GigsEntity> allGigs) {
		allGigs.stream().filter(GigsEntity:: getIsSoldOut).collect(Collectors.toList());
		return true;

	}
}
