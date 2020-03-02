package com.example.musicdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.musicdatabase.entity.GigsEntity;

@Repository
public interface GigsRepository extends JpaRepository<GigsEntity, Long> {

}
