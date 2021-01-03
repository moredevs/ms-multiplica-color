package com.multiplica.talent.microservicecolors.service.impl;

import com.multiplica.talent.microservicecolors.mappers.ColorMapper;
import com.multiplica.talent.microservicecolors.mappers.EntityColorMapper;
import com.multiplica.talent.microservicecolors.mappers.PageColorMapper;
import com.multiplica.talent.microservicecolors.mappers.dto.Colors;
import com.multiplica.talent.microservicecolors.mappers.dto.PageColorDTO;
import com.multiplica.talent.microservicecolors.repository.ColorRepository;
import com.multiplica.talent.microservicecolors.service.IColorService;
import com.multiplica.talent.microservicecolors.util.ColorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class ImplColorService implements IColorService {

    @Autowired
    ColorRepository colorRepository;

    @Override
    public Mono<PageColorDTO> findAllColors(Integer page, Integer size) {

        Pageable pageable = PageRequest.of(ColorUtil.pageIsNull(page), ColorUtil.sizeIsNull(size));

        return Mono.justOrEmpty(colorRepository.findAll(pageable))
                .map(PageColorMapper.PageColorToPageColorDTO)
                .doOnSubscribe(success -> log.info("Success List colors"))
                .doOnError(error -> log.info("Error server " + error.getMessage()));

    }

    @Override
    public Mono<Colors> getById(Integer id) {
        return Mono.justOrEmpty(colorRepository.findById(id))
                .map(ColorMapper.colorToColorsDTO)
                .doOnSubscribe(success -> log.info("Success Color Attribute"))
                .doOnError(error -> log.info("Error server " + error.getMessage()));
    }

    @Override
    public Mono<Colors> createColor(Colors product) {
        return Mono.just(product)
                .map(EntityColorMapper.colorDTOToColor)
                .map(colorEntity -> colorRepository.save(colorEntity))
                .map(ColorMapper.colorToColorsDTO)
                .doOnSubscribe(success -> log.info("Success save color"))
                .doOnError(exception -> log.error("Error occurred while consuming message", exception));

    }


}
