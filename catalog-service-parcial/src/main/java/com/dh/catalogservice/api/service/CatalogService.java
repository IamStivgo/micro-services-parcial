package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.model.dto.CatalogWS;
import org.springframework.http.ResponseEntity;

public interface CatalogService {

    ResponseEntity<CatalogWS> getCatalogByGenre(String genre);
}
