package com.multiplica.talent.microservicecolors.mappers.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Color", description = "Model that represent model Color")
public class Colors {

      @ApiModelProperty(name = "id",hidden = true,value = "id")
      Integer id;

      @ApiModelProperty(name = "name", example = "red", required = true)
      String name;

      @JsonInclude(JsonInclude.Include.NON_NULL)
      @ApiModelProperty(name = "year", example = "2020", required = true)
      Integer year;

      @ApiModelProperty(name = "color", example = "#ccc", required = true)
      String color;

      @JsonInclude(JsonInclude.Include.NON_NULL)
      @ApiModelProperty(name = "pantone_value", example = "10-2010", required = true)
      String pantone_value;
}
