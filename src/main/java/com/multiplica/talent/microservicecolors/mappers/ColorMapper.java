package com.multiplica.talent.microservicecolors.mappers;

import com.multiplica.talent.microservicecolors.mappers.dto.Colors;
 import com.multiplica.talent.microservicecolors.repository.model.Color;

import java.util.function.Function;

public interface ColorMapper {

    Function<Color, Colors> colorToColorsDTO = (Color color) -> Colors
            .builder()
            .id(color.getId())
            .name(color.getName())
            .year(color.getYear())
            .color(color.getColor())
            .pantone_value(color.getPantoneValue())
            .build();

    Function<Color, Colors> colorToColorsDTOAll = (Color color) -> Colors
            .builder()
            .id(color.getId())
            .name(color.getName())
            .color(color.getColor())
            .build();

}
