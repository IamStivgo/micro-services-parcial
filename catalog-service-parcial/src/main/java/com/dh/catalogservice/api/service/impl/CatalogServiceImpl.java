package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
	private MovieRepository movieRepository;

	@Autowired
	public CatalogServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public ResponseEntity<CatalogWS> getCatalogByGenre(String genre) {
		List<MovieWS> movies = this.movieRepository.getMoviesByGenre(genre);
		return new ResponseEntity<CatalogWS>(CatalogWS.builder().genre(genre).movies(movies).build(), HttpStatus.OK);
	}
}
