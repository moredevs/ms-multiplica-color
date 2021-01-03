package com.multiplica.talent.microservicecolors.mappers;


import com.multiplica.talent.microservicecolors.mappers.dto.PageColorDTO;
import com.multiplica.talent.microservicecolors.repository.model.Color;
import org.springframework.data.domain.Page;
import java.util.function.Function;
import java.util.stream.Collectors;


public interface PageColorMapper {

    Function<Page<Color>, PageColorDTO> PageColorToPageColorDTO = (Page<Color> color) -> PageColorDTO
            .builder()
            .colors(color.toList().stream()
                    .map(ColorMapper.colorToColorsDTOAll).collect(Collectors.toList()))
             .totalColors(color.getTotalElements())
            .totalPage(color.getTotalPages())
            .actualPage(color.getNumber()+1)
            .build();

}
