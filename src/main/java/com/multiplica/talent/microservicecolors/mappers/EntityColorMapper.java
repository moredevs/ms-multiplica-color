package com.multiplica.talent.microservicecolors.mappers;

import com.multiplica.talent.microservicecolors.mappers.dto.Colors;
import com.multiplica.talent.microservicecolors.repository.model.Color;

import java.util.function.Function;

public interface EntityColorMapper {

    Function<Colors, Color> colorDTOToColor = (Colors colors) -> Color
            .builder()
            .id(colors.getId())
            .name(colors.getName())
            .year(colors.getYear())
            .color(colors.getColor())
            .pantoneValue(colors.getPantone_value())
            .build();

}
