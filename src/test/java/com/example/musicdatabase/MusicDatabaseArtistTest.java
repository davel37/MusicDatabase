package com.example.musicdatabase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.musicdatabase.dto.ArtistSearchDTO;
import com.example.musicdatabase.entity.AlbumEntity;
import com.example.musicdatabase.entity.ArtistEntity;
import com.example.musicdatabase.repository.ArtistRepository;
import com.example.musicdatabase.serviceimpl.ArtistServiceImpl;
import com.example.musicdatabase.specifications.ArtistSpecification;

//@RunWith(MockitoJUnitRunner.class)
public class MusicDatabaseArtistTest {

	Pageable page;

	List<ArtistEntity> allArtistDataMock;

	Page<ArtistEntity> allArtistDataMockPag;

	ArtistSpecification artistSpecification;

	List<ArtistSearchDTO> criteria;

	ArtistEntity mockArtist;

	@Mock
	private ArtistRepository artistRepo;

	@InjectMocks
	@Spy
	ArtistServiceImpl artistServiceImpl = new ArtistServiceImpl(artistRepo);
	@Before
	public void setup(){
	    MockitoAnnotations.initMocks(this); //without this you will get NPE
	}

//	 @Before
//	  public void prepareData() {
//
//		 this.allArtistDataMock = new ArrayList<>();
//
//		 this.page =  PageRequest.of(1, 2);
//
//		 this.allArtistDataMockPag = new PageImpl<>(this.allArtistDataMock);
//
//		 this.artistSpecification = new ArtistSpecification(getCriteria());
//
//		 this.allArtistDataMock = generateArtistData(1);
//
//		 this.mockArtist = generateMockArtist();
//
//		 Mockito.when(this.artistRepo.findAll()).thenReturn(this.allArtistDataMock);
//		 Mockito.when(this.artistRepo.findAll(this.page)).thenReturn(this.allArtistDataMockPag);
//		 Mockito.when(this.artistRepo.findAll(this.artistSpecification, this.page)).thenReturn(this.allArtistDataMockPag);
//		 Mockito.when(this.artistRepo.findById(5l)).thenReturn(Optional.of(this.mockArtist));;
//	 }

	 public ArtistEntity generateMockArtist() {

		 ArtistEntity mock = new ArtistEntity();
		           mock.setName("SlowDive");
		          mock.setCountry("England");
		          mock.setId(5l);
                   return mock;


	}
	 @Test
	 public void testAllArtistMockData() {
		 this.allArtistDataMock = generateArtistData(1);

		 List<ArtistEntity> entity = this.allArtistDataMock;
		  assertNotNull(entity);
		  assertFalse(entity.isEmpty());

	 }

//	@Test
//	  public void findAllArtistsWithoutPage() {
//		 this.allArtistDataMock = generateArtistData(1);
//
//		 when(this.artistRepo.findAll()).thenReturn(this.allArtistDataMock);
//
//		// Mockito.when(this.artistRepo.findAll()).thenReturn(generateArtistData(1));;
//	  List<ArtistEntity> list = this.artistServiceImpl.findAllArtistsWithoutPage();
//	    assertNotNull(list);
//	    assertFalse(list.isEmpty());
//	  }

	private ArtistEntity getCriteria() {
		ArtistEntity entity = new ArtistEntity();
		entity.setCountry("Ireland");
		entity.setName("Delorentos");

		return entity;
	}

	private List<ArtistEntity> generateArtistData(int number) {

		final List<ArtistEntity> mockArtists = new ArrayList<>();
		for(int i = 0; i < number; i++) {
			mockArtists.add(generateMockArtist(i));

		}
		return mockArtists;
	}

//	 private List<PagDataEntity> generatePagDataEntityList(int numOfItems) {
//
//		    final List<PagDataEntity> mockList = new ArrayList<>();
//
//		    for (int i = 0; i < numOfItems; i++) {
//		      mockList.add(generatePagDataEntity(i));
//		    }
//
//		    return mockList;
//
//		  }
	private ArtistEntity generateMockArtist(int i) {
		ArtistEntity entity = new ArtistEntity();

		entity.setId(Long.valueOf(i));
		entity.setCountry("Ireland");
		entity.setName("Delorentos");
		//entity.setAllAlbums(setMockAlbums(Long.valueOf(i)));


		return entity;
	}

	private List<AlbumEntity> setMockAlbums(Long id) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "2010-08-07";

		List<AlbumEntity> mockAlbums = new ArrayList<>();

				AlbumEntity albumMock = new AlbumEntity();
				albumMock.setArtistId(Long.valueOf(id));
				albumMock.setName("Home Stories");
				try {
					albumMock.setYear(sdf.parse(dateInString));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           mockAlbums.add(albumMock);
		           return mockAlbums;
	}

}
