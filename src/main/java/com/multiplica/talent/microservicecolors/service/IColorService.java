package com.multiplica.talent.microservicecolors.service;

import com.multiplica.talent.microservicecolors.mappers.dto.Colors;
import com.multiplica.talent.microservicecolors.mappers.dto.PageColorDTO;
import reactor.core.publisher.Mono;


public interface IColorService {

    Mono<PageColorDTO> findAllColors(Integer  page, Integer size);

    Mono<Colors> getById(Integer id);

    Mono<Colors> createColor(  Colors product);
}
