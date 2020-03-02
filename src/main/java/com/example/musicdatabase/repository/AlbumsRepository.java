package com.example.musicdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.musicdatabase.entity.AlbumEntity;

@Repository
public interface AlbumsRepository extends JpaRepository<AlbumEntity, Long> {

}
