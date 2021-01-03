package com.multiplica.talent.microservicecolors.mappers.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Colors", description = "Model that represent all colors with pagination")
public class PageColorDTO {

    List<Colors> colors;

    @ApiModelProperty(name = "totalPage" ,value = "totalPage", example = "1")
    int totalPage;

    @ApiModelProperty(name = "totalColors" ,value = "totalColors", example = "12")
    Long totalColors;

    @ApiModelProperty(name = "actualPage" ,value = "actualPage", example = "1")
    int actualPage;
}
